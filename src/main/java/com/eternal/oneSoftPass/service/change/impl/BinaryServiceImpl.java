package com.eternal.oneSoftPass.service.change.impl;

import com.eternal.oneSoftPass.service.change.IBinaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BinaryServiceImpl implements IBinaryService {

    @Override
    public Map<String, String> getBinary(Map<String, String> param) {
        String binary = param.get("binary");
        String num = String.valueOf(param.get("num"));
        Map<String,String> map = new HashMap<>();


        //先把n进制转换为10进制
        int temp = Integer.parseInt(num,Integer.parseInt(binary));

        //转换为各进制存储
        map.put("binary2",Integer.toString(temp,2));
        map.put("binary8",Integer.toString(temp,8));
        map.put("binary10",Integer.toString(temp,10));
        map.put("binary16",Integer.toString(temp,16));


        return map;
    }

}
