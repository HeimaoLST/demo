package dev.heimao.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import dev.heimao.demo.entity.Comment;
import dev.heimao.demo.entity.NewComment;
import dev.heimao.demo.mapper.CommentMapper;
import dev.heimao.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        StpUtil.checkLogin();
        return commentService.findAll();

    }

    @PostMapping("/newComment")
    public SaResult newComment(@Validated @RequestBody NewComment newComment) {
        StpUtil.checkLogin();
        Comment comment = commentService.getNewComment(newComment);
        boolean flag = commentService.setComment(comment);
        if (flag) {
            return SaResult.ok("评论成功");
        } else {
            return SaResult.error("评论失败");
        }
    }
    @PostMapping("/newAdminComment")
    public SaResult newAdminComment(@RequestBody NewComment newComment) {
        StpUtil.checkLogin();
        StpUtil.getRoleList();
        StpUtil.checkRole("admin");
        Comment comment = commentService.getNewComment(newComment);
        comment.setFromAdmin(true);
        boolean flag = commentService.setAdminComment(comment);
        if (flag) {
            return SaResult.ok("评论成功");
        } else {
            return SaResult.error("评论失败");
        }
    }
    @GetMapping("/delete/{id}")
    public SaResult deleteComment(@PathVariable("id") Integer id) {
        StpUtil.checkLogin();
        Comment comment = commentService.findById(id);

        boolean flag = commentService.deleteComment(id);
        if (flag) {
            return SaResult.ok("删除成功");
        } else {
                return SaResult.error("您无权删除该评论");
            }

        }
    @GetMapping("/getByAuthorId/{authorId}")
    public SaResult findByAuthorId(@PathVariable("authorId") Integer authorId) {
        StpUtil.checkLogin();
        List<Comment> CommentList =  commentService.findByAuthorId(authorId);
        if(CommentList == null){
            return SaResult.ok("无评论");
        }
        return SaResult.data(CommentList);
    }

    @GetMapping("/like/{id}")
    public SaResult likeComment(@PathVariable Integer id) {
        StpUtil.checkLogin();
        boolean success = commentService.likeComment(id);
        if (success) {
            return SaResult.ok("Liked comment");
        } else {
            return SaResult.error("Failed to like comment");
        }
    }
}


