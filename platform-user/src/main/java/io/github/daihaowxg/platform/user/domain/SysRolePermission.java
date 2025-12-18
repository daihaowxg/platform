package io.github.daihaowxg.platform.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色-权限关联表
 */
@TableName(value = "sys_role_permission")
@Data
public class SysRolePermission implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键（雪花ID）
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;
    /**
     * 权限ID
     */
    @TableField(value = "permission_id")
    private Long permissionId;
    /**
     *
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;
}