package com.crm.service.EmployeeInfo;

import com.crm.entity.EmployeeInfo;

public interface EmployeeInfoService {
    /**
     *  登录的方法
     * @param employeeInfo
     * @return
     */
    EmployeeInfo login(EmployeeInfo employeeInfo) throws Exception;
}
