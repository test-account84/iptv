package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ChallengeContinuation implements CognitoIdentityProviderContinuation {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    private final RespondToAuthChallengeResult challengeResult;
    private final String clientId;
    private final Context context;
    private final boolean runInBackground;
    private final String secretHash;
    private final CognitoUser user;
    private final String username;
    protected final Map challengeResponses = new HashMap();
    private final Map clientMetaData = new HashMap();

    public class 1 implements Runnable {
        final /* synthetic */ RespondToAuthChallengeRequest val$respondToAuthChallengeRequest;

        public class 1 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 1(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                ChallengeContinuation.access$200(ChallengeContinuation.this).onFailure(this.val$e);
            }
        }

        public 1(RespondToAuthChallengeRequest respondToAuthChallengeRequest) {
            this.val$respondToAuthChallengeRequest = respondToAuthChallengeRequest;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(ChallengeContinuation.access$000(ChallengeContinuation.this).getMainLooper());
            try {
                runnable = ChallengeContinuation.access$300(ChallengeContinuation.this).respondToChallenge(ChallengeContinuation.access$100(ChallengeContinuation.this), this.val$respondToAuthChallengeRequest, ChallengeContinuation.access$200(ChallengeContinuation.this), true);
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
            ChallengeContinuation.access$200(ChallengeContinuation.this).onFailure(this.val$e);
        }
    }

    public ChallengeContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        this.challengeResult = respondToAuthChallengeResult;
        this.context = context;
        this.clientId = str2;
        this.secretHash = str3;
        this.user = cognitoUser;
        this.username = str;
        this.callback = authenticationHandler;
        this.runInBackground = z;
    }

    public static /* synthetic */ Context access$000(ChallengeContinuation challengeContinuation) {
        return challengeContinuation.context;
    }

    public static /* synthetic */ Map access$100(ChallengeContinuation challengeContinuation) {
        return challengeContinuation.clientMetaData;
    }

    public static /* synthetic */ AuthenticationHandler access$200(ChallengeContinuation challengeContinuation) {
        return challengeContinuation.callback;
    }

    public static /* synthetic */ CognitoUser access$300(ChallengeContinuation challengeContinuation) {
        return challengeContinuation.user;
    }

    public void continueTask() {
        Runnable runnable;
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        this.challengeResponses.put("USERNAME", this.username);
        this.challengeResponses.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setChallengeName(this.challengeResult.getChallengeName());
        respondToAuthChallengeRequest.setSession(this.challengeResult.getSession());
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeResponses(this.challengeResponses);
        if (!this.clientMetaData.isEmpty()) {
            respondToAuthChallengeRequest.setClientMetadata(this.clientMetaData);
        }
        if (this.runInBackground) {
            new Thread(new 1(respondToAuthChallengeRequest)).start();
            return;
        }
        try {
            runnable = this.user.respondToChallenge(this.clientMetaData, respondToAuthChallengeRequest, this.callback, false);
        } catch (Exception e) {
            runnable = new 2(e);
        }
        runnable.run();
    }

    public String getChallengeName() {
        return this.challengeResult.getChallengeName();
    }

    public Map getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetaData);
    }

    public void setChallengeResponse(String str, String str2) {
        this.challengeResponses.put(str, str2);
    }

    public void setClientMetaData(Map map) {
        this.clientMetaData.clear();
        if (map != null) {
            this.clientMetaData.putAll(map);
        }
    }

    public void setResponseSessionCode(String str) {
        this.challengeResult.setSession(str);
    }

    public Map getParameters() {
        return this.challengeResult.getChallengeParameters();
    }
}
