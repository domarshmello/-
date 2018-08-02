package org.test.service;

import org.apache.ibatis.annotations.Param;
import org.test.dto.ClassDTO;
import org.test.dto.DefenseDTO;

import java.util.List;


public interface DefenseService {

    List<DefenseDTO> list();

    DefenseDTO findById(Integer id);

    void addDefense(DefenseDTO defense);

    void inputDefenseScore(DefenseDTO defense);
}
