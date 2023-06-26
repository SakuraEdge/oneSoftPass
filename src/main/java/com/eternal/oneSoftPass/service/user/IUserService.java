package com.eternal.oneSoftPass.service.user;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.utils.CommonResp;

import java.util.Map;

public interface IUserService {

    UserBean getUserInfo(Map<String,String> param);
}
