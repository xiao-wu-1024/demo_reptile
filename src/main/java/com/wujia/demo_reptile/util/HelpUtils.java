package com.wujia.demo_reptile.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Map;

/**
 * 普通工具类
 * @author xiao-_-wu
 * @date 2021/4/2 17:17
 */
@Slf4j
public class HelpUtils {

    /**
     * map去重 key
     * @param map map
     * @param key key
     */
    public static void byKeyRemoveRepeat(Map<String,String> map, String key){
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> newMap = iterator.next();
            String str = newMap.getKey();
            str = MyHttpUtils.getTopDomain(str, 2, "");
            // 判断 url 是否匹配
            if (!str.equals(key)) {
                iterator.remove();
//                map.remove(str);
            }
        }
    }

}
