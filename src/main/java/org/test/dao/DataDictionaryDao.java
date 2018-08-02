package org.test.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.test.dto.DataDictionaryItem;

import java.util.List;

@Repository
public interface DataDictionaryDao {
    List<DataDictionaryItem> listItem(@Param("typeName") String typeId);

    List<DataDictionaryItem> listSubItem(@Param("typeName") String typeId, @Param("parentValue") String parentValue);
}
