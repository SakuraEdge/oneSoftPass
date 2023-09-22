package com.eternal.oneSoftPass.service.datasource;

import java.sql.SQLException;


public interface IDataSourceService {

    String testConn(String url,String userName,String userPwd);
}
