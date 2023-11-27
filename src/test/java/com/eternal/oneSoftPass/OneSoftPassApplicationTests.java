package com.eternal.oneSoftPass;

import com.eternal.oneSoftPass.bean.BsParaBean;
import com.eternal.oneSoftPass.utils.BsParaDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OneSoftPassApplicationTests {

    @Test
    void contextLoads() {
        List<BsParaBean> bsParaDetails = BsParaDetail.getParaDetailValue("USER_LEVEL","");
        System.out.println(bsParaDetails);
    }

}
