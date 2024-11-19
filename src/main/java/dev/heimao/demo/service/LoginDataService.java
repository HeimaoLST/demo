package dev.heimao.demo.service;

public interface LoginDataService {

        boolean login(String username, String password);
        Integer getUserId(String username);

        boolean adminLogin(String username, String password);

        Integer getAdminId(String username);
}
