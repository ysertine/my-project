/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018-11-10 16:39:22                          */
/*==============================================================*/


drop table if exists sys_permission;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   id                   int(11) not null comment '主键ID',
   name                 varchar(50) not null comment '权限名称',
   parent_id            int(11) comment '父类编号',
   parent_ids           varchar(255) comment '父编号列表',
   permission           varchar(255) comment '权限字符串',
   resource_type        tinyint(4) comment '资源类型：0=menu，1=button',
   url                  varchar(255) comment '资源路径',
   status               tinyint(4) not null comment '状态：0=禁用，1=正常',
   primary key (id)
);

alter table sys_permission comment '系统权限表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int(11) not null comment '主键ID',
   role                 varchar(50) not null comment '角色名称',
   description          varchar(200) comment '角色描述',
   status               tinyint(4) not null comment '状态：0=禁用，1=正常',
   primary key (id)
);

alter table sys_role comment '系统角色表';

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
   id                   int(11) not null comment '主键ID',
   role_id              int(11) not null comment '角色ID',
   permission_id        int(11) not null comment '权限ID',
   primary key (id)
);

alter table sys_role_permission comment '系统角色权限表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   int(11) not null comment '主键ID',
   user_name            varchar(20) not null comment '用户名',
   password             varchar(50) not null comment '用户密码',
   salt                 varchar(50) not null comment '加密盐值',
   sex                  tinyint(4) comment '性别：1=男，2=女',
   phone                varchar(20) not null comment '手机号码',
   email                varchar(50) comment '电子邮箱',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   last_login_time      datetime comment '最后登录时间',
   status               tinyint(4) comment '状态：-1=删除，0=禁用，1=正常',
   primary key (id)
);

alter table sys_user comment '系统用户表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   int(11) not null comment '主键ID',
   user_id              int(11) not null comment '用户ID',
   role_id              int(11) not null comment '角色ID',
   primary key (id)
);

alter table sys_user_role comment '系统用户角色表';

