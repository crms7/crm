package com.crm.controller.roleManagementController;

import com.crm.entity.Dept;
import com.crm.entity.EmployeeInfo;
import com.crm.entity.RoleManagement;
import com.crm.service.dept.DeptService;
import com.crm.service.roleManagement.RoleManagementService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleManagementController {
    @Resource
    private RoleManagementService roleManagementService;
    @Resource
    private DeptService deptService;
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
    @RequestMapping(value = "/addRole")
    @ResponseBody
    public Object add(RoleManagement roleManagement, HttpSession session){
            EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
        roleManagement.setRm_Operator(emp.getE_Name());
        int num = roleManagementService.insert(roleManagement);
        return num;
    }

    /**
     * 修改角色
     * @param roleManagement
     * @return
     */
    @RequestMapping(value = "/updateRole")
    @ResponseBody
    public Object update(RoleManagement roleManagement,HttpSession session){
        EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
        roleManagement.setRm_Operator(emp.getE_Name());
        int i = roleManagementService.updateRole(roleManagement);
        return i;
    }

    /**
     * 点击修改按钮 得到id返回全部数据
     * @param id
     * @return
     */
    @RequestMapping("/showUpInfo/{id}")
    public ModelAndView showUpInfo(@PathVariable("id") String id){
        List<Dept> depts = deptService.selectAll(new HashMap());
        RoleManagement roleManagement = roleManagementService.selectOne(Integer.parseInt(id));
        mv.addObject("dept",depts);
        mv.addObject("role",roleManagement);
        mv.setViewName("upd-role");
        return mv;
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping("/delRole/{id}")
    @ResponseBody
    public Object del(@PathVariable("id")  Integer id){
        int i = roleManagementService.deleteRole(id);
        return i;
    }

    /**
     * 验证角色编码或名称是否存在
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/roleExits",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> roleExit(@RequestParam(required = false,defaultValue = "",value = "rm_Code") String rm_Code,@RequestParam(required = false,defaultValue = "" ,value = "rm_Name")String rm_Name,@RequestParam(required = false,defaultValue = "")Integer id){
        int i = roleManagementService.selectExit(rm_Code, rm_Name, id);
            HashMap map = new HashMap();
        if(i>0){
            map.put("valid",false);
        }else{
            map.put("valid",true);
        }
        return map;
    }


}
