package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.constant.Constans;
import com.xiaoping.pojo.Rs;
import com.xiaoping.utils.RandomHelper;
import com.xiaoping.utils.StringHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController extends BaseBizController {

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String mailUser;

    private Logger logger = Logger.getLogger(MailController.class);

    @GetMapping("/send")
    public Rs sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailUser);
        message.setTo("784516419@qq.com");
        message.setSubject("主题");
        message.setText("这是内容");
        sender.send(message);
        return Rs.ok();
    }

    @GetMapping("/sendTick")
    public Rs sendTick() {
        String email = requireStringParam("email");
        if ( !StringHelper.isEmail(email) ) {
            return Rs.errParamer("邮箱不正确");
        }
        SimpleMailMessage mail = new SimpleMailMessage();
        logger.info("mailUser: " +  mailUser);
        mail.setFrom(mailUser);
        mail.setTo(email);
        mail.setSubject("【验证码】请查收您的验证码，10 分钟内有效");
        String code = RandomHelper.getRandomNumberCode(6);
        mail.setText("验证码：" + code);
        session.setAttribute(Constans.EMAIL_CODE_SESSION_KEY + email, code);
        session.setMaxInactiveInterval(60*10);
        sender.send(mail);
        return Rs.ok();
    }

}
