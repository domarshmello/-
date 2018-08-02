package org.test.dao;

import org.springframework.stereotype.Repository;
import org.test.dto.picDTO;

import java.util.List;

/**
 * Created by apple on 2017/10/21.
 */
@Repository
public interface testUserdao {

    List<picDTO> queryDataCustom();
}
