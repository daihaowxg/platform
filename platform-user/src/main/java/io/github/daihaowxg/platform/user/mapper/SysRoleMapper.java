package io.github.daihaowxg.platform.user.mapper;

import io.github.daihaowxg.platform.user.domain.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author wxg
 * @description 针对表【sys_role(角色表)】的数据库操作Mapper
 * @createDate 2025-12-18 16:47:07
 * @Entity io.github.daihaowxg.platform.user.domain.SysRole
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查询角色列表
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRole> selectRolesByUserId(Long userId);

}
