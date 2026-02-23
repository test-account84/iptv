package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.amazonaws.util.StringUtils;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RegisterMfaContinuation extends ChallengeContinuation {
    private List mfaOptions;

    public RegisterMfaContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
        this.mfaOptions = getListFromString((String) getParameters().get("MFAS_CAN_SETUP"));
    }

    private List getListFromString(String str) {
        return Arrays.asList(str.replace("[", "").replace("]", "").replace("\"", "").split(","));
    }

    public void continueTask() {
        super.continueTask();
    }

    public List getMfaOptions() {
        if (this.mfaOptions == null) {
            this.mfaOptions = getListFromString((String) getParameters().get("MFAS_CAN_SETUP"));
        }
        return this.mfaOptions;
    }

    public void setSessionToken(String str) {
        if (StringUtils.isBlank(str)) {
            throw new CognitoParameterInvalidException("session token cannot be null");
        }
        setResponseSessionCode(str);
    }
}
