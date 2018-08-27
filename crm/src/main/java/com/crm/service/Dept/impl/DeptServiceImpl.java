package com.crm.service.Dept.impl;

import com.crm.dao.Dept.DeptMapper;
import com.crm.entity.Dept;
import com.crm.service.Dept.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
   private  DeptMapper deptMapper;

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
