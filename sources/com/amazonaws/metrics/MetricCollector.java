package com.amazonaws.metrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class MetricCollector {
    public static final MetricCollector NONE = new 1();

    public static class 1 extends MetricCollector {
        public RequestMetricCollector getRequestMetricCollector() {
            return RequestMetricCollector.NONE;
        }

        public ServiceMetricCollector getServiceMetricCollector() {
            return ServiceMetricCollector.NONE;
        }

        public boolean isEnabled() {
            return false;
        }

        public boolean start() {
            return true;
        }

        public boolean stop() {
            return true;
        }
    }

    public interface Factory {
        MetricCollector getInstance();
    }

    public abstract RequestMetricCollector getRequestMetricCollector();

    public abstract ServiceMetricCollector getServiceMetricCollector();

    public abstract boolean isEnabled();

    public abstract boolean start();

    public abstract boolean stop();
}
