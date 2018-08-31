package com.crm.dao.employeeInfo;

import com.crm.entity.EmployeeInfo;

public interface EmployeeInfoMapper {
    /**
     *  登录的方法
     * @param employeeInfo
     * @return
     */
    EmployeeInfo login(EmployeeInfo employeeInfo) throws Exception;

    /**
     * 修改用户
     * @param employeeInfo
     * @return
     */
    int updateEmp(EmployeeInfo employeeInfo);

    int oldPwd(EmployeeInfo employeeInfo);

}
