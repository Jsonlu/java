package cn.jsonlu.utils.https.commons;

import java.util.List;
import java.util.Map;

/**
 * Author:JsonLu
 * DateTime:2017/6/27 下午7:03
 * Email:jsonlu@qq.com
 * Desc:
 **/
public interface IHttpAdapter {
    /**
     * http request method
     *
     * @param request  assemble request
     * @param listener http response notify
     */
    void sendRequest(Request request, OnHttpListener listener);

    interface OnHttpListener {

        /**
         * start request
         * main thread
         */
        void onHttpStart();

        /**
         * headers received
         * sub thread
         */
        void onHeadersReceived(int statusCode, Map<String, List<String>> headers);


        /**
         * http response finish
         * main thread
         *
         * @param response
         */
        void onHttpFinish(Response response);
    }
}
