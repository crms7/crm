package com.crm.controller.ClientResource;


import com.crm.entity.ClientResource;
import com.crm.entity.DataDictionary;
import com.crm.service.ClientResource.ClientResourceService;
import com.crm.service.DataDictionary.DataDictionaryService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/client")
@Controller
public class ClientResourceController {
    @Resource
    private DataDictionaryService dataDictService;
    @Resource
    private ClientResourceService clientResourceService;
    /**
     * 返回客户信息
     * @param clientResource
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("/clientListInfo")
    @ResponseBody
    public Object selectClientInfo(
        ClientResource clientResource,
        @RequestParam(value = "draw", required = false, defaultValue = "0") String draw,
        @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
        @RequestParam(value = "length", required = false, defaultValue = "2") Integer length
    ){

        Map map = new HashMap();
        map.put("begin",start);
        map.put("end",length);
        map.put("client",clientResource);
        // 客户总记录数
        int countClient=clientResourceService.countClient(map);
        //客户信息列表
        List<ClientResource> clientResourcesList = clientResourceService.selectClient(map);
        Page<ClientResource> pages =new Page<ClientResource>();
        //datatables必要参数
        pages.setRecordsFiltered(countClient);
        //datatables必要参数
        pages.setRecordsTotal(countClient);
        //datatables必要参数 （客户信息数据）
        pages.setData(clientResourcesList);
        //datatables必要参数 （每页大小）
        pages.setLength(length);
        //datatables必要参数 （开始页）
        pages.setStart(start);
        //datatables必要参数 （绘制）
        pages.setDraw(Integer.parseInt(draw));
        return pages;
    }

    /**
     * 获取字典表数据（客户分配状态）
     * @param dataDictionary
     * @return
     */
    @RequestMapping("/getAllocaionState")
    @ResponseBody
    public Object getDataDict(DataDictionary dataDictionary){
        List<DataDictionary> dataDict = dataDictService.getDataDict(dataDictionary);
        return dataDict;
    }
}
