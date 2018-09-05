package com.crm.controller.employeeInfo;

import com.crm.md5.MD5;
import com.crm.entity.EmployeeInfo;
import com.crm.service.employeeInfo.EmployeeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class EmployeeInfoController {
    @Resource
    private   EmployeeInfoService employeeInfoService;
    private ModelAndView mv = new ModelAndView();

    /**
     * 登录信息验证
     * @param employeeInfo
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginTo",method = RequestMethod.POST)
    @ResponseBody
    public Object login(EmployeeInfo employeeInfo, HttpSession session){
        //判断接收页面密码是否为空，为空直接返回登录
            String m_pwd = MD5.MD5Util(employeeInfo.getE_Pwd()); //加密后密码
            employeeInfo.setE_Pwd(m_pwd);
            EmployeeInfo emp=null;
            int num=0;  //作为ajax的判断
            try {
                emp = employeeInfoService.login(employeeInfo); //调用登录的方法
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if(emp!=null){
                    num=1;
                    session.setAttribute("emp",emp);
                }
                return num;
            }
    }



    /**
     * 默认进入login页面
     * @return
     */
    @RequestMapping("/")
    public String defaultPage(){
        return "page-login";
    }

    /**
     * 修改emp
     * @param employeeInfo
     * @return
     */
    @RequestMapping("/upEmp/{str}")
    @ResponseBody
    public Object updateEmp(EmployeeInfo employeeInfo, @PathVariable("str") String str,HttpSession session){
        if("phone".equals(str)){
            EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
            emp.setE_Phone(employeeInfo.getE_Phone());
            session.setAttribute("emp",emp);
        }
        int num = employeeInfoService.updateEmp(employeeInfo);
        return num;
    }

    @RequestMapping("/uppwdyz")
    @ResponseBody
    public Object upPwdyz(EmployeeInfo employeeInfo){
        String m_pwd = MD5.MD5Util(employeeInfo.getE_Pwd()); //加密后密码
        employeeInfo.setE_Pwd(m_pwd);
        int num= employeeInfoService.oldPwd(employeeInfo);
        HashMap map = new HashMap();
        if(num<1){
            map.put("valid",false);
        }else{
            map.put("valid",true);
        }
        return map;
    }

    @RequestMapping("/uppwd")
    @ResponseBody
    public Object uppwd(EmployeeInfo employeeInfo){
        String m_pwd = MD5.MD5Util(employeeInfo.getE_Pwd()); //加密后密码
        employeeInfo.setE_Pwd(m_pwd);
        int i = employeeInfoService.upPwd(employeeInfo);
        return i;
    }
}
