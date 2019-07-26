package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.pojo.Rs;
import com.xiaoping.service.UserService;
import com.xiaoping.utils.DataRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController extends BaseBizController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/signup")
    public Rs signup() {
        String username = getStringParam("username");
        String password = getStringParam("password");
        String email = getStringParam("email");
        String code = getStringParam("code");
        logger.info("username: " + username + " password: " + password + " email: " + email + " code: " + code );
        DataRow param = new DataRow(getParamMap());
        logger.info(param.toString());
        return Rs.ok();
    }

}
