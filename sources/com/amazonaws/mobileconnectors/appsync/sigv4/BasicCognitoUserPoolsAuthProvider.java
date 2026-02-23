package com.amazonaws.mobileconnectors.appsync.sigv4;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import java.util.concurrent.Semaphore;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BasicCognitoUserPoolsAuthProvider implements CognitoUserPoolsAuthProvider {
    private String lastTokenRetrievalFailureMessage;
    private String token;
    private CognitoUserPool userPool;

    public class 1 implements AuthenticationHandler {
        final /* synthetic */ Semaphore val$semaphore;

        public 1(Semaphore semaphore) {
            this.val$semaphore = semaphore;
        }

        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
            BasicCognitoUserPoolsAuthProvider.access$102(BasicCognitoUserPoolsAuthProvider.this, "Cognito Userpools is not signed-in");
            this.val$semaphore.release();
        }

        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
            BasicCognitoUserPoolsAuthProvider.access$102(BasicCognitoUserPoolsAuthProvider.this, "Cognito Userpools is not signed-in");
            this.val$semaphore.release();
        }

        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
            BasicCognitoUserPoolsAuthProvider.access$102(BasicCognitoUserPoolsAuthProvider.this, "Cognito Userpools is not signed-in");
            this.val$semaphore.release();
        }

        public void onFailure(Exception exc) {
            BasicCognitoUserPoolsAuthProvider.access$102(BasicCognitoUserPoolsAuthProvider.this, "Cognito Userpools failed to get session");
            this.val$semaphore.release();
        }

        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
            BasicCognitoUserPoolsAuthProvider.access$002(BasicCognitoUserPoolsAuthProvider.this, cognitoUserSession.getAccessToken().getJWTToken());
            this.val$semaphore.release();
        }
    }

    public BasicCognitoUserPoolsAuthProvider(CognitoUserPool cognitoUserPool) {
        this.userPool = cognitoUserPool;
    }

    public static /* synthetic */ String access$002(BasicCognitoUserPoolsAuthProvider basicCognitoUserPoolsAuthProvider, String str) {
        basicCognitoUserPoolsAuthProvider.token = str;
        return str;
    }

    public static /* synthetic */ String access$102(BasicCognitoUserPoolsAuthProvider basicCognitoUserPoolsAuthProvider, String str) {
        basicCognitoUserPoolsAuthProvider.lastTokenRetrievalFailureMessage = str;
        return str;
    }

    private synchronized void fetchToken() {
        try {
            Semaphore semaphore = new Semaphore(0);
            this.lastTokenRetrievalFailureMessage = null;
            this.userPool.getCurrentUser().getSessionInBackground(new 1(semaphore));
            try {
                semaphore.acquire();
                if (this.lastTokenRetrievalFailureMessage != null) {
                    throw new RuntimeException(this.lastTokenRetrievalFailureMessage);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted waiting for Cognito Userpools token.", e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String getLatestAuthToken() {
        fetchToken();
        return this.token;
    }
}
