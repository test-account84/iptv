package com.amazonaws.mobile.auth.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StartupAuthResult {
    private final StartupAuthErrorDetails errors;
    private final IdentityManager identityManager;

    public StartupAuthResult(IdentityManager identityManager, StartupAuthErrorDetails startupAuthErrorDetails) {
        this.identityManager = identityManager;
        this.errors = startupAuthErrorDetails;
    }

    public StartupAuthErrorDetails getErrorDetails() {
        return this.errors;
    }

    public IdentityManager getIdentityManager() {
        return this.identityManager;
    }

    public boolean isIdentityIdAvailable() {
        return this.identityManager.getCachedUserID() != null;
    }

    public boolean isUserAnonymous() {
        return isIdentityIdAvailable() && !isUserSignedIn();
    }

    public boolean isUserSignedIn() {
        return this.identityManager.isUserSignedIn();
    }
}
