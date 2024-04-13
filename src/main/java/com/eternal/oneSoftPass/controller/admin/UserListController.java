package com.eternal.oneSoftPass.controller.admin;

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
public class UserListController {

    @Autowired
    IUserService userService;

    @PostMapping("/getUserList")
    public CommonResp<List<UserBean>> getUserList(@RequestBody Map<String,String> param){
        DataIsNull<UserBean> isNull = new DataIsNull<>();
        return isNull.listIsNull(userService.getUserList(param));
    }

    @PostMapping("/getUserNum")
    public CommonResp<Map<String,String>> getUserNum(){
        DataIsNull<Map<String,String>> isNull = new DataIsNull<>();
        return isNull.mapIsNull(userService.getUserNum());
    }

    @PostMapping("/updatePerm")
    public void updatePerm(@RequestBody Map<String,String> param){
        userService.updatePerm(param);
    }

}
