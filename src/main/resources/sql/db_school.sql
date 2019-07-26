CREATE DATABASE IF NOT EXISTS `school` DEFAULT CHARSET utf8 COLLATE utf8_unicode_ci;

USE `school`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(128) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `display_name` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称',
  `email` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `protrait` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像',
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT 'N' COMMENT '性别 M.男 F.女 N.保密',
  `introduce` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简介',
  `create_time` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '注册时间',
  `last_login_time` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;