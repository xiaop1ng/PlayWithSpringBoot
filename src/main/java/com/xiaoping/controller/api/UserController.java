package com.xiaoping.controller.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.constant.Constans;
import com.xiaoping.entity.User;
import com.xiaoping.exception.InvokeException;
import com.xiaoping.pojo.Rs;
import com.xiaoping.service.UserService;
import com.xiaoping.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/api/user")
public class UserController extends BaseBizController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 注册
     */
    @PostMapping("/signup")
    public Rs signup() {
        String username = requireStringParam("username");
        String password = requireStringParam("password");
        String email = requireStringParam("email");
        String code = requireStringParam("code");
        if(!StringHelper.isEmail(email)) {
            throw new InvokeException(Rs.ERROR_CODE_PARAM_ERROR, "邮箱格式不正确");
        }
        User checkByName = userService.findByName(username);
        if(null != checkByName) {
            throw new InvokeException(Rs.ERROR_CODE_BIZ, "该用户名已被注册！");
        }

        User checkByEmail = userService.findByEmail(email);

        if(null != checkByEmail) {
            throw new InvokeException(Rs.ERROR_CODE_BIZ, "该邮箱已被其他账户绑定！");
        }

        User user = new User();
        user.setUserName(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setEmail(email);
        user = userService.register(user);
        return Rs.ok(user, "注册成功！");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Rs login() {

        String username = requireStringParam("username");
        String password = requireStringParam("password");

        User checkByName = userService.findByName(username);
        if(null == checkByName) {
            throw new InvokeException(Rs.ERROR_CODE_BIZ, "该账户还未注册，请先注册！");
        }
        User user = new User();
        user.setUserName(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        User loginUser = userService.login(user);

        if(null == loginUser) {
            // 这里可以做一个错误次数放在 session 或者内存中，后面方便做登录限制
            throw new InvokeException(Rs.ERROR_CODE_UNAUTHORIZED, "用户名或密码错误。");
        }

        // 生成 token 信息
        Algorithm algorithm = Algorithm.HMAC256(Constans.JWT_SECRET);
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + 1000*60*30); // 半小时
        String token = JWT.create()
                .withIssuer(Constans.JWT_ISSUER) // 签发人
                .withExpiresAt(expireTime)
                .withClaim("username", loginUser.getUserName())
                .withClaim("id", loginUser.getId())
                .sign(algorithm);
        response.setHeader(Constans.HEADER_AUTHORIZATION, "Bearer " + token);
        return Rs.ok(loginUser, "登录成功");
    }



}
