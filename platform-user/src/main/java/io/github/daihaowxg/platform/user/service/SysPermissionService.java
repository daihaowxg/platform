package io.github.daihaowxg.platform.user.service;

import io.github.daihaowxg.platform.user.domain.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wxg
 * @description 针对表【sys_permission(权限表)】的数据库操作Service
 * @createDate 2025-12-18 16:47:07
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 根据用户ID查询权限标识列表
     * 
     * @param userId 用户ID
     * @return 权限标识列表
     */
    List<String> getPermCodesByUserId(Long userId);

}
