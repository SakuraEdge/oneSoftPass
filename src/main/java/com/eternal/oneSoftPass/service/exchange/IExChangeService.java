package com.eternal.oneSoftPass.service.exchange;

import com.eternal.oneSoftPass.bean.ExChangeBean;

import java.util.List;

public interface IExChangeService {
    void updateExchange();

    List<ExChangeBean> getRetInfo();
}
