package dev.heimao.demo.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import dev.heimao.demo.dto.UserDTO;
import dev.heimao.demo.service.BlackListService;
import dev.heimao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BlackListService blacklistService;

    @GetMapping("admin/deleteUser/{id}")
    public SaResult deleteUser(@PathVariable Integer id) {
        StpUtil.checkLogin();
        StpUtil.getRoleList();
        StpUtil.checkRole("admin");
        if (userService.findById(id) == null) {
            return SaResult.error("用户不存在");
        }
        UserDTO userDTO = new UserDTO(userService.findById(id));
//        userService.deleteUser(id);
        blacklistService.addToBlacklist(id, userDTO.getUsername(), "Deleted by admin");
        return SaResult.data(userDTO);
    }

    @GetMapping("admin/getAllUser")
    public SaResult findAll() {
        StpUtil.checkLogin();
        StpUtil.getRoleList();
        StpUtil.checkRole("admin");
        return SaResult.data(userService.findAll());
    }
}
