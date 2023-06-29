package com.eternal.oneSoftPass.service.change;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface IURLService {

    String encodeURL(Map<String,String> param) throws UnsupportedEncodingException;

    String decodeURL(Map<String,String> param) throws UnsupportedEncodingException;
}
