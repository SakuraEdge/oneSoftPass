package com.eternal.oneSoftPass;

import com.eternal.oneSoftPass.bean.BsParaBean;
import com.eternal.oneSoftPass.controller.log.UpdateLogController;
import com.eternal.oneSoftPass.service.log.IUpdateLogService;
import com.eternal.oneSoftPass.utils.BsParaDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OneSoftPassApplicationTests {

    @Autowired
    IUpdateLogService service;

    @Test
    void contextLoads() {
        System.out.println(service.getUpdateLog());
    }

}
