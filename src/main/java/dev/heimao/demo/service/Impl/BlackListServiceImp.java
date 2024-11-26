package dev.heimao.demo.service.Impl;

import dev.heimao.demo.entity.Blacklist;
import dev.heimao.demo.mapper.BlacklistMapper;
import dev.heimao.demo.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackListServiceImp implements BlackListService {

    @Autowired
    BlacklistMapper blacklistMapper;

    public void addToBlacklist(Integer id, String username, String reason) {
        Blacklist blacklist = new Blacklist();
        blacklist.setId(id);
        blacklist.setUsername(username);
        blacklist.setReason(reason);
        blacklistMapper.insertBlacklist(blacklist);
    }

    @Override
    public boolean isUserBlacklisted(String username) {
        return blacklistMapper.isUserBlacklisted(username) > 0;
    }
}

