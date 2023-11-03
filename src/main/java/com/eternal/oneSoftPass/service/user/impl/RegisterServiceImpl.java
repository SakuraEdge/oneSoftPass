package com.eternal.oneSoftPass.service.user.impl;

import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.user.IUserDAO;
import com.eternal.oneSoftPass.service.user.IRegisterService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    IUserDAO userDAO;


    @Override
    public CommonResp<String> register(Map<String, String> map) {
        String name = map.get("username");
        String tel = map.get("tel");
        String pwd = map.get("password");
        String email = map.get("email");
        CommonResp<String> resp = new CommonResp<>();

        pwd = MD5Utils.getPWD(pwd);

        String is_tel = userDAO.selectUIDByTEL(tel);
        String is_email = userDAO.selectUIDByEmail(email);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);

        if (is_tel != null){
            resp.setCode(301);
        }
        else if (is_email != null){
            resp.setCode(302);
        }
        else {
            UserBean bean = new UserBean();
            bean.setNAME(name);
            bean.setTEL(tel);
            bean.setPASSWORD(pwd);
            bean.setEMAIL(email);
            bean.setCREATE_TIME(time);
            userDAO.insert(bean);
            resp.setCode(200);
            resp.setMsg("注册成功");
        }
        return resp;
    }
}
