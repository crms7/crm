package com.crm.datadictionary;

import com.crm.entity.DataDictionary;
import com.crm.service.dataDictionary.DataDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/dataDict")
@Controller
public class DataDictionaryController {
    @Resource
    private DataDictionaryService dataDictService;
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
