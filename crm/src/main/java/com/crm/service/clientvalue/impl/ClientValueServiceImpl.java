package com.crm.service.clientvalue.impl;

import com.crm.dao.clientvalue.ClientValueMapper;
import com.crm.entity.ClientValue;
import com.crm.service.clientvalue.ClientValueService;
import com.crm.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ClientValueServiceImpl implements ClientValueService {
    @Resource
    private ClientValueMapper valueMapper;
    @Override
    public Page<ClientValue> selectClientValue(Map map) {
        Page<ClientValue> pages=null;
        try {
            //客户价值信息列表
            List<ClientValue> clientValues = valueMapper.selectClientValue(map);
            pages =new Page<ClientValue>();
            //datatables必要参数
            pages.setRecordsFiltered(new Integer((Integer)map.get("countClientValue")));
            //datatables必要参数
            pages.setRecordsTotal(new Integer((Integer)map.get("countClientValue")));
            //datatables必要参数 （列表信息数据）
            pages.setData(clientValues);
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
    public int countClientValue(Map map) {
        int i = 0;
        try {
            i = valueMapper.countClientValue(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return i;
        }
    }

}
