package com.crm.controller.RoleManagementController;

import com.crm.entity.RoleManagement;
import com.crm.service.RoleManagement.RoleManagementService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleManagementController {
    @Resource
    RoleManagementService roleManagementService;
    ModelAndView mv = new ModelAndView();

    /**
     * 显示角色信息
     * @return
     */
    @RequestMapping("/roleList")
    @ResponseBody
    public Object roleListShow(
            RoleManagement roleManagement,
            @RequestParam(value = "draw", required = false, defaultValue = "0") String draw,
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "5") Integer length,
            @RequestParam(value = "rm_Name", required = false, defaultValue = "")  String rm_Name){
        Map map = new HashMap();
        map.put("begin",start);
        map.put("end",length);
        map.put("rm_Name",rm_Name);
        Page<RoleManagement> pages = new Page<RoleManagement>();
        int countRole = roleManagementService.countRole(roleManagement); //得到角色表总记录数
        List<RoleManagement> roleManagements = roleManagementService.selectAll(map);
        pages.setRecordsFiltered(countRole);
        pages.setRecordsTotal(countRole);
        pages.setData(roleManagements);
        pages.setLength(length);
        pages.setStart(start);
        pages.setDraw(Integer.parseInt(draw));
        return pages;
    }

    /**
     * 新增角色
     * @param roleManagement
     * @return
     */
    @RequestMapping("/addRole")
    public ModelAndView add(RoleManagement roleManagement){
        /* 测试数据
        roleManagement.setRm_Code("t2");
        roleManagement.setRm_Name("涛子2");
        roleManagement.setRm_DepartId(1L);
        roleManagement.setRm_Operator(1L);
        roleManagement.setRm_Description("超级管理员2");
        */
        int num = roleManagementService.insert(roleManagement);
        if(num>0){
            mv.setViewName("index");
        }else{
            mv.setViewName("page-login");
        }
        return mv;
    }

    /**
     * 修改角色
     * @param roleManagement
     * @return
     */
    @RequestMapping("/updateRole")
    public ModelAndView update(RoleManagement roleManagement){
        /*
        roleManagement.setRm_Id(7L);
        roleManagement.setRm_Code("t3");
        roleManagement.setRm_Name("涛子3");
        roleManagement.setRm_DepartId(2L);
        roleManagement.setRm_Description("超级管理员3");
        */
        int i = roleManagementService.updateRole(roleManagement);
        if(i>0){
            mv.setViewName("index");
        }else{
            mv.setViewName("page-login");
        }
        return mv;
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping("/delRole")
    public Object del(@RequestParam(required = false,defaultValue = "")  Integer id){
        //测试数据id=7;
        int i = roleManagementService.deleteRole(id);
        return i;
    }

}
