package com.crm.service.dept;

import com.crm.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {
    List<Dept> selectAll(Map map);
    List<Dept> selectName();
    int countDept(Dept dept);
}
