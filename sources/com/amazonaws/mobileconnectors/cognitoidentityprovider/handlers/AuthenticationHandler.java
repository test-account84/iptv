package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AuthenticationHandler {
    void authenticationChallenge(ChallengeContinuation challengeContinuation);

    void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str);

    void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation);

    void onFailure(Exception exc);

    void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice);
}
