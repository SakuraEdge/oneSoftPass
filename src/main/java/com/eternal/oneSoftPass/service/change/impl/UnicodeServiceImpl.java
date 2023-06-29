package com.eternal.oneSoftPass.service.change.impl;

import com.eternal.oneSoftPass.service.change.IUnicodeService;
import com.eternal.oneSoftPass.utils.CommonResp;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UnicodeServiceImpl implements IUnicodeService {

    @Override
    public String getUnicodeByKanji(Map<String, String> param) {
        String kanji = param.get("kanji");
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < kanji.length(); i++) {
            // 取出每一个字符
            char c = kanji.charAt(i);
            // 转换为unicode
            String tmp = Integer.toHexString(c);
            if (tmp.length() >= 4) {
                unicode.append("\\u").append(Integer.toHexString(c));
            } else if (tmp.length() == 3){
                unicode.append("\\u0").append(Integer.toHexString(c));
            } else if (tmp.length() == 2){
                unicode.append("\\u00").append(Integer.toHexString(c));
            } else {
                unicode.append("\\u000").append(Integer.toHexString(c));
            }
        }
        return unicode.toString();
    }

    @Override
    public String getKanjiByUnicode(Map<String, String> param) {
        String unicode = param.get("unicode");
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicode);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            unicode = unicode.replace(matcher.group(1), ch + "");
        }
        return unicode;
    }
}