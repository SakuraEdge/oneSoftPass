package com.eternal.oneSoftPass.controller.change;

import com.eternal.oneSoftPass.service.change.IBinaryService;
import com.eternal.oneSoftPass.service.change.IURLService;
import com.eternal.oneSoftPass.service.change.IUnicodeService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
public class ChangeController {

    @Autowired
    IUnicodeService unicodeService;

    @Autowired
    IURLService iurlService;

    @Autowired
    IBinaryService binaryService;

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

    @PostMapping("/getBinary")
    public CommonResp<Map<String,String>> getBinary(@RequestBody Map<String,String> param){
        DataIsNull<Map<String,String>> isNull = new DataIsNull<>();
        return isNull.mapIsNull(binaryService.getBinary(param));
    }

    @PostMapping("/encodeURL")
    public CommonResp<String> encodeURL(@RequestBody Map<String,String> param) throws UnsupportedEncodingException {
        DataIsNull<String> isNull = new DataIsNull<>();
        return isNull.noIsNull(iurlService.encodeURL(param));
    }

    @PostMapping("/decodeURL")
    public CommonResp<String> decodeURL(@RequestBody Map<String,String> param) throws UnsupportedEncodingException {
        DataIsNull<String> isNull = new DataIsNull<>();
        return isNull.noIsNull(iurlService.decodeURL(param));
    }


}
