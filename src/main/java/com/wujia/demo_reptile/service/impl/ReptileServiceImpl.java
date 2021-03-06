package com.wujia.demo_reptile.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wujia.demo_reptile.constant.ReptileConst;
import com.wujia.demo_reptile.constant.ReptileEnum;
import com.wujia.demo_reptile.entity.TestReptile;
import com.wujia.demo_reptile.entity.TestSource;
import com.wujia.demo_reptile.mapper.ReptileMapper;
import com.wujia.demo_reptile.mapper.TestSourceMapper;
import com.wujia.demo_reptile.service.ReptileService;
import com.wujia.demo_reptile.util.MyHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiao-_-wu
 * @date 2021/3/29 17:56
 */
@Slf4j
@Service
public class ReptileServiceImpl extends ServiceImpl<ReptileMapper, TestReptile> implements ReptileService {

    @Resource
    private TestSourceMapper sourceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getMessage(String url, Integer type) {
        Document doc = getDoc(url);

        TestSource entity = isSpecial(doc.title(), url);
        Map<String, String> map = getMessageMap(doc, type);
        if (map != null) {
            save(map, type, entity.getId());
            return "本次爬取数据 : " + map.size();
        }
        return "本次爬取数据 : 0";
    }

    @Override
    public Map<String, String> getMessageMap(Document doc, Integer type) {
        ReptileEnum anEnum = selectLabel(type);
        if (anEnum == null) {
            throw new RuntimeException("选择类型不存在异常");
        }
        return listUrl(doc, anEnum);
    }

    @Override
    public Document getDoc(String url){
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            log.error("出现异常:{}", e.getMessage());
            return null;
        }
        return doc;
    }

    /**
     * 保存爬取到的数据
     * @param map map
     * @param type 类型
     */
    private void save(Map<String, String> map, Integer type, Long domainId){
        for (Map.Entry<String,String> entry : map.entrySet()){
            TestReptile entity = this.lambdaQuery()
                    .eq(TestReptile::getUrl, entry.getKey())
                    .one();
            if (entity == null) {
                TestReptile reptile = TestReptile.builder()
                        .name(entry.getValue())
                        .url(entry.getKey())
                        .domainId(domainId)
                        .type(type)
                        .build();
                this.save(reptile);
            }
        }
    }

    /**
     * 获取链接
     * @param doc 网页模板
     * @param anEnum 枚举
     * @return ret
     */
    private Map<String,String> listUrl(Document doc, ReptileEnum anEnum){
        log.info("-----开始获取url-----");
        // Map<链接地址, 链接名称>
        Map<String,String> map = new HashMap<>(16);

        // 选择标签获取标签中的 url
        Elements links;
        if (anEnum.getCode().equals(ReptileEnum.SRC.getCode())) {
            links = doc.select(ReptileConst.RESOURCES_IMG);
        }else if (anEnum.getCode().equals(ReptileEnum.HREF.getCode())) {
            links = doc.select(ReptileConst.HREF_LABEL_A);
        }else {
            return null;
        }
        for (Element link : links){
//            System.out.println("名称 : " + link.text());
//            System.out.println("链接 : " + link.attr(anEnum.getMessage()));
            map.put(link.absUrl(anEnum.getMessage()), link.text());
        }
        log.info("-----结束获取url-----");
        return map;
    }



    /**
     * 判断是否存在资源库
     * @param url 网站域名
     * @return ret
     */
    private TestSource isSpecial(String name, String url){
        url = MyHttpUtils.getDomain(url);
        TestSource entity = sourceMapper.getByUrl(url);
        if (entity == null) {
            entity = TestSource.builder()
                    .sourceName(name)
                    .sourceUrl(url)
                    .build();
            sourceMapper.insert(entity);
        }
        return  entity;
    }

    /**
     * 获取资源类型
     * @param label 1网站链接 2图片资源
     * @return ret
     */
    private ReptileEnum selectLabel(Integer label){
        if (label.equals(ReptileEnum.HREF.getCode())) {
            return ReptileEnum.HREF;
        }
        if (label.equals(ReptileEnum.SRC.getCode())) {
            return ReptileEnum.SRC;
        }
        return null;
    }

}
