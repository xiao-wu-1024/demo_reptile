package com.wujia.demo_reptile.dto;

import lombok.Data;

/**
 * 资源DTO
 * @author xiao-_-wu
 * @date 2021/3/31 17:21
 */
@Data
public class SourceDTO {

    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源链接
     */
    private String url;
    /**
     * 资源类型
     */
    private Integer type;

}
