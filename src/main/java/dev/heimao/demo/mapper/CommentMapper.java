package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CommentMapper {

    @Select("select * from comment where id = #{id}")
    public Comment findById(Integer id);

    @Select("select * from comment")
    public List<Comment> findAll();

    @Insert("insert into comment (content,authorid,createdate) values ( #{content},#{authorId},#{createTime})")
    public void setComment(Comment comment);

    @Insert("insert into comment (content,authorid,isadmin,createdate) values ( #{content},#{authorId},#{fromAdmin},#{createTime})")
    public void setAdminComment(Comment comment);

    @Delete("delete from comment where id = #{id}")
    public void deleteComment(Integer id);

    @Select("select * from comment where authorid = #{authorId}")
    List<Comment> findByAuthorId(Integer authorId);

    @Update("UPDATE comment SET likecount = likecount + 1 WHERE id = #{id}")
    int incrementLikeCount(Integer id);
}

