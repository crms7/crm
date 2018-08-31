package com.crm.controller.dept;

import com.crm.entity.Dept;
import com.crm.entity.RoleManagement;
import com.crm.service.dept.DeptService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Dept> dept = deptService.selectAll(new HashMap());
        return dept;
    }

    @RequestMapping("/showDepts")
    @ResponseBody
    public Object showDeptList(
            Dept dept,
            @RequestParam(value = "draw", required = false, defaultValue = "0") String draw,
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "5") Integer length,
            @RequestParam(value = "rm_Name", required = false, defaultValue = "")  String rm_Name
    ){
        Map map = new HashMap();
        map.put("begin",start);
        map.put("end",length);
        map.put("rm_Name",rm_Name);
        Page<Dept> pages = new Page<Dept>();
        int countDept = deptService.countDept(dept); //得到角色表总记录数
        List<Dept> depts = deptService.selectAll(map);
        pages.setRecordsFiltered(countDept);
        pages.setRecordsTotal(countDept);
        pages.setData(depts);
        pages.setLength(length);
        pages.setStart(start);
        pages.setDraw(Integer.parseInt(draw));
        return pages;
    }
}