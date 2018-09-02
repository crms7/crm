package com.crm.service.clientResource;

import com.crm.entity.ClientResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClientResourceService {
    List<ClientResource> selectClient(Map map);

    int countClient(Map map);

    int addClient(ClientResource clientResource);

    String selectMaxId();

    int selectOne(@Param("id") Integer id);

    int changeClient(ClientResource clientResource);

    int selectClientId(String clientCode);

}
