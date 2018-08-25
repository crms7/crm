package com.crm.service.ClientResource;

import com.crm.entity.ClientResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ClientResourceService {
    List<ClientResource> selectClient(Map map);

    int countClient(Map map);
}
