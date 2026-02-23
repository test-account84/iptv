package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.metrics.RequestMetricCollector;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AmazonWebServiceRequest implements Cloneable {
    private AmazonWebServiceRequest cloneSource;
    private AWSCredentials credentials;
    private ProgressListener generalProgressListener;
    private final RequestClientOptions requestClientOptions = new RequestClientOptions();

    @Deprecated
    private RequestMetricCollector requestMetricCollector;

    private void setCloneSource(AmazonWebServiceRequest amazonWebServiceRequest) {
        this.cloneSource = amazonWebServiceRequest;
    }

    public AmazonWebServiceRequest clone() {
        try {
            AmazonWebServiceRequest amazonWebServiceRequest = (AmazonWebServiceRequest) super.clone();
            amazonWebServiceRequest.setCloneSource(this);
            return amazonWebServiceRequest;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    public final AmazonWebServiceRequest copyBaseTo(AmazonWebServiceRequest amazonWebServiceRequest) {
        amazonWebServiceRequest.setGeneralProgressListener(this.generalProgressListener);
        amazonWebServiceRequest.setRequestMetricCollector(this.requestMetricCollector);
        return amazonWebServiceRequest;
    }

    public AmazonWebServiceRequest getCloneRoot() {
        AmazonWebServiceRequest amazonWebServiceRequest = this.cloneSource;
        if (amazonWebServiceRequest != null) {
            while (amazonWebServiceRequest.getCloneSource() != null) {
                amazonWebServiceRequest = amazonWebServiceRequest.getCloneSource();
            }
        }
        return amazonWebServiceRequest;
    }

    public AmazonWebServiceRequest getCloneSource() {
        return this.cloneSource;
    }

    public ProgressListener getGeneralProgressListener() {
        return this.generalProgressListener;
    }

    public RequestClientOptions getRequestClientOptions() {
        return this.requestClientOptions;
    }

    public AWSCredentials getRequestCredentials() {
        return this.credentials;
    }

    @Deprecated
    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }

    public void setGeneralProgressListener(ProgressListener progressListener) {
        this.generalProgressListener = progressListener;
    }

    public void setRequestCredentials(AWSCredentials aWSCredentials) {
        this.credentials = aWSCredentials;
    }

    @Deprecated
    public void setRequestMetricCollector(RequestMetricCollector requestMetricCollector) {
        this.requestMetricCollector = requestMetricCollector;
    }

    public AmazonWebServiceRequest withGeneralProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(progressListener);
        return this;
    }

    @Deprecated
    public AmazonWebServiceRequest withRequestMetricCollector(RequestMetricCollector requestMetricCollector) {
        setRequestMetricCollector(requestMetricCollector);
        return this;
    }
}
