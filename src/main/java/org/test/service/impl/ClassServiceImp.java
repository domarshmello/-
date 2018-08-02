package org.test.service.impl;

import org.springframework.stereotype.Service;
import org.test.dao.DefenseDao;
import org.test.dao.SubDao;
import org.test.dto.ClassDTO;
import org.test.dto.SubDTO;
import org.test.service.ClassService;
import org.test.service.SubService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户端：display subject list and query subject by id
 * Created by apple on 2017/11/16.
 */
@Service
public class ClassServiceImp implements ClassService {
    @Resource
    DefenseDao defenseDao;

    public List<ClassDTO> list() {
        return defenseDao.listClass();
    }

}
