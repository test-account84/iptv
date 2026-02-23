package com.amazonaws.mobile.auth.core.signin;

import com.amazonaws.mobile.auth.core.IdentityProvider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ProviderAuthException extends AuthException {
    public ProviderAuthException(IdentityProvider identityProvider, Exception exc) {
        super(identityProvider, exc);
    }
}
