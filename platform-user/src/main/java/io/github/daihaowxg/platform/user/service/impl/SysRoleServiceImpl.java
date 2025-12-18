package io.github.daihaowxg.platform.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.daihaowxg.platform.user.domain.SysRole;
import io.github.daihaowxg.platform.user.service.SysRoleService;
import io.github.daihaowxg.platform.user.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author wxg
 * @description 针对表【sys_role(角色表)】的数据库操作Service实现
 * @createDate 2025-12-18 16:47:07
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Override
    public List<SysRole> getRolesByUserId(Long userId) {
        return baseMapper.selectRolesByUserId(userId);
    }

}
