package dev.heimao.demo.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import dev.heimao.demo.common.CommonResponse;
import dev.heimao.demo.common.LoginResponse;
import dev.heimao.demo.dto.UserDTO;
import dev.heimao.demo.entity.LoginData;
import dev.heimao.demo.entity.User;
import dev.heimao.demo.service.BlackListService;
import dev.heimao.demo.service.LogService;
import dev.heimao.demo.service.LoginDataService;
import dev.heimao.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginDataController {


    private static final Logger log = LoggerFactory.getLogger(LoginDataController.class);

    @Autowired
    LoginDataService loginDataService;

    @Autowired
    UserService userService;

    @Autowired
    BlackListService blacklistService;

    @Autowired
    LogService logService;

    @PostMapping("/login")
    public SaResult doLogin(@RequestBody @Validated LoginData loginData) {
        boolean flag = loginDataService.login(loginData.getUsername(), loginData.getPassword());
        Integer uid = loginDataService.getUserId(loginData.getUsername());
        User user = userService.findByName(loginData.getUsername());

        logService.logOperation(loginData.getUsername(), "try login");
            if (blacklistService.isUserBlacklisted(user.getUsername())) {
                    return SaResult.error("用户已被拉黑");
            }
            if (uid == null) {
                return SaResult.error("登录失败");
            }
            String ClientId = "User" + uid;
            UserDTO userDTO = new UserDTO(user);

            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            LoginResponse Data = new LoginResponse(userDTO, tokenInfo);

            if (flag) {

                StpUtil.login(ClientId);
                log.info("User: " + loginData.getUsername() + " 登录成功");
                logService.logOperation(loginData.getUsername(), "login success");

                return SaResult.data(Data);


            } else {
                log.info("User: " + loginData.getUsername() + " 登录失败");
                logService.logOperation(loginData.getUsername(), "login failed");
                return SaResult.error("登录失败");
            }

    }

        @PostMapping("/adminLogin")
        public SaResult doAdminLogin (@RequestBody @Validated LoginData loginData){
            boolean flag = loginDataService.adminLogin(loginData.getUsername(), loginData.getPassword());
            Integer uid = loginDataService.getAdminId(loginData.getUsername());
            User user = userService.findAdminByName(loginData.getUsername());
            logService.logOperation(loginData.getUsername(), "try admin login");

            if (uid == null) {
                return SaResult.error("登录失败");
            }
            String ClientId = "Admin" + uid;
            UserDTO userDTO = new UserDTO(user);

            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            LoginResponse Data = new LoginResponse(userDTO, tokenInfo);

            if (flag) {
                log.info("Admin: " + loginData.getUsername() + " 登录成功");
                logService.logOperation(loginData.getUsername(), "admin login success");
                StpUtil.login(ClientId);
                return SaResult.data(Data);
            } else {
                log.info("Admin: " + loginData.getUsername() + " 登录失败");
                logService.logOperation(loginData.getUsername(), "admin login failed");
                return SaResult.error("登录失败");
            }

        }
        //调试接口
        @GetMapping("token")
        public SaResult showToken () {
            StpUtil.getRoleList();
            StpUtil.checkRole("admin");
            if (StpUtil.getTokenValue() != null) {
                return SaResult.ok((String) StpUtil.getLoginIdByToken(StpUtil.getTokenValue()));
            } else {
                return SaResult.error("未登录");
            }

        }
        @GetMapping("logout")
        public SaResult logout () {
            StpUtil.logout();
            logService.logOperation((String) StpUtil.getLoginId(), "logout");
            return SaResult.ok();
        }
    }
