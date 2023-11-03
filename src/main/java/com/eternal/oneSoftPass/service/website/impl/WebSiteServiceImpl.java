package com.eternal.oneSoftPass.service.website.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eternal.oneSoftPass.bean.DataSourceBean;
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
        QueryWrapper<WebSiteBean> wrapper = new QueryWrapper<>();
        wrapper.eq("IS_OPEN","1");
        return webSiteDAO.selectList(wrapper);
    }
}
