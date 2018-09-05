package com.crm.dao.dept;

import com.crm.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    /**
     * 根据条件查询，返回数据
     * @param map
     * @return
     */
    List<Dept> selectAll(Map map) ;

    /**
     * 得到下拉框name
     * @return
     */
    List<Dept> selectName();

    /**
     * 根据传入条件查询是否存在
     * @param dept
     * @return
     */
    int countDept(Dept dept);

    /**
     * 添加一个部门
     * @param dept
     * @return
     */
    int insert(Dept dept);

    Dept selectOne(@Param("id") Integer id);

    int upDept(Dept dept);

    int delDept(Dept dept);

}
