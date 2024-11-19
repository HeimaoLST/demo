package dev.heimao.demo.controller;

import dev.heimao.demo.entity.Comment;
import dev.heimao.demo.entity.NewComment;
import dev.heimao.demo.mapper.CommentMapper;
import dev.heimao.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CommentController {


    @Autowired
    CommentService commentService;


    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id") Integer id) {

     Comment comment  = commentService.findById(id);

     return comment;

    }
    @GetMapping("/getAll")
    public Object findAll() {

        return commentService.findAll();

    }

//    @PostMapping("/newComment")
//    public Object getNewComment(@RequestBody NewComment newComment,@RequestHeader("sat") String token) {
//        return commentService.getNewComment(newComment.getContent(),newComment.getAuthorId(),newComment.isFromAdmin());
//    }
}
