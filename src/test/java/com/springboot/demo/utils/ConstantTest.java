package com.springboot.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class ConstantTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getUser() {
        return "{\n" +
                "    \"first_name\": \"Ajay\",\n" +
                "    \"last_name\" : \"Mishra\",\n" +
                "    \"address\" : \"Mumbai\",\n" +
                "    \"email\" : \"zyxgmail.com\",\n" +
                "    \"mobile_number\":\"7654321897\",\n" +
                "    \"contact_number\":\"7654321897\"\n" +
                "}";
    }

    public static <T> T convertStringToObject(Class<T> t, String json) throws JsonProcessingException {
        return objectMapper.readValue(json, t);
    }

    public static String convertObjectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
