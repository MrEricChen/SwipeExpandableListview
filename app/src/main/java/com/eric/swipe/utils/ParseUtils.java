package com.eric.swipe.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @Module :
 * @Comments : Gson反序列化解析工具类
 * @Author : eric.chen
 * @CreateDate : 2016-3-23
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-3-23
 * @Modified :
 */
public class ParseUtils {

    public static <T> T parseJson(String content, Type t) {
        if (content == null || content.equalsIgnoreCase("null")
                || content.equals("{}") || content.equals("[]")) {
            return null;
        }
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(
                    Date.class, new JsonDateDeserializer()).serializeNulls().create();
            return gson.fromJson(content, t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    static class JsonDateDeserializer implements JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement je, Type arg1,
                                JsonDeserializationContext arg2) throws JsonParseException {
            String s = je.getAsJsonPrimitive().getAsString();
            long l = Long.parseLong(s.substring(6, s.length() - 2));
            Date d = new Date(l);
            return d;
        }
    }

    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class,
                new JsonDateSerializer()).create();
        return gson.toJson(obj);
    }

    static class JsonDateSerializer implements JsonSerializer<Date> {

        @Override
        public JsonElement serialize(Date date, Type arg1,
                                     JsonSerializationContext arg2) {
            String res = "/Date(" + String.valueOf(date.getTime()) + ")/";
            return new JsonPrimitive(res);
        }

    }
}
