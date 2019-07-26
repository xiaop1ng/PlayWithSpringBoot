package com.xiaoping.base.impl;

import com.xiaoping.base.BaseController;
import com.xiaoping.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务处理器基类
 */
public class BaseBizController implements BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    private Logger logger = LoggerFactory.getLogger(BaseBizController.class);

    /**
     * spring ModelAttribute
     * 放置在方法上面：表示请求该类的每个Action前都会首先执行它，也可以将一些准备数据的操作放置在该方法里面
     */
    @ModelAttribute
    public void setBaseBizController(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
        this.session=request.getSession();
    }

    @Override
    public HttpServletRequest getRequest() {
        return this.request;
    }

    @Override
    public HttpServletResponse getResponse() {
        return this.response;
    }

    @Override
    public HttpSession getSession() {
        return this.session;
    }

    @Override
    public String getIp() {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @Override
    public String getStringParam(String paramName) {
        String result = request.getParameter(paramName);
        result = StringHelper.decodeHtml(result);
        return result;
    }

    @Override
    public String getStringParam(String paramName, String defaultValue) {
        String result = getStringParam(paramName);
        if(StringHelper.isEmpty(result)) {
            return defaultValue;
        }
        return result;
    }

    private int parseIntParam(String paramName, int defaultValue) {
        String result = request.getParameter(paramName);
        if(StringHelper.isEmpty(result)) {
            return defaultValue;
        }
        int value;
        try{
            value = Integer.parseInt(result);
        } catch (Exception ex) {
            logger.debug("参数`" + paramName + "`对应的值`" + result + "`不是数字，返回0", ex);
            value = 0;
        }
        return value;
    }

    private long parseLongParam(String paramName, long defaultValue) {
        String result = request.getParameter(paramName);
        if(StringHelper.isEmpty(result)) {
            return defaultValue;
        }
        long value;
        try{
            value = Long.parseLong(result);
        } catch (Exception ex) {
            logger.debug("参数`" + paramName + "`对应的值`" + result + "`不是数字，返回0", ex);
            value = 0;
        }
        return value;
    }

    private double parseDoubleParam(String paramName, double defaultValue) {
        String result = request.getParameter(paramName);
        if(StringHelper.isEmpty(result)) {
            return defaultValue;
        }
        double value;
        try{
            value = Double.parseDouble(result);
        } catch (Exception ex) {
            logger.debug("参数`" + paramName + "`对应的值`" + result + "`不是数字，返回0", ex);
            value = 0;
        }
        return value;
    }

    @Override
    public int getIntParam(String paramName) {
        return parseIntParam(paramName, 0);
    }

    @Override
    public int getIntParam(String paramName, int defaultValue) {
        return parseIntParam(paramName, defaultValue);
    }

    @Override
    public long getLongParam(String paramName) {
        return parseLongParam(paramName, 0);
    }

    @Override
    public long getLongParam(String paramName, long defaultValue) {
        return parseLongParam(paramName, defaultValue);
    }

    @Override
    public double getDoubleParam(String paramName) {
        return parseDoubleParam(paramName, 0);
    }

    @Override
    public double getDoubleParam(String paramName, double defaultValue) {
        return parseDoubleParam(paramName, defaultValue);
    }

    @Override
    public Map getParamMap() {
        // request 中防止重名参数问题，所以把 value 做成了数组，我们这里不考虑参数重名问题
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> retMap = new HashMap<>();
        parameterMap.forEach((key, val) ->{
            retMap.put(key, val[0]);
        });
        return retMap;
    }
}
