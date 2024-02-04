package com.eternal.oneSoftPass.service.log;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IUpdateLogService {

    List<Map<String, Object>> getUpdateLog() throws ParseException;
}
