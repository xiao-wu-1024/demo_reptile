package com.wujia.demo_reptile.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujia.demo_reptile.entity.TestReptileLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 爬虫html标签库(TestReptileLabel)表数据库访问层
 *
 * @author xiao_wu
 * @since 2021-03-30 15:52:24
 */
@Mapper
public interface TestReptileLabelMapper extends BaseMapper<TestReptileLabel> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestReptileLabel queryById(@Param("id") Long id);

    /**
     * 新增数据
     *
     * @param testReptileLabel 实例对象
     * @return 影响行数
     */
    int insert(TestReptileLabel testReptileLabel);

    /**
     * 修改数据
     *
     * @param testReptileLabel 实例对象
     * @return 影响行数
     */
    int update(TestReptileLabel testReptileLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

