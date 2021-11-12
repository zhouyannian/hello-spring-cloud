package com.zhouyn.demo.redisserver.demo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalTest {
    public static void main(String[] args) {
        String str = "7.33136443711219e+24";
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal bigDecimal = new BigDecimal(str);
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
