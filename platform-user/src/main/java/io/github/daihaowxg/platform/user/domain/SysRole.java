package io.github.daihaowxg.platform.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色表
 */
@TableName(value = "sys_role")
@Data
public class SysRole implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键（雪花ID）
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 角色编码，如 ADMIN / USER
     */
    @TableField(value = "role_code")
    private String roleCode;
    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    private String roleName;
    /**
     * 角色描述
     */
    @TableField(value = "description")
    private String description;
    /**
     * 状态：1-启用 0-停用
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