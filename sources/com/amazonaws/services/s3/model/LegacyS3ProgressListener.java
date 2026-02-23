package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LegacyS3ProgressListener implements com.amazonaws.event.ProgressListener {
    private final ProgressListener listener;

    public LegacyS3ProgressListener(ProgressListener progressListener) {
        this.listener = progressListener;
    }

    private ProgressEvent transform(com.amazonaws.event.ProgressEvent progressEvent) {
        return new ProgressEvent(progressEvent.getEventCode(), progressEvent.getBytesTransferred());
    }

    public void progressChanged(com.amazonaws.event.ProgressEvent progressEvent) {
        ProgressListener progressListener = this.listener;
        if (progressListener == null) {
            return;
        }
        progressListener.progressChanged(transform(progressEvent));
    }

    public ProgressListener unwrap() {
        return this.listener;
    }
}
