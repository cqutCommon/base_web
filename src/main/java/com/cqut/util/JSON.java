package com.cqut.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/12/8 15:04
 */
public class JSON {
    private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    private static ObjectMapper objectMapperWithDate = new ObjectMapper();
    static {
        objectMapperWithDate.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
    }
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String toJsonString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static String toJsonStringWithDate(Object o) {
        try {
            return objectMapperWithDate.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> T parse(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);// or :objectMapper.readValue(jsonString, new TypeReference<T>(){})
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
