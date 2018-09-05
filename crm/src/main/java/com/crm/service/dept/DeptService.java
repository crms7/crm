package com.crm.service.dept;

import com.crm.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptService {
    List<Dept> selectAll(Map map);
    List<Dept> selectName();
    int countDept(Dept dept);
    int insert(Dept dept);
    Dept selectOne(@Param("id") Integer Id);
    int upDept(Dept dept);

    int delDept(Dept dept);
}
