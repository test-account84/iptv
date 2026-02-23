package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class RetryPolicy {
    private final BackoffStrategy backoffStrategy;
    private final boolean honorMaxErrorRetryInClientConfig;
    private final int maxErrorRetry;
    private final RetryCondition retryCondition;

    public interface BackoffStrategy {
        public static final BackoffStrategy NO_DELAY = new 1();

        public static class 1 implements BackoffStrategy {
            public long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
                return 0L;
            }
        }

        long delayBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i);
    }

    public interface RetryCondition {
        public static final RetryCondition NO_RETRY_CONDITION = new 1();

        public static class 1 implements RetryCondition {
            public boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
                return false;
            }
        }

        boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i);
    }

    public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int i, boolean z) {
        retryCondition = retryCondition == null ? PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION : retryCondition;
        backoffStrategy = backoffStrategy == null ? PredefinedRetryPolicies.DEFAULT_BACKOFF_STRATEGY : backoffStrategy;
        if (i < 0) {
            throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
        }
        this.retryCondition = retryCondition;
        this.backoffStrategy = backoffStrategy;
        this.maxErrorRetry = i;
        this.honorMaxErrorRetryInClientConfig = z;
    }

    public BackoffStrategy getBackoffStrategy() {
        return this.backoffStrategy;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public RetryCondition getRetryCondition() {
        return this.retryCondition;
    }

    public boolean isMaxErrorRetryInClientConfigHonored() {
        return this.honorMaxErrorRetryInClientConfig;
    }
}
