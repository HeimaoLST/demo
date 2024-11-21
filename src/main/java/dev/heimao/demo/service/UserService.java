package dev.heimao.demo.service;

import dev.heimao.demo.dto.UserDTO;
import dev.heimao.demo.entity.User;

import java.util.List;

public interface UserService {
     User findByName(String username);
     User findById(Integer uid);
     List<UserDTO> findAll();
     boolean deleteUser(Integer uid);
     User findAdminByName(String username);
}
