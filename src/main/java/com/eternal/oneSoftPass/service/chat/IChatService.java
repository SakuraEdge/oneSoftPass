package com.eternal.oneSoftPass.service.chat;

import com.eternal.oneSoftPass.bean.ChatBean;

import java.util.List;

public interface IChatService {
    List<ChatBean> getChatList();

    void sendMsg(String id, String name, String msg);

    void delMsg();
}
