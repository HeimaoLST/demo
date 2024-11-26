package dev.heimao.demo.service;

import org.springframework.stereotype.Service;


public interface BlackListService {
    public void addToBlacklist(Integer id, String username, String reason);

    boolean isUserBlacklisted(String username);
}
