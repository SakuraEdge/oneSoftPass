package com.eternal.oneSoftPass.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("osp_exchange")
public class ExChangeBean {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    private String name;
    private String hui_in;
    private String hui_out;
    private String chao_in;
    private String chao_out;
    private String code;
    private String zhesuan;
    private String day;
    private String time;
}
