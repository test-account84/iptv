package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface SignUpHandler {
    void onFailure(Exception exc);

    void onSuccess(CognitoUser cognitoUser, SignUpResult signUpResult);
}
