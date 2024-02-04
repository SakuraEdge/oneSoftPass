package com.eternal.oneSoftPass.service.log.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eternal.oneSoftPass.bean.UpdateLogBean;
import com.eternal.oneSoftPass.dao.log.IUpdateLogDAO;
import com.eternal.oneSoftPass.service.log.IUpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UpdateLogServiceImpl implements IUpdateLogService {

    @Autowired
    IUpdateLogDAO updateLogDAO;


    @Override
    public List<Map<String, Object>> getUpdateLog() throws ParseException {
        QueryWrapper<UpdateLogBean> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("TIME");
        List<UpdateLogBean> list = updateLogDAO.selectList(wrapper);
        List<Map<String, Object>> log = new ArrayList<>();
        for (UpdateLogBean bean : list) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",bean.getID());
            map.put("version",bean.getVERSION());
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            map.put("time",dateFormat.format(inputFormat.parse(bean.getTIME())));
            List<String> msg = Arrays.asList(bean.getMESSAGE().split(";"));
            map.put("msg",msg);
            log.add(map);
        }
        return log;
    }
}
