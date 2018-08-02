package org.test.service;

import org.test.dto.DataDictionaryItem;

import java.util.List;

public interface DataDictionaryService {

    List<DataDictionaryItem> listItem(String typeName);

    List<DataDictionaryItem> listSubItem(String typeName, String parentValue);
}