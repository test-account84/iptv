package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface GetDetailsHandler {
    void onFailure(Exception exc);

    void onSuccess(CognitoUserDetails cognitoUserDetails);
}
