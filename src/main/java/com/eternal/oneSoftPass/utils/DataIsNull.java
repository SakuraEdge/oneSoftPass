package com.eternal.oneSoftPass.utils;

import java.util.List;
import java.util.Map;

/**
 * 工具类，用于判断查询的值是否为空值
 * 根据是否空值返回对应的code和msg
 */
public class DataIsNull<T> {

    /**
     * 查询列表类型是否为空值
     * 非列表类型使用noIsNull方法
     */
    public CommonResp<List<T>> listIsNull(List<T> list) {
        CommonResp<List<T>> commonResp = new CommonResp<>();
        commonResp.setResult(list);
        if (list == null || list.isEmpty()){
            commonResp.setCode(300);
            commonResp.setResult(null);
            commonResp.setMsg("没有数据");
        }
        else {
            commonResp.setCode(200);
            commonResp.setMsg("成功");
        }
        return commonResp;
    }

    /**
     * 查询非列表类型是否为空值
     * 列表类型使用listIsNull方法
     */
    public CommonResp<T> noIsNull(T data){
        CommonResp<T> commonResp = new CommonResp<>();
        commonResp.setResult(data);
        if (data == null || data == ""){
            commonResp.setCode(300);
            commonResp.setResult(null);
            commonResp.setMsg("没有数据");
        }
        else {
            commonResp.setCode(200);
            commonResp.setMsg("成功");
        }
        return commonResp;
    }

    public CommonResp<Map<String,String>> mapIsNull(Map<String,String> data){
        CommonResp<Map<String,String>> commonResp = new CommonResp<>();
        commonResp.setResult(data);
        if (data.size() == 0){
            commonResp.setCode(300);
            commonResp.setResult(null);
            commonResp.setMsg("没有数据");
        }
        else {
            commonResp.setCode(200);
            commonResp.setMsg("成功");
        }
        return commonResp;
    }


}
