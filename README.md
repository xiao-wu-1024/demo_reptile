# java爬虫(demo)
## 描述
* 框架 SpringBoot + MyBatis-Plus
* 数据库 Mysql
* 使用前记得 导入sql脚本文件(重要的事说三遍)
* 使用前记得 导入sql脚本文件(重要的事说三遍)
* 使用前记得 导入sql脚本文件(重要的事说三遍)
## sql脚本
```sql
CREATE TABLE `test_reptile` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '链接名称',
  `url` varchar(400) NOT NULL COMMENT '链接',
  `other` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `type` bigint NOT NULL COMMENT '链接类型',
  `domain_id` bigint NOT NULL COMMENT '域名id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='爬虫链接库';

CREATE TABLE `test_reptile_label` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `html_label` varchar(60) NOT NULL COMMENT '标签名',
  `html_label_attributes` varchar(60) NOT NULL COMMENT '标签属性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='爬虫html标签库';

CREATE TABLE `test_source` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `source_name` varchar(20) DEFAULT NULL COMMENT '资源库名称(网站)',
  `source_url` varchar(255) DEFAULT NULL COMMENT '资源库域名',
  `source_top` varchar(255) DEFAULT NULL COMMENT '资源库前缀(多个)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='特殊资源网站';
```