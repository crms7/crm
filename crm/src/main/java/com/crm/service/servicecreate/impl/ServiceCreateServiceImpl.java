package com.crm.service.servicecreate.impl;

import com.crm.dao.servicecreate.ServiceCreateMapper;
import com.crm.entity.ServiceCreate;
import com.crm.service.servicecreate.ServiceCreateService;
import com.crm.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ServiceCreateServiceImpl implements ServiceCreateService {
    @Resource
    private ServiceCreateMapper serviceCreateMapper;
    @Override
    public Page<ServiceCreate> serviceCreateInfo(Map map) {
        Page<ServiceCreate> pages=null;
        try {
            List<ServiceCreate> serviceCreates = serviceCreateMapper.selServiceCreate(map);
            //客户价值信息列表
            List<ServiceCreate> serviceCreatesInfo = serviceCreateMapper.selServiceCreate(map);
            pages =new  Page<ServiceCreate>();
            //datatables必要参数
            pages.setRecordsFiltered(new Integer((Integer)map.get("countService")));
            //datatables必要参数
            pages.setRecordsTotal(new Integer((Integer)map.get("countService")));
            //datatables必要参数 （列表信息数据）
            pages.setData(serviceCreatesInfo);
            //datatables必要参数 （每页大小）
            pages.setLength(new Integer((Integer)map.get("end")));
            //datatables必要参数 （开始页）
            pages.setStart( new Integer((Integer)map.get("begin")));
            //datatables必要参数 （绘制）
            pages.setDraw( new Integer((Integer)map.get("draw")));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return pages;
        }
    }

    @Override
    public int countService(Map map) {
        int i = 0;
        try {
            i = serviceCreateMapper.countService(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return i;
        }
    }
}
