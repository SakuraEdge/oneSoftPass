package com.eternal.oneSoftPass.service.datasource.impl;

import com.eternal.oneSoftPass.service.datasource.IDataSourceService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Service
public class DataSourceServiceImpl implements IDataSourceService {

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

}
