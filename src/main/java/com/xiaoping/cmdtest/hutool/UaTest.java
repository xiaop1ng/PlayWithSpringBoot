package com.xiaoping.cmdtest.hutool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UaTest {

    public static void main(String[] args) {
        String uaStr = "Mozilla/5.0 (Linux; Android 9; Redmi 8A Build/PKQ1.190319.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/80.0.3987.99 Mobile Safari/537.36 MMWEBID/990 MicroMessenger/7.0.13.1640(0x27000D38) Process/tools NetType/4G Language/zh_CN ABI/arm32 WeChat/arm32";
        String reg = "MicroMessenger/[\\d\\.]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(uaStr);
        if(m.find()) {
            System.out.println(m.group()); // MicroMessenger/7.0.13.1640
        }
    }
}
