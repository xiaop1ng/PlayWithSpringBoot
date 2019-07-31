package com.xiaoping.controller.api;

import com.xiaoping.base.impl.BaseBizController;
import com.xiaoping.constant.Constans;
import com.xiaoping.utils.CaptchaHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageCodeController extends BaseBizController {

    private Logger logger = LoggerFactory.getLogger(ImageCodeController.class);

    @GetMapping("/image/captcha")
    public void captcha() throws Exception {
        String captcha = CaptchaHelper.out(response);
        // 保存 captcha 到 session 中
        logger.info("[图形验证码]" + captcha);
        session.setAttribute(Constans.IMAGE_CODE_SESSION_KEY, captcha.toLowerCase());
    }

}
