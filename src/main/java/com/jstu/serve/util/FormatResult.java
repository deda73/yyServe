package com.jstu.serve.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * 统一返回格式
 * @author 呆居
 */
public class FormatResult {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;

    public static FormatResult build(Integer status, String msg, Object data) {
        return new FormatResult(status, msg, data);
    }

    public static FormatResult ok(Object data) {
        return new FormatResult(data);
    }

    public static FormatResult ok() {
        return new FormatResult((Object)null);
    }

    public FormatResult() {
    }

    public static FormatResult build(Integer status, String msg) {
        return new FormatResult(status, msg, (Object)null);
    }

    public FormatResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public FormatResult(Object data) {
        this.status = 200;
        this.msg = "操作成功";
        this.data = data;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static FormatResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return (FormatResult)MAPPER.readValue(jsonData, FormatResult.class);
            } else {
                JsonNode jsonNode = MAPPER.readTree(jsonData);
                JsonNode data = jsonNode.get("data");
                Object obj = null;
                if (clazz != null) {
                    if (data.isObject()) {
                        obj = MAPPER.readValue(data.traverse(), clazz);
                    } else if (data.isTextual()) {
                        obj = MAPPER.readValue(data.asText(), clazz);
                    }
                }

                return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
            }
        } catch (Exception var5) {
            return null;
        }
    }

    public static FormatResult format(String json) {
        try {
            return (FormatResult)MAPPER.readValue(json, FormatResult.class);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static FormatResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }

            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception var5) {
            return null;
        }
    }
}
