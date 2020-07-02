package com.xiaoping.cmdtest.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class ConvertTest {

    public static void main(String[] args) {
        String date = "20200512";

        Date dateObj = Convert.toDate(date);

        System.out.println(dateObj); // Tue May 12 00:00:00 CST 2020

        double amount = 13600348.66d;

        String amountCn = Convert.digitToChinese(amount);

        System.out.println(amountCn); // 壹仟叁佰陆拾万零叁佰肆拾捌元陆角陆分


        String now = DateUtil.now();
        System.out.println(now);
        String today = DateUtil.today();
        System.out.println(today);
        Date yesterday = DateUtil.yesterday();

        ChineseDate dateCn = new ChineseDate(yesterday);
        System.out.println(dateCn); // 庚子鼠年 四月十九
        System.out.println(dateCn.getFestivals());


    }

}
