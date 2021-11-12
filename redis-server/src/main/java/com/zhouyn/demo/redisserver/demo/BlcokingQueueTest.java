package com.zhouyn.demo.redisserver.demo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author zhouyn
 * @date 2021年07月14日 下午2:16
 */
public class BlcokingQueueTest {
    public static void main(String[] args) {

//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<Integer>(5);
//
//        new Thread(() -> IntStream.rangeClosed(0, 10).forEach(i -> {
////            System.out.println(i);
//            try {
//                arrayBlockingQueue.put(i);
//                System.out.println(LocalDateTime.now() + ":Size = " + arrayBlockingQueue.size());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        })).start();
//
//        new Thread(() -> IntStream.rangeClosed(0, 10).forEach(i -> {
//            try {
//                Thread.sleep(1000);
//                if (!arrayBlockingQueue.isEmpty()) {
//                    Object take = arrayBlockingQueue.take();
//                    System.out.println(LocalDateTime.now() + ":" + take);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        })).start();

        Long a = 0L;
//        System.out.println(Objects.equals(a, 0L));
//        System.out.println(Math.round(-1.6));
//        Set<String> set = Sets.newHashSet();
//        set.add("");
//        List<String> list = Lists.newArrayList();
//        final Object[] objects = list.toArray();
//        try {
//            Collections.unmodifiableCollection(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        BlcokingQueueTest test = new BlcokingQueueTest();
        System.out.println(test.calculateSellPrice(BigDecimal.valueOf(213), 123));

        String str = "A,B,C";
        System.out.println(str);
        if (str.endsWith(",")) {
            str = str.substring(0, str.lastIndexOf(","));
        }
        System.out.println(str);
    }

    public BigDecimal calculateSellPrice(BigDecimal purchasePrice, Integer packageWeight) {
        if (Objects.isNull(purchasePrice) || Objects.isNull(packageWeight)) {
            return null;
        }

        /*销售价(USD)会根据采购价和预估重量自动计算
        公式：销售价(USD)=(采购价￥+预估重量g/10)/0.35/6.5
        销售价会自动以.49或.99结尾*/
        BigDecimal sellPrice = purchasePrice.add(BigDecimal.valueOf(packageWeight.doubleValue() / 10))
                .divide(BigDecimal.valueOf(0.35), 2, BigDecimal.ROUND_HALF_UP)
                .divide(BigDecimal.valueOf(6.5), 2, BigDecimal.ROUND_HALF_UP);
//                .setScale(2, BigDecimal.ROUND_HALF_UP);

        // 整数部分
        String intPart = String.valueOf(sellPrice.intValue());
        // 小数部分
        double decimalPart = sellPrice.subtract(new BigDecimal(intPart)).doubleValue();
        return new BigDecimal(intPart + (decimalPart > 0.49 ? ".99" : ".49"));

    }
}
