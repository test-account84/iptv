package com.amazonaws.mobileconnectors.cognitoauth.handlers;

import com.amazonaws.mobileconnectors.cognitoauth.AuthUserSession;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AuthHandler {
    void onFailure(Exception exc);

    void onSignout();

    void onSuccess(AuthUserSession authUserSession);
}
