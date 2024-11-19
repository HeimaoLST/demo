package dev.heimao.demo.service.Impl;
import org.apache.commons.lang3.StringUtils;
import dev.heimao.demo.entity.User;
import dev.heimao.demo.mapper.UserMapper;
import dev.heimao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    
    @Autowired
    UserMapper userMapper;
    
    
    public User findByName(String username) {
        if (StringUtils.isNotBlank(username)) {

            User user = userMapper.findByName(username);

            return user;
        }
        return null;
    }
}
