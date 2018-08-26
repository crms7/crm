package com.crm.dao.ClientResource;

import com.crm.entity.ClientResource;

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
}
