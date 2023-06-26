package com.eternal.oneSoftPass.controller.user;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.service.user.IUserService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/getUserInfo")
    public CommonResp<UserBean> getUserInfo(@RequestBody Map<String,String> param){
        DataIsNull<UserBean> isNull = new DataIsNull<>();
        return isNull.noIsNull(userService.getUserInfo(param));
    }
}
