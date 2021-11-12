package com.zhouyn.demo.redisserver.demo;

import com.google.common.collect.Lists;
import com.zhouyn.demo.redisserver.entity.User;

import java.util.List;

/**
 * @author zhouyn
 * @date 2021年06月09日 上午11:19
 */
public class DateTest {

    public static void main(String[] args) {
//        1623205712966

        // 13位的豪秒级别的时间戳
//        double time2 = 1623205712966d;
//        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time2);
//        System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);
        List<User> list = Lists.newArrayList();
        list.add(User.builder().userName("A").build());
        list.add(User.builder().userName(null).build());
        list.add(User.builder().userName("B").build());
        list.add(User.builder().userName(null).build());
        list.add(User.builder().userName(null).build());
        list.add(User.builder().userName("Z").build());
        list.add(User.builder().userName("F").build());
        list.add(User.builder().userName("S").build());
        list.add(User.builder().userName(null).build());
        list.add(User.builder().userName("C").build());
//        System.out.println(list.stream()
//                .sorted(Comparator.comparing(User::getUserName, Comparator.nullsFirst(String::compareTo)).reversed())
//        .collect(Collectors.toList()));
//        list.add("A");
//        list.add("B");
//        System.out.println(list.stream().collect(Collectors.joining()));
//        Set<String> set =
//                Sets.newHashSet("A", "B", "B");
//        set.addAll(list);
//        System.out.println(set);
//        List<String> list = Lists.newArrayList(set);
//        System.out.println(list);
//        Map<Integer, Boolean> map = new HashMap();
//        map.put(1, Boolean.FALSE);
//        map.put(2, Boolean.TRUE);
//        map.put(1, Boolean.TRUE);
//        System.out.println(map.get(null));
//        map.put(null, null);
//        System.out.println(map);
//        Validate.notEmpty(list,"111111111");

//        System.out.println(map.get(3));

//        System.out.println(16 >> 1);
        String str = "A";
//        System.out.println(ObjectUtils.allNotNull(null, str));

        Boolean b = null;
        if (b) {
            System.out.println("来了，老弟啊！");
        } else {
            System.out.println("走了啊，老弟！");
        }
    }
}
