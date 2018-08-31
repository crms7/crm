package com.crm.controller.utilController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    /**
     * 中转站,跳页面
     * @param path
     * @return
     */
    @RequestMapping("/jumps/{path}")
    public String Jump(@PathVariable("path") String path){
            return path;
    }
}
