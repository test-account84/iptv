package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiFactorAuthenticationContinuation implements CognitoIdentityProviderContinuation {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    private final RespondToAuthChallengeResult challenge;
    private final Context context;
    private final boolean runInBackground;
    private final CognitoUser user;
    private String mfaCode = null;
    private final Map clientMetadata = new HashMap();

    public class 1 implements Runnable {

        public class 1 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 1(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                MultiFactorAuthenticationContinuation.access$400(MultiFactorAuthenticationContinuation.this).onFailure(this.val$e);
            }
        }

        public 1() {
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(MultiFactorAuthenticationContinuation.access$000(MultiFactorAuthenticationContinuation.this).getMainLooper());
            try {
                runnable = MultiFactorAuthenticationContinuation.access$500(MultiFactorAuthenticationContinuation.this).respondToMfaChallenge(MultiFactorAuthenticationContinuation.access$100(MultiFactorAuthenticationContinuation.this), MultiFactorAuthenticationContinuation.access$200(MultiFactorAuthenticationContinuation.this), MultiFactorAuthenticationContinuation.access$300(MultiFactorAuthenticationContinuation.this), MultiFactorAuthenticationContinuation.access$400(MultiFactorAuthenticationContinuation.this), true);
            } catch (Exception e) {
                runnable = new 1(e);
            }
            handler.post(runnable);
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ Exception val$e;

        public 2(Exception exc) {
            this.val$e = exc;
        }

        public void run() {
            MultiFactorAuthenticationContinuation.access$400(MultiFactorAuthenticationContinuation.this).onFailure(this.val$e);
        }
    }

    public MultiFactorAuthenticationContinuation(CognitoUser cognitoUser, Context context, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context;
        this.callback = authenticationHandler;
        this.runInBackground = z;
        this.challenge = respondToAuthChallengeResult;
    }

    public static /* synthetic */ Context access$000(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        return multiFactorAuthenticationContinuation.context;
    }

    public static /* synthetic */ Map access$100(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        return multiFactorAuthenticationContinuation.clientMetadata;
    }

    public static /* synthetic */ String access$200(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        return multiFactorAuthenticationContinuation.mfaCode;
    }

    public static /* synthetic */ RespondToAuthChallengeResult access$300(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        return multiFactorAuthenticationContinuation.challenge;
    }

    public static /* synthetic */ AuthenticationHandler access$400(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        return multiFactorAuthenticationContinuation.callback;
    }

    public static /* synthetic */ CognitoUser access$500(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        return multiFactorAuthenticationContinuation.user;
    }

    public void continueTask() {
        Runnable runnable;
        if (this.runInBackground) {
            new Thread(new 1()).start();
            return;
        }
        try {
            runnable = this.user.respondToMfaChallenge(this.clientMetadata, this.mfaCode, this.challenge, this.callback, false);
        } catch (Exception e) {
            runnable = new 2(e);
        }
        runnable.run();
    }

    public Map getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetadata);
    }

    public CognitoUserCodeDeliveryDetails getParameters() {
        return "SOFTWARE_TOKEN_MFA".equals(this.challenge.getChallengeName()) ? new CognitoUserCodeDeliveryDetails("Time-based One-time Password", (String) this.challenge.getChallengeParameters().get("FRIENDLY_DEVICE_NAME"), null) : "SMS_MFA".equals(this.challenge.getChallengeName()) ? new CognitoUserCodeDeliveryDetails((String) this.challenge.getChallengeParameters().get("CODE_DELIVERY_DESTINATION"), (String) this.challenge.getChallengeParameters().get("CODE_DELIVERY_DELIVERY_MEDIUM"), null) : new CognitoUserCodeDeliveryDetails("", "", "");
    }

    public void setClientMetaData(Map map) {
        this.clientMetadata.clear();
        if (map != null) {
            this.clientMetadata.putAll(map);
        }
    }

    public void setMfaCode(String str) {
        this.mfaCode = str;
    }
}
