package com.crm.dao.servicecreate;

import com.crm.entity.ServiceCreate;

import java.util.List;
import java.util.Map;

public interface ServiceCreateMapper {

    /**
     * 服务信息
     * @param map
     * @return
     * @throws Exception
     */
    List<ServiceCreate> selServiceCreate(Map map)throws Exception;

    /**
     * 服务的总记录数
     * @param map
     * @return
     * @throws Exception
     */
    int countService(Map map)throws Exception;
}
