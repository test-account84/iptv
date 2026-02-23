package com.amazonaws.mobile.auth.core;

import android.app.Activity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface SignInResultHandler {
    boolean onCancel(Activity activity);

    void onIntermediateProviderCancel(Activity activity, IdentityProvider identityProvider);

    void onIntermediateProviderError(Activity activity, IdentityProvider identityProvider, Exception exc);

    void onSuccess(Activity activity, IdentityProvider identityProvider);
}
