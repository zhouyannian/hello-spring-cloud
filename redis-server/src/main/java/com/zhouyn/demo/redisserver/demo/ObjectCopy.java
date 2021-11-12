package com.zhouyn.demo.redisserver.demo;

/**
 * @author zhouyn
 * @date 2021年09月08日 下午4:41
 */
public class ObjectCopy {

    public static void main(String[] args) {

//        Studnt studnt = Studnt.builder().user(User.builder().userName("zhouyn").build()).build();
//        Studnt studnt1 = Studnt.builder().build();
//        BeanUtils.copyProperties(studnt, studnt1);
//        studnt1.getUser().setUserName("ABC");
//        System.out.println(studnt.getUser().getUserName());
        Integer i = 3;
        Integer j = null;
        System.out.println(i.compareTo(j));
    }
}
