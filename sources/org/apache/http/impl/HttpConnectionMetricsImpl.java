package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.io.HttpTransportMetrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    private final HttpTransportMetrics inTransportMetric;
    private Map metricsCache;
    private final HttpTransportMetrics outTransportMetric;
    private long requestCount = 0;
    private long responseCount = 0;

    public HttpConnectionMetricsImpl(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        this.inTransportMetric = httpTransportMetrics;
        this.outTransportMetric = httpTransportMetrics2;
    }

    public Object getMetric(String str) {
        HttpTransportMetrics httpTransportMetrics;
        long j;
        Map map = this.metricsCache;
        Object obj = map != null ? map.get(str) : null;
        if (obj != null) {
            return obj;
        }
        if ("http.request-count".equals(str)) {
            j = this.requestCount;
        } else {
            if (!"http.response-count".equals(str)) {
                if ("http.received-bytes-count".equals(str)) {
                    httpTransportMetrics = this.inTransportMetric;
                    if (httpTransportMetrics == null) {
                        return null;
                    }
                } else {
                    if (!"http.sent-bytes-count".equals(str)) {
                        return obj;
                    }
                    httpTransportMetrics = this.outTransportMetric;
                    if (httpTransportMetrics == null) {
                        return null;
                    }
                }
                return Long.valueOf(httpTransportMetrics.getBytesTransferred());
            }
            j = this.responseCount;
        }
        return Long.valueOf(j);
    }

    public long getReceivedBytesCount() {
        HttpTransportMetrics httpTransportMetrics = this.inTransportMetric;
        if (httpTransportMetrics != null) {
            return httpTransportMetrics.getBytesTransferred();
        }
        return -1L;
    }

    public long getRequestCount() {
        return this.requestCount;
    }

    public long getResponseCount() {
        return this.responseCount;
    }

    public long getSentBytesCount() {
        HttpTransportMetrics httpTransportMetrics = this.outTransportMetric;
        if (httpTransportMetrics != null) {
            return httpTransportMetrics.getBytesTransferred();
        }
        return -1L;
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }

    public void incrementResponseCount() {
        this.responseCount++;
    }

    public void reset() {
        HttpTransportMetrics httpTransportMetrics = this.outTransportMetric;
        if (httpTransportMetrics != null) {
            httpTransportMetrics.reset();
        }
        HttpTransportMetrics httpTransportMetrics2 = this.inTransportMetric;
        if (httpTransportMetrics2 != null) {
            httpTransportMetrics2.reset();
        }
        this.requestCount = 0L;
        this.responseCount = 0L;
        this.metricsCache = null;
    }

    public void setMetric(String str, Object obj) {
        if (this.metricsCache == null) {
            this.metricsCache = new HashMap();
        }
        this.metricsCache.put(str, obj);
    }
}
