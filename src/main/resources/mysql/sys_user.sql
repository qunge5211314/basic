create table if not exists sys_user
(
    id          bigint      not null primary key auto_increment comment '主键id',
    is_valid    boolean     not null default true comment '是否有效记录',
    create_time datetime    not null default CURRENT_TIMESTAMP comment '记录创建时间',
    update_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '记录更新时间',
    username    varchar(32) not null comment '姓名',
    identity    varchar(32) not null comment 'ID',
    email       varchar(60) not null comment '邮箱',
    pwd         varchar(32) not null comment '密码',
    gender      boolean comment '性别，false:女，true：男',
    state       boolean comment '状态，false:禁用，true：启用',
    is_sys      boolean comment '是否系统内置用户，false：否，true：是',
    index (is_valid),
    index (create_time),
    index (update_time),
    index (identity, pwd)
) engine = innodb,
  charset = utf8, comment ='用户表';