package com.crm.service.roleManagement;

import com.crm.entity.RoleManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleManagementService {
    /**
     * 查询信息
     * @param map
     * @return
     */
    List<RoleManagement> selectAll(Map map);

    /**
     * 修改
     * @param roleManagement
     * @return
     */
    int updateRole(RoleManagement roleManagement);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteRole(@Param("id") Integer id);

    /**
     * 新增
     * @param roleManagement
     * @return
     */
    int insert(RoleManagement roleManagement);

    /**
     * 得到总记录数
     * @param roleManagement
     * @return
     */
    int countRole(RoleManagement roleManagement);

    /**
     * 点击修改时，得到修改前的信息
     * @param id
     * @return
     */
    RoleManagement selectOne(@Param("id")Integer id);

    /**
     * 根据编码和角色名称，是否存在
     * @param
     * @return
     */
    int selectExit(String Code , String name,Integer id);
}
