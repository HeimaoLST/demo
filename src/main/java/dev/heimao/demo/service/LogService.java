package dev.heimao.demo.service;

import dev.heimao.demo.entity.Log;
import dev.heimao.demo.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public void log(String level, String message) {
        Log log = new Log();
        log.setLevel(level);
        log.setMessage(message);
        logMapper.insertLog(log);
    }

    public void logOperation(String username, String operation) {
        String message = username + " did " + operation + " operation";
        log("INFO", message);
    }
}