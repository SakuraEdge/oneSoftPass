package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bm_chat")
public class ChatBean {
    @TableId(value = "CHAT_ID",type = IdType.AUTO)
    private String CHAT_ID;
    private String CHAT_UID;
    private String CHAT_UNAME;
    private String CHAT_MSG;
    private String CHAT_TIME;
    private String STATE;

}
