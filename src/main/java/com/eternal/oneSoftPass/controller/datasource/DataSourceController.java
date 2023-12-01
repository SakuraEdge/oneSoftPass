package com.eternal.oneSoftPass.controller.datasource;

import com.eternal.oneSoftPass.bean.DataSourceBean;
import com.eternal.oneSoftPass.service.datasource.IDataSourceService;
import com.eternal.oneSoftPass.service.datasource.impl.DataSourceServiceImpl;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
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
        return getStringCommonResp(isConn);
    }

    @PostMapping("/sourceSave")
    public CommonResp<String> sourceSave(@RequestBody Map<String,String> param) {
        String isSave = dataSourceService.sourceSave(param);
        return getStringCommonResp(isSave);
    }

    @PostMapping("/updateSourceSave")
    public CommonResp<String> updateSourceSave(@RequestBody Map<String,String> param) {
        String isSave = dataSourceService.updateSourceSave(param);
        return getStringCommonResp(isSave);
    }


    @PostMapping("/getSource")
    public CommonResp<List<DataSourceBean>> getSource(@RequestBody Map<String,String> param) {
        CommonResp<List<DataSourceBean>> comm = new CommonResp<>();
        DataIsNull<DataSourceBean> isNull = new DataIsNull<>();
        String id = param.get("id");
        List<DataSourceBean> bean = dataSourceService.getSource(id);
        return isNull.listIsNull(bean);
    }

    @PostMapping("/delSource")
    public CommonResp<String> delSource(@RequestBody Map<String,List<String>> param){
        List<String> list = param.get("sourceList");
        String isDel = dataSourceService.delSource(list);
        return getStringCommonResp(isDel);
    }

    @PostMapping("/getTables")
    public CommonResp<List<String>> getTables(@RequestBody Map<String,String> param) throws SQLException {
        DataIsNull<String> isNull = new DataIsNull<>();
        String url = param.get("url");
        String userName = param.get("userName");
        String userPwd = param.get("userPwd");
        String table = param.get("table");
        return isNull.listIsNull(dataSourceService.getTables(url,userName,userPwd,table));
    }

    private CommonResp<String> getStringCommonResp(String isSave) {
        CommonResp<String> comm = new CommonResp<>();
        if ("true".equals(isSave)) {
            comm.setCode(200);
            comm.setResult(isSave);
        }
        else {
            comm.setCode(300);
            comm.setResult(isSave);
        }
        return comm;
    }
}
