package com.eternal.oneSoftPass.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.BsParaBean;
import com.eternal.oneSoftPass.dao.utils.BsParaDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class BsParaDetail {
    @Autowired
    private BsParaDetailDAO dao;
    public static BsParaDetail bsParaDetail;

    @PostConstruct
    public void init(){
        bsParaDetail = this;
        bsParaDetail.dao = this.dao;
    }
    public static List<BsParaBean> getParaDetailValue(String paraType, String paraCode) {
        QueryWrapper<BsParaBean> wrapper = new QueryWrapper<>();
        if (!"".equals(paraType)){
            wrapper.eq("PARA_TYPE",paraType);
        }
        if (!"".equals(paraCode)){
            wrapper.eq("PARA_CODE",paraCode);
        }

        return bsParaDetail.dao.selectList(wrapper);

    }
}
