package com.eternal.oneSoftPass.controller.user;

import com.eternal.oneSoftPass.service.change.IUnicodeService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChangeController {

    @Autowired
    IUnicodeService unicodeService;

    @PostMapping("/getUnicodeByKanji")
    public CommonResp<String> getUnicodeByKanji(@RequestBody Map<String,String> param){
        DataIsNull<String> isNull = new DataIsNull<>();
        return isNull.noIsNull(unicodeService.getUnicodeByKanji(param));
    }

    @PostMapping("/getKanjiByUnicode")
    public CommonResp<String> getKanjiByUnicode(@RequestBody Map<String,String> param){
        DataIsNull<String> isNull = new DataIsNull<>();
        return isNull.noIsNull(unicodeService.getKanjiByUnicode(param));
    }


}
