package com.amazonaws.mobile.auth.core;

import android.content.Context;
import com.amazonaws.mobile.config.AWSConfiguration;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface IdentityProvider {
    String getCognitoLoginKey();

    String getDisplayName();

    String getToken();

    void initialize(Context context, AWSConfiguration aWSConfiguration);

    String refreshToken();

    boolean refreshUserSignInState();

    void signOut();
}
