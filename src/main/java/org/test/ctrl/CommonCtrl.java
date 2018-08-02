package org.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.dto.DataDictionaryItem;
import org.test.service.DataDictionaryService;

import java.util.List;

@Controller
public class CommonCtrl {
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @RequestMapping("/datadictionaries/items/{typeName}")
    @ResponseBody
    public ResponseEntity listDataDictionaryItem(@PathVariable("typeName") String typeId,
                                                 @RequestParam(name = "parentValue", required = false) String parentValue) {
        List<DataDictionaryItem> items;

        if (StringUtils.isEmpty(parentValue)) {
            items = dataDictionaryService.listItem(typeId);
        } else {
            items = dataDictionaryService.listSubItem(typeId, parentValue);
        }

        return ResponseEntity.ok(items);
    }
}

