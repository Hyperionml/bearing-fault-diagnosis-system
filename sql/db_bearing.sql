/**
  轴承故障诊断系统的数据库搭建sql
 */
create schema db_bearing;
use db_bearing;
create table bearing
(
    sid    int auto_increment,
    name   varchar(50)                  not null,
    status varchar(20) default 'normal' not null,
    msg    varchar(100)                 null,
    constraint tb_status_pk
        primary key (sid)
);
create table history_status
(
    hid       int auto_increment
        primary key,
    sid       int           not null,
    err_count int default 0 not null,
    err_msg   varchar(100)  null,
    datetime  date          not null
);