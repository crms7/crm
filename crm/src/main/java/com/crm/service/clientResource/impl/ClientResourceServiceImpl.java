package com.crm.service.clientResource.impl;

import com.crm.dao.clientResource.ClientResourceMapper;
import com.crm.entity.ClientResource;
import com.crm.service.clientResource.ClientResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String selectMaxId() {
        String result="";
        try {
            int maxId = clientResourceMapper.selectMaxId()+1;
            //获取当前年月日
            Date date=new Date();
            //转换为stirng
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            //去除 -
            String replace = format.replace("-", "");
            //获取到客户表最大id并加1
            if(maxId<10){
                result=replace+0+maxId;
            }else{
                result=replace+maxId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
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

    @Override
    public int changeClient(ClientResource clientResource) {
        int result= 0;
        try {
            result = clientResourceMapper.changeClient(clientResource);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }

    @Override
    public int selectClientId(String clientCode) {
        int result= 0;
        try {
            result = clientResourceMapper.selectClientId(clientCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
