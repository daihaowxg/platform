package io.github.daihaowxg.platform.user.controller;

import io.github.daihaowxg.platform.user.domain.SysRole;
import io.github.daihaowxg.platform.user.service.SysPermissionService;
import io.github.daihaowxg.platform.user.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysRoleService roleService;
    private final SysPermissionService permissionService;

    /**
     * 查询用户角色
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    @GetMapping("/{userId}/roles")
    public List<SysRole> getRoles(@PathVariable Long userId) {
        return roleService.getRolesByUserId(userId);
    }

    /**
     * 查询用户权限标识
     * 
     * @param userId 用户ID
     * @return 权限标识列表
     */
    @GetMapping("/{userId}/permissions")
    public List<String> getPermissions(@PathVariable Long userId) {
        return permissionService.getPermCodesByUserId(userId);
    }
}
