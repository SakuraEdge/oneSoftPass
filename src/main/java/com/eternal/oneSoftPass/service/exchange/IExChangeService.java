package com.eternal.oneSoftPass.service.exchange;

import com.eternal.oneSoftPass.bean.RetBean;

import java.util.ArrayList;

public interface IExChangeService {
    void updateExchange();

    ArrayList<RetBean> getRetInfo();
}
