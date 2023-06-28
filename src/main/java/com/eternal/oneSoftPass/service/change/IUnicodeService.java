package com.eternal.oneSoftPass.service.change;

import com.eternal.oneSoftPass.utils.CommonResp;

import java.util.Map;

public interface IUnicodeService {

    String getUnicodeByKanji(Map<String,String> param);

    String getKanjiByUnicode(Map<String,String> param);
}
