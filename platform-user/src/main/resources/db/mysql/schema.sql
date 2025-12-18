CREATE TABLE IF NOT EXISTS sys_user (
    id              BIGINT NOT NULL COMMENT '主键（雪花ID）',
    username        VARCHAR(64)  NOT NULL COMMENT '登录名',
    password        VARCHAR(255) NOT NULL COMMENT '加密后的密码',
    nickname        VARCHAR(64)           COMMENT '昵称',
    email           VARCHAR(128)          COMMENT '邮箱',
    mobile          VARCHAR(32)           COMMENT '手机号',

    status          TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1-启用 0-禁用',
    is_deleted      TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除',

    last_login_time DATETIME               COMMENT '最后登录时间',
    last_login_ip   VARCHAR(64)            COMMENT '最后登录IP',

    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    UNIQUE KEY uk_username (username)
) COMMENT='用户表';



CREATE TABLE IF NOT EXISTS sys_role (
    id           BIGINT NOT NULL COMMENT '主键（雪花ID）',
    role_code    VARCHAR(64) NOT NULL COMMENT '角色编码，如 ADMIN / USER',
    role_name    VARCHAR(64) NOT NULL COMMENT '角色名称',
    description  VARCHAR(255)        COMMENT '角色描述',

    status       TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1-启用 0-停用',
    is_deleted   TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除',

    created_at   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    UNIQUE KEY uk_role_code (role_code)
) COMMENT='角色表';



CREATE TABLE IF NOT EXISTS sys_permission (
    id              BIGINT NOT NULL COMMENT '主键（雪花ID）',
    perm_code       VARCHAR(128) NOT NULL COMMENT '权限标识，如 user:add',
    perm_name       VARCHAR(64)  NOT NULL COMMENT '权限名称',
    perm_type       TINYINT NOT NULL COMMENT '权限类型：1-菜单 2-按钮 3-接口',
    parent_id       BIGINT DEFAULT 0 COMMENT '父权限ID（菜单树）',

    path            VARCHAR(255) COMMENT '前端路由 / 后端接口路径',
    method          VARCHAR(16)  COMMENT 'HTTP方法 GET/POST/PUT/DELETE',

    status          TINYINT NOT NULL DEFAULT 1 COMMENT '状态',
    is_deleted      TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除',

    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    UNIQUE KEY uk_perm_code (perm_code)
) COMMENT='权限表';




CREATE TABLE IF NOT EXISTS sys_user_role (
    id          BIGINT NOT NULL COMMENT '主键（雪花ID）',
    user_id     BIGINT NOT NULL COMMENT '用户ID',
    role_id     BIGINT NOT NULL COMMENT '角色ID',

    created_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    UNIQUE KEY uk_user_role (user_id, role_id),
    KEY idx_user_id (user_id),
    KEY idx_role_id (role_id)
) COMMENT='用户-角色关联表';




CREATE TABLE IF NOT EXISTS sys_role_permission (
    id             BIGINT NOT NULL COMMENT '主键（雪花ID）',
    role_id        BIGINT NOT NULL COMMENT '角色ID',
    permission_id  BIGINT NOT NULL COMMENT '权限ID',

    created_at     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    UNIQUE KEY uk_role_perm (role_id, permission_id),
    KEY idx_role_id (role_id),
    KEY idx_perm_id (permission_id)
) COMMENT='角色-权限关联表';
