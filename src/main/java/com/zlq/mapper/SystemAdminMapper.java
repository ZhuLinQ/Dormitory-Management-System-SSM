package com.zlq.mapper;

import com.zlq.pojo.SystemAdmin;

public interface SystemAdminMapper {
    public SystemAdmin findByUsername(String username);
}
