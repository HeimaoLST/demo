package dev.heimao.demo.service;

import dev.heimao.demo.entity.User;

public interface UserService {
     User findByName(String username);
}
