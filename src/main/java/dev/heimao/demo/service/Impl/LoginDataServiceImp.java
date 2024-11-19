package dev.heimao.demo.service.Impl;

import dev.heimao.demo.mapper.AdminMapper;
import dev.heimao.demo.mapper.UserMapper;
import dev.heimao.demo.service.LoginDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginDataServiceImp implements LoginDataService {

    @Autowired
    UserMapper userMapper;
    AdminMapper adminMapper;

    public boolean login(String username, String password) {

        if(userMapper.findByName(username) != null){
            if(userMapper.findByName(username).getPassword().equals(password)){
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean adminLogin(String username, String password) {
        if(adminMapper.findByName(username) != null){
            if(adminMapper.findByName(username).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Integer getUserId(String username) {
        return userMapper.findByName(username).getUid();
    }
    public Integer getAdminId(String username) {
        return adminMapper.findByName(username).getUid();
    }
}

