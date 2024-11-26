package dev.heimao.demo.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import dev.heimao.demo.dto.CommentDTO;
import dev.heimao.demo.entity.Comment;
import dev.heimao.demo.entity.NewComment;
import dev.heimao.demo.entity.User;
import dev.heimao.demo.mapper.AdminMapper;
import dev.heimao.demo.mapper.CommentMapper;
import dev.heimao.demo.mapper.UserMapper;
import dev.heimao.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {


    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;

    public Comment findById(Integer id) {

        Comment comment = commentMapper.findById(id);

        return comment;

    }
    public List<CommentDTO> findAll() {

        List<Comment> comments= commentMapper.findAll();


        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {

            CommentDTO commentDTO = new CommentDTO(comment);
            User user;
            if(comment.isFromAdmin()){
                user = adminMapper.findById(comment.getAuthorId());
            }
            else {
                user = userMapper.findById(comment.getAuthorId());
            }
            commentDTO.setAuthorName(user.getUsername());


            return commentDTO;
        }).toList();

        return commentDTOS;

    }

    public boolean setComment(Comment newcomment) {


        commentMapper.setComment(newcomment);

        return true;
    }
    public boolean setAdminComment(Comment newcomment) {
        commentMapper.setAdminComment(newcomment);
        return true;

    }

    public Comment getNewComment(NewComment newComment) {
        String loginId = (String) StpUtil.getLoginId();
        Integer authorId = Integer.parseInt(loginId.replace("User", ""));

        Comment comment = new Comment();
        comment.setAuthorId(authorId);
        comment.setContent(newComment.getContent());
        comment.setFromAdmin(false);

        comment.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return comment;

    }


    public boolean deleteComment(Integer id) {

        StpUtil.getRoleList();
        if(StpUtil.hasRole("admin")){
            commentMapper.deleteComment(id);
            return true;
        }
        if(StpUtil.hasRole("user")){
            Comment comment = commentMapper.findById(id);
            String loginId = (String) StpUtil.getLoginId();
            Integer authorId = Integer.parseInt(loginId.replace("User", ""));
            if(comment.getAuthorId().equals(authorId)){
                commentMapper.deleteComment(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Comment> findByAuthorId(Integer authorId) {
        return commentMapper.findByAuthorId(authorId);
    }

    @Override
    public boolean likeComment(Integer commentId) {
        return commentMapper.incrementLikeCount(commentId) > 0;
    }
}

