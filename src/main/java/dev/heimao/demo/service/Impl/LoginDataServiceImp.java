package dev.heimao.demo.service.Impl;

import dev.heimao.demo.entity.User;
import dev.heimao.demo.mapper.AdminMapper;
import dev.heimao.demo.mapper.UserMapper;
import dev.heimao.demo.service.LoginDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginDataServiceImp implements LoginDataService {

    @Autowired
    UserMapper userMapper;
    @Autowired
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
        if(adminMapper.findAdminByName(username) != null){
            if(adminMapper.findAdminByName(username).getPassword().equals(password)){
                return true;
            }
        }
        return true;
    }

    public Integer getUserId(String username) {
        User user = userMapper.findByName(username);
        if (user != null) {
            return user.getUid();
        }

        return null; // 或者抛出一个自定义异常
    }

    public Integer getAdminId(String username) {
        User user = adminMapper.findAdminByName(username);
        if (user != null) {
            return user.getUid();
        }
        return null; // 或者抛出一个自定义异常
    }
}

