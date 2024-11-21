package dev.heimao.demo.service.Impl;
import dev.heimao.demo.dto.UserDTO;
import dev.heimao.demo.mapper.AdminMapper;
import org.apache.commons.lang3.StringUtils;
import dev.heimao.demo.entity.User;
import dev.heimao.demo.mapper.UserMapper;
import dev.heimao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImp implements UserService {
    
    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;
    
    
    public User findByName(String username) {
        if (StringUtils.isNotBlank(username)) {

            User user = userMapper.findByName(username);

            return user;
        }
        return null;
    }

    @Override
    public User findAdminByName(String username) {
        if (StringUtils.isNotBlank(username)) {

            User user = adminMapper.findAdminByName(username);

            return user;
        }
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userMapper.findAll();
        return users.stream().map(
                user -> {
                    UserDTO userDTO = new UserDTO(user);


                    return userDTO;
                }
        ).collect(Collectors.toList());
    }

    public User findById(Integer uid) {
        if (uid != null) {
            return userMapper.findById(uid);
        }
        return null;
    }
    @Override
    public boolean deleteUser(Integer uid) {
        if(findById(uid) == null){
            return false;
        }
        userMapper.deleteUser(uid);
        return true;
    }
}
