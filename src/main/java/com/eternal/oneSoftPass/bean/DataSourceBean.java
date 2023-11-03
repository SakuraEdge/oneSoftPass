package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("osp_datasource_save")
public class DataSourceBean {

    @TableId(value = "ID",type = IdType.AUTO)
    private String ID;
    private String NAME;
    private String U_ID;
    private String DATA_TYPE;
    private String DATA_IP;
    private String DATA_PORT;
    private String DATA_TABLE;
    private String DATA_USERNAME;
    private String DATA_PASSWORD;
    private String STATE;
    private String CREATE_TIME;
    private String UPDATE_TIME;
    private String NOTE;

}
