package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface ForgotPasswordHandler {
    void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation);

    void onFailure(Exception exc);

    void onSuccess();
}
