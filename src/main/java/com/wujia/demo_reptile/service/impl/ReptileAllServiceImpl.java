package com.wujia.demo_reptile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wujia.demo_reptile.constant.ReptileEnum;
import com.wujia.demo_reptile.entity.TestReptile;
import com.wujia.demo_reptile.mapper.ReptileMapper;
import com.wujia.demo_reptile.service.ReptileAllService;
import com.wujia.demo_reptile.service.ReptileService;
import com.wujia.demo_reptile.util.HelpUtils;
import com.wujia.demo_reptile.util.MyHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xiao-_-wu
 * @date 2021/4/2 10:23
 */
@Slf4j
@Service
public class ReptileAllServiceImpl extends ServiceImpl<ReptileMapper, TestReptile> implements ReptileAllService {

    @Lazy
    @Resource
    private ReptileService reptileService;

    @Override
    public Map<String, String> getAllMessage(String url) {
        log.info("入参url: {}", url);
        // 获取第一个页面的链接
        Map<String, String> startMap = getAllUrl(url, null);
        return execute(startMap,startMap, new HashMap<>(16));
    }

    /**
     * 具体执行
     * @param startMap 起始map
     * @param repeatMap 重复map
     * @param recordingMap 记录map
     * @return
     */
    public Map<String,String> execute(Map<String, String> startMap, Map<String,String> repeatMap, Map<String,String> recordingMap){
        log.info("++++++++++++++startMap当前条数 : {}", startMap.size());
        log.info("++++++++++++++repeatMap当前条数 : {}", repeatMap.size());
        log.info("++++++++++++++recordingMap当前条数 : {}", recordingMap.size());
        Map<String,String> map = new HashMap<>(16);
        map.putAll(startMap);
        // 循环首页所有链接
        for (Map.Entry<String,String> entry : map.entrySet()) {
            log.info("-----------当前循环url : {}", entry.getKey());
            Map<String,String> childMap = new HashMap<>(16);

            if (recordingMap.get(entry.getKey()) == null) {
                // 获取子连接下的所有链接
                childMap = getAllUrl(entry.getKey(), null);
                recordingMap.put(entry.getKey(),entry.getValue());
                if (childMap == null) {
                    continue;
                }
            }
            // 保存所有链接
            repeatMap.putAll(childMap);
        }

        for (Map.Entry<String,String> entry : repeatMap.entrySet()){
            if (recordingMap.get(entry.getKey()) == null) {
                return execute(repeatMap, repeatMap,recordingMap);
            }
        }
        return recordingMap;
    }

    /**
     * 获取当前页面的请求url
     * @param url url
     * @return ret
     */
    public Map<String, String> getAllUrl(String url, Map<String, String> map){
        Document doc = reptileService.getDoc(url);
        if (doc == null) {
            return null;
        }
        // 获取首页所有 href
        Map<String, String> urlMap = reptileService.getMessageMap(doc, ReptileEnum.HREF.getCode());
        // 保存 href 为当前域名下的链接
        String domain = MyHttpUtils.getTopDomain(url, 2, "");
        // 去除非当前域名下的 href
        HelpUtils.byKeyRemoveRepeat(urlMap, domain);
        return urlMap;
    }

}
