package com.eternal.oneSoftPass.service.website.impl;

import com.eternal.oneSoftPass.bean.WebSiteBean;
import com.eternal.oneSoftPass.dao.website.IWebSiteDAO;
import com.eternal.oneSoftPass.service.website.IWebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteServiceImpl implements IWebSiteService {

    @Autowired
    private IWebSiteDAO webSiteDAO;

    @Override
    public List<WebSiteBean> getWebSite() {
        return webSiteDAO.getWebSite();
    }
}
