package com.wujia.demo_reptile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wujia.demo_reptile.entity.TestReptile;

/**
 * @author wu_jia
 */
public interface ReptileService extends IService<TestReptile> {

    /**
     * 获取网站信息
     * @param url url
     * @param type 1网站链接 2图片资源
     * @return ret
     */
    String getMessage(String url, Integer type);

}
