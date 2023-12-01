package com.eternal.oneSoftPass.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Json {
    private String space = "   ";
    private boolean existLeft = false;

    //格式化json
    public String formatJson(String json){
        StringBuffer result = new StringBuffer();
        int length = json.length();
        int number = 0;
        char key = 0;
        for (int i = 0; i < length; i++){
            key = json.charAt(i);

            if (isEffectSpecChr(i,key,json)){
                if((key == '[') || (key == '{') ){
                    result.append(key);
                    result.append('\n');
                    number++;
                    result.append(indent(number));
                    continue;
                }

                if((key == ']') || (key == '}') ){
                    result.append('\n');
                    number--;
                    result.append(indent(number));
                    result.append(key);
                    continue;
                }

                if((key == ',')){
                    result.append(key);
                    result.append('\n');
                    result.append(indent(number));
                    continue;
                }
            }
            result.append(key);
        }
        return result.toString();
    }

    public String zipJson(String json){
        JSONObject ob = JSON.parseObject(json);
        String zipJson = ob.toJSONString().replaceAll("\\s+","");
        zipJson = zipJson.replaceAll("//.*|/\\*(.|[\\r\\n])*?\\*/","");
        return zipJson;
    }

    //过滤有效的特殊字符
    private boolean isEffectSpecChr(int index, char key, String json) {
        boolean flag = false;

        if (isDouMark(index,String.valueOf(key),json)){
            if (existLeft){
                existLeft = false;
            }else {
                existLeft = true;
            }
        }else {
            if ((key == '[')
                    || (key == '{')
                    || (key == ']')
                    || (key == '}')
                    || (key == ',')){
                if (!existLeft){
                    flag = true;
                }
            }
        }
        return flag;
    }

    //判断当前双引号是否为特殊字符
    private boolean isDouMark(int index, String key, String json) {
        if (key.equals("\"") && index >= 0){
            if (index == 0){
                return true;
            }

            char c = json.charAt(index - 1);
            if (c != '\\'){
                return true;
            }
        }
        return false;
    }

    //补充tab空格
    private String indent(int number){
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++){
            result.append(space);
        }
        return result.toString();
    }
}
