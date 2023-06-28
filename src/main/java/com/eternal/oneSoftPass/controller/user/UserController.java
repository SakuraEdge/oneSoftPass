package com.eternal.oneSoftPass.controller.user;

import com.eternal.oneSoftPass.bean.SignInfoBean;
import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.service.user.IUserService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @PostMapping("/updateDes")
    public void updateDes(@RequestBody Map<String,String> param){
        userService.updateDes(param);
    }

    @PostMapping("/updatePwd")
    public CommonResp<String> updatePwd(@RequestBody Map<String,String> param){
        return userService.updatePwd(param);
    }

    @PostMapping("/getSignInfo")
    public CommonResp<List<SignInfoBean>> getSignInfo(){
        DataIsNull<SignInfoBean> isNull = new DataIsNull<>();
        return isNull.listIsNull(userService.getSignInfo());
    }

}
