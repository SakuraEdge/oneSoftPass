package com.eternal.oneSoftPass.service.chat.impl;

import com.eternal.oneSoftPass.bean.ChatBean;
import com.eternal.oneSoftPass.dao.chat.IChatDAO;
import com.eternal.oneSoftPass.service.chat.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements IChatService {

    @Autowired
    IChatDAO chatDAO;


    @Override
    public List<ChatBean> getChatList() {
        return chatDAO.selectList(null);
    }

    @Override
    public void sendMsg(String id, String name, String msg) {
        ChatBean bean = new ChatBean();
        bean.setCHAT_UID(id);
        bean.setCHAT_UNAME(name);
        bean.setCHAT_MSG(msg);
        chatDAO.insert(bean);
    }

    @Override
    public void delMsg() {
        chatDAO.delete(null);
    }
}
