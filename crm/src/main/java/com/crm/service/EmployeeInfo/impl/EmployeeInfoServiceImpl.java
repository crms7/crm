package com.crm.service.EmployeeInfo.impl;

import com.crm.dao.EmployeeInfo.EmployeeInfoMapper;
import com.crm.entity.EmployeeInfo;
import com.crm.service.EmployeeInfo.EmployeeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Resource
    private  EmployeeInfoMapper employeeInfoMapper;


    /**
     * 登录
     * @param employeeInfo
     * @return
     */
    @Override
    public EmployeeInfo login(EmployeeInfo employeeInfo)  {
        EmployeeInfo emp=null ;
        try {
            emp=  employeeInfoMapper.login(employeeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return emp;
        }
    }

    @Override
    public int updateEmp(EmployeeInfo employeeInfo) {
        return employeeInfoMapper.updateEmp(employeeInfo);
    }
}
