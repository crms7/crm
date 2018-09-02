package com.crm.service.clientvalue;

import com.crm.entity.ClientProgress;
import com.crm.entity.ClientValue;
import com.crm.util.Page;

import java.util.Map;

public interface ClientValueService {
    Page<ClientValue> selectClientValue(Map map);

    int countClientValue(Map map);

}
