package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Register;
import dev.heimao.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Insert("insert into admin(username,password) values(#{username},#{password})")
    void insertAdmin(Register newUser);

    @Select("select * from admin where username = #{username}")
    User findAdminByName(String username);
}
