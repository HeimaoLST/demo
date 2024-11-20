package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from comment where id = #{id}")
    public Comment findById(Integer id);

    @Select("select * from comment")
    public List<Comment> findAll();

    @Insert("insert into comment (content,authorid) values ( #{content},#{authorId})")
    public void setComment(Comment comment);

    @Insert("insert into comment (content,authorid,isadmin) values ( #{content},#{authorId},#{fromAdmin})")
    public void setAdminComment(Comment comment);

    @Delete("delete from comment where id = #{id}")
    public void deleteComment(Integer id);
}
