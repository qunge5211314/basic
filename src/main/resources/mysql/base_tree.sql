create table if not exists base_tree
(
    id          bigint   not null primary key auto_increment comment '主键id',
    is_valid    boolean  not null default true comment '是否有效记录',
    create_time datetime not null default CURRENT_TIMESTAMP comment '记录创建时间',
    update_time datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '记录更新时间',
    parent_id   bigint,
    tree_id     int      not null comment '树id',
    lft         int      not null comment '当前节点左侧数值',
    rgt         int      not null comment '当前节点右侧数值',
    depth       int      not null comment '当前节点所在层级深度',
    index (is_valid),
    index (create_time),
    index (update_time),
    index (parent_id),
    index (tree_id),
    index (lft),
    index (rgt)
) engine = innodb,
  charset = utf8, comment ='基础层级树建表语句';