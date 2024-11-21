package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Register;
import dev.heimao.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {


    @Select("select * from user where username = #{username}")
    User findByName(String username);

    @Select("select * from user where uid = #{uid}")
    User findById(Integer uid);

    @Insert("insert into user(username,password) values(#{username},#{password})")

    void insertUser(Register newUser);

    @Select("select * from user")
    List<User> findAll();

    @Delete("delete from user where uid = #{uid}")
    void deleteUser(Integer uid);


}
