package com.eternal.oneSoftPass.service.website;

import com.eternal.oneSoftPass.bean.WebSiteBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IWebSiteService {

    List<WebSiteBean> getWebSite();

    List<WebSiteBean> getWebSiteByName(Map<String, String> param);

    void delWeb(Map<String, String> param);

    void webSave(Map<String, String> param);

    void webUpdate(Map<String, String> param);
}
