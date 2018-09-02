package com.crm.service.clientprogress.impl;

import com.crm.dao.clientprogress.ClientProgressMapper;
import com.crm.entity.ClientProgress;
import com.crm.service.clientprogress.ClientProgressService;
import com.crm.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ClientProgressServiceImpl implements ClientProgressService {
    @Resource
    private ClientProgressMapper mapper;
    @Override
    public Page<ClientProgress> selectProgress(Map map) {
        Page<ClientProgress> pages=null;
        try {
            List<ClientProgress> clientProgresses  = mapper.selectProgress(map);
            //客户发展信息列表
            pages =new Page<ClientProgress>();
            //datatables必要参数
            pages.setRecordsFiltered(new Integer((Integer)map.get("countClient")));
            //datatables必要参数
            pages.setRecordsTotal(new Integer((Integer)map.get("countClient")));
            //datatables必要参数 （客户信息数据）
            pages.setData(clientProgresses);
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
    public int countClientProgress(Map map) {
        int i = 0;
        try {
            i = mapper.countClientProgress(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return i;
        }
    }

    @Override
    public int addProgress(ClientProgress clientProgress) {
        int result = 0;
        try {
            result = mapper.addProgress(clientProgress);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }

    @Override
    public String getPlanCode(String spelling) {
        String result="";
        try {
            int maxId = mapper.selectMaxId()+1;
            //获取当前年月日
            Date date=new Date();
            //转换为stirng
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            //去除 - 的日期
            String replace = format.replace("-", "");
            //获取到客户表最大id并加1
            if(10>maxId){
                result="_KHFZ"+replace+0+maxId;
            }else{
                result="_KHFZ"+replace+maxId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ClientProgress progressInfo(ClientProgress clientProgress) {
        ClientProgress clientProgress1=null;
        try {
             clientProgress1 = mapper.selectOne(clientProgress);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return clientProgress1;
        }
    }

    @Override
    public int updProgress(ClientProgress clientProgress) {
        int i = 0;
        try {
            i = mapper.updProgress(clientProgress);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return i;
        }
    }

    @Override
    public int delProgress(Integer cp_Id) {
        int count = 0;
        try {
            count = mapper.delProgress(cp_Id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return count;
        }
    }
}