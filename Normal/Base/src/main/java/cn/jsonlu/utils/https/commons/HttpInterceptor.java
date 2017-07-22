package cn.jsonlu.utils.https.commons;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Author:JsonLu
 * DateTime:17/2/16 23:01
 * Email:jsonlu@qq.com
 * Desc:Http拦截器&&网路路由调度
 **/
public class HttpInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .build();
        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        System.out.println("网络日志" + String.format("Request header=%s Received response for %s in %.1fms%n%s", new Object[]{request.headers(), response.request().url(), Double.valueOf((double) (t2 - t1) / 1000000.0D), response.headers()}));
        return response;
    }

}
