package com.zhouyn.demo.redisserver.demo;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 停车场记录统计
 *
 * @Author zhouyn
 * @Date 00:12 2020/3/21
 */
public class Parking {

    public static final String RESULT_YES = "y";
    public static final String CAR_NUMBER_KEY = "-n=";
    public static final String CAR_TIME_KEY = "-t=";
    public static final String RECORD = "record";
    public static final String CHECK_IN = "checkin";
    public static final String CHECK_OUT = "checkout";
    public static final String COLON = ":";
    public static final String BLANK = " ";
    public static final String IN = " in ";
    public static final String OUT = " out ";
    public static final String TIME_SUFFIX = ":00";

    public static void main(String[] args) {
        System.out.println("Input:");
        List<String> inputList = new ArrayList<>();
        String result = RESULT_YES;

        // 循环输入
        while (RESULT_YES.equals(result)) {
            Scanner input = new Scanner(System.in);
            String inputStr = input.nextLine();
            inputList.add(inputStr);
            System.out.print("Do you want to continue typing?(y/n):");
            result = input.nextLine();
        }
        try {
            if (checkData(inputList)) {
                // 调用打印输出记录的函数
                Parking.printRecord(inputList);
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Incorrect data entry!");
        }
    }

    /**
     * @Return 是否正确
     * @Author zhouyn
     * @Description 输入数据校验
     * @Date 00:29 2020/3/21
     * @Params inputList:输入数据
     */
    public static boolean checkData(List<String> inputList) {
        AtomicBoolean isPass = new AtomicBoolean(true);
        inputList.forEach(input -> {
            if (!((input.contains(CHECK_IN) || input.contains(CHECK_OUT)) &&
                    input.contains(CAR_NUMBER_KEY) && input.contains(CAR_TIME_KEY))) {
                System.out.println("Data format error : " + input);
                isPass.set(false);
            }
        });

        return isPass.get();
    }

    /**
     * @Return
     * @Author zhouyn
     * @Description 打印数据记录
     * @Date 00:11 2020/3/21
     * @Params inputList:输入记录列表
     */
    public static void printRecord(List<String> inputList) throws StringIndexOutOfBoundsException {
        List<String> recordList = new ArrayList<>();
        AtomicInteger recordIndex = new AtomicInteger();
        AtomicBoolean isDriveOut = new AtomicBoolean(false);

        inputList.forEach(checkinRecord -> {
            isDriveOut.set(false);
            if (checkinRecord.contains(CHECK_IN)) {
                recordIndex.getAndIncrement();
                // 车牌号
                String carNumber = checkinRecord.substring(checkinRecord.indexOf(CAR_NUMBER_KEY) + CAR_NUMBER_KEY.length());
                // 驶入时间
                int checkIn = Integer.valueOf(checkinRecord.substring(checkinRecord.indexOf(CAR_TIME_KEY) + CAR_TIME_KEY.length(),
                        checkinRecord.indexOf(CAR_TIME_KEY) + CAR_TIME_KEY.length() + 2));

                inputList.forEach(checkoutRecord -> {
                    if (checkoutRecord.contains(carNumber) && checkoutRecord.contains(CHECK_OUT)) {
                        isDriveOut.set(true);
                        // 驶出时间
                        int checkOut = Integer.valueOf(checkoutRecord.substring(checkoutRecord.indexOf(CAR_TIME_KEY) + CAR_TIME_KEY.length(),
                                checkoutRecord.indexOf(CAR_TIME_KEY) + CAR_TIME_KEY.length() + 2));
                        recordList.add(getReturnValue(carNumber, recordIndex.get(), checkIn, checkOut));
                    }
                });

                // 车辆未驶出
                if (!isDriveOut.get()) {
                    recordList.add(getReturnValue(carNumber, recordIndex.get(), checkIn, -1));
                }

            }
        });

        // 输出记录
        System.out.println("Output:");
        recordList.forEach(System.out::println);

    }

    /**
     * @Return 输出记录
     * @Author zhouyn
     * @Description 封装输出记录
     * @Date 00:09 2020/3/21
     * @Params carNumber:车牌号 recordIndex:输出记录索引值 checkIn:驶入时间 checkOut：驶出时间（-1表示未驶出，其他数值表示驶出时间）
     */
    public static String getReturnValue(String carNumber, int recordIndex, int checkIn, int checkOut) {
        StringBuilder sb = new StringBuilder();
        sb.append(RECORD)
                .append(recordIndex)
                .append(COLON)
                .append(carNumber)
                .append(BLANK)
                .append(checkIn)
                .append(TIME_SUFFIX)
                .append(IN);

        if (checkOut != -1) {
            sb.append(checkOut)
                    .append(TIME_SUFFIX)
                    .append(OUT);
        }

        return sb.toString();
    }
}
