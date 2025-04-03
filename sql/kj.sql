-- ----------------------------
-- 1、序列号
-- ----------------------------
drop table if exists kj_sequence;
create table kj_sequence (
                         seq_name varchar(50) not null comment '序列名称',
                         seq_prefix varchar(50) default null comment '序列前缀',
                         min_value bigint(20) not null comment '最小值',
                         max_value bigint(20) not null comment '最大值',
                         current_val bigint(20) not null comment '当前值',
                         increment_val int(11) not null DEFAULT '1' comment '增长步数',
                         remark varchar(500) default null comment '备注',
                         primary key (seq_name)
) engine=innodb auto_increment=1 comment = '单据编号表';

insert into kj_sequence values('purchase_number_seq', 'P','1', '999999999999999999', '1', '1', '采购单据编号');
insert into kj_sequence values('sale_number_seq',     'S','1', '999999999999999999', '1', '1', '销售单据编号');
insert into kj_sequence values('weight_number_seq',   'W','1', '999999999999999999', '1', '1', '称重单据编号');

-- ----------------------------
-- 2、设备信息表 '8' 'none' '1'
-- ----------------------------
# drop table if exists kj_device;
# create table kj_device (
#                            device_id         bigint(20)      not null auto_increment    comment '主键',
#                            device_type       char(1)         default '0'                comment '设备类型（0网络设备 1串口设备）',
#                            device_name       varchar(100)    not null                   comment '设备名',
#                            auto_open         char(1)         default '0'                comment '自动打开（0是 1否）',
#                            device_ip         varchar(128)    default ''                 comment 'IP',
#                            port              varchar(20)     default ''                 comment '端口',
#                            polling           varchar(20)     default ''                 comment '轮询间隔',
#                            custom            varchar(20)     default ''                 comment '自定义',
#                            device_acc        varchar(20)     default ''                 comment '设备账户',
#                            device_pas        varchar(20)     default ''                 comment '设备密码',
#                            baud_rate         integer                                    comment '波特率',
#                            data_bits         integer                                    comment '数据位',
#                            parity            varchar(20)     default ''                 comment '奇偶检验',
#                            stop_bits         integer                                    comment '停止位',
#                            status            char(1)         default '0'                comment '状态（0正常 1停用）',
#                            del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
#                            create_by         varchar(64)     default ''                 comment '创建者',
#                            create_time 	   datetime                                   comment '创建时间',
#                            update_by         varchar(64)     default ''                 comment '更新者',
#                            update_time       datetime                                   comment '更新时间',
#                            remark            varchar(500)    default null               comment '备注',
#                            primary key (device_id)
# ) engine=innodb auto_increment=1 comment = '设备信息表';
#
# INSERT INTO kj_device VALUES(1,'1','meter','1','','com5','','','','',9600,8,'none',1,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(2,'0','plc','1','192.168.1.120','102','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(3,'0','rfid1','1','192.168.1.190','6000','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(4,'0','rfid2','1','192.168.1.190','6000','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(5,'0','camera1','1','192.168.1.2','80','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(6,'0','camera2','1','192.168.1.2','80','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(7,'0','camera3','1','192.168.1.2','80','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(8,'0','rtCamera1','1','192.168.1.65','8131','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(9,'0','rtCamera2','1','192.168.1.66','8131','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(10,'0','led1','1','192.168.1.222','5200','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);
# INSERT INTO kj_device VALUES(11,'0','led2','1','192.168.1.223','5200','','','','',NULL,NULL,'',NULL,'0','0','',NULL,'',NULL,NULL);

-- ----------------------------
-- 3、车辆信息表
-- ----------------------------
drop table if exists kj_car;
create table kj_car (
                           car_id            bigint(20)      not null auto_increment    comment '主键',
                           car_number        varchar(100)    not null                   comment '车牌号',
                           material_id       bigint(20)      not null                   comment '货物id',
                           shipper_id        bigint(20)      default null               comment '发货单位id',
                           transport_id      bigint(20)      default null               comment '运输单位id',
                           receiver_id       bigint(20)      default null               comment '收货单位id',
                           customize1        varchar(100)    default null               comment '自定义1',
                           customize2        varchar(100)    default null               comment '自定义2',
                           customize3        varchar(100)    default null               comment '自定义3',
                           status            char(1)         default '0'                comment '状态（0正常 1停用）',
                           del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                           create_by         varchar(64)     default ''                 comment '创建者',
                           create_time 	     datetime                                   comment '创建时间',
                           update_by         varchar(64)     default ''                 comment '更新者',
                           update_time       datetime                                   comment '更新时间',
                           remark            varchar(500)    default null               comment '备注',
                           primary key (car_id)
) engine=innodb auto_increment=1 comment = '车辆信息表';

