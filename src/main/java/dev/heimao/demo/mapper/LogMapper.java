package dev.heimao.demo.mapper;

import dev.heimao.demo.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    @Insert("INSERT INTO logs (level, message) VALUES (#{level}, #{message})")
    void insertLog(Log log);
}