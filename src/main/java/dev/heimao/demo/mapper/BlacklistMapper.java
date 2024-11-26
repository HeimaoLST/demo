package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Blacklist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlacklistMapper {

    @Insert("INSERT INTO blacklist (id, username, reason) VALUES (#{id}, #{username}, #{reason})")
    void insertBlacklist(Blacklist blacklist);

    @Select("SELECT COUNT(*) FROM blacklist WHERE username = #{username}")
    int isUserBlacklisted(String username);
}
