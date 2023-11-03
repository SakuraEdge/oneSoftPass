package com.eternal.oneSoftPass.dao.website;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.bean.WebSiteBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IWebSiteDAO extends BaseMapper<WebSiteBean> {
}
