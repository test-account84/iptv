package com.amazonaws.mobileconnectors.appsync.retry;

import android.util.Log;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RetryInterceptor implements Interceptor {
    private static final int BASE_RETRY_WAIT_MILLIS = 100;
    private static final int JITTER = 100;
    private static final int MAX_RETRY_COUNT = 12;
    private static final int MAX_RETRY_WAIT_MILLIS = 300000;
    private static final String TAG = "RetryInterceptor";

    public static int calculateBackoff(int i) {
        if (i >= 12) {
            return 300000;
        }
        return (int) Math.min((Math.pow(2.0d, i) * 100.0d) + (Math.random() * 100.0d), 300000.0d);
    }

    private void sleep(int i) {
        if (i > 0) {
            try {
                Log.d(TAG, "Will sleep for " + i + " ms as per backoff sequence");
                Thread.sleep((long) i);
            } catch (InterruptedException unused) {
                Log.e(TAG, "Retry **wait** interrupted.");
            }
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i;
        Log.d(TAG, "Retry Interceptor called");
        int i2 = -1;
        int i3 = 0;
        while (true) {
            sleep(i3);
            try {
                Response proceed = chain.proceed(chain.request());
                if (proceed.isSuccessful()) {
                    Log.i(TAG, "Returning network response: success");
                    return proceed;
                }
                i2++;
                String header = proceed.header("Retry-After");
                if (header != null) {
                    try {
                        int parseInt = Integer.parseInt(header) * 1000;
                        proceed.close();
                        i = parseInt;
                    } catch (NumberFormatException unused) {
                        String str = TAG;
                        Log.w(str, "Could not parse Retry-After header: " + header);
                        Log.w(str, "Will proceed with exponential backoff strategy");
                    }
                } else {
                    if ((proceed.code() < 500 || proceed.code() >= 600) && proceed.code() != 429) {
                        Log.d(TAG, "Encountered non-retriable error. Returning response");
                        return proceed;
                    }
                    i = calculateBackoff(i2);
                    proceed.close();
                }
                if (i >= 300000) {
                    Log.i(TAG, "Returning network response, retries exhausted");
                    return proceed;
                }
                i3 = i;
            } catch (IOException e) {
                Log.w(TAG, "Encountered IO Exception making HTTP call [" + e + "]");
                throw e;
            }
        }
    }
}
