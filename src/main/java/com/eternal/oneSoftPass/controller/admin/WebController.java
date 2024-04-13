package com.eternal.oneSoftPass.controller.admin;



import com.eternal.oneSoftPass.bean.WebSiteBean;
import com.eternal.oneSoftPass.service.website.IWebSiteService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WebController {

    @Autowired
    IWebSiteService service;

    @PostMapping("/getWebByName")
    public CommonResp<List<WebSiteBean>> getWebByName(@RequestBody Map<String,String> param) {
        DataIsNull<WebSiteBean> isNull = new DataIsNull<>();
        return isNull.listIsNull(service.getWebSiteByName(param));
    }

    @PostMapping("/delWeb")
    public void delWeb(@RequestBody Map<String,String> param) {
        service.delWeb(param);
    }

    @PostMapping("/webSave")
    public void webSave(@RequestBody Map<String,String> param) {
        service.webSave(param);
    }

    @PostMapping("/webUpdate")
    public void webUpdate(@RequestBody Map<String,String> param) {
        service.webUpdate(param);
    }

}
