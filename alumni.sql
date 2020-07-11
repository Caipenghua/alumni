create database if not exists alumni_system;

use alumni_system;

-- 班级表
create table class(
class_id int auto_increment not null comment '班级编号',
class_grade char(4) not null comment '年级',
class_class char(4) not null comment '班',
class_major varchar(30) not null comment '专业',
class_creator varchar(20) not null comment '创建人学号',
class_number_of_member int not null default 1 comment '班级人数',
class_introduction varchar(200) default '班级介绍' comment '班级介绍',
class_create_time date not null comment '创建时间',
primary key(class_id)
)charset=utf8;

-- 校友表
create table alumni(
alumni_number varchar(20) not null comment '学号',
alumni_name varchar(30) not null comment '姓名',
alumni_gender char(1) default '男' comment '性别',
alumni_grade char(4) not null comment '年级',
alumni_major varchar(30) not null comment '专业',
alumni_city varchar(10) comment '所在城市',
alumni_phone varchar(20) comment '联系电话',
alumni_mail varchar(30) comment '邮箱',
alumni_company varchar(30) comment '所在公司',
alumni_motto varchar(200) default '介绍一下自己吧！' comment '自我介绍',
alumni_class int comment '所在班级id',
primary key(alumni_number)
)charset=utf8;

-- 用户表
create table user(
user_id int auto_increment not null comment '编号',
user_username varchar(20) not null comment '用户登陆名，即学号',
user_password varchar(30) not null comment '用户登陆密码',
primary key(user_id)
)charset=utf8;

-- 帖子
create table post(
post_id int auto_increment not null comment '帖子编号',
post_title varchar(50) not null comment '题目',
post_key_word varchar(50) comment '关键词',
post_content varchar(500) not null comment '内容',
post_publish_time timestamp not null comment '发表时间',
post_publisher varchar(20) not null comment '发表人',
post_delete char(1) default '0' comment '是否删除',
primary key(post_id),
foreign key(post_publisher) references alumni(alumni_number)
)charset=utf8;

-- 评论表
create table mycomment(
mycomment_id int auto_increment not null comment '评论编号',
mycomment_content varchar(500) not null comment '评论内容',
mycomment_publish_time timestamp not null comment '评论时间',
mycomment_post int not null comment '在哪条帖子下的评论',
mycomment_parent int default '-1' comment '哪条评论的评论,如果是-1代表首评论',
mycomment_publisher varchar(20) not null comment '发表人',
mycomment_delete char(1) default '0' comment '是否删除',
primary key(mycomment_id),
foreign key(mycomment_post) references post(post_id),
foreign key(mycomment_publisher) references alumni(alumni_number)
)charset=utf8;



