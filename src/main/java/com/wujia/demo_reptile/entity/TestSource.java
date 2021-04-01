package com.wujia.demo_reptile.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 特殊资源网站(TestSource)实体类
 *
 * @author xiao-_-wu
 * @since 2021-03-31 15:11:22
 */
@Data
@Builder
public class TestSource implements Serializable {
    private static final long serialVersionUID = -34951177997399112L;

    private Long id;
    /**
     * 资源库名称(网站)
     */
    private String sourceName;
    /**
     * 资源库域名
     */
    private String sourceUrl;
    /**
     * 资源库前缀(多个)
     */
    private String sourceTop;


}

