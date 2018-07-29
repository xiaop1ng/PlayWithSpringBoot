create database mbs;

use mbs;

drop table if exists `contract_template`;
create table `contract_template` (
	id int(11) primary key auto_increment, -- 主键 自增
	template_name varchar(256), -- 模板名
	version varchar(128), -- 模板版本号
	template_type varchar(128), -- 模板类型
	create_time datetime not null default now(), -- 创建时间
	enable boolean not null default false, -- 状态 f. 禁用 t. 启用
	doc_src varchar(512), -- word 文档
	pdf_src	varchar(512) -- pdf 文档
);