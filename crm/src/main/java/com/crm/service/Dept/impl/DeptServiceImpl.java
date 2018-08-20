package com.crm.service.Dept.impl;

import com.crm.dao.Dept.DeptMapper;
import com.crm.entity.Dept;
import com.crm.service.Dept.DeptService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DeptServiceImpl implements DeptService {
    @Resource
    DeptMapper deptMapper;

    @Override
    public Dept selectAll() {
        return deptMapper.selectAll();
    }
}
