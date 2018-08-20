package com.crm.controller.RoleManagementController;

import com.crm.entity.RoleManagement;
import com.crm.service.RoleManagement.RoleManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleManagementController {
    @Resource
    RoleManagementService roleManagementService;


    /**
     * 显示角色信息
     * @return
     */
    @RequestMapping("/roleList")
    public Object roleListShow(){
        List<RoleManagement> roleManagements = roleManagementService.selectAll(new RoleManagement());
        return roleManagements;
    }

}
