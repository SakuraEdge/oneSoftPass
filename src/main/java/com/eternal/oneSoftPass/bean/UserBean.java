package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("osp_user")
public class UserBean {
    @TableId(value = "U_ID",type = IdType.AUTO)
    private String U_ID;
    private String NAME;
    private String TEL;
    private String EMAIL;
    private String PASSWORD;
    private String DESCRIPTION;
    private String LOGIN_TIME;
    private String exp;
    private String CREATE_TIME;
    private String STATE;
    private String LEVEL;
}
