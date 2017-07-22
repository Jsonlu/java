package cn.jsonlu.utils.https;


import cn.jsonlu.utils.https.commons.HttpInterceptor;
import cn.jsonlu.utils.https.commons.IHttpAdapter;
import cn.jsonlu.utils.https.commons.Request;
import cn.jsonlu.utils.https.commons.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author:JsonLu
 * DateTime:17/6/25 15:58
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class HttpAdapter implements IHttpAdapter {


    private ExecutorService mExecutorService;

    private final OkHttpClient client = new OkHttpClient
            .Builder()
            .addInterceptor(new HttpInterceptor())
            .connectTimeout(2, TimeUnit.SECONDS)
            .build();

    private final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    private okhttp3.Response getReq(Request req) throws IOException {
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(req.url)
                .method(req.method != null ? req.method : "GET", req.body != null ? RequestBody.create(mediaType, req.body) : null)
                .build();
        okhttp3.Response response = client.newCall(request).execute();
        return response;
    }

    private void execute(Runnable runnable) {
        if (mExecutorService == null) {
            mExecutorService = Executors.newFixedThreadPool(8);
        }
        mExecutorService.submit(runnable);
    }


    @Override
    public void sendRequest(final Request request, final OnHttpListener listener) {
        if (listener != null) {
            listener.onHttpStart();
        }
        execute(new Runnable() {
            @Override
            public void run() {
                final Response response = new Response();
                try {
                    okhttp3.Response resData = getReq(request);
                    Map<String, List<String>> headers = resData.headers().toMultimap();
                    int responseCode = resData.code();
                    if (listener != null) {
                        listener.onHeadersReceived(responseCode, headers);
                    }
                    response.statusCode = String.valueOf(responseCode);
                    String body = resData.body().string();
                    if (responseCode >= 200 && responseCode <= 299) {
                        response.data = body;
                    } else {
                        response.errorMsg = body;
                    }
                } catch (IOException | IllegalArgumentException e) {
                    e.printStackTrace();
                    response.statusCode = "-1";
                    response.errorCode = "-1";
                    response.errorMsg = e.getMessage();
                }
            }
        });
    }

}
