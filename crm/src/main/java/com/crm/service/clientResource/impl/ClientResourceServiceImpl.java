package com.crm.service.clientResource.impl;

import com.crm.dao.clientResource.ClientResourceMapper;
import com.crm.entity.ClientResource;
import com.crm.service.clientResource.ClientResourceService;
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

    /**
     * 添加客户
     * @param clientResource
     * @return
     */
    @Override
    public int addClient(ClientResource clientResource) {
        int i = 0;
        try {
            i = clientResourceMapper.addClient(clientResource);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return i;
        }
    }

    @Override
    public int selectMaxId() {
        int i = 0;
        try {
            i = clientResourceMapper.selectMaxId();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return i;
        }
    }

    @Override
    public int selectOne(Integer id) {
        int result = 0;
        try {
            result = clientResourceMapper.selectOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
