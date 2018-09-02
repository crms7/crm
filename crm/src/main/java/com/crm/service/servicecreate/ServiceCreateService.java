package com.crm.service.servicecreate;

import com.crm.entity.ServiceCreate;
import com.crm.util.Page;

import java.util.Map;

public interface ServiceCreateService {
    Page<ServiceCreate> serviceCreateInfo(Map map);

    int countService(Map map);

}
