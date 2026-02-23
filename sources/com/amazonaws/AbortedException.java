package com.amazonaws;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AbortedException extends AmazonClientException {
    private static final long serialVersionUID = 1;

    public AbortedException() {
        super("");
    }

    public boolean isRetryable() {
        return false;
    }

    public AbortedException(String str) {
        super(str);
    }

    public AbortedException(String str, Throwable th) {
        super(str, th);
    }

    public AbortedException(Throwable th) {
        super("", th);
    }
}
