package com.xiaoping.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface BaseController {

    /**
     * 获取请求对象
     */
    HttpServletRequest getRequest();

    /**
     * 获取响应对象
     */
    HttpServletResponse getResponse();

    /**
     * 获取会话对象
     */
    HttpSession getSession();

    /**
     * 获取请求Ip
     */
    String getIp();

    /**
     * 获取参数
     * @param paramName 参数名
     */
    String getStringParam(String paramName);

    /**
     * 获取参数
     * @param paramName 参数名
     * @param defaultValue 缺省值
     */
    String getStringParam(String paramName, String defaultValue);

    /**
     * 获取并校验参数非空
     * @param paramName 参数名
     */
    String requireStringParam(String paramName);

    /**
     * 获取并校验参数非空
     * @param paramName 参数名
     * @param tips 参数为空自定义提示
     */
    String requireStringParam(String paramName, String tips);

    int getIntParam(String paramName);

    int getIntParam(String paramName, int defaultValue);

    int requireIntParam(String paramName);

    int requireIntParam(String paramName, String tipsEmpty, String tipsNaN);

    long getLongParam(String paramName);

    long getLongParam(String paramName, long defaultValue);

    long requireLongParam(String paramName);

    long requireLongParam(String paramName, String tipsEmpty, String tipsNaN);

    double getDoubleParam(String paramName);

    double getDoubleParam(String paramName, double defaultValue);

    double requireDoubleParam(String paramName);

    double requireDoubleParam(String paramName, String tipsEmpty, String tipsNaN);

    /**
     * 获取请求参数map
     */
    Map getParamMap();

}
