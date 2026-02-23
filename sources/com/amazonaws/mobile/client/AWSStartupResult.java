package com.amazonaws.mobile.client;

import com.amazonaws.mobile.auth.core.IdentityManager;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AWSStartupResult {
    private IdentityManager identityManager;

    public AWSStartupResult(IdentityManager identityManager) {
        this.identityManager = identityManager;
    }

    public boolean isIdentityIdAvailable() {
        return this.identityManager.getCachedUserID() != null;
    }
}
