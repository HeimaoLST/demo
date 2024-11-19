package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Register;
import dev.heimao.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {


    @Select("select * from user where username = #{username}")
    User findByName(String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insertUser(Register newUser);


}
