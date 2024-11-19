package dev.heimao.demo.entity;

import jakarta.validation.constraints.NotBlank;

public class LoginData {

    @NotBlank(message = "username can not be empty")
    private String username;
    @NotBlank(message = "password can not be empty")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
