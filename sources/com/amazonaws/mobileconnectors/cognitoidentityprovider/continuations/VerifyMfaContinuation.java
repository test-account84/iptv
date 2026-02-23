package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.RegisterMfaHandler;
import com.amazonaws.util.StringUtils;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VerifyMfaContinuation implements CognitoIdentityProviderContinuation {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final RegisterMfaHandler callback;
    private final String clientId;
    private final Context context;
    private String friendlyName = "Time-based One-time Password MFA";
    private final Map mfaSetupDetails;
    private final boolean runInBackground;
    private final String sessionToken;
    private final boolean useSessionToken;
    private final CognitoUser user;
    private String verificationCode;

    public VerifyMfaContinuation(Context context, String str, CognitoUser cognitoUser, RegisterMfaHandler registerMfaHandler, Map map, boolean z, String str2, boolean z2) {
        this.context = context;
        this.clientId = str;
        this.user = cognitoUser;
        this.callback = registerMfaHandler;
        this.mfaSetupDetails = map;
        this.useSessionToken = z;
        this.sessionToken = str2;
        this.runInBackground = z2;
    }

    public void continueTask() {
        CognitoUser cognitoUser;
        String str = null;
        if (this.runInBackground && this.useSessionToken) {
            cognitoUser = this.user;
            str = this.sessionToken;
        } else {
            cognitoUser = this.user;
        }
        cognitoUser.verifySoftwareTokenInBackground(str, this.verificationCode, this.friendlyName, this.callback);
    }

    public void setVerificationResponse(String str, String str2) {
        if (StringUtils.isBlank(str)) {
            throw new CognitoParameterInvalidException("verification code is invalid");
        }
        this.verificationCode = str;
        if (StringUtils.isBlank(str2)) {
            return;
        }
        this.friendlyName = str2;
    }

    public Map getParameters() {
        return this.mfaSetupDetails;
    }
}
