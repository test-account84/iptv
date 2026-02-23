package com.amazonaws;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AmazonClientException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public AmazonClientException(String str) {
        super(str);
    }

    public boolean isRetryable() {
        return true;
    }

    public AmazonClientException(String str, Throwable th) {
        super(str, th);
    }

    public AmazonClientException(Throwable th) {
        super(th);
    }
}
