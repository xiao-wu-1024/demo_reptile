package com.wujia.demo_reptile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wujia.demo_reptile.entity.TestReptile;

import java.util.Map;

/**
 * @author wu_jia
 */
public interface ReptileAllService extends IService<TestReptile> {

    /**
     * 获取当前域名下所有资源
     * @param url 域名
     * @return ret
     */
    Map<String, String> getAllMessage(String url);

}
