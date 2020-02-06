package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.constant.Constans;
import com.xiaoping.pojo.Rs;
import com.xiaoping.utils.CaptchaHelper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ImageCodeController extends BaseBizController {

    private Logger logger = Logger.getLogger(ImageCodeController.class);

    @GetMapping("/image/captcha")
    public void captcha() {
        String captcha = CaptchaHelper.out(response);
        // 保存 captcha 到 session 中
        logger.info("[图形验证码]" + captcha);
        session.setAttribute(Constans.IMAGE_CODE_SESSION_KEY, captcha.toLowerCase());
    }

    @GetMapping("/image/testcode")
    @ResponseBody
    public Rs testCode() {
        return Rs.ok();
    }

}
