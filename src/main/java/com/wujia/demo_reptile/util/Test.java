package com.wujia.demo_reptile.util;

import java.util.*;

/**
 * @author xiao-_-wu
 * @date 2021/4/2 17:54
 */
public class Test {

    public static void main(String[] args) {
        List<String> listA = new ArrayList<>();
        listA.add("张无忌");
        listA.add("张三丰");
        listA.add("李四");
        listA.add("王五");
        listA.add("狄仁杰");
        listA.add("汤姆");
        List<String> listB = new ArrayList<>();
        listB.add("张无忌");
        listB.add("李四");
        listB.add("王五");
        listB.add("赵六");
        listB.add("张翠山");
        listB.add("周芷若");
        List<String> listC = new ArrayList<>();
        listC.add("周芷若");
        listC.add("张无忌");
        listC.add("张翠山");
        listC.add("赵敏敏");
        listC.add("法海");
        listC.add("白蛇1");
        listC.add("白蛇2");
        List<String> listD = new ArrayList<>();
        listD.add("张无忌");
        listD.add("青蛇");
        listD.add("法海");
        listD.add("赵敏敏");
        listD.add("周传雄");

//        Map<String,List<String>> mapA = new HashMap<>();
//        Map<String,List<String>> mapB = new HashMap<>();
//        Map<String,List<String>> mapC = new HashMap<>();
        Map<String,List<String>> mapD = new HashMap<>();
        mapD.put("汤姆",listD);
        mapD.put("张无忌",listA);
        mapD.put("青蛇",listB);
        mapD.put("周芷若",listC);

        // 获取 汤姆下面的list
        Map<String,List<String>> nameMap = new HashMap<>();
        get(mapD, nameMap, null);
        int i = 0;
        for (Map.Entry<String,List<String>> entry : nameMap.entrySet()) {
            System.out.println((i += 1) + "名称: " + entry.getKey());
        }
        System.out.println("总数: " + nameMap.size());

        Set<String> sets = new HashSet<>(new ArrayList<>());
        sets.addAll(listB);
        sets.addAll(listC);
        sets.addAll(listD);
        sets.addAll(listA);
        i = 0;
        for (String str : sets) {
            System.out.println((i += 1) + "名称: " + str);
        }
        System.out.println("集合: " + sets.size());
    }

    /**
     *
     * @param mapD 初始集合
     * @param nameMap 返回集合
     * @return
     */
    private static Map<String,String> get(Map<String,List<String>> mapD, Map<String,List<String>> nameMap, Map<String,String> repeatMap){
        Set<String> set = new HashSet<>();
        for (Map.Entry<String,List<String>> entry : mapD.entrySet()) {
            for (String str : entry.getValue()) {
                // 获得当前url下所有url
                set.add(str);
                nameMap.put(str, null);

            }
            List<String> list = new ArrayList<>(set);
            // 再把当前url吓得链接存入 nameMap
        }
        return null;
    }
}
