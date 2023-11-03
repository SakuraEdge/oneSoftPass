package com.eternal.oneSoftPass.controller.exchange;

import com.eternal.oneSoftPass.bean.ExChangeBean;
import com.eternal.oneSoftPass.service.exchange.IExChangeService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExChangeController {

    @Autowired
    IExChangeService exChangeService;

    @PostMapping("/updateExChange")
    public void updateExchange(){
        exChangeService.updateExchange();
    }

    @PostMapping("/getRetInfo")
    public CommonResp<List<ExChangeBean>> getRetInfo(){
        DataIsNull<ExChangeBean> isNull = new DataIsNull<>();
        return isNull.listIsNull(exChangeService.getRetInfo());
    }

}
