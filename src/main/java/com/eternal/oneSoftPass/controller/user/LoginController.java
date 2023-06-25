package com.eternal.oneSoftPass.controller.user;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.service.user.ILoginService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    ILoginService loginService;

    @PostMapping ("/login")
    public CommonResp<UserBean> login(@RequestBody Map<String,String> param){
        UserBean bean = loginService.getUserByLogin(param);
        DataIsNull<UserBean> isNull = new DataIsNull<>();
        return isNull.noIsNull(bean);
    }

    @PostMapping ("/loginByCookie")
    public CommonResp<UserBean> loginByCookie(@RequestBody Map<String,String> param){
        UserBean bean = loginService.getUserByCookie(param);
        DataIsNull<UserBean> isNull = new DataIsNull<>();
        return isNull.noIsNull(bean);
    }
}
