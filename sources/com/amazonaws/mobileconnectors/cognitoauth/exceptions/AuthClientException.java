package com.amazonaws.mobileconnectors.cognitoauth.exceptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthClientException extends RuntimeException {
    private static final long serialVersionUID = -2748057344647987093L;

    public AuthClientException(String str) {
        super(str);
    }

    public boolean isRetryable() {
        return true;
    }

    public AuthClientException(String str, Throwable th) {
        super(str, th);
    }
}
