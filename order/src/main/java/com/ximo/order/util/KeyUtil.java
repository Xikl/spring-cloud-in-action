package com.ximo.order.util;

import java.util.Random;

/**
 * @author Ximo
 * @date 2018/10/7 14:57
 */
public class KeyUtil {


    private KeyUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * 生成唯一的主键
     * 高并发下还是会不唯一，这里只作为简单的操作
     *
     * @return 时间戳加上一个六位的随机数
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(90000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }


}
