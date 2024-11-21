package dev.heimao.demo.service.Impl;

import dev.heimao.demo.entity.Register;
import dev.heimao.demo.entity.User;
import dev.heimao.demo.mapper.AdminMapper;
import dev.heimao.demo.mapper.UserMapper;
import dev.heimao.demo.service.RegisterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterDataServiceImp implements RegisterDataService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AdminMapper adminMapper;


    public boolean isUserExist(String username) {
        User user = userMapper.findByName(username);
        return user != null;
    }
    public boolean isAdminExist(String username) {
        User user = adminMapper.findAdminByName(username);
        return user != null;
    }

    public boolean userRegister(String username, String password) {
        if(username == null || password == null){
            return false;
        }

        if(!isUserExist(username)){
            Register newUser = new Register();
            newUser.setUsername(username);
            newUser.setPassword(password);

            userMapper.insertUser(newUser);
            return true;
        }
        return false;
    }

    public boolean adminRegister(String username, String password) {
        if(username == null || password == null){
            return false;
        }

        if(!isUserExist(username)){
            Register newUser = new Register();
            newUser.setUsername(username);
            newUser.setPassword(password);

            adminMapper.insertAdmin(newUser);
            return true;
        }
        return false;
    }
}
