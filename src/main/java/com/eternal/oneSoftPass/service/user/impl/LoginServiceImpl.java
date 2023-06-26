package com.eternal.oneSoftPass.service.user.impl;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.user.ILoginDAO;
import com.eternal.oneSoftPass.service.user.ILoginService;
import com.eternal.oneSoftPass.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        UserBean bean = loginDAO.getUserByLogin(tel,pwd);
        if (bean != null){
            String id = bean.getU_ID();
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(date);
            loginDAO.updateLoginTime(id,time);
        }
        return bean;
    }

    @Override
    public UserBean getUserByCookie(Map<String, String> param) {
        String id = param.get("id");
        String pwd = param.get("password");
        return loginDAO.getUserByCookie(id,pwd);
    }

}
