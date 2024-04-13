package com.eternal.oneSoftPass.service.website.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eternal.oneSoftPass.bean.DataSourceBean;
import com.eternal.oneSoftPass.bean.WebSiteBean;
import com.eternal.oneSoftPass.dao.website.IWebSiteDAO;
import com.eternal.oneSoftPass.service.website.IWebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<WebSiteBean> getWebSiteByName(Map<String, String> param) {
        QueryWrapper<WebSiteBean> wrapper = new QueryWrapper<>();
        wrapper.eq("IS_OPEN","1");
        wrapper.like("NAME",param.get("name"));
        return webSiteDAO.selectList(wrapper);
    }

    @Override
    public void delWeb(Map<String, String> param) {
        WebSiteBean bean = webSiteDAO.selectById(param.get("id"));
        bean.setIS_OPEN("0");
        webSiteDAO.updateById(bean);
    }

    @Override
    public void webSave(Map<String, String> param) {
        WebSiteBean bean = new WebSiteBean();
        bean.setNAME(param.get("name"));
        bean.setWEBSITE(param.get("website"));
        bean.setCOMMENT(param.get("desc"));
        webSiteDAO.insert(bean);
    }

    @Override
    public void webUpdate(Map<String, String> param) {
        WebSiteBean bean = webSiteDAO.selectById(param.get("id"));
        bean.setNAME(param.get("name"));
        bean.setWEBSITE(param.get("website"));
        bean.setCOMMENT(param.get("comment"));
        webSiteDAO.updateById(bean);
    }
}
