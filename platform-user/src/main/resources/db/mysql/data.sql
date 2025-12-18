-- =============================================
-- 测试数据初始化脚本 (MySQL)
-- =============================================

-- =============================================
-- 清空现有数据 (按外键依赖顺序)
-- =============================================
SET FOREIGN_KEY_CHECKS = 0;  -- 临时禁用外键检查

-- 1. 清空关联表
TRUNCATE TABLE sys_role_permission;
TRUNCATE TABLE sys_user_role;

-- 2. 清空主表
TRUNCATE TABLE sys_permission;
TRUNCATE TABLE sys_role;
TRUNCATE TABLE sys_user;

SET FOREIGN_KEY_CHECKS = 1;  -- 重新启用外键检查

-- =============================================
-- 插入测试数据
-- =============================================

-- 1. 用户数据
-- 密码统一为 123456 的 BCrypt 加密结果: $2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi
INSERT INTO sys_user (id, username, password, nickname, email, mobile, status, is_deleted, last_login_time, last_login_ip, created_at, updated_at) VALUES
(1001, 'admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '系统管理员', 'admin@platform.com', '13800138000', 1, 0, '2025-12-18 10:00:00', '127.0.0.1', NOW(), NOW()),
(1002, 'zhangsan', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '张三', 'zhangsan@platform.com', '13800138001', 1, 0, '2025-12-18 09:30:00', '192.168.1.100', NOW(), NOW()),
(1003, 'lisi', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '李四', 'lisi@platform.com', '13800138002', 1, 0, '2025-12-18 08:45:00', '192.168.1.101', NOW(), NOW()),
(1004, 'wangwu', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '王五', 'wangwu@platform.com', '13800138003', 1, 0, NULL, NULL, NOW(), NOW()),
(1005, 'zhaoliu', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '赵六', 'zhaoliu@platform.com', '13800138004', 0, 0, NULL, NULL, NOW(), NOW());


-- 2. 角色数据
INSERT INTO sys_role (id, role_code, role_name, description, status, is_deleted, created_at, updated_at) VALUES
(2001, 'SUPER_ADMIN', '超级管理员', '拥有系统所有权限', 1, 0, NOW(), NOW()),
(2002, 'ADMIN', '管理员', '拥有大部分管理权限', 1, 0, NOW(), NOW()),
(2003, 'USER', '普通用户', '基础用户权限', 1, 0, NOW(), NOW()),
(2004, 'GUEST', '访客', '只读权限', 1, 0, NOW(), NOW());


-- 3. 权限数据
INSERT INTO sys_permission (id, perm_code, perm_name, perm_type, parent_id, path, method, status, is_deleted, created_at, updated_at) VALUES
-- 用户管理模块 (parent_id = 0 表示顶级菜单)
(3001, 'user:menu', '用户管理', 1, 0, '/user', NULL, 1, 0, NOW(), NOW()),
(3002, 'user:list', '用户列表', 2, 3001, '/user/list', 'GET', 1, 0, NOW(), NOW()),
(3003, 'user:add', '新增用户', 2, 3001, '/user/add', 'POST', 1, 0, NOW(), NOW()),
(3004, 'user:edit', '编辑用户', 2, 3001, '/user/edit', 'PUT', 1, 0, NOW(), NOW()),
(3005, 'user:delete', '删除用户', 2, 3001, '/user/delete', 'DELETE', 1, 0, NOW(), NOW()),
(3006, 'user:export', '导出用户', 2, 3001, '/user/export', 'GET', 1, 0, NOW(), NOW()),

-- 角色管理模块
(3011, 'role:menu', '角色管理', 1, 0, '/role', NULL, 1, 0, NOW(), NOW()),
(3012, 'role:list', '角色列表', 2, 3011, '/role/list', 'GET', 1, 0, NOW(), NOW()),
(3013, 'role:add', '新增角色', 2, 3011, '/role/add', 'POST', 1, 0, NOW(), NOW()),
(3014, 'role:edit', '编辑角色', 2, 3011, '/role/edit', 'PUT', 1, 0, NOW(), NOW()),
(3015, 'role:delete', '删除角色', 2, 3011, '/role/delete', 'DELETE', 1, 0, NOW(), NOW()),
(3016, 'role:assign', '分配权限', 2, 3011, '/role/assign', 'POST', 1, 0, NOW(), NOW()),

-- 权限管理模块
(3021, 'permission:menu', '权限管理', 1, 0, '/permission', NULL, 1, 0, NOW(), NOW()),
(3022, 'permission:list', '权限列表', 2, 3021, '/permission/list', 'GET', 1, 0, NOW(), NOW()),
(3023, 'permission:add', '新增权限', 2, 3021, '/permission/add', 'POST', 1, 0, NOW(), NOW()),
(3024, 'permission:edit', '编辑权限', 2, 3021, '/permission/edit', 'PUT', 1, 0, NOW(), NOW()),
(3025, 'permission:delete', '删除权限', 2, 3021, '/permission/delete', 'DELETE', 1, 0, NOW(), NOW()),

-- 系统监控模块
(3031, 'monitor:menu', '系统监控', 1, 0, '/monitor', NULL, 1, 0, NOW(), NOW()),
(3032, 'monitor:online', '在线用户', 2, 3031, '/monitor/online', 'GET', 1, 0, NOW(), NOW()),
(3033, 'monitor:log', '操作日志', 2, 3031, '/monitor/log', 'GET', 1, 0, NOW(), NOW()),
(3034, 'monitor:server', '服务器监控', 2, 3031, '/monitor/server', 'GET', 1, 0, NOW(), NOW()),

-- 个人中心 (所有用户都有的基础权限)
(3041, 'profile:menu', '个人中心', 1, 0, '/profile', NULL, 1, 0, NOW(), NOW()),
(3042, 'profile:view', '查看资料', 2, 3041, '/profile/view', 'GET', 1, 0, NOW(), NOW()),
(3043, 'profile:edit', '修改资料', 2, 3041, '/profile/edit', 'PUT', 1, 0, NOW(), NOW()),
(3044, 'profile:password', '修改密码', 2, 3041, '/profile/password', 'PUT', 1, 0, NOW(), NOW());


-- 4. 用户-角色关联
INSERT INTO sys_user_role (id, user_id, role_id, created_at) VALUES
(4001, 1001, 2001, NOW()),  -- admin -> 超级管理员
(4002, 1002, 2002, NOW()),  -- zhangsan -> 管理员
(4003, 1003, 2003, NOW()),  -- lisi -> 普通用户
(4004, 1004, 2003, NOW()),  -- wangwu -> 普通用户
(4005, 1005, 2004, NOW());  -- zhaoliu -> 访客 (已禁用)


-- 5. 角色-权限关联
INSERT INTO sys_role_permission (id, role_id, permission_id, created_at) VALUES
(5001, 2001, 3001, NOW()), (5002, 2001, 3002, NOW()), (5003, 2001, 3003, NOW()), 
(5004, 2001, 3004, NOW()), (5005, 2001, 3005, NOW()), (5006, 2001, 3006, NOW()),
(5007, 2001, 3011, NOW()), (5008, 2001, 3012, NOW()), (5009, 2001, 3013, NOW()), 
(5010, 2001, 3014, NOW()), (5011, 2001, 3015, NOW()), (5012, 2001, 3016, NOW()),
(5013, 2001, 3021, NOW()), (5014, 2001, 3022, NOW()), (5015, 2001, 3023, NOW()), 
(5016, 2001, 3024, NOW()), (5017, 2001, 3025, NOW()),
(5018, 2001, 3031, NOW()), (5019, 2001, 3032, NOW()), (5020, 2001, 3033, NOW()), 
(5021, 2001, 3034, NOW()),
(5022, 2001, 3041, NOW()), (5023, 2001, 3042, NOW()), (5024, 2001, 3043, NOW()), 
(5025, 2001, 3044, NOW()),
(5031, 2002, 3001, NOW()), (5032, 2002, 3002, NOW()), (5033, 2002, 3003, NOW()), 
(5034, 2002, 3004, NOW()), (5035, 2002, 3005, NOW()),
(5036, 2002, 3011, NOW()), (5037, 2002, 3012, NOW()), (5038, 2002, 3013, NOW()), 
(5039, 2002, 3014, NOW()), (5040, 2002, 3015, NOW()),
(5041, 2002, 3041, NOW()), (5042, 2002, 3042, NOW()), (5043, 2002, 3043, NOW()), 
(5044, 2002, 3044, NOW()),
(5051, 2003, 3001, NOW()), (5052, 2003, 3002, NOW()),  -- 可以查看用户列表
(5053, 2003, 3011, NOW()), (5054, 2003, 3012, NOW()),  -- 可以查看角色列表
(5055, 2003, 3041, NOW()), (5056, 2003, 3042, NOW()), 
(5057, 2003, 3043, NOW()), (5058, 2003, 3044, NOW()),
(5061, 2004, 3041, NOW()), (5062, 2004, 3042, NOW());
