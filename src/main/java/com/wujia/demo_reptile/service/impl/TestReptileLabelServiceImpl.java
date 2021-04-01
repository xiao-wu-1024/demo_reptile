package com.wujia.demo_reptile.service.impl;

import com.wujia.demo_reptile.mapper.TestReptileLabelMapper;
import com.wujia.demo_reptile.service.ITestReptileLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 爬虫html标签库(TestReptileLabel)表服务实现类
 *
 * @author xiao_wu
 * @since 2021-03-30 15:51:42
 */
@Service("testReptileLabelService")
public class TestReptileLabelServiceImpl implements ITestReptileLabelService {
    @Resource
    private TestReptileLabelMapper testReptileLabelMapper;
}

