package com.crm.service.DataDictionary.impl;

import com.crm.dao.DataDictionary.DataDictionaryMapper;
import com.crm.entity.DataDictionary;
import com.crm.service.DataDictionary.DataDictionaryService;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryMapper mapper;
    @Override
    public List<DataDictionary> getDataDict(DataDictionary dataDictionary) {
        List<DataDictionary> dataDict = null;
        try {
            dataDict = mapper.getDataDict(dataDictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return dataDict;
        }
    }
}
