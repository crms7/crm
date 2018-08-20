package com.crm.dao.RoleManagement;

import com.crm.entity.RoleManagement;

import java.util.List;

public interface RoleManagementMapper {
    List<RoleManagement> selectAll(RoleManagement roleManagement) ;
}
