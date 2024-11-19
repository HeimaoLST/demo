package dev.heimao.demo;

import dev.heimao.demo.entity.Comment;
import dev.heimao.demo.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void selectComment() {

        Comment comment = commentMapper.findById(1);

        System.out.println(comment.getContent());
    }

}
