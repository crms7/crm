package com.crm.dao.EmployeeInfo;

import com.crm.entity.EmployeeInfo;

public interface EmployeeInfoMapper {
    /**
     *  登录的方法
     * @param employeeInfo
     * @return
     */
    EmployeeInfo login(EmployeeInfo employeeInfo) throws Exception;
}
