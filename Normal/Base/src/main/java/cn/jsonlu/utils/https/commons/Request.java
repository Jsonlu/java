package cn.jsonlu.utils.https.commons;

import java.util.Map;

/**
 * Author:JsonLu
 * DateTime:2017/6/27 下午7:00
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class Request {
    /**
     * The request parameter
     */
    public Map<String, String> paramMap;

    /**
     * The request URL
     */
    public String url;
    /**
     * The request method
     */
    public String method;
    /**
     * The request body
     */
    public String body;

    /**
     * The request time out
     */
    public int timeoutMs = Request.DEFAULT_TIMEOUT_MS;

    /**
     * The default timeout
     */
    public static final int DEFAULT_TIMEOUT_MS = 3000;
}
