package com.crm.controller.clientvalue;
import com.crm.entity.ClientValue;
import com.crm.service.clientvalue.ClientValueService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/clientValue")
public class ClientValueController {
    @Resource
    private ClientValueService clientValueService;
    @RequestMapping("/selectClientValue")
    @ResponseBody
    public Object selectClientValue(
            ClientValue clientValue,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw,
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "2") Integer length
    ){
        Map map = new HashMap();
        map.put("begin",start);
        map.put("end",length);
        map.put("value",clientValue);
        map.put("draw",draw);
        // 客户发展总记录数
        int countClientValue=clientValueService.countClientValue(map);
        map.put("countClientValue",countClientValue);
        Page<ClientValue> clientValuePage = clientValueService.selectClientValue(map);
        return clientValuePage;
    }
}
