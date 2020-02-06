package com.xiaoping.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class CaptchaHelper {

    protected Font font = new Font("Arial", Font.BOLD, 32); // 字体Verdana
    protected int len = 4; // 验证码随机字符长度
    protected int width = 130; // 验证码显示宽度
    protected int height = 48; // 验证码显示高度
    protected String chars = null; // 当前验证码
    // 常用颜色
    protected static final int[][] COLOR = {{0, 135, 255}, {51, 153, 51}, {255, 102, 102}, {255, 153, 0}, {153, 102, 0}, {153, 102, 153}, {51, 153, 153}, {102, 102, 255}, {0, 102, 204}, {204, 51, 51}, {0, 153, 204}, {0, 51, 102}};
    protected static final Random RANDOM = new Random();
    // 定义验证码字符.去除了O和I等容易混淆的字母
    protected static final char ALPHA[] = {'2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'G', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private CaptchaHelper(){};

    /**
     * 产生两个数之间的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    private static int num(int min, int max) {
        return min + RANDOM.nextInt(max - min);
    }

    /**
     * 产生0-num的随机数,不包括num
     *
     * @param num 最大值
     * @return 随机数
     */
    private static int num(int num) {
        return RANDOM.nextInt(num);
    }

    /**
     * 返回ALPHA中的随机字符
     *
     * @return 随机字符
     */
    private static char alpha() {
        return ALPHA[num(ALPHA.length)];
    }

    /**
     * 返回ALPHA中第0位到第num位的随机字符
     *
     * @param num 到第几位结束
     * @return 随机字符
     */
    private static char alpha(int num) {
        return ALPHA[num(num)];
    }

    /**
     * 返回ALPHA中第min位到第max位的随机字符
     *
     * @param min 从第几位开始
     * @param max 到第几位结束
     * @return 随机字符
     */
    private static char alpha(int min, int max) {
        return ALPHA[num(min, max)];
    }

    public static String out(HttpServletResponse response) {
        return new CaptchaHelper().outImage(response);
    }

    public static String out(HttpServletResponse response, int len) {
        CaptchaHelper captchaHelper = new CaptchaHelper();
        captchaHelper.len = len;
        return captchaHelper.outImage(response);
    }

    public static String out(HttpServletResponse response, int len, int width) {
        CaptchaHelper captchaHelper = new CaptchaHelper();
        captchaHelper.len = len;
        captchaHelper.width = width;
        return captchaHelper.outImage(response);
    }

    public static String out(HttpServletResponse response, int len, int width, int height) {
        CaptchaHelper captchaHelper = new CaptchaHelper();
        captchaHelper.len = len;
        captchaHelper.width = width;
        captchaHelper.height = height;
        return captchaHelper.outImage(response);
    }

    public static String out(HttpServletResponse response, int len, int width, int height, Font font) {
        CaptchaHelper captchaHelper = new CaptchaHelper();
        captchaHelper.len = len;
        captchaHelper.width = width;
        captchaHelper.height = height;
        captchaHelper.font = font;
        return captchaHelper.outImage(response);
    }

    private String outImage(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        char[] strs = alphas();
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) bi.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            // 抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setStroke(new BasicStroke(1.3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            // 随机画干扰线
            drawLine(3, g);
            // 随机画干扰圆
            drawOval(8, g);
            // 画字符串
            AlphaComposite ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);// 指定透明度
            g.setComposite(ac3);
            int hp = (height - font.getSize()) >> 1;
            int h = height - hp;
            int w = width / strs.length;
            int sp = (w - font.getSize()) / 2;
            for (int i = 0; i < strs.length; i++) {
                g.setColor(new Color(20 + num(110), 20 + num(110), 20 + num(110)));
                // 计算坐标
                int x = i * w + sp + num(3);
                int y = h - num(3, 6);
                if (x < 8) {
                    x = 8;
                }
                if (x + font.getSize() > width) {
                    x = width - font.getSize();
                }
                if (y > height) {
                    y = height;
                }
                if (y - font.getSize() < 0) {
                    y = font.getSize();
                }
                g.setFont(font.deriveFont(num(2) == 0 ? Font.PLAIN : Font.ITALIC));
                g.drawString(String.valueOf(strs[i]), x, y);
            }
            ImageIO.write(bi, "png", out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return String.valueOf(chars);

    }

    private char[] alphas() {
        char[] cs = new char[len];
        for (int i = 0; i < len; i++) {
            cs[i] = alpha();
        }
        chars = new String(cs);
        return cs;
    }

    /**
     * 给定范围获得随机颜色
     *
     * @param fc 0-255
     * @param bc 0-255
     * @return 随机颜色
     */
    private Color color(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + num(bc - fc);
        int g = fc + num(bc - fc);
        int b = fc + num(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 获取当前的验证码
     *
     * @return 字符串
     */
    private String text() {
        checkAlpha();
        return chars;
    }

    /**
     * 获取当前验证码的字符数组
     *
     * @return 字符数组
     */
    private char[] textChar() {
        checkAlpha();
        return chars.toCharArray();
    }

    /**
     * 检查验证码是否生成，没有这立即生成
     */
    private void checkAlpha() {
        if (chars == null) {
            alphas(); // 生成验证码
        }
    }

    /**
     * 随机画干扰线
     *
     * @param num 数量
     * @param g   Graphics2D
     */
    private void drawLine(int num, Graphics2D g) {
        drawLine(num, null, g);
    }

    /**
     * 随机画干扰线
     *
     * @param num   数量
     * @param color 颜色
     * @param g     Graphics2D
     */
    private void drawLine(int num, Color color, Graphics2D g) {
        for (int i = 0; i < num; i++) {
            g.setColor(color == null ? color(150, 250) : color);
            int x1 = num(-10, width - 10);
            int y1 = num(5, height - 5);
            int x2 = num(10, width + 10);
            int y2 = num(2, height - 2);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 随机画干扰圆
     *
     * @param num 数量
     * @param g   Graphics2D
     */
    private void drawOval(int num, Graphics2D g) {
        for (int i = 0; i < num; i++) {
            g.setColor(color(100, 250));
            g.drawOval(num(width), num(height), 10 + num(20), 10 + num(20));
        }
    }

    /**
     * 随机画干扰圆
     *
     * @param num   数量
     * @param color 颜色
     * @param g     Graphics2D
     */
    private void drawOval(int num, Color color, Graphics2D g) {
        for (int i = 0; i < num; i++) {
            g.setColor(color == null ? color(100, 250) : color);
            g.drawOval(num(width), num(height), 10 + num(20), 10 + num(20));
        }
    }

}
