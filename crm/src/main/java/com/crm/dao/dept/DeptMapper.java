package com.crm.dao.dept;

import com.crm.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    List<Dept> selectAll(Map map) ;
    int countDept(Dept dept);
}
