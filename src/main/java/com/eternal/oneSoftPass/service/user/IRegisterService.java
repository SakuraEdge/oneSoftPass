package com.eternal.oneSoftPass.service.user;

import com.eternal.oneSoftPass.utils.CommonResp;

import java.util.Map;

public interface IRegisterService {

    CommonResp<String> register(Map<String,String> map);
}
