package com.eternal.oneSoftPass.service.user;

import com.eternal.oneSoftPass.bean.SignInfoBean;
import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.utils.CommonResp;

import java.util.List;
import java.util.Map;

public interface IUserService {

    UserBean getUserInfo(Map<String,String> param);

    void updateDes(Map<String,String> param);

    CommonResp<String> updatePwd(Map<String, String> param);

    List<SignInfoBean> getSignInfo();

    List<UserBean> getUserList(Map<String,String> param);
}
