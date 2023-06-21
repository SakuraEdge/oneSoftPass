package com.eternal.oneSoftPass.service.login;

import com.eternal.oneSoftPass.bean.UserBean;

import java.util.Map;

public interface ILoginService {

    UserBean getUserByLogin(Map<String,String> param);
}
