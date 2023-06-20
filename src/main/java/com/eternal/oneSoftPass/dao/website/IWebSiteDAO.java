package com.eternal.oneSoftPass.dao.website;

import com.eternal.oneSoftPass.bean.WebSiteBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IWebSiteDAO {
    @Select("select * from website_info;")
    List<WebSiteBean> getWebSite();
}
