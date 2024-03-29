package com.eternal.oneSoftPass.service.datasource.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eternal.oneSoftPass.bean.DataSourceBean;
import com.eternal.oneSoftPass.dao.datasource.IDataSourceDAO;
import com.eternal.oneSoftPass.service.datasource.IDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public List<Map<String,Object>> getTables(String url, String userName, String userPwd, String table) throws SQLException {
        List<Map<String,Object>> list = new ArrayList<>();
        Properties info = new Properties();
        info.setProperty("user",userName);
        info.setProperty("password",userPwd);
        Connection conn = DriverManager.getConnection(url, info);
        ResultSet tables = conn.getMetaData().getTables(table,null,null,new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            ResultSet columns = conn.getMetaData().getColumns(null,null,tableName,"%");
            List<Map<String,String>> columnList = new ArrayList<>();
            while (columns.next()){
                String columnName = columns.getString("COLUMN_NAME");
                String typeName = columns.getString("TYPE_NAME");
                String remarks = columns.getString("REMARKS");
                Map<String,String> columnMap = new HashMap<>();
                columnMap.put("columnName",columnName);
                columnMap.put("typeName",typeName);
                columnMap.put("remarks",remarks);
                columnList.add(columnMap);
            }
            Map<String,Object> map = new HashMap<>();
            map.put("tableName",tableName);
            map.put("column",columnList);
            list.add(map);
        }
        return list;
    }

    @Override
    public String sourceSave(Map<String,String> param) {
        DataSourceBean bean = new DataSourceBean();
        bean.setU_ID(param.get("uid"));
        getParam(param, bean);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);

        bean.setCREATE_TIME(time);

        try {
            dataSourceDAO.insert(bean);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "true";
    }

    @Override
    public List<DataSourceBean> getSource(String id) {
        QueryWrapper<DataSourceBean> wrapper = new QueryWrapper<>();
        wrapper.eq("U_ID",id);
        wrapper.eq("STATE",'U');
        return dataSourceDAO.selectList(wrapper);
    }

    @Override
    public String delSource(List<String> param) {
        try {
            for (String i:param){
                DataSourceBean bean = dataSourceDAO.selectById(i);
                bean.setSTATE("E");
                dataSourceDAO.updateById(bean);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "true";
    }

    @Override
    public String updateSourceSave(Map<String, String> param) {
        String id = param.get("id");
        DataSourceBean bean = dataSourceDAO.selectById(id);
        getParam(param, bean);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);

        bean.setUPDATE_TIME(time);

        try {
            dataSourceDAO.updateById(bean);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "true";
    }

    private void getParam(Map<String, String> param, DataSourceBean bean) {
        bean.setNAME(param.get("name"));
        bean.setDATA_TYPE(param.get("type"));
        bean.setDATA_IP(param.get("ip"));
        bean.setDATA_PORT(param.get("port"));
        bean.setDATA_TABLE(param.get("table"));
        bean.setDATA_USERNAME(param.get("userName"));
        bean.setDATA_PASSWORD(param.get("userPwd"));
        bean.setNOTE(param.get("note"));
    }

}
