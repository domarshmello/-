package org.test.service.impl;

import org.springframework.stereotype.Service;
import org.test.dao.DefenseDao;
import org.test.dto.ClassDTO;
import org.test.dto.DefenseDTO;
import org.test.service.ClassService;
import org.test.service.DefenseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户端：display subject list and query subject by id
 * Created by apple on 2017/11/16.
 */
@Service
public class DefenseServiceImp implements DefenseService {
    @Resource
    DefenseDao defenseDao;

    public List<DefenseDTO> list() {
        return defenseDao.list();
    }

    public DefenseDTO findById(Integer id) {
        return defenseDao.findById(id);
    }

    public void addDefense(DefenseDTO defense) {
        defenseDao.addDefense(defense);
    }

    public void inputDefenseScore(DefenseDTO defense) {
        defenseDao.inputDefenseScore(defense);
    }
}
