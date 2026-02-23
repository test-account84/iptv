package com.amazonaws.metrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ServiceMetricCollector {
    public static final ServiceMetricCollector NONE = new 1();

    public static class 1 extends ServiceMetricCollector {
        public void collectByteThroughput(ByteThroughputProvider byteThroughputProvider) {
        }

        public void collectLatency(ServiceLatencyProvider serviceLatencyProvider) {
        }

        public boolean isEnabled() {
            return false;
        }
    }

    public interface Factory {
        ServiceMetricCollector getServiceMetricCollector();
    }

    public abstract void collectByteThroughput(ByteThroughputProvider byteThroughputProvider);

    public abstract void collectLatency(ServiceLatencyProvider serviceLatencyProvider);

    public boolean isEnabled() {
        return true;
    }
}
