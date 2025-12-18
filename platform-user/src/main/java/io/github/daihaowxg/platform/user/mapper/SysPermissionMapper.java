package io.github.daihaowxg.platform.user.mapper;

import io.github.daihaowxg.platform.user.domain.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author wxg
 * @description 针对表【sys_permission(权限表)】的数据库操作Mapper
 * @createDate 2025-12-18 16:47:07
 * @Entity io.github.daihaowxg.platform.user.domain.SysPermission
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据用户ID查询权限标识列表
     * 
     * @param userId 用户ID
     * @return 权限标识列表
     */
    List<String> selectPermCodesByUserId(Long userId);

}
