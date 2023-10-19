create table if not exists sys_role
(
    id          bigint   not null primary key auto_increment comment '主键id',
    is_valid    boolean  not null default true comment '是否有效记录',
    create_time datetime not null default CURRENT_TIMESTAMP comment '记录创建时间',
    update_time datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '记录更新时间',
    name        varchar(32) not null unique comment '角色名',
    index (is_valid),
    index (create_time),
    index (update_time),
    index (name)
    ) engine = innodb,
    charset = utf8, comment ='角色表';