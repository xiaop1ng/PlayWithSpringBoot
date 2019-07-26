package com.xiaoping.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface BaseController {

    HttpServletRequest getRequest();

    HttpServletResponse getResponse();

    HttpSession getSession();

    String getIp();

    String getStringParam(String paramName);

    String getStringParam(String paramName, String defaultValue);

    int getIntParam(String paramName);

    int getIntParam(String paramName, int defaultValue);

    long getLongParam(String paramName);

    long getLongParam(String paramName, long defaultValue);

    double getDoubleParam(String paramName);

    double getDoubleParam(String paramName, double defaultValue);

    Map getParamMap();

}
