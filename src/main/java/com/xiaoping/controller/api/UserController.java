package com.xiaoping.controller.api;

import com.xiaoping.entity.User;
import com.xiaoping.pojo.Rs;
import com.xiaoping.service.UserService;
import com.xiaoping.utils.DataRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Rs test() {
        DataRow data = new DataRow();
        data.set("key", "张三丰");
        data.set("value", "李晓晓");
        return Rs.ok(data);
    }

    @RequestMapping("/signup")
    public Rs register(@RequestParam String username, @RequestParam String password){
        if(userService.findByName(username) != null) {
            return Rs.errMsg("username had register");
        }
        User user = userService.register(new User(username, DigestUtils.md5DigestAsHex(password.getBytes())));
        if(user != null) {
            return Rs.ok(user);
        }
        return Rs.errMsg("register fail.");
    }

    @PostMapping("/sign")
    public Rs sign(@RequestParam String username, @RequestParam String password,
                   @RequestParam String email, @RequestParam String code) {


        return Rs.ok();
    }

}
