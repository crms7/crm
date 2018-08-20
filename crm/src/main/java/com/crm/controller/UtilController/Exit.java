package com.crm.controller.UtilController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Exit {

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String exitLogin(HttpSession session){
        session.invalidate(); //清空session里面的值
        return "page-login";
    }
}
