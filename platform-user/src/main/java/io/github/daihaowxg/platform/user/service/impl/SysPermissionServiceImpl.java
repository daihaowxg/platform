package io.github.daihaowxg.platform.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.daihaowxg.platform.user.domain.SysPermission;
import io.github.daihaowxg.platform.user.service.SysPermissionService;
import io.github.daihaowxg.platform.user.mapper.SysPermissionMapper;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author wxg
 * @description 针对表【sys_permission(权限表)】的数据库操作Service实现
 * @createDate 2025-12-18 16:47:07
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
        implements SysPermissionService {

    @Override
    public List<String> getPermCodesByUserId(Long userId) {
        return baseMapper.selectPermCodesByUserId(userId);
    }

}
