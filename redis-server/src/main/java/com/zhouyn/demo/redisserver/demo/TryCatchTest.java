package com.zhouyn.demo.redisserver.demo;

public class TryCatchTest {

    public static int test() {
//        Map map = Maps.newHashMap();
        int i = 0;
        try {
//            map.put("1","1");
//            i++;
            return ++i;
//            throw new NullPointerException();
        } catch (Exception e) {
            return i;
        } finally {
//            i++;
//            map.put("2","2");
//            return "finally";
            return ++i;
        }
    }

    public static void main(String[] args) {
//        System.out.println(TryCatchTest.test());
//        System.out.println(BooleanUtils.isTrue(null));
        Integer a = null;
        System.out.println(a > 0);
    }
}
