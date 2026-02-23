package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.VerifyMfaContinuation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface RegisterMfaHandler {
    void onFailure(Exception exc);

    void onSuccess(String str);

    void onVerify(VerifyMfaContinuation verifyMfaContinuation);
}
