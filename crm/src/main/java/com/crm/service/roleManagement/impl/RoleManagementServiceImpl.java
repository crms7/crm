package com.crm.service.roleManagement.impl;

import com.crm.dao.roleManagement.RoleManagementMapper;
import com.crm.entity.RoleManagement;
import com.crm.service.roleManagement.RoleManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RoleManagementServiceImpl implements RoleManagementService {
     @Resource
     private  RoleManagementMapper roleManagementMapper;

    @Override
    public List<RoleManagement> selectAll(Map map) {
        return roleManagementMapper.selectAll(map);
    }

    @Override
    public int updateRole(RoleManagement roleManagement) {
        return roleManagementMapper.updateRole(roleManagement);
    }

    @Override
    public int deleteRole(Integer id) {
        return roleManagementMapper.deleteRole(id);
    }

    @Override
    public int insert(RoleManagement roleManagement) {
        return roleManagementMapper.insert(roleManagement);
    }

    @Override
    public int countRole(RoleManagement roleManagement) {
        return roleManagementMapper.countRole(roleManagement);
    }

    @Override
    public RoleManagement selectOne(Integer id) {
        return roleManagementMapper.selectOne(id);
    }

    @Override
    public int selectExit(String  code,String name,Integer id) {
        return  roleManagementMapper.selectExit(code, name,id);
    }
}
