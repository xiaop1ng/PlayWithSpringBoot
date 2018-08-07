package com.xiaoping.controller.api;

import com.xiaoping.entity.User;
import com.xiaoping.pojo.Rs;
import com.xiaoping.service.UserService;
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
        return Rs.ok();
    }

    @PostMapping("/signup")
    public Rs register(@RequestParam String username, @RequestParam String password){
        if(userService.findByName(username) != null) {
            return Rs.errorMsg("username had register");
        }
        User user = userService.register(new User(username, DigestUtils.md5DigestAsHex(password.getBytes())));
        if(user != null) {
            return Rs.ok(user);
        }
        return Rs.errorMsg("register fail.");
    }
}
