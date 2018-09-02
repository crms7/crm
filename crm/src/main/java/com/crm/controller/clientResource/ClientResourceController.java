package com.crm.controller.clientResource;


import com.crm.entity.ClientResource;
import com.crm.entity.DataDictionary;
import com.crm.entity.EmployeeInfo;
import com.crm.service.clientResource.ClientResourceService;
import com.crm.service.dataDictionary.DataDictionaryService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
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

    /**
     * 添加客户
     * @param clientResource
     * @return
     */
    @RequestMapping(value = "/addClient")
    @ResponseBody
    public Object addClient(ClientResource clientResource, HttpSession session){
        EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
        clientResource.setCr_EntryPerson(emp.getE_Id());
        int i = clientResourceService.addClient(clientResource);
        return i;
    }

    /**
     * 获取单个客户
     * @param id
     * @return
     */
    @RequestMapping(value = "/getOneClient/{id}")
    public ModelAndView selectOne(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView();
        ClientResource clientResource =new ClientResource();
        clientResource.setCr_Id(id);
        Map map = new HashMap();
        map.put("begin",0);
        map.put("end",2);
        map.put("client",clientResource);
        List<ClientResource> clientResources = clientResourceService.selectClient(map);
        //获取下拉框的数据
        List<DataDictionary> dataDict = dataDictService.getDataDict(new DataDictionary());
        modelAndView.setViewName("upd-client");
        modelAndView.addObject("dataDict",dataDict);
        modelAndView.addObject("client",clientResources.get(0));
        return modelAndView;
    }

    /**
     * 修改客户信息
     * @param clientResource
     * @return
     */
    @RequestMapping(value = "/changeClient")
    @ResponseBody
    public Object changeClient(ClientResource clientResource,HttpSession session){
        EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
         // 最后操作时间
        clientResource.setCr_EnterTime(new Date());
        // 分配状态   默认为1（未分配）
        clientResource.setCr_AllotStatus(1L);
        //操作人
        clientResource.setCr_EntryPerson(emp.getE_Id());
        //执行修改
        int result= clientResourceService.changeClient(clientResource);
        return result;
    }
    /**
     * 自获取客户下一个编码
     * @return
     */
    @RequestMapping(value = "/getCode")
    @ResponseBody
    public Object getClientCode(){
        String clientCode = clientResourceService.selectMaxId();
        return clientCode;
    }
}
