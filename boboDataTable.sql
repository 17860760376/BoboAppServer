-------------------------

create table `bobo_user`(
    `id` int(11) not null  auto_increment COMMENT '用户id',
    `username` varchar(50) not null COMMENT'用户名，一般都是用户自己的手机号',
    `password` varchar(50) not null COMMENT '用户密码，MD5加密',
    `BOBO`     varchar(60) not null comment '每一个用户的唯一的BOBO号',
    `role` int(4) not null  COMMENT '角色0-管理员，1-普通用户',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    primary key (`id`),
    unique key `user_name_unique` (`username`) using btree
)ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
------------------------
create table `bobo_user_information`(
    `BOBO` varchar(60) not null comment '每一个用户的唯一的bobo号',
    `bobo_profile_phone` varchar(100) not null comment '用户的头像',
    `bobo_name` varchar(20) not null comment '用户的名字（昵称）',
    `bobo_introdution` varchar(100) not null comment '用户的个人简介',
    `bobo_user_school` varchar(20) not null comment '用户的学校',
    `bobo_gender` int(4) not null commment '用户的性别,0-男，1-女',
    `boob_birthday` datetime not null comment '用户的生日',
    `bobo_user_address` varchar(50) not null comment '用户的地区',
    `bobo_praise_number` int(10) not null comment '用户获赞数',
    unique key `user_BOBO_unique` (`BOBO`) using btree
)ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-------------------------
---测试学习建立的一张表
CREATE TABLE IF EXISTS `t_user`(
    `USER_ID` varchar(50),
    `USERNAME` varchar(50),
    `PASSWORD` varchar(50),
    `PHONE_NUM` VARCHAR(15)
);
insert into `t_user` values ('1','admin','admin','dkjfkdfj');
insert into `t_user` values ('2','root','root','dksfjkdjfk');

