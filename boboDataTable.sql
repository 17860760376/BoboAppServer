-------------------------
------------------存储的图片都是存储的路径,将图片以文件形式传送到服务器上面，通过路径来访问-------------
------------用户表-------------
create table `bobo_user`(
    `id` int not null  auto_increment COMMENT '用户id',
    `username` varchar(50) not null COMMENT'用户名/用户的手机号',
    `bobo_number` varchar(50) not null comment '用户对应的唯一的bobo号',
    `password` varchar(50) not null COMMENT '用户密码，MD5加密',
    `role` int not null  COMMENT '角色0-管理员，1-普通用户，用户的权限不同',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    primary key (`id`),
    unique key `bobo_number_unique` (`bobo_number`) using btree,
    unique key `user_name_unique` (`username`) using btree
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
------------------------



-- 用户信息表，关键的内容：
-- 头像、个人简介、学校、性别、生日、国家、省份、城市、
-- 获赞数、粉丝数、好友数、关注数、加入的社团、社团中的身份
------------------用户信息表------------
create table `bobo_user_information`(
    `id` int not null auto_increment COMMENT '用户id',
    `bobo_number` varchar(50) not null comment '用户对应的唯一的bobo号',
    `bobo_profile_phone` varchar(100) not null comment '用户的头像',
    `bobo_name` varchar(20) not null comment '用户的名字（昵称）',


    `bobo_introdution` varchar(100)  comment '用户的个人简介',
    `bobo_user_school` varchar(20) not null comment '用户的学校',
    `bobo_gender` int not null comment '用户的性别,0-男，1-女',
    `boob_birthday` datetime not null comment '用户的生日',
    `bobo_user_country` varchar(10) not null comment '用户所处国家',
    `bobo_user_province` varchar(10) not null comment '用户所处省份',
    `bobo_user_city` varchar(10) not null comment '用户所处城市',
--     `bobo_user_addreee` varchar(20) comment '用户所处详细地址',
--     `bobo_user_address` varchar(100) comment '用户的地区',



    `bobo_praise_number` int default 0 comment '用户获赞数',
    `bobo_fans_numbers` int default 0 comment '粉丝数',
    `bobo_frients_numbers` int default 0 comment  '好友数',
    `bobo_focuson_numbers` int default 0 comment '关注数',
    `bobo_community` varchar(50) comment '所加入的社团，如果是null就说明没有加入社团',
    `bobo_community_position` int default 0 comment '-0表示没有加入社团，-1表示身份是社团成员，-2表示是副社长，-3表示是社长，不同身份有不同的权限',




    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    unique key `bobo_number_unique` (`bobo_number`) using btree,
    unique key `bobo_name` (`bobo_name`) using btree,
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;



------------------------
-------------用户关注表----------------
---------这里可以进行检索，获得用户的关注，好友，粉丝的对应的列表
create table `bobo_user_attention`(
    `id` int(11) not null auto_increment comment '关注表的标号',
    `follow_bobo_number`varchar(50) not null comment  '关注者的bobo号',
    `befollow_bobo_number` varchar(50) not null comment '被关注者的bobo号',
    `relationship` int default 0 comment '用户之间的状态，0表示单向关注，1表示双向关注，用来获取用户的粉丝、好友、关注列表',
    `focus_on_time` datetime not null comment '关注时间',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    foreign key (`follow_bobo_number`) references `bobo_user`(`bobo_number`),
    foreign key (`befollow_bobo_number`) references `bobo_user`(`bobo_number`),
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;







-----------------------------------
----------------动态类别表------------------即类别
create table `bobo_category` (
    `id` int not null auto_increment comment '种类id',
    `parent_id` int not null comment '父类的id,当parent_id=0时，表示时一级类别',
    `label_value` int default 0 not null comment '种类的热度',
    `name` varchar(50) default null comment '种类名称',
    `status` int default 1 comment '类别状态1-正常，2-已废弃',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
--------------------------------------
--------------用户发布的动态表，通过用户的bobo号来进行CRUL----------------
create table `bobo_dynamicment`(
    `id` int not null auto_increment comment '发布的动态id',
    `publisher_bobo_number` varchar(50) not null comment '发布者的bobo号',
    `dynamicment_category` varchar(10) comment '动态所属类别，如果为Null表示没有类别',
    `publisher_port` varchar(100) comment '发布者的头像',
    `publisher_name` varchar(20) not null comment '发布者的昵称/名字',
    `publish_time` datetime not null comment '发布动态的时间',
    `dynamicment_content` text not null comment '发布的动态文本内容',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    `dynamicment_pariser_number` int default 0 not null comment '动态获赞数',
    `dynamic_comment_number` int default 0 not null comment '动态评论数',
    `dynamic_tranmit_number` int default 0 not null comment '动态转发数',
    foreign key(`publisher_bobo_number`) references `bobo_user`(`bobo_number`),
    foreign key(`publisher_name`) references `bobo_user_information`(`bobo_name`),
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
---------------------------------------
---------------动态的图片表，通过动态的id进行CRUL,这里存储的也是图片的存储路径-------------
create table `bobo_dynamicment_picture`(
    `id` int not null auto_increment comment '发布动态的图片id',
    `dynamicment_id` int not null comment '图片所属动态的id',
    `picture` varchar(100) not null comment '图片',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    foreign key(`dynamicment_id`) references `bobo_dynamicment`(`id`),
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
------------------------------------
---------------动态评论表-------------------
create table `bobo_comments`(
    `id` int not null auto_increment comment '发布的评论的id',
    `status` int not null comment '表明该评论的状态，0-表示这是对动态的评论，-1表示这是对评论的回复',
    `dynamic_or_comment_id` int not null comment '该评论对应的动态id或是评论id',
    `comment_publisher_name` varchar(50) not null comment '该评论发布者的昵称/名字',
    `comment_publish_time` datetime not null comment '评论发布的时间',
    `comment_content` text not null comment '评论的内容',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    `comment_pariser_number` int default 0 not null comment '评论获赞数',
    foreign key(`comment_publisher_name`) references `bobo_user_information`(`bobo_name`),
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;







-----------------------------------
------------------社团表------------------------加入社团即加入到对应的群聊中，创建社团即创建出该群聊
create table `bobo_communitys`(
    `id` int not null auto_increment comment '社团对应的id',
    `community_name` varchar(30) not null comment '社团名称',
    `community_creater` varchar(50) not null comment '社团创建者',
    `community_symbol` varchar(50) not null comment '社团标签，简短的介绍',
    `community_heat` int default 0  comment '社团热度',
    `community_login_number` int default 0  comment '社团申请入驻次数',
    `community_introduction` text comment '社团详情介绍',
    `community_member_number` int default 0   comment '社团成员数量',
    `community_focuson_number` int default 0   comment '社团粉丝数',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    `community_activity_number` int default 0  comment '社团举办的活动数量',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
---------------------------------
----------------社团活动表-------------------
create table `bobo_community_activitys`(
    `id` int not null auto_increment comment '活动对应的id',
    `community_id` int not null comment '活动所属社团',
    `activity_label` varchar(30) not null comment '活动标签',
    `activity_focuson_number` int default 0 not null comment '活动关注数',
    `activity_heat` int default 0 not null comment '活动热度',
    `activity_name` varchar(50) not null comment '活动名称',
    `activity_time` datetime not null comment '活动举办时间',
    `activity_address` varchar(50) comment '活动举办地点',
    `activiti_content` text not null comment '活动详情',
     `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
-------------------------------
-----------------社团图片表--------------
create table  `bobo_community_picture` (
    `id` int not null auto_increment comment '社团图片对应的id',
    `the_community_name` varchar(50) not null comment '社团图片所属社团名称，用于索引',
    `community_picture` varchar(100) not null comment '社团图片/(地址)',
     `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
-------------------------------
-------------------活动图片表-----------------
create table `bobo_activity_picture` (
   `id` int not null auto_increment comment '活动图片对应的id',
   `activity_id` int not null comment '活动图片所属活动id，用于索引',
   `activity_picture` varchar(100) not null comment '活动图片/(地址)',
    `create_time` datetime not null COMMENT '创建时间',
    `update_time` datetime not null COMMENT '最后一次更新时间',
    foreign key (`activity_id`) references `bobo_community_activitys`(`id`),
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
----------------------------------------------