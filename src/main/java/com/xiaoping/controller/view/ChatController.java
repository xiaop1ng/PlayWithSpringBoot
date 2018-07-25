package com.xiaoping.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @RequestMapping("/chat")
    public String chat(HttpServletRequest req) {
        return "chat";
    }

}
