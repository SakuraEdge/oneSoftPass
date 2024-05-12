package com.eternal.oneSoftPass.controller.chat;

import com.eternal.oneSoftPass.bean.ChatBean;
import com.eternal.oneSoftPass.service.chat.IChatService;
import com.eternal.oneSoftPass.service.user.IUserService;
import com.eternal.oneSoftPass.utils.CommonResp;
import com.eternal.oneSoftPass.utils.DataIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ChatController {

    @Autowired
    IChatService chatService;

    @Autowired
    IUserService userService;

    @PostMapping("/getChatList")
    public CommonResp<List<ChatBean>> getChatList(){
        DataIsNull<ChatBean> isNull = new DataIsNull<>();
        return isNull.listIsNull(chatService.getChatList());
    }

    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody Map<String,String> param){
        String id = param.get("id");
        String name = userService.getUserNameById(id);
        String msg = param.get("msg");
        chatService.sendMsg(id,name,msg);
    }

    @PostMapping("/delMsg")
    public void delMsg(){
        chatService.delMsg();
    }

}
