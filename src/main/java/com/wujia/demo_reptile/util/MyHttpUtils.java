package com.wujia.demo_reptile.util;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 个人http工具类
 * @author xiao-_-wu
 * @date 2021/3/29 17:57
 */
@Slf4j
public class MyHttpUtils {

    /**
     * 获取当前链接域名信息
     * @param url url
     * @return ret
     */
    public static String getDomain(String url){
        int x = StrUtil.indexOf(url,'/');
        if (x < 0) {
            return url;
        }
        x = StrUtil.indexOf(url,'/',x + 2);
        if (x < 0) {
            return url;
        }
        url = StrUtil.sub(url, 0, x);
        return url;
    }

    /**
     * 递归截取域名
     * @param url 源域名
     * @param num 次数
     * @param newUrl 顶级域名
     * @return ret
     */
    public static String getTopDomain(String url, Integer num, String newUrl){
        url = getDomain(url);
        return execute(url, num, newUrl);
    }

    private static String execute(String url, Integer num, String newUrl){
        int x = url.lastIndexOf('.');
        if (num == 1) {
            x += 1;
        }
        String modifyUrl = StrUtil.sub(url, x, url.length());
        newUrl = modifyUrl + newUrl;
        url = StrUtil.sub(url, 0, x);
        if (num != 1){
            num -= 1;
            return execute(url, num, newUrl);
        }
        return newUrl;
    }

    public static void main(String[] args) {
        String url = "https://pic.netbian.com/index_4.html";
        url = getDomain(url);
        System.out.println("最终输出: " + getTopDomain(url, 2, ""));;
    }


    /**
     * 另一种方式
     * @param source url
     * @param peelPoint 截取标点
     * @param num 循环次数
     * @return ret
     */
    public static String reverseDivestiture(String source, String peelPoint, int num) {
        return StrUtil.sub(source, getIndex(source, peelPoint, num, 0), source.length());
    }

    /**
     *
     * @param source url
     * @param peelPoint 节点
     * @param num 次数
     * @param initNum 次数
     * @return 下标
     */
    public static int getIndex(String source, String peelPoint, int num, int initNum) {
        log.info("source: {}", source);
        int point = source.lastIndexOf(peelPoint);
        log.info("节点位置：{}", point);
        initNum++;
        if (initNum >= num) {
            return point + 1;
        }
        return getIndex(StrUtil.sub(source, 0, point), peelPoint, num, initNum);
    }
}
