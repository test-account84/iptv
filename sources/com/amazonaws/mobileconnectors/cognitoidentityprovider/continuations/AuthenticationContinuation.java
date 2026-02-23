package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthenticationContinuation implements CognitoIdentityProviderContinuation {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    private final Context context;
    private final boolean runInBackground;
    private final CognitoUser user;
    private AuthenticationDetails authenticationDetails = null;
    private final Map clientMetadata = new HashMap();

    public class 1 implements Runnable {

        public class 1 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 1(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                AuthenticationContinuation.access$300(AuthenticationContinuation.this).onFailure(this.val$e);
            }
        }

        public 1() {
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(AuthenticationContinuation.access$000(AuthenticationContinuation.this).getMainLooper());
            try {
                runnable = AuthenticationContinuation.access$400(AuthenticationContinuation.this).initiateUserAuthentication(AuthenticationContinuation.access$100(AuthenticationContinuation.this), AuthenticationContinuation.access$200(AuthenticationContinuation.this), AuthenticationContinuation.access$300(AuthenticationContinuation.this), true);
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
            AuthenticationContinuation.access$300(AuthenticationContinuation.this).onFailure(this.val$e);
        }
    }

    public AuthenticationContinuation(CognitoUser cognitoUser, Context context, boolean z, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context;
        this.runInBackground = z;
        this.callback = authenticationHandler;
    }

    public static /* synthetic */ Context access$000(AuthenticationContinuation authenticationContinuation) {
        return authenticationContinuation.context;
    }

    public static /* synthetic */ Map access$100(AuthenticationContinuation authenticationContinuation) {
        return authenticationContinuation.clientMetadata;
    }

    public static /* synthetic */ AuthenticationDetails access$200(AuthenticationContinuation authenticationContinuation) {
        return authenticationContinuation.authenticationDetails;
    }

    public static /* synthetic */ AuthenticationHandler access$300(AuthenticationContinuation authenticationContinuation) {
        return authenticationContinuation.callback;
    }

    public static /* synthetic */ CognitoUser access$400(AuthenticationContinuation authenticationContinuation) {
        return authenticationContinuation.user;
    }

    public void continueTask() {
        Runnable runnable;
        if (this.runInBackground) {
            new Thread(new 1()).start();
            return;
        }
        try {
            runnable = this.user.initiateUserAuthentication(this.clientMetadata, this.authenticationDetails, this.callback, false);
        } catch (Exception e) {
            runnable = new 2(e);
        }
        runnable.run();
    }

    public Map getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetadata);
    }

    public void setAuthenticationDetails(AuthenticationDetails authenticationDetails) {
        this.authenticationDetails = authenticationDetails;
    }

    public void setClientMetaData(Map map) {
        this.clientMetadata.clear();
        if (map != null) {
            this.clientMetadata.putAll(map);
        }
    }

    public String getParameters() {
        return "AuthenticationDetails";
    }
}
