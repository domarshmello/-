package org.test.service;

import org.test.dto.SubDTO;
import org.test.dto.UserDTO;

import java.util.List;


public interface SubService {

    List<SubDTO> getSubjects();

    SubDTO findById(String subId);

    boolean updateSubject(SubDTO subject);
    boolean delete(String subId);

    public boolean addSubject(SubDTO subject);


}
