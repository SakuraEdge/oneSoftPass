package com.eternal.oneSoftPass.service.datasource;

import com.eternal.oneSoftPass.bean.DataSourceBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IDataSourceService {

    String testConn(String url,String userName,String userPwd);

    String sourceSave(Map<String,String> param);

    List<DataSourceBean> getSource(String id);

    String delSource(List<String> param);

    String updateSourceSave(Map<String, String> param);
}
