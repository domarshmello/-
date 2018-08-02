package org.test.service;

import org.springframework.stereotype.Service;
import org.test.dto.picDTO;

import java.util.List;

/**
 * Created by apple on 2017/10/21.
 */

public interface testService {
    /**
     * queryData
     *
     * @return
     */
    List<picDTO> queryData();
}
