package com.amazonaws.services.s3.metrics;

import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {
    public static final S3ThroughputMetric S3_DOWLOAD_THROUGHPUT;
    public static final S3ServiceMetric S3_DOWNLOAD_BYTE_COUNT;
    public static final S3ServiceMetric S3_UPLOAD_BYTE_COUNT;
    public static final S3ThroughputMetric S3_UPLOAD_THROUGHPUT;
    static final String SERVICE_NAME_PREFIX = "S3";
    private static final S3ServiceMetric[] VALUES;
    private final String name;

    public static class 1 extends S3ThroughputMetric {
        public 1(String str) {
            super(str, null);
        }

        public ServiceMetricType getByteCountMetricType() {
            return S3ServiceMetric.S3_DOWNLOAD_BYTE_COUNT;
        }
    }

    public static class 2 extends S3ThroughputMetric {
        public 2(String str) {
            super(str, null);
        }

        public ServiceMetricType getByteCountMetricType() {
            return S3ServiceMetric.S3_UPLOAD_BYTE_COUNT;
        }
    }

    public static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        private S3ThroughputMetric(String str) {
            super(str, null);
        }

        public /* synthetic */ S3ThroughputMetric(String str, 1 r2) {
            this(str);
        }
    }

    static {
        1 r0 = new 1(metricName("DownloadThroughput"));
        S3_DOWLOAD_THROUGHPUT = r0;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(metricName("DownloadByteCount"));
        S3_DOWNLOAD_BYTE_COUNT = s3ServiceMetric;
        2 r2 = new 2(metricName("UploadThroughput"));
        S3_UPLOAD_THROUGHPUT = r2;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(metricName("UploadByteCount"));
        S3_UPLOAD_BYTE_COUNT = s3ServiceMetric2;
        VALUES = new S3ServiceMetric[]{r0, s3ServiceMetric, r2, s3ServiceMetric2};
    }

    private S3ServiceMetric(String str) {
        this.name = str;
    }

    private static final String metricName(String str) {
        return "S3" + str;
    }

    public static S3ServiceMetric valueOf(String str) {
        for (S3ServiceMetric s3ServiceMetric : values()) {
            if (s3ServiceMetric.name().equals(str)) {
                return s3ServiceMetric;
            }
        }
        throw new IllegalArgumentException("No S3ServiceMetric defined for the name " + str);
    }

    public static S3ServiceMetric[] values() {
        return (S3ServiceMetric[]) VALUES.clone();
    }

    public String getServiceName() {
        return "Amazon S3";
    }

    public String name() {
        return this.name;
    }

    public /* synthetic */ S3ServiceMetric(String str, 1 r2) {
        this(str);
    }
}
