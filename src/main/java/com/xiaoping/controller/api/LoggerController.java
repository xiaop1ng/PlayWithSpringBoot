package com.xiaoping.controller.api;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {

    Logger logger = Logger.getLogger(LoggerController.class);

}
