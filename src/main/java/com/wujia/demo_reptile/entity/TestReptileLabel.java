package com.wujia.demo_reptile.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 爬虫html标签库(TestReptileLabel)实体类
 *
 * @author xiao-_-wu
 * @since 2021-03-30 15:51:42
 */
@Data
@Builder
public class TestReptileLabel implements Serializable {
    private static final long serialVersionUID = -18414295189713271L;

    private Long id;
    /**
     * 标签名
     */
    private String htmlLabel;
    /**
     * 标签属性
     */
    private String htmlLabelAttributes;


}

