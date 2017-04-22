package cn.jsonlu.bean;

import java.io.Serializable;

/**
 * Author:JsonLu
 * DateTime:17/4/7 13:42
 * Email:jsonlu@qq.com
 * Desc:
 */
public class BaseVo implements Serializable {

    private int code = 200;

    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
