package com.wujia.demo_reptile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wu_jia
 */
@MapperScan("com.wujia.demo_reptile.mapper")
@SpringBootApplication
public class DemoReptileApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoReptileApplication.class, args);
    }

}
