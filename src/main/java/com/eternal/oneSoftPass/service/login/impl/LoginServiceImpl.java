package com.eternal.oneSoftPass.service.login.impl;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.login.ILoginDAO;
import com.eternal.oneSoftPass.service.login.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    ILoginDAO loginDAO;

    @Override
    public UserBean getUserByLogin(Map<String, String> param) {
        String tel = param.get("tel");
        String pwd = param.get("password");
        return loginDAO.getUserByLogin(tel,pwd);
    }
}
