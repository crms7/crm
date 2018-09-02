package com.crm.dao.clientprogress;

import com.crm.entity.ClientProgress;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClientProgressMapper {
    /**
     * 查询客户发展计划
     * @param map
     * @return
     */
    List<ClientProgress> selectProgress(Map map) throws Exception;

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int countClientProgress(Map map)throws Exception;

    /**
     * 添加计划
     * @param clientProgress
     * @return
     * @throws Exception
     */
    int addProgress(ClientProgress clientProgress) throws Exception;

    /**
     * 获取最大的客户计划id
     * @return
     * @throws Exception
     */
    int selectMaxId() throws Exception;

    /**
     * 以条件查询单条信息
     * @param clientProgress
     * @return
     * @throws Exception
     */
    ClientProgress selectOne(ClientProgress clientProgress)throws Exception;

    /**
     * 修改客户计划信息
     * @param clientProgress
     * @return
     * @throws Exception
     */
    int updProgress(ClientProgress clientProgress)throws Exception;

    /**
     * 删除客户计划信息
     * @param cp_Id
     * @return
     * @throws Exception
     */
    int delProgress(@Param("cp_Id") Integer cp_Id)throws Exception;
}
