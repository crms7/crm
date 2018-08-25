package com.crm.service.DataDictionary;

import com.crm.entity.DataDictionary;

import java.util.List;

/**
 * 查询字典表
 */
public interface DataDictionaryService {
    List<DataDictionary> getDataDict(DataDictionary dataDictionary);
}
