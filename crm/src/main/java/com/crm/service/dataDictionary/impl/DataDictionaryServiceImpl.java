package com.crm.service.dataDictionary.impl;

import com.crm.dao.dataDictionary.DataDictionaryMapper;
import com.crm.entity.DataDictionary;
import com.crm.service.dataDictionary.DataDictionaryService;
import org.springframework.stereotype.Service;

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
