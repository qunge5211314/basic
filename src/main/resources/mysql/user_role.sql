create table if not exists user_role
(
    id          bigint   not null primary key auto_increment comment '主键id',
    is_valid    boolean  not null default true comment '是否有效记录',
    create_time datetime not null default CURRENT_TIMESTAMP comment '记录创建时间',
    update_time datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '记录更新时间',
    sys_user_id bigint not null comment '用户id',
    sys_role_id bigint not null comment '角色id',
    index (is_valid),
    index (create_time),
    index (update_time),
    index (sys_user_id),
    index (sys_role_id)
) engine = innodb,
  charset = utf8, comment ='用户角色关联表';