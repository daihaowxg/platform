package io.github.daihaowxg.platform.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限表
 */
@TableName(value = "sys_permission")
@Data
public class SysPermission implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键（雪花ID）
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 权限标识，如 user:add
     */
    @TableField(value = "perm_code")
    private String permCode;
    /**
     * 权限名称
     */
    @TableField(value = "perm_name")
    private String permName;
    /**
     * 权限类型：1-菜单 2-按钮 3-接口
     */
    @TableField(value = "perm_type")
    private Integer permType;
    /**
     * 父权限ID（菜单树）
     */
    @TableField(value = "parent_id")
    private Long parentId;
    /**
     * 前端路由 / 后端接口路径
     */
    @TableField(value = "path")
    private String path;
    /**
     * HTTP方法 GET/POST/PUT/DELETE
     */
    @TableField(value = "method")
    private String method;
    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;
    /**
     *
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;
    /**
     *
     */
    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;
}