package com.eternal.oneSoftPass.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("osp_update_log")
public class UpdateLogBean {
    private String ID;
    private String VERSION;
    private String TIME;
    private String MESSAGE;
}
