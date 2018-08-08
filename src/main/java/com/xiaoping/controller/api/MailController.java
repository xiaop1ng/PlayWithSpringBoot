package com.xiaoping.controller.api;

import com.xiaoping.pojo.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private JavaMailSender sender;

    @GetMapping("/send")
    public Rs sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("13227379709@163.com");
        message.setTo("784516419@qq.com");
        message.setSubject("主题");
        message.setText("这是内容");
        sender.send(message);
        return Rs.ok();
    }
}
