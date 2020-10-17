create database one_piece;
use one_piece;
create table figure_info
(
    id bigint auto_increment comment '自增id',
    user_name varchar(255) null comment '名称',
    user_skill varchar(1024) null comment '技能',
    devil_nuts varchar(1024) null comment '恶魔果实',
    user_fight integer null comment '战斗力',
    comment_info varchar(2048) null comment '备注',
    attribute varchar(2048) null comment '扩展字段',
    create_time timestamp default now() not null comment '创建时间',
    update_time timestamp default now() not null comment '更新时间',
    constraint partner_info_pk
        primary key (id)
) comment '海贼王人物信息';

