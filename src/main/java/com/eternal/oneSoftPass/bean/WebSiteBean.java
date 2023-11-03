package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("website_info")
public class WebSiteBean{
    @TableId(value = "W_ID",type = IdType.AUTO)
    private String W_ID;
    private String NAME;
    private String WEBSITE;
    private String COMMENT;
    private String IS_OPEN;
    private String U_ID;

}
