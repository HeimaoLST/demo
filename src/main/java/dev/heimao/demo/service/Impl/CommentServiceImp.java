package dev.heimao.demo.service.Impl;

import dev.heimao.demo.entity.Comment;
import dev.heimao.demo.mapper.CommentMapper;
import dev.heimao.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {


    @Autowired
    CommentMapper commentMapper;


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

    public Comment getNewComment(String Content, Integer authorId, boolean fromAdmin) {
        Comment newcomment = new Comment();
        newcomment.setContent(Content);
        newcomment.setAuthorId(authorId);
        newcomment.setFromAdmin(fromAdmin);
        return newcomment;
    }
}
