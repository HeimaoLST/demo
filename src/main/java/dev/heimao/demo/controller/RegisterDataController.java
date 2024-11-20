package dev.heimao.demo.controller;

import dev.heimao.demo.common.CommonResponse;
import dev.heimao.demo.entity.Register;
import dev.heimao.demo.service.RegisterDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterDataController {

    private static final Logger log = LoggerFactory.getLogger(RegisterDataController.class);

    @Autowired
    RegisterDataService registerDataService;

    @PostMapping("/register")
    public CommonResponse<String> register(@RequestBody @Validated Register register) {
        boolean flag = registerDataService.userRegister(register.getUsername(), register.getPassword());

        if (flag) {
            log.info("User: " + register.getUsername() + " 注册成功");
            return new CommonResponse<>(200, true,"注册成功", null);
        } else {
            log.info("User: " + register.getUsername() + " 注册失败");
            return new CommonResponse<>(400, false,"注册失败", null);
        }
    }
    @PostMapping("/adminRegister")
    public CommonResponse<String> adminRegister(@RequestBody @Validated Register register) {
        boolean flag = registerDataService.adminRegister(register.getUsername(), register.getPassword());

        if (flag) {
            log.info("Admin: " + register.getUsername() + " 注册成功");
            return new CommonResponse<>(200, true,"管理员注册成功", null);
        } else {
            log.info("Admin: " + register.getUsername() + " 注册失败");
            return new CommonResponse<>(400, false,"管理员注册失败", null);
        }
    }
}