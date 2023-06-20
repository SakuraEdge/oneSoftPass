package com.eternal.oneSoftPass.controller.website;

import com.eternal.oneSoftPass.bean.WebSiteBean;
import com.eternal.oneSoftPass.service.website.IWebSiteService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/website")
public class WebSiteController {

    @Autowired
    private IWebSiteService webSiteService;

    @RequestMapping("/getWebSite")
    public CommonResp<List<WebSiteBean>> getWebSite(Map<String,String> param){

        List<WebSiteBean> list = webSiteService.getWebSite();

        DataIsNull<WebSiteBean> isNull = new DataIsNull<>();
        return isNull.listIsNull(list);
    }

}
