package com.xiaoping.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserStatTask {

    private Logger logger = Logger.getLogger(UserStatTask.class);

    // 60s 执行一次
    @Scheduled(cron="0/60 * *  * * ? ")
    public void execute() {
        logger.info("UserStatTask execute invoke");
    }
}
