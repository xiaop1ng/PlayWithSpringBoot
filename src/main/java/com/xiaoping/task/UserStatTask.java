package com.xiaoping.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserStatTask {

    private Logger logger = LoggerFactory.getLogger(UserStatTask.class);

    // 120s 执行一次
    @Scheduled(cron="0/120 * *  * * ? ")
    public void execute() {
        logger.info("UserStatTask execute invoke");
    }
}
