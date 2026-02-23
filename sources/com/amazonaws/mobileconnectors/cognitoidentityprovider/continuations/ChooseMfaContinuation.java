package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ChooseMfaContinuation extends ChallengeContinuation {
    private List mfaOptions;

    public ChooseMfaContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
        this.mfaOptions = getListFromString((String) getParameters().get("MFAS_CAN_CHOOSE"));
    }

    private List getListFromString(String str) {
        return Arrays.asList(str.replace("[", "").replace("]", "").replace("\"", "").split(","));
    }

    public void continueTask() {
        if (!this.challengeResponses.containsKey("ANSWER")) {
            throw new CognitoParameterInvalidException("MFA option is not set");
        }
        super.continueTask();
    }

    public List getMfaOptions() {
        if (this.mfaOptions == null) {
            this.mfaOptions = getListFromString((String) getParameters().get("MFAS_CAN_CHOOSE"));
        }
        return this.mfaOptions;
    }

    public void setMfaOption(String str) {
        List mfaOptions = getMfaOptions();
        if (str == null || !mfaOptions.contains(str)) {
            throw new CognitoParameterInvalidException(String.format(Locale.US, "invalid MFA option: %s", new Object[]{str}));
        }
        setChallengeResponse("ANSWER", str);
    }
}
