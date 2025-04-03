
-- ----------------------------
-- 自定义1 区域信息
-- ----------------------------
drop table if exists kj_customize1;
create table kj_customize1 (
                               customize1_id     bigint(20)      not null auto_increment    comment '主键',
                               customize1        varchar(50)     not null                   comment '区域',
                               status            char(1)         default '0'                comment '状态（0正常 1停用）',
                               del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                               create_by         varchar(64)     default ''                 comment '创建者',
                               create_time 	   datetime                                   comment '创建时间',
                               update_by         varchar(64)     default ''                 comment '更新者',
                               update_time       datetime                                   comment '更新时间',
                               remark            varchar(500)    default null               comment '备注',
                               primary key (customize1_id)
) engine=innodb auto_increment=1 comment = '区域信息';

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('区域信息', '5', '5', 'customize1', 'kj/customize1/index', 1, 0, 'C', '0', '0', 'kj:customize1:list', 'radio', 'admin', sysdate(), '', null, '区域信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('区域信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'kj:customize1:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('区域信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'kj:customize1:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('区域信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'kj:customize1:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('区域信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'kj:customize1:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('区域信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'kj:customize1:export',       '#', 'admin', sysdate(), '', null, '');