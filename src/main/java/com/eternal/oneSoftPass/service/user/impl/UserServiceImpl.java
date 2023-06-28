package com.eternal.oneSoftPass.service.user.impl;

import com.eternal.oneSoftPass.bean.SignInfoBean;
import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.user.ILoginDAO;
import com.eternal.oneSoftPass.dao.user.IUserDAO;
import com.eternal.oneSoftPass.service.user.IUserService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    ILoginDAO loginDAO;

    @Override
    public UserBean getUserInfo(Map<String, String> param) {
        String id = param.get("id");
        UserBean bean = userDAO.selectUserByID(id);
        String tel = bean.getTEL();
        tel = tel.substring(0, 3) + "****" + tel.substring(7);
        bean.setTEL(tel);
        return bean;
    }

    @Override
    public void updateDes(Map<String, String> param) {
        String id = param.get("id");
        String description = param.get("description");
        userDAO.updateDes(id,description);
    }

    @Override
    public CommonResp<String> updatePwd(Map<String, String> param) {
        String id = param.get("id");
        String pwd = MD5Utils.getPWD(param.get("pwd"));
        String newPwd = MD5Utils.getPWD(param.get("newPwd"));

        CommonResp<String> resp = new CommonResp<>();
        UserBean bean = loginDAO.getUserByCookie(id,pwd);
        if (bean == null){
            resp.setCode(300);
        }
        else{
            userDAO.updatePwd(id,newPwd);
        }

        return resp;
    }

    @Override
    public List<SignInfoBean> getSignInfo() {
        return userDAO.getSignInfo();
    }
}
