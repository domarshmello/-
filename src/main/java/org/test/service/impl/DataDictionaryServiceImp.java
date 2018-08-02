package org.test.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.dao.DataDictionaryDao;
import org.test.dao.UserDao;
import org.test.dto.DataDictionaryItem;
import org.test.dto.UserDTO;
import org.test.service.DataDictionaryService;
import org.test.service.UserService;

import java.util.List;

@Service
public class DataDictionaryServiceImp implements DataDictionaryService {

    Logger logger = Logger.getLogger(DataDictionaryServiceImp.class);

    @Autowired
    DataDictionaryDao dataDictionaryDao;

    @Override
    public List<DataDictionaryItem> listItem(String typeName) {
        return dataDictionaryDao.listItem(typeName);
    }

    @Override
    public List<DataDictionaryItem> listSubItem(String typeName, String parentValue) {
        return dataDictionaryDao.listSubItem(typeName, parentValue);
    }
}






