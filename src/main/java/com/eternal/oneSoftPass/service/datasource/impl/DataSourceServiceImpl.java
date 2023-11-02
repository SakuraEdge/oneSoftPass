package com.eternal.oneSoftPass.service.datasource.impl;

import com.eternal.oneSoftPass.bean.DataSourceBean;
import com.eternal.oneSoftPass.dao.datasource.IDataSourceDAO;
import com.eternal.oneSoftPass.service.datasource.IDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class DataSourceServiceImpl implements IDataSourceService {

    @Autowired
    IDataSourceDAO dataSourceDAO;

    @Override
    public String testConn(String url, String userName, String userPwd){
        //属性对象
        Properties info = new Properties();
        info.setProperty("user",userName);
        info.setProperty("password",userPwd);
        try {
            Connection connection = DriverManager.getConnection(url, info);
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "true";
    }

    @Override
    public String sourceSave(Map<String,String> param) {
        String name = param.get("name");
        String uid = param.get("uid");
        String type = param.get("type");
        String ip = param.get("ip");
        String port = param.get("port");
        String table = param.get("table");
        String userName = param.get("userName");
        String userPwd = param.get("userPwd");
        String note = param.get("note");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);

        try {
            dataSourceDAO.sourceSave(name,uid,type,ip,port,table,userName,userPwd,time,note);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "true";
    }

    @Override
    public List<DataSourceBean> getSource(String id) {
        return dataSourceDAO.getSource(id);
    }

    @Override
    public String delSource(List<String> param) {
        try {
            for (String i:param){
                dataSourceDAO.delSource(i);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "true";
    }

}
