package com.xiaoping.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class NumberHelper {


    /**
     * 描述：通过一个整数i获取你所要的哪几个(从0开始)
     * i为 多个2的n次方之和，如i=7，那么根据原值是2的n次方之各，你的原值必定是1，2，4 。
     * @param i 数值
     * @return
     */
    public static int[] getWhich(long i)
    {
        int exp = Math.getExponent(i);
        if (i == (1 << (exp + 1)) - 1)
        {
            exp = exp + 1;
        }
        int[] num = new int[exp];
        int x = exp - 1;
        for (int n = 0; (1 << n) < i + 1; n++)
        {
            if ((1 << (n + 1)) > i && (1 << n) < (i + 1))
            {
                num[x] = n;
                i -= 1 << n;
                n = 0;
                x--;
            }
        }
        return num;
    }

    /**
     * 描述：非四舍五入取整处理
     * @param v 需要四舍五入的数字
     * @return
     */
    public static int roundDown(double v)
    {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, 0, BigDecimal.ROUND_DOWN).intValue();
    }

    /**
     * 描述：四舍五入取整处理
     * @param v 需要四舍五入的数字
     * @return
     */
    public static int roundUp(double v)
    {
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, 0, BigDecimal.ROUND_UP).intValue();
    }

    /**
     * 描述：提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 描述：四舍五入保留两位小数
     * @param num 数字
     * @return 保留两位小数的数字字串
     */
    public static String format(double num)
    {
        return format(num, "0.00");
    }

    /**
     * 描述：四舍五入数字保留小数位
     * @param num 数字
     * @param digits 小数位
     * @return
     */
    public static String format(double num, int digits)
    {
        String pattern = "0";
        if (digits > 0)
        {
            pattern += "." + createStr("0", digits, "");
        }
        return format(num, pattern);
    }

    /**
     * 描述：数字格式化
     * @param num 数字
     * @param pattern 格式
     * @return
     */
    public static String format(double num, String pattern)
    {
        NumberFormat fmt = null;
        if (pattern != null && pattern.length() > 0)
        {
            fmt = new DecimalFormat(pattern);
        }
        else
        {
            fmt = new DecimalFormat();
        }
        return fmt.format(num);
    }

    /**
     * 求浮点数的权重
     *
     * @param number
     * @return
     */
    public static double weight(double number)
    {
        if (number == 0)
        {
            return 1;
        }

        double e = Math.log10(Math.abs(number));
        int n = Double.valueOf(Math.floor(e)).intValue();
        double weight = 1;
        if (n > 0)
        {
            for (int i = 0; i < n; i++)
            {
                weight *= 10;
            }
        }
        else
        {
            for (int i = 0; i > n; i--)
            {
                weight /= 10;
            }
        }
        return weight;
    }

    /**
     * 获得权重的单位
     *
     * @param scale
     * @return
     */
    public static String unit(double scale)
    {
        if (scale == 1 || scale == 0)
        {
            return "";// 不设置单位倍率单位，使用基准单位
        }
        String[] units = new String[] { "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "兆" };
        String[] units2 = new String[] { "十分", "百分", "千分", "万分", "十万分", "百万分", "千万分" };
        double e = Math.log10(scale);
        int position = Double.valueOf(Math.ceil(e)).intValue();
        if (position >= 1 && position <= units.length)
        {
            return units[position - 1];
        }
        else if (position <= -1 && -position <= units2.length)
        {
            return units2[-position - 1];
        }
        else
        {
            return "无量";
        }
    }

    /**
     * 获得浮点数的缩放比例
     *
     * @param num
     * @return
     */
    public static double scale(double num)
    {
        double absValue = Math.abs(num);
        // 无需缩放
        if (absValue < 10000 && absValue >= 1)
        {
            return 1;
        }
        // 无需缩放
        else if (absValue < 1 && absValue > 0.0001)
        {
            return 1;
        }
        else
        {
            return weight(num) / 10;
        }
    }

    /**
     * 获得缩放后并且格式化的浮点数
     *
     * @param num
     * @param scale
     * @return
     */
    public static double scaleNumber(double num, double scale)
    {
        DecimalFormat df = null;
        if (scale == 1)
        {
            df = new DecimalFormat("#.0000");
        }
        else
        {
            df = new DecimalFormat("#.00");
        }
        double scaledNum = num / scale;
        return Double.valueOf(df.format(scaledNum));
    }

    /**
     * 产生n位随机数 TODO:性能不要，有待优化
     */
    public static String ramdomNumber(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("n must be positive !");
        }
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

    /**
     * 缩放1W倍
     */
    public static double changeTo(double number)
    {
        boolean flag = false;
        if (number < 0)
        {
            flag = true;
        }
        double value = Math.abs(number);
        value = value / 10000.0;
        if (flag)
        {
            value = Double.parseDouble("-" + value);
        }
        return value;
    }

    /**
     *
     * 描述：缩放比例
     * @param number
     * @param scale
     * @param points
     * @return
     */
    public static String scaleNumberToStr(double number, double scale, int points)
    {
        boolean flag = (number < 0);
        number = Math.abs(number);
        String result = "";
        DecimalFormat nbf3 = (DecimalFormat) NumberFormat.getInstance();// 默认格式
        nbf3.setGroupingUsed(false);
        nbf3.setMinimumFractionDigits(points);
        nbf3.setMaximumFractionDigits(points);
        double scaledNum = number / scale;
        result = nbf3.format(scaledNum);
        if (flag)
        {
            result = "-" + result;
        }
        return result;
    }

    /**
     * 描述：生成字符串
     * 作者：李建  lijian@thinkive.com
     * 时间：Mar 18, 2010 2:48:39 PM
     * @param arg0 字符串元素
     * @param arg1 生成个数
     * @return
     */
    public static String createStr(String arg0, int arg1)
    {
        if ( arg0 == null )
        {
            return "";
        }
        return createStr(arg0, arg1, ",");
    }

    /**
     * 描述：生成字符串
     * @param arg0 字符串元素
     * @param arg1 生成个数
     * @param arg2 间隔符号
     * @return
     */
    public static String createStr(String arg0, int arg1, String arg2)
    {
        if ( arg0 == null )
        {
            return "";
        }
        else
        {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arg1; i++)
            {
                if ( arg2 == null )
                    arg2 = "";
                sb.append(arg0).append(arg2);
            }
            if ( sb.length() > 0 )
            {
                sb.delete(sb.lastIndexOf(arg2), sb.length());
            }

            return sb.toString();
        }
    }
}
