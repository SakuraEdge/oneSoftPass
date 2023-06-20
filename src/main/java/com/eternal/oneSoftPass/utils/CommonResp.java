package com.eternal.oneSoftPass.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CommonResp<T> {

    /**
     * 响应码
     */
    @ApiModelProperty("响应码")
    private int code;

    /**
     *  响应信息
     */
    @ApiModelProperty("响应信息")
    private String msg;

    /**
     *  版本号
     */
    @ApiModelProperty("版本号")
    private String version = "V1.0";

    /**
     * 响应的结果信息（查询）
     */
    @ApiModelProperty("响应结果")
    private T result;

    private String token;

}
