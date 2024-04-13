package com.eternal.oneSoftPass.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eternal.oneSoftPass.bean.SignInfoBean;
import com.eternal.oneSoftPass.bean.UserBean;
import com.eternal.oneSoftPass.dao.user.ILoginDAO;
import com.eternal.oneSoftPass.dao.user.IUserDAO;
import com.eternal.oneSoftPass.service.user.IUserService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public List<UserBean> getUserList(Map<String, String> param) {
        QueryWrapper<UserBean> wrapper = new QueryWrapper<>();
        String name = param.get("name");
        if (name != null){
            wrapper.like("NAME",name);
        }
        return userDAO.selectList(wrapper);
    }

    @Override
    public Map<String,String> getUserNum() {
        Map<String,String> map = new HashMap<>();
        QueryWrapper<UserBean> wrapper = new QueryWrapper<>();
        Long allNum = userDAO.selectCount(wrapper);
        map.put("allNum",allNum.toString());
        // state = U
        wrapper.eq("STATE","U");
        Long num = userDAO.selectCount(wrapper);
        map.put("existNum",num.toString());
        wrapper.clear();
        // state != U
        wrapper.ne("STATE","U");
        num = userDAO.selectCount(wrapper);
        map.put("closeNum",num.toString());
        wrapper.clear();
        // normal
        wrapper.eq("LEVEL","1");
        num = userDAO.selectCount(wrapper);
        map.put("normalNum",num.toString());
        wrapper.clear();
        // VIP
        wrapper.eq("LEVEL","2");
        num = userDAO.selectCount(wrapper);
        map.put("VIPNum",num.toString());
        wrapper.clear();
        // SVIP
        wrapper.eq("LEVEL","3");
        num = userDAO.selectCount(wrapper);
        map.put("sVIPNum",num.toString());
        wrapper.clear();
        // TVIP
        wrapper.eq("LEVEL","4");
        num = userDAO.selectCount(wrapper);
        map.put("tVIPNum",num.toString());
        wrapper.clear();
        // admin
        wrapper.gt("LEVEL","4");
        num = userDAO.selectCount(wrapper);
        map.put("adminNum",num.toString());
        wrapper.clear();


        return map;
    }

    @Override
    public String getUserNameById(String id) {
        return userDAO.selectUserByID(id).getNAME();
    }

    @Override
    public void updatePerm(Map<String, String> param) {
        String id = param.get("id");
        String perm = param.get("perm");
        UserBean user = userDAO.selectUserByID(id);
        user.setU_ID(id);
        user.setLEVEL(perm);
        userDAO.updateById(user);
    }

}
