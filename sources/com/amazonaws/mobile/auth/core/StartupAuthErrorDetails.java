package com.amazonaws.mobile.auth.core;

import com.amazonaws.mobile.auth.core.signin.AuthException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StartupAuthErrorDetails {
    private final AuthException authException;
    private final Exception unauthException;

    public StartupAuthErrorDetails(AuthException authException, Exception exc) {
        this.authException = authException;
        this.unauthException = exc;
    }

    public boolean didErrorOccurObtainingUnauthenticatedIdentity() {
        return this.unauthException != null;
    }

    public boolean didErrorOccurRefreshingProvider() {
        return this.authException != null;
    }

    public AuthException getProviderRefreshException() {
        return this.authException;
    }

    public Exception getUnauthenticatedErrorException() {
        return this.unauthException;
    }
}
