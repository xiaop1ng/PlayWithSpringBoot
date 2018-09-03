package com.xiaoping.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping("/chat")
    public String chat(HttpServletRequest req) {
        return "chat";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest req) {
        return "index";
    }

}