-- ----------------------------
-- 4、卡号信息表
-- ----------------------------
drop table if exists kj_card;
create table kj_card (
                             card_id           bigint(20)      not null auto_increment    comment '主键',
                             card_number       varchar(50)     not null                   comment '卡号',
                             car_id            bigint(20)      not null                   comment '车号id',
                             status            char(1)         default '0'                comment '状态（0正常 1停用）',
                             del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                             create_by         varchar(64)     default ''                 comment '创建者',
                             create_time 	   datetime                                   comment '创建时间',
                             update_by         varchar(64)     default ''                 comment '更新者',
                             update_time       datetime                                   comment '更新时间',
                             remark            varchar(500)    default null               comment '备注',
                             primary key (card_id)
) engine=innodb auto_increment=1 comment = '卡号信息表';

-- ----------------------------
-- 5、称重信息表
-- ----------------------------
drop table if exists kj_weight;
create table kj_weight (
                             weight_id         bigint(20)      not null auto_increment    comment '主键',
                             weight_seq        varchar(50)     not null                   comment '称重编号',
                             car_number        varchar(100)    not null                   comment '车牌号',
                             material_name     varchar(300)    default null               comment '货名',
                             shipper           varchar(300)    default null               comment '发货单位',
                             transport         varchar(300)    default null               comment '运输单位',
                             receiver          varchar(300)    default null               comment '收货单位',
                             first_time        datetime        default null               comment '一次称重时间',
                             first_img         varchar(500)    default null               comment '一次过磅图片',
                             first_weight      decimal(24,6)   default null               comment '一次过磅重量',
                             second_time       datetime        default null               comment '二次称重时间',
                             second_img        varchar(500)    default null               comment '二次过磅图片',
                             second_weight     decimal(24,6)   default null               comment '二次过磅重量',
                             net_weight        decimal(24,6)   default null               comment '净重重量',
                             customize1        varchar(100)    default null               comment '自定义1',
                             customize2        varchar(100)    default null               comment '自定义2',
                             customize3        varchar(100)    default null               comment '自定义3',
                             finish            bit(1)          default  0                 comment '称重标识（0未完成 1已完成）',
                             upload            bit(1)          default  0                 comment '上传标识（0未完成 1已完成）',
                             status            char(1)         default '0'                comment '状态（0正常 1作废）',
                             del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                             create_by         varchar(64)     default ''                 comment '创建者',
                             create_time 	   datetime                                   comment '创建时间',
                             update_by         varchar(64)     default ''                 comment '更新者',
                             update_time       datetime                                   comment '更新时间',
                             remark            varchar(500)    default null               comment '备注',
                             primary key (weight_id)
) engine=innodb auto_increment=1 comment = '称重信息表';

-- ----------------------------
-- 6、货物信息表
-- ----------------------------
drop table if exists kj_material;
create table kj_material (
                             material_id       bigint(20)      not null auto_increment    comment '主键',
                             material_name     varchar(50)     not null                   comment '货名',
                             material_model    varchar(50)     default null               comment '型号',
                             standard          varchar(50)     default null               comment '规格',
                             status            char(1)         default '0'                comment '状态（0正常 1停用）',
                             del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                             create_by         varchar(64)     default ''                 comment '创建者',
                             create_time 	  datetime                                   comment '创建时间',
                             update_by         varchar(64)     default ''                 comment '更新者',
                             update_time       datetime                                   comment '更新时间',
                             remark            varchar(500)    default null               comment '备注',
                             primary key (material_id)
) engine=innodb auto_increment=1 comment = '货物信息表';

-- ----------------------------
-- 插入数据
-- ----------------------------
insert into sys_menu values(5, '信息维护', 0, 1, 'info', NULL, NULL, 1, 0, 'M', '0', '0', '', 'table', 'admin', sysdate(), '', null, '');

