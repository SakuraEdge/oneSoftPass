package com.eternal.oneSoftPass.service.user.impl;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.user.ILoginDAO;
import com.eternal.oneSoftPass.service.user.ILoginService;
import com.eternal.oneSoftPass.utils.MD5Utils;
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
        pwd = MD5Utils.getPWD(pwd); //密码加密
        return loginDAO.getUserByLogin(tel,pwd);
    }

    @Override
    public UserBean getUserByCookie(Map<String, String> param) {
        String tel = param.get("tel");
        String pwd = param.get("password");
        return loginDAO.getUserByLogin(tel,pwd);
    }

}
