package dev.heimao.demo.common;

import cn.dev33.satoken.stp.SaTokenInfo;
import dev.heimao.demo.dto.UserDTO;

public class LoginResponse {
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SaTokenInfo getToken() {
        return token;
    }

    public void setToken(SaTokenInfo token) {
        this.token = token;
    }

    private Integer uid;
    private String username;
    private SaTokenInfo token;

    public  LoginResponse(UserDTO userDTO, SaTokenInfo SaTokenInfo) {

        this.uid = userDTO.getUid();
        this.username = userDTO.getUsername();
        this.token = SaTokenInfo;




    }
}

