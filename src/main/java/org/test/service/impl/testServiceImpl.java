package org.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.dao.testUserdao;
import org.test.dto.picDTO;
import org.test.service.testService;

import java.util.List;

/**
 * Created by apple on 2017/10/21.
 */
@Service
public class testServiceImpl implements testService {

    @Autowired
    testUserdao mTestUserDao;

    public List<picDTO> queryData() {
        System.out.println(mTestUserDao.queryDataCustom());
        return mTestUserDao.queryDataCustom();
    }
}
