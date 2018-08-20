package com.crm.controller.EmployeeInfo;

import com.crm.MD5.MD5;
import com.crm.entity.EmployeeInfo;
import com.crm.service.EmployeeInfo.EmployeeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeInfoController {
    @Resource
    EmployeeInfoService employeeInfoService;

    /**
     * 登录信息验证
     * @param employeeInfo
     * @param session
     * @return
     */
    @RequestMapping("/loginTo")
    public String login(EmployeeInfo employeeInfo, HttpSession session){
        String m_pwd = MD5.MD5Util(employeeInfo.getE_Pwd()); //加密后密码
        employeeInfo.setE_Pwd(m_pwd);
        String msg=null;
        EmployeeInfo emp=null;
        try {
            emp = employeeInfoService.login(employeeInfo);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if(emp!=null){
                session.setAttribute("emp",emp);
                return "index";
            }else{
                msg="账号或密码错误";
                return "page-login";
            }
        }
    }

    //测试 后面删掉
    @RequestMapping("/indexss")
    public String show(){
        return "blank-page";
    }


    /**
     * 默认进入login页面
     * @return
     */
    @RequestMapping("/")
    public String defaultPage(){
        return "page-login";
    }

}
