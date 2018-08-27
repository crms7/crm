package com.crm.service.ClientResource;

import com.crm.entity.ClientResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ClientResourceService {
    List<ClientResource> selectClient(Map map);

    int countClient(Map map);

    int addClient(ClientResource clientResource);

    int selectMaxId();

    int selectOne(@Param("id") Integer id);
}
