package com.amplifyframework.auth.cognito.util;

import com.amazonaws.mobile.client.results.SignInState;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.step.AuthSignInStep;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SignInStateConverter {
    private static final Map CONVERT_SIGN_IN_STATE;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(SignInState.SMS_MFA, AuthSignInStep.CONFIRM_SIGN_IN_WITH_SMS_MFA_CODE);
        hashMap.put(SignInState.CUSTOM_CHALLENGE, AuthSignInStep.CONFIRM_SIGN_IN_WITH_CUSTOM_CHALLENGE);
        hashMap.put(SignInState.NEW_PASSWORD_REQUIRED, AuthSignInStep.CONFIRM_SIGN_IN_WITH_NEW_PASSWORD);
        hashMap.put(SignInState.DONE, AuthSignInStep.DONE);
        CONVERT_SIGN_IN_STATE = Collections.unmodifiableMap(hashMap);
    }

    private SignInStateConverter() {
    }

    public static AuthSignInStep getAuthSignInStep(SignInState signInState) throws AuthException {
        AuthSignInStep authSignInStep = (AuthSignInStep) CONVERT_SIGN_IN_STATE.get(signInState);
        if (authSignInStep != null) {
            return authSignInStep;
        }
        throw new AuthException("Unsupported sign in state", "We currently do not support the " + signInState + " state from AWSMobileClient. If this error is reached, please report it as a bug");
    }
}
