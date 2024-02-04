package com.eternal.oneSoftPass.controller.log;

import com.eternal.oneSoftPass.bean.DataSourceBean;
import com.eternal.oneSoftPass.service.log.IUpdateLogService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class UpdateLogController {

    @Autowired
    private IUpdateLogService updateLogService;

    @PostMapping("/getUpdateLog")
    public CommonResp<List<Map<String,Object>>> getUpdateLog() throws ParseException {
        DataIsNull<Map<String,Object>> isNull = new DataIsNull<>();

        return isNull.listIsNull(updateLogService.getUpdateLog());
    }

}
