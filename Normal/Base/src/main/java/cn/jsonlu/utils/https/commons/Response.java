package cn.jsonlu.utils.https.commons;

import java.util.Map;

/**
 * Author:JsonLu
 * DateTime:2017/6/27 下午7:02
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class Response {
    /**
     * Status code
     */
    public String statusCode;

    /**
     * Byte stream fetched from the connection
     */
    public String data;

    public byte[] originalData;

    /**
     * Server internal error
     */
    public String errorCode;

    /**
     * Server error message
     */
    public String errorMsg;

    /**
     * Message for toast
     */
    public String toastMsg;

    /**
     * Parameter for further extension.
     */
    public Map<String, Object> extendParams;
}
