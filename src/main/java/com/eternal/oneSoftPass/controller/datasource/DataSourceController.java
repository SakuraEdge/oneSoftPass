package com.eternal.oneSoftPass.controller.datasource;

import com.eternal.oneSoftPass.service.datasource.IDataSourceService;
import com.eternal.oneSoftPass.service.datasource.impl.DataSourceServiceImpl;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class DataSourceController {
    @Autowired
    IDataSourceService dataSourceService;

    @PostMapping("/testConn")
    public CommonResp<String> testConn(@RequestBody Map<String,String> param) {
        String url = param.get("url");
        String userName = param.get("userName");
        String userPwd = param.get("userPwd");
        String isConn = dataSourceService.testConn(url,userName,userPwd);
        CommonResp<String> comm = new CommonResp<>();
        if ("true".equals(isConn)) {
            comm.setCode(200);
            comm.setResult(isConn);
        }
        else {
            comm.setCode(300);
            comm.setResult(isConn);
        }
        return comm;
    }
}
