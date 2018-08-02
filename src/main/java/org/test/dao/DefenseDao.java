package org.test.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.test.dto.ClassDTO;
import org.test.dto.DefenseDTO;

import java.util.List;

/**
 * Created by apple on 2017/12/7.
 */
@Repository
public interface DefenseDao {
    List<DefenseDTO> list();

    DefenseDTO findById(Integer id);

    void addDefense(@Param("defense") DefenseDTO defense);

    void inputDefenseScore(@Param("defense") DefenseDTO defense);

    List<ClassDTO> listClass();

}
