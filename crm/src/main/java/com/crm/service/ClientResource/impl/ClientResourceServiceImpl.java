package com.crm.service.ClientResource.impl;

import com.crm.dao.ClientResource.ClientResourceMapper;
import com.crm.entity.ClientResource;
import com.crm.service.ClientResource.ClientResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ClientResourceServiceImpl implements ClientResourceService {
    @Resource
    private ClientResourceMapper clientResourceMapper;

    /**
     * 查询客户信息
     * @param map
     * @return
     */
    @Override
    public List<ClientResource> selectClient(Map map) {
        List<ClientResource> clientResources = null;
        try {
            clientResources = clientResourceMapper.selectClient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return clientResources;
        }
    }

    @Override
    public int countClient(Map map) {
        int count = 0;
        try {
            count = clientResourceMapper.countClient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        return count;
        }
    }
}
