package com.eternal.oneSoftPass.service.exchange.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eternal.oneSoftPass.dao.exchange.IExChangeDAO;
import com.eternal.oneSoftPass.service.exchange.IExChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeServiceImpl implements IExChangeService {

    @Autowired
    IExChangeDAO exChangeDAO;

    @Override
    public void updateExchange() {
        String appcode = "e7e04ff89e9f41e8a1a6324c03fe7d86";
        String apipost = HttpRequest.get("ali-waihui.showapi.com/waihui-list")
                .header("Authorization","APPCODE " + appcode)
                .execute().body();

        JSONObject jsonObject = JSON.parseObject(apipost);
        jsonObject = JSON.parseObject(jsonObject.get("showapi_res_body").toString());
        JSONArray list = jsonObject.getJSONArray("list");


        for (int i = 0;i<list.size();i++){
            Map<String,String> map = (Map<String, String>) JSON.parse(list.get(i).toString());
            String name = map.get("name");
            String hui_in = map.get("hui_in");
            String hui_out = map.get("hui_out");
            String chao_in = map.get("chao_in");
            String chao_out = map.get("chao_out");
            String code = map.get("code");
            String zhesuan = map.get("zhesuan");
            String day = map.get("day");
            String time = map.get("time");
            exChangeDAO.UpdateExChange(i,name,hui_in,hui_out,chao_in,chao_out,code,zhesuan,day,time);
        }
        System.out.println("更新汇率成功");
    }
}
