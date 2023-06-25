package com.eternal.oneSoftPass.service.user;

import com.eternal.oneSoftPass.bean.UserBean;

import java.util.Map;

public interface ILoginService {

    UserBean getUserByLogin(Map<String,String> param);

    UserBean getUserByCookie(Map<String,String> param);
}
