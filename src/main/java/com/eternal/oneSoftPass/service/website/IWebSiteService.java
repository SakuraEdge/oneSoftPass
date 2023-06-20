package com.eternal.oneSoftPass.service.website;

import com.eternal.oneSoftPass.bean.WebSiteBean;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IWebSiteService {

    List<WebSiteBean> getWebSite();
}
