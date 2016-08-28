package com.cqut.util;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/11/25 17:38
 */
public class StringUtil {
    final static Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

    public static String ISO2UTF8(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return str;
        }

        try {
            return new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("不支持的字符集错误", e);
            System.exit(-1);
            return null;
        }
    }

}
