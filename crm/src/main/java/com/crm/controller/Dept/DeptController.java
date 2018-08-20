package com.crm.controller.Dept;

import com.crm.entity.Dept;
import com.crm.service.Dept.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class DeptController {
    @Resource
    DeptService deptService;

    /**
     * 下拉框name
     * @return
     */
    @RequestMapping("/getDName")
    public Object getDeptName(){
        Dept dept = deptService.selectAll();
        return dept;
    }
}
