package com.zhouyn.demo.serviceConsumer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lineNum = input.nextInt();

        if (lineNum >= 1 && lineNum <= 100) {

            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < lineNum; i++) {
                int result;
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                int num3 = input.nextInt();

                if (num1 != 1 && num2 != 1 && num3 != 1) {
                    result = num1 * num2 * num3;
                } else if (num1 == 1) {
                    result = (num1 + num2) * num3;
                } else if (num2 == 1) {
                    if (num1 > num3) {
                        result = num1 * (num2 + num3);
                    } else {
                        result = (num1 + num2) * num3;
                    }
                } else {
                    result = num1 * (num2 + num3);
                }
                resultList.add(result);
            }
            resultList.forEach(num -> System.out.println(num));
        }
    }
}
