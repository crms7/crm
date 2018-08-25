package com.crm.dao.DataDictionary;

import com.crm.entity.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {
    /**
     * 查询字典表数据
     * @param dataDictionary
     * @return
     * @throws Exception
     */
    List<DataDictionary> getDataDict(DataDictionary dataDictionary) throws Exception;
}
