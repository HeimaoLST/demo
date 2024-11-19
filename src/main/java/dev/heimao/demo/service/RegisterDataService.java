package dev.heimao.demo.service;

public interface RegisterDataService {

    boolean isUserExist(String username);

    boolean userRegister(String username, String password);

    boolean adminRegister(String username, String password);
}
