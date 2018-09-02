package com.crm.controller.servicecreate;

import com.crm.entity.ServiceCreate;
import com.crm.service.servicecreate.ServiceCreateService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/service")
public class ServiceCreateController {
    @Resource
    private ServiceCreateService serviceCreateService;

    /**
     * 服务创建信息列表
     * @param serviceCreate
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("/selectServiceCreate")
    @ResponseBody
    public Object serviceInfoList(
            ServiceCreate serviceCreate,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw,
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "2") Integer length
    ){
        Map map = new HashMap();
        map.put("begin",start);
        map.put("end",length);
        map.put("service",serviceCreate);
        map.put("draw",draw);
        // 服务列表总记录数
        int countService=serviceCreateService.countService(map);
        map.put("countService",countService);
        Page<ServiceCreate> clientProgressPage = serviceCreateService.serviceCreateInfo(map);
        return clientProgressPage;
    }
}
