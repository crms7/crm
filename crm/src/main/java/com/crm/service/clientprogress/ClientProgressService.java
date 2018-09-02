package com.crm.service.clientprogress;

import com.crm.entity.ClientProgress;
import com.crm.util.Page;

import java.util.Map;

public interface ClientProgressService {
    Page<ClientProgress> selectProgress(Map map);

    int countClientProgress(Map map);

    int addProgress(ClientProgress clientProgress);

    String getPlanCode(String spelling);

    ClientProgress progressInfo(ClientProgress clientProgress);

    int updProgress(ClientProgress clientProgress);

    int delProgress(Integer cp_Id);

}
