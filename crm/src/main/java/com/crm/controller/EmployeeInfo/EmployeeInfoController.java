package com.crm.controller.EmployeeInfo;

import com.crm.MD5.MD5;
import com.crm.entity.EmployeeInfo;
import com.crm.service.EmployeeInfo.EmployeeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public ModelAndView login(EmployeeInfo employeeInfo, HttpSession session){
        //判断接收页面密码是否为空，为空直接返回登录
        if(employeeInfo.getE_Pwd()!=null&&employeeInfo.getE_Pwd()!=""){
            String m_pwd = MD5.MD5Util(employeeInfo.getE_Pwd()); //加密后密码
            employeeInfo.setE_Pwd(m_pwd);
            EmployeeInfo emp=null;
            try {
                emp = employeeInfoService.login(employeeInfo); //调用登录的方法
            } catch (Exception e) {
                System.out.println(e);
            }finally {
                //登录成功
                if(emp!=null){
                    session.setAttribute("emp",emp);
                    mv.setViewName("index");
                }else{
                    //登录成功
                    mv.addObject("msg","账号或密码错误");
                    mv.setViewName("page-login");
                }
            }
        }else{
            mv.addObject("msg","账号和密码不能为空");
            mv.setViewName("page-login");
        }
        return mv;
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
    @RequestMapping("/upEmp")
    @ResponseBody
    public Object updateEmp(EmployeeInfo employeeInfo,HttpSession session){
        EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
        employeeInfo.setE_Id(emp.getE_Id());
        employeeInfo.setE_Phone(emp.getE_Phone());
        int num = employeeInfoService.updateEmp(employeeInfo);
        return num;
    }

}
