drop table if exists kj_weight_history;
create table kj_weight_history
(
    history_id       bigint(20) not null auto_increment comment '主键',
    weight_id        bigint(20) not null comment '称重id',
    original_content varchar(1000) default null comment '原始数据',
    after_content    varchar(1000) default null comment '改后数据',
    create_by        varchar(64)   default '' comment '创建者',
    create_time      datetime comment '创建时间',
    primary key (history_id)
) engine=innodb auto_increment=1 comment = '称重修改历史表';