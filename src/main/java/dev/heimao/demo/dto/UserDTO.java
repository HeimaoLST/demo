package dev.heimao.demo.dto;

import dev.heimao.demo.entity.User;

public class



UserDTO {


    private Integer uid;
    private String username;
    public Integer getUid() {
        return uid;
    }
    public UserDTO(User user){
        this.uid = user.getUid();
        this.username = user.getUsername();
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

}
