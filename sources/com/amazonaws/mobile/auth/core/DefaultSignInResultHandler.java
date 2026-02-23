package com.amazonaws.mobile.auth.core;

import android.app.Activity;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class DefaultSignInResultHandler implements SignInResultHandler {
    private static final String LOG_TAG = "DefaultSignInResultHandler";

    public void onIntermediateProviderCancel(Activity activity, IdentityProvider identityProvider) {
        Log.d(LOG_TAG, String.format("%s Sign-In flow is canceled", new Object[]{identityProvider.getDisplayName()}));
    }

    public void onIntermediateProviderError(Activity activity, IdentityProvider identityProvider, Exception exc) {
        Log.e(LOG_TAG, String.format(activity.getString(R.string.sign_in_failure_message_format), new Object[]{identityProvider.getDisplayName(), exc.getMessage()}), exc);
    }
}
