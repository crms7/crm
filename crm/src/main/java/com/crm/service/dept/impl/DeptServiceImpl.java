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
    public List<Dept> selectName() {
        return deptMapper.selectName();
    }

    @Override
    public int countDept(Dept dept) {
        return deptMapper.countDept(dept);
    }

    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public Dept selectOne(Integer id) {
        return deptMapper.selectOne(id);
    }

    @Override
    public int upDept(Dept dept) {
        return deptMapper.upDept(dept);
    }

    @Override
    public int delDept(Dept dept) {
        return deptMapper.delDept(dept);
    }
}
