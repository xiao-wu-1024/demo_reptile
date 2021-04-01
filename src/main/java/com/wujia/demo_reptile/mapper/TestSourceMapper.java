package com.wujia.demo_reptile.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujia.demo_reptile.entity.TestSource;
import org.apache.ibatis.annotations.Mapper;

/**
 * 特殊资源网站(TestSource)表数据库访问层
 *
 * @author xiao_wu
 * @since 2021-03-31 15:11:22
 */
@Mapper
public interface TestSourceMapper extends BaseMapper<TestSource> {

    /**
     * 通过域名获取
     * @param url 域名
     * @return ret
     */
    TestSource getByUrl(String url);

    /**
     * 修改数据
     *
     * @param testSource 实例对象
     * @return 影响行数
     */
    int update(TestSource testSource);

}

