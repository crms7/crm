package com.crm.controller.Dept;

import com.crm.entity.Dept;
import com.crm.service.Dept.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeptController {
    @Resource
   private   DeptService deptService;

    /**
     * 下拉框name
     * @return
     */
    @RequestMapping("/getDName")
    @ResponseBody
    public Object getDeptName(){
        List<Dept> dept = deptService.selectAll();
        return dept;
    }
}
