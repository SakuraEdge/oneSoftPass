package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("osp_sign_info")
public class SignInfoBean {
    @TableId(value = "S_ID",type = IdType.AUTO)
    private String S_ID;
    private String U_ID;
    private String U_NAME;
    private String S_MSG;
    private String S_TIME;
    private String S_EXP;

}
