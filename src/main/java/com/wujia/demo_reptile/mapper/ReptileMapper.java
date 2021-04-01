package com.wujia.demo_reptile.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujia.demo_reptile.entity.TestReptile;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiao-_-wu
 * @date 2021/3/29 17:56
 */
@Mapper
public interface ReptileMapper extends BaseMapper<TestReptile> {
}
