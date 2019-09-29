package com.xiaoping.cmdtest.log4j;

import com.google.common.base.Objects;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4jTest {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Log4jTest.class);

        Logger rootLogger = Logger.getRootLogger();

        Logger rootLog = LogManager.getRootLogger();

        System.out.println(Objects.equal(rootLog, rootLogger)); // true

        System.out.println(Objects.equal(logger, rootLogger)); // false

    }
}
