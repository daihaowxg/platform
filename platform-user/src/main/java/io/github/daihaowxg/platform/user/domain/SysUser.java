package io.github.daihaowxg.platform.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@TableName(value = "sys_user")
@Data
public class SysUser implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键（雪花ID）
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 登录名
     */
    @TableField(value = "username")
    private String username;
    /**
     * 加密后的密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;
    /**
     * 状态：1-启用 0-禁用
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;
    /**
     * 最后登录时间
     */
    @TableField(value = "last_login_time")
    private LocalDateTime lastLoginTime;
    /**
     * 最后登录IP
     */
    @TableField(value = "last_login_ip")
    private String lastLoginIp;
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