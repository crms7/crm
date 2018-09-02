package com.crm.controller.clientprogress;

import com.crm.entity.ClientProgress;
import com.crm.entity.DataDictionary;
import com.crm.entity.EmployeeInfo;
import com.crm.service.clientResource.ClientResourceService;
import com.crm.service.clientprogress.ClientProgressService;
import com.crm.service.dataDictionary.DataDictionaryService;
import com.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/progress")
public class ClientProgressController {
    @Resource
    private ClientProgressService service;
    @Resource
    private ClientResourceService resourceService;
    @Resource
    private DataDictionaryService dataDictService; //字典表
    @RequestMapping("/clientProgressInfo")
    @ResponseBody
    public Object selectClientProgress(
            ClientProgress clientProgress,
            @RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw,
            @RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue = "2") Integer length
    ){
        Map map = new HashMap();
        map.put("begin",start);
        map.put("end",length);
        map.put("progress",clientProgress);
        map.put("draw",draw);
        // 客户发展总记录数
        int countClient=service.countClientProgress(map);
        map.put("countClient",countClient);
        Page<ClientProgress> clientProgressPage = service.selectProgress(map);
        return clientProgressPage;
    }

    /**
     * 删除计划信息
     * @param cp_Id
     * @return
     */
    @RequestMapping("/delProgress/{cp_Id}")
    @ResponseBody
    public Object delProgress(@PathVariable Integer cp_Id){
        int count = service.delProgress(cp_Id);
        return count;
    }

    /**
     * 添加计划信息
     * @param clientProgress
     * @param clientCode
     * @param session
     * @return
     */
    @RequestMapping(value = "/addProgress",method=RequestMethod.POST)
    @ResponseBody
    public Object addClientProgress(ClientProgress clientProgress, String clientCode, HttpSession session,String planCode){
        /*拼接计划编号*/
        clientProgress.setCp_PlanCode(clientProgress.getCp_PlanCode().toUpperCase()+planCode);
        //查询计划人id
        Long resultClientId=new Long(resourceService.selectClientId(clientCode));
        EmployeeInfo emp =(EmployeeInfo) session.getAttribute("emp");
        //计划人id
        clientProgress.setCp_NameId( resultClientId);
        clientProgress.setCp_PlanName(emp.getE_Name());
        //操作人
        clientProgress.setCp_OperationPerson(emp.getE_Id());
        int i = service.addProgress(clientProgress);
        return i;
    }

    /**
     * 以客户编码查询客户id
     * @param clientCode
     * @return
     */
    @RequestMapping(value = "/checkClient",method=RequestMethod.POST)
    @ResponseBody
    public Object checkClientName(@RequestParam(required = false,defaultValue = "",value = "clientCode") String clientCode){
        int resultClientId=resourceService.selectClientId(clientCode);
        HashMap map = new HashMap();
        if(resultClientId>0){
            //bootstrapValidator(验证器)需要返回的结果!
            map.put("valid",true);
        }else{
            map.put("valid",false);
        }
        return map;
    }

    /**
     * 修改客户计划
     * @param clientProgress
     * @return
     */
    @RequestMapping("/changeProgress")
    @ResponseBody
    public Object updClientProgress(ClientProgress clientProgress){
        int i = service.updProgress(clientProgress);
        return i;
    }
    /**
     * 修改时显示的值
     * @param cp_Id
     * @return
     */
    @RequestMapping("/selectOneInfo/{cp_Id}")
    public ModelAndView selectOneInfo(@PathVariable Long cp_Id){
        ClientProgress progress =new ClientProgress();
        progress.setCp_Id(cp_Id);
        //条件查出的数据
        ClientProgress clientProgress1 = service.progressInfo(progress);
        ModelAndView modelAndView =new ModelAndView();
        //字典表状态
        List<DataDictionary> dataDict = dataDictService.getDataDict(new DataDictionary());
        modelAndView.addObject("progress",clientProgress1);
        modelAndView.setViewName("upd-develop");
        modelAndView.addObject("dataDict",dataDict);
        return modelAndView;
    }
    /**
     * 自获取添加时的计划编号
     * @param spelling
     * @return
     */
    @RequestMapping("/getPlanCode/{name}")
    public ModelAndView getPlanCode(@PathVariable String name,String spelling){
        String planCode = service.getPlanCode(spelling);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("planCode",planCode);
        modelAndView.setViewName(name);
        return modelAndView;
    }
}