insert into sys_menu values(118, '车辆管理', 5, 3, 'car', 'kj/car/index', NULL, 1, 0, 'C', '0', '0', 'kj:car:list', 'radio', 'admin', sysdate(), '', null, '车辆菜单');
-- 车辆按钮
insert into sys_menu values(1066, '车辆查询', 118, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:car:query', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1067, '车辆新增', 118, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:car:add', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1068, '车辆修改', 118, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:car:edit', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1069, '车辆删除', 118, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:car:remove', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1070, '车辆导出', 118, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:car:export', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu values(120, '货物管理', 5, 2, 'material', 'kj/material/index', NULL, 1, 0, 'C', '0', '0', 'kj:material:list', 'radio', 'admin', sysdate(), '', null, '货物菜单');
-- 货物按钮
insert into sys_menu values(1076, '货物查询', 120, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:material:query', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1077, '货物新增', 120, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:material:add', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1078, '货物修改', 120, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:material:edit', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1079, '货物删除', 120, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:material:remove', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1080, '货物导出', 120, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:material:export', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu values(121, '卡号管理', 5, 4, 'card', 'kj/card/index', NULL, 1, 0, 'C', '0', '0', 'kj:card:list', 'radio', 'admin', sysdate(), '', null, '卡号菜单');
-- 卡号按钮
insert into sys_menu values(1081, '卡号查询', 121, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:card:query', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1082, '卡号新增', 121, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:card:add', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1083, '卡号修改', 121, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:card:edit', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1084, '卡号删除', 121, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:card:remove', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1085, '卡号导出', 121, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:card:export', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu values(6, '称重管理', 0, 2, 'order', NULL, NULL, 1, 0, 'M', '0', '0', '', 'tree-table', 'admin', sysdate(), '', null, '');

insert into sys_menu values(123, '称重明细', 6, 1, 'weight', 'kj/weight/index', NULL, 1, 0, 'C', '0', '0', 'kj:weight:list', 'radio', 'admin', sysdate(), '', null, '称重菜单');
insert into sys_menu values(124, '称重统计', 6, 2, 'report', 'kj/report/index', NULL, 1, 0, 'C', '0', '0', 'kj:weight:list', 'radio', 'admin', sysdate(), '', null, '称重统计');
-- 称重按钮
insert into sys_menu values(1091, '称重查询', 123, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:weight:query', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1092, '称重新增', 123, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:weight:add', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1093, '称重修改', 123, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:weight:edit', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1094, '称重删除', 123, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:weight:remove', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values(1095, '称重导出', 123, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'kj:weight:export', '#', 'admin', sysdate(), '', null, '');

# insert into sys_dict_type values(17, '设备类型', 'kj_device_type', '0', 'admin', sysdate(), '', null, '设备类型');
# insert into sys_dict_data values(46,  1,  '网络',     '0',       'kj_device_type',        '',   'primary',  'Y', '0', 'admin', sysdate(), '', null, '网络设备');
# insert into sys_dict_data values(47,  2,  '串口',     '1',       'kj_device_type',        '',   'info',     'N', '0', 'admin', sysdate(), '', null, '串口设备');
#
# insert into sys_dict_type values(18, '自动打开', 'kj_device_autoOpen', '0', 'admin', sysdate(), '', null, '自动打开');
# insert into sys_dict_data values(48,  1,  '开启',     '0',       'kj_device_autoOpen',        '',   'primary',  'Y', '0', 'admin', sysdate(), '', null, '开启');
# insert into sys_dict_data values(49,  2,  '关闭',     '1',       'kj_device_autoOpen',        '',   'danger',     'N', '0', 'admin', sysdate(), '', null, '关闭');

# insert into sys_menu values(7, '设备管理', 0, 7, 'device', NULL, NULL, 1, 0, 'M', '0', '0', '', 'example', 'admin', sysdate(), '', null, '');
# insert into sys_menu values(125, '设备信息', 7, 1, 'device', 'kj/device/index', NULL, 1, 0, 'C', '0', '0', '', 'radio', 'admin', sysdate(), '', null, '称重菜单');
# insert into sys_menu values(126, '测试', 7, 1, 'test', 'kj/test/index', NULL, 1, 0, 'C', '0', '0', '', 'radio', 'admin', sysdate(), '', null, '称重菜单');








