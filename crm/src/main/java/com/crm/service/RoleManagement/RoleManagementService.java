package com.crm.service.RoleManagement;

import com.crm.entity.RoleManagement;

import java.util.List;

public interface RoleManagementService {
    List<RoleManagement> selectAll(RoleManagement roleManagement);
}
