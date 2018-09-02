package com.crm.dao.clientvalue;

import com.crm.entity.ClientValue;

import java.util.List;
import java.util.Map;

public interface ClientValueMapper {
    /**
     * 查询客户价值信息
     * @param map
     * @return
     */
    List<ClientValue> selectClientValue(Map map)throws Exception;

    /**
     * 客户价值总计记录数
     * @param map
     * @return
     * @throws Exception
     */
    int countClientValue(Map map)throws Exception;
}
