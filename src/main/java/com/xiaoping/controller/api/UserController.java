package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.pojo.Rs;
import com.xiaoping.service.UserService;
import com.xiaoping.utils.DataRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController extends BaseBizController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/test")
    public Rs test() {
        DataRow data = new DataRow();
        data.set("key", "张三丰");
        data.set("value", "李晓晓");
        return Rs.ok(data);
    }

//    @RequestMapping("/signup")
//    public Rs register(@RequestParam String username, @RequestParam String password){
//        if(userService.findByName(username) != null) {
//            throw new InvokeException("username had register");
//        }
//        User user = userService.register(new User(username, DigestUtils.md5DigestAsHex(password.getBytes())));
//        if(user != null) {
//            return Rs.ok(user);
//        }
//        return Rs.errMsg("register fail.");
//    }

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
