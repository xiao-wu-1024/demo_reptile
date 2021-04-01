package com.wujia.demo_reptile.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 图片类
 * @author xiao-_-wu
 * @date 2021/3/29 17:49
 */
@Data
@Builder
public class TestReptile implements Serializable {
    private static final long serialVersionUID = -5818845174751760986L;

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 地址
     */
    private String url;
    /**
     * 备注字段
     */
    private String other;
    /**
     * 数据类型 1图片 2视屏 3音频 4文本 5其他
     */
    private Integer type;
    /**
     * 域名id
     */
    private Long domainId;
}
