package com.zhouyn.demo.redisserver.annotation;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    protected JsonUtils() {
    }

    public static String objectToJson(Object object) {
        String ret = null;
        if (object != null) {
            try {
                ret = getObjectMapper().writeValueAsString(object);
            } catch (JsonProcessingException var3) {
                LOGGER.error("Object to json failed!", var3);
            }
        }

        return ret;
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) {
        T ret = null;
        if (!Strings.isNullOrEmpty(json) && clazz != null) {
            try {
                ret = getObjectMapper().readValue(json, clazz);
            } catch (IOException var4) {
                LOGGER.error("Json {} to {} failed!", new Object[]{json, clazz.getName(), var4});
            }
        }

        return ret;
    }

    public static <T> T jsonToObject(String json, TypeReference<?> typeReference) {
        T ret = null;
        if (!Strings.isNullOrEmpty(json)) {
            try {
                ret = getObjectMapper().readValue(json, typeReference);
            } catch (IOException var4) {
                LOGGER.error("Json {} to object failed!", json, var4);
            }
        }

        return ret;
    }

    public static <T> T jsonToObject(String json, Class<?> collectionClass, Class<?>... elementClasses) {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        } else {
            try {
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
                return objectMapper.readValue(json, javaType);
            } catch (Exception var4) {
                LOGGER.error("Json {} to object failed!", json, var4);
                return null;
            }
        }
    }

    public static <T> boolean canDeserialize(String json, Class<T> clazz) {
        boolean flag = true;

        try {
            (new ObjectMapper()).readValue(json, clazz);
        } catch (IOException var4) {
            flag = false;
        }

        return flag;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        JsonUtils.objectMapper = objectMapper;
    }

    static {
        getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        getObjectMapper().setSerializationInclusion(Include.NON_NULL);
    }
}
