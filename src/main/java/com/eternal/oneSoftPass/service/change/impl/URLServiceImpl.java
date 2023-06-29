package com.eternal.oneSoftPass.service.change.impl;

import com.eternal.oneSoftPass.service.change.IURLService;
import com.sun.deploy.net.URLEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Service
public class URLServiceImpl implements IURLService {

    @Override
    public String encodeURL(Map<String, String> param) throws UnsupportedEncodingException {
        String url = param.get("url");
        url = URLEncoder.encode(url,"utf-8");
        return url;
    }

    @Override
    public String decodeURL(Map<String, String> param) throws UnsupportedEncodingException {
        String url = param.get("url");
        url = URLDecoder.decode(url,"utf-8");
        return url;
    }
}
