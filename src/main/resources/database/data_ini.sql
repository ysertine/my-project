INSERT INTO `sys_user` VALUES (1, 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 1, '15988888888', '123456@qq.com', '2018-11-9 08:37:25', '2018-11-10 08:37:30', '2018-11-10 08:37:33', 1);
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_permission` VALUES (1, '系统用户管理', 0, '0/', 'sysUser:view', 0, 'sysUserInfo/userList', 1);
INSERT INTO `sys_permission` VALUES (2, '系统用户添加', 1, '0/1', 'sysUser:add', 1, 'sysUserInfo/userAdd', 1);
INSERT INTO `sys_permission` VALUES (3, '系统用户修改', 1, '0/1', 'sysUser:edit', 1, 'sysUser/userEdit', 1);
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', 1);
INSERT INTO `sys_role` VALUES (2, 'developer', '开发', 1);
INSERT INTO `sys_role` VALUES (3, 'test', '测试', 1);
INSERT INTO `sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` VALUES (2, 2, 1);
INSERT INTO `sys_role_permission` VALUES (3, 3, 2);