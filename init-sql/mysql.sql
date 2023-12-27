create database memory_words;

use memory_words;

create table user
(
    `name`     varchar(32) primary key comment '用户名',
    `password` varchar(32) not null default '123456' comment '密码',
    `admin`    boolean     not null default true comment '是否是管理员',
    `times`    int         not null default 0 comment '学习次数'
);

create table words
(
    `english` varchar(128) primary key comment '英语单词',
    `chinese` varchar(256) not null comment '中文翻译',
    `times`   int          not null default 0 comment '记忆次数'
);

insert into user (name, password, admin) values ('admin', '123456', 1);

insert into memory_words.words (english, chinese, times) values ('apple', '苹果', 2);
insert into memory_words.words (english, chinese, times) values ('banana', '香蕉', 2);
insert into memory_words.words (english, chinese, times) values ('interesting', '有趣的', 2);
