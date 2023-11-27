package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bs_para_detail")
public class BsParaBean {
    private String PARA_TYPE;
    private String PARA_CODE;
    private String PARA_NAME;
    private String PARA1;
    private String PARA2;
    private String PARA3;
    private String PARA4;
    private String PARA5;
    private String PARA_DESC;
    private String STATE;
    private String CREATE_TIME;
    private String UPDATE_TIME;
    private String REMARKS;
}
