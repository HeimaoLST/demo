package dev.heimao.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
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

    @PostMapping("/newComment")
    public SaResult newComment(@RequestBody NewComment newComment) {
        StpUtil.checkLogin();
        Comment comment = commentService.getNewComment(newComment);
        boolean flag = commentService.setComment(comment);
        if (flag) {
            return SaResult.ok("评论成功");
        } else {
            return SaResult.error("评论失败");
        }



    }

}
