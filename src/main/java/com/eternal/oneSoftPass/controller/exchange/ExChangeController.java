package com.eternal.oneSoftPass.controller.exchange;

import com.eternal.oneSoftPass.service.exchange.IExChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExChangeController {

    @Autowired
    IExChangeService exChangeService;

    @PostMapping("/updateExChange")
    public void updateExchange(){
        exChangeService.updateExchange();
    }


}
