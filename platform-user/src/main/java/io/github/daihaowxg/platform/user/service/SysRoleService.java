package io.github.daihaowxg.platform.user.service;

import io.github.daihaowxg.platform.user.domain.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wxg
 * @description 针对表【sys_role(角色表)】的数据库操作Service
 * @createDate 2025-12-18 16:47:07
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户ID查询角色列表
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRole> getRolesByUserId(Long userId);

}
