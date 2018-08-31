package com.crm.service.dept.impl;

import com.crm.dao.dept.DeptMapper;
import com.crm.entity.Dept;
import com.crm.service.dept.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
   private  DeptMapper deptMapper;

    @Override
    public List<Dept> selectAll(Map map) {
        return deptMapper.selectAll(map);
    }

    @Override
    public int countDept(Dept dept) {
        return deptMapper.countDept(dept);
    }
}
