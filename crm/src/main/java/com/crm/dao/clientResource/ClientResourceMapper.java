package com.crm.dao.clientResource;

import com.crm.entity.ClientResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClientResourceMapper {
    /**
     * 查询客户信息
     * @param map
     * @return
     * @throws Exception
     */
    List<ClientResource> selectClient(Map map) throws Exception;

    /**
     * 客户总记录数查询
     * @param map
     * @return
     * @throws Exception
     */
    int countClient(Map map)throws Exception;

    /**
     * 添加客户
     * @param clientResource
     * @return
     * @throws Exception
     */
    int addClient(ClientResource clientResource) throws  Exception;

    /**
     * 查询最大的id
     * @return
     * @throws Exception
     */
    int selectMaxId() throws  Exception;

    /**
     * 查客户单条信息
     * @param id
     * @return
     * @throws Exception
     */
    int selectOne(@Param("id") Integer id)throws  Exception;

    /**
     * 修改客户信息
     * @param clientResource
     * @return
     * @throws Exception
     */
    int changeClient(ClientResource clientResource)throws Exception;

    /**
     * 以客户编码查询客户id
     * @param clientCode
     * @return
     * @throws Exception
     */
    int selectClientId(@Param("clientCode") String clientCode) throws Exception;
}
