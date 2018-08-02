package org.test.service;


import org.test.dto.UserDTO;

import java.util.List;


/**
 * Author:YoYo_D
 * Created by apple on 2017/10/25.
 * 针对接口编程 调用mapper
 */

public interface UserService {
    // 通过用户名及密码核查用户登录
    public UserDTO login(String username, String password);

    public UserDTO QueryById(String userId);

    public List<UserDTO> getAllStudents();

    /**
     * 添加学生
     */
    public boolean addStudent(UserDTO student);

    public boolean updateStudent(UserDTO student);

    public boolean delete(String userId);

    public List<UserDTO> getAllTeachers();

    public boolean addTeacher(UserDTO teacher);

    public boolean register(UserDTO user, String user_id);



}


