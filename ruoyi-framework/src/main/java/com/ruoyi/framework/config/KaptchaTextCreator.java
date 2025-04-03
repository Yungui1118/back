package com.ruoyi.framework.config;

import java.util.Random;
import com.google.code.kaptcha.text.impl.DefaultTextCreator;

/**
 * 验证码文本生成器
 *
 * @author ruoyi
 */
public class KaptchaTextCreator extends DefaultTextCreator
{
    private static final String[] CNUMBERS = "0,1,2,3,4,5,6,7,8,9,10".split(",");

    /**
     * math.random() 随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
     *
     * Math.round(1.2);  //1.2的相邻整数区间是[1,2],更加靠近1,所以结果是1
     * Math.round(1.6);  //1.6相邻整数区间是[1,2],更加靠近2,所以结果是2
     */

    @Override
    public String getText()
    {
        Integer result = 0;
        Random random = new Random();
        int x = random.nextInt(6) + 3;
        int []numbers = {2,3,4,5,6};
        int index = random.nextInt(numbers.length);
        int y = numbers[index];
        StringBuilder suChinese = new StringBuilder();
        int randomoperands = (int) Math.round(Math.random() * 2);
        if(randomoperands == 0)
        {
            result = x + y;
            suChinese.append(CNUMBERS[x]);
            suChinese.append("+");
            suChinese.append(CNUMBERS[y]);
        }else
        {
            if (x >= y)
            {
                result = x - y;
                suChinese.append(CNUMBERS[x]);
                suChinese.append("-");
                suChinese.append(CNUMBERS[y]);
            }
            else
            {
                result = y - x;
                suChinese.append(CNUMBERS[y]);
                suChinese.append("-");
                suChinese.append(CNUMBERS[x]);
            }
        }
        suChinese.append("=?@" + result);
        return suChinese.toString();
    }
}
