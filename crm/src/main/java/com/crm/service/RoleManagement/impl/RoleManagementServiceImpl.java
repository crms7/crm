package com.crm.service.RoleManagement.impl;

import com.crm.dao.RoleManagement.RoleManagementMapper;
import com.crm.entity.RoleManagement;
import com.crm.service.RoleManagement.RoleManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoleManagementServiceImpl implements RoleManagementService {
    @Resource
    RoleManagementMapper roleManagementMapper;

    @Override
    public List<RoleManagement> selectAll(RoleManagement roleManagement) {
        return roleManagementMapper.selectAll(roleManagement);
    }
}
