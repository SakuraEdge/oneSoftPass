package com.eternal.oneSoftPass.task;


import com.eternal.oneSoftPass.controller.exchange.ExChangeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ExChangeTask {

    @Autowired
    ExChangeController controller;

    @Scheduled(cron = "0 0 8,15 * * ?")
    public void exChange(){
        controller.updateExchange();
    }
}
