package org.test.dao;

import org.springframework.stereotype.Repository;
import org.test.dto.SubDTO;
import org.test.dto.UserDTO;

import java.util.List;

/**
 * the Dao of Subject
 * SubjectMapper文件声明的方法
 * Created by apple on 2017/11/16.
 */
// 首先使用 @Repository 将 DAO 类声明为 Bean  UserDao==UserMapper
@Repository
public interface SubDao {
    public List<SubDTO> list();

    public SubDTO findById(String subId);

    public int addSubject(SubDTO subject);

    public int updateSubject(SubDTO subject);

    public int deleteSubjectById(String subId);



}
