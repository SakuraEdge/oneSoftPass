package com.eternal.oneSoftPass.service.user.impl;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.user.IUserDAO;
import com.eternal.oneSoftPass.service.user.IUserService;
import com.eternal.oneSoftPass.utils.CommonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public UserBean getUserInfo(Map<String, String> param) {
        String id = param.get("id");
        UserBean bean = userDAO.selectUserByID(id);
        String tel = bean.getTEL();
        tel = tel.substring(0, 3) + "****" + tel.substring(7);
        bean.setTEL(tel);
        return bean;
    }
}
