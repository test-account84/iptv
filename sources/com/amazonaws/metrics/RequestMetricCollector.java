package com.amazonaws.metrics;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class RequestMetricCollector {
    public static final RequestMetricCollector NONE = new 1();

    public static class 1 extends RequestMetricCollector {
        public void collectMetrics(Request request, Response response) {
        }

        public boolean isEnabled() {
            return false;
        }
    }

    public interface Factory {
        RequestMetricCollector getRequestMetricCollector();
    }

    public abstract void collectMetrics(Request request, Response response);

    public boolean isEnabled() {
        return true;
    }
}
