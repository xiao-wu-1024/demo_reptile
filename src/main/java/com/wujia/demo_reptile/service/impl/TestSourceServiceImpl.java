package com.wujia.demo_reptile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wujia.demo_reptile.entity.TestSource;
import com.wujia.demo_reptile.mapper.TestSourceMapper;
import com.wujia.demo_reptile.service.ITestSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 特殊资源网站(TestSource)表服务实现类
 *
 * @author xiao_wu
 * @since 2021-04-01 10:33:32
 */
@Service("testSourceService")
public class TestSourceServiceImpl extends ServiceImpl<TestSourceMapper, TestSource> implements ITestSourceService {
    @Resource
    private TestSourceMapper testSourceMapper;
}

