package dev.heimao.demo.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import dev.heimao.demo.entity.Comment;
import dev.heimao.demo.entity.NewComment;
import dev.heimao.demo.mapper.CommentMapper;
import dev.heimao.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {


    @Autowired
    CommentMapper
            commentMapper;


    public Comment findById(Integer id) {

        Comment comment = commentMapper.findById(id);

        return comment;

    }
    public List<Comment> findAll() {

        List<Comment> comments= commentMapper.findAll();

        return comments;

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
}

