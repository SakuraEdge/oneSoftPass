package com.eternal.oneSoftPass.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CommonResp<T> {
    @ApiModelProperty("响应码")
    private int code;

    @ApiModelProperty("响应信息")
    private String msg;

    @ApiModelProperty("版本号")
    private String version = "V1.0";

    @ApiModelProperty("响应结果")
    private T result;

    private String token;

}
