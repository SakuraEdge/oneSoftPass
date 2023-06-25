package com.eternal.oneSoftPass.controller.user;

import com.eternal.oneSoftPass.service.user.IRegisterService;
import com.eternal.oneSoftPass.utils.CommonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {

    @Autowired
    IRegisterService registerService;

    @PostMapping("/register")
    public CommonResp<String> register(@RequestBody Map<String,String> param){
        CommonResp<String> resp = registerService.register(param);
        return resp;
    }
}
