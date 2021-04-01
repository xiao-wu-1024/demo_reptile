package com.wujia.demo_reptile.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wujia.demo_reptile.dto.ResourceLibraryDTO;
import com.wujia.demo_reptile.dto.SourceDTO;
import com.wujia.demo_reptile.entity.TestReptile;
import com.wujia.demo_reptile.entity.TestSource;
import com.wujia.demo_reptile.service.ITestSourceService;
import com.wujia.demo_reptile.service.ReptileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiao-_-wu
 * @date 2021/3/29 17:53
 */
@Slf4j
@RestController
@RequestMapping("/reptile")
public class ReptileController {

    @Resource
    private ReptileService reptileService;
    @Resource
    private ITestSourceService testSourceService;

    /**
     * 获取资源库
     * @param pageNo 当前页码数
     * @param pageSize 每页显示数
     * @return ret
     */
    @GetMapping("/list/resource")
    public Page<ResourceLibraryDTO> listResource(@RequestParam(defaultValue = "1") Integer pageNo,
                                                 @RequestParam(defaultValue = "10") Integer pageSize){
        Page<TestSource> entityPage = new Page<>(pageNo, pageSize);
        List<TestSource> list = testSourceService.lambdaQuery()
                .list();
        entityPage.setRecords(list);
        Page<ResourceLibraryDTO> dtoPage = new Page<>();
        BeanUtils.copyProperties(entityPage, dtoPage);
        return dtoPage;
    }

    /**
     * 获取信息
     * @param url 地址
     * @param type 信息类型 1链接 2图片
     * @return ret
     */
    @GetMapping("/get/message")
    public String getMessage(String url, Integer type){
        log.info("请求参数:\n url = {},\n type = {}", url, type);
        return reptileService.getMessage(url, type);
    }

    /**
     * 获取资源列表
     * @param pageNo 当前页码数
     * @param pageSize 每页显示数
     * @param type 资源类型 1链接 2图片
     * @return ret
     */
    @GetMapping("/list/source")
    public Page<SourceDTO> listSource(@RequestParam(defaultValue = "1") Integer pageNo,
                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                      String type){
        Page<TestReptile> page = new Page<>(pageNo, pageSize);
        List<TestReptile> list = reptileService.lambdaQuery()
                .eq(StrUtil.isNotBlank(type), TestReptile::getType, type)
                .list();
        page.setRecords(list);
        Page<SourceDTO> dtoPage = new Page<>();
        BeanUtils.copyProperties(page, dtoPage);
        return dtoPage;
    }

}