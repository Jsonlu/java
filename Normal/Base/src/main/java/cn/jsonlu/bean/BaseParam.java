package cn.jsonlu.bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * Author:JsonLu
 * DateTime:17/3/3 15:47
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class BaseParam implements Serializable {


    @Override
    public String toString() {
        String[] fields = getFieldsName();
        StringBuilder buffer = new StringBuilder();
        for (String field : fields) {
            Object value = invokeMethod(this, field);
            if (null != value && !"".equals(value.toString())) {
                buffer.append(field + "=" + value + "&");
            }
        }
        if (buffer.lastIndexOf("&") == (buffer.length() - 1)) {
            buffer.setLength(buffer.length() - 1);
        }
        return buffer.toString();
    }

    public Map toMap() {
        String[] fields = getFieldsName();
        HashMap map = new HashMap();
        for (String field : fields) {
            if ("sign_type".equals(field) || "sign".equals(field)) {
                continue;
            }
            Object value = invokeMethod(this, field);
            if (value == null || value.equals(""))
                continue;
            map.put(field, value);
        }
        return map;
    }

    private String[] getFieldsName() {
        Field[] superFields = getClass().getSuperclass().getDeclaredFields();
        Field[] fields = getClass().getDeclaredFields();
        String[] fieldsName = new String[superFields.length + fields.length];
        for (int i = 0; i < superFields.length; i++) {
            fieldsName[i] = superFields[i].getName();
        }
        for (int i = 0; i < fields.length; i++) {
            fieldsName[superFields.length + i] = fields[i].getName();
        }
        Arrays.sort(fieldsName);
        return fieldsName;
    }

    private Object invokeMethod(Object owner, String fieldName) {
        Class<? extends Object> ownerClass = owner.getClass();
        String methodName = fieldName.substring(0, 1).toUpperCase(Locale.getDefault()) + fieldName.substring(1);
        Method method = null;
        try {
            method = ownerClass.getMethod("get" + methodName);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e) {
            return "";
        }
        try {
            return method.invoke(owner);
        } catch (Exception e) {
            return "";
        }
    }

}
