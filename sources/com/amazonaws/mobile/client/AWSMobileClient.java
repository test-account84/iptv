package com.amazonaws.mobile.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.auth.facebook.FacebookButton;
import com.amazonaws.mobile.auth.facebook.FacebookSignInProvider;
import com.amazonaws.mobile.auth.google.GoogleButton;
import com.amazonaws.mobile.auth.google.GoogleSignInProvider;
import com.amazonaws.mobile.auth.ui.AuthUIConfiguration;
import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider;
import com.amazonaws.mobile.client.internal.InternalCallback;
import com.amazonaws.mobile.client.internal.ReturningRunnable;
import com.amazonaws.mobile.client.internal.oauth2.AuthorizeResponse;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Client;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Tokens;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.amazonaws.mobile.client.results.ForgotPasswordState;
import com.amazonaws.mobile.client.results.SignInResult;
import com.amazonaws.mobile.client.results.SignInState;
import com.amazonaws.mobile.client.results.Tokens;
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails;
import com.amazonaws.mobile.config.AWSConfigurable;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoauth.Auth;
import com.amazonaws.mobileconnectors.cognitoauth.AuthUserSession;
import com.amazonaws.mobileconnectors.cognitoauth.handlers.AuthHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoPinpointSharedContext;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidentityprovider.model.AuthFlowType;
import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidUserPoolConfigurationException;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;
import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSMobileClient implements AWSCredentialsProvider {
    static final String AUTH_KEY = "Auth";
    public static final String CHALLENGE_RESPONSE_NEW_PASSWORD_KEY = "NEW_PASSWORD";
    public static final String CHALLENGE_RESPONSE_USER_ATTRIBUTES_PREFIX_KEY = "userAttributes.";
    private static final String COGNITO_USERPOOL_CUSTOM_ENDPOINT = "Endpoint";
    private static final String CUSTOM_ROLE_ARN_KEY = "customRoleArn";
    public static final String DEFAULT_USER_AGENT = "AWSMobileClient";
    private static final String FACEBOOK = "FacebookSignIn";
    static final String FEDERATION_ENABLED_KEY = "isFederationEnabled";
    private static final String GOOGLE = "GoogleSignIn";
    private static final String GOOGLE_WEBAPP_CONFIG_KEY = "ClientId-WebApp";
    public static final String HOSTED_UI_KEY = "hostedUI";
    static final String IDENTITY_ID_KEY = "cognitoIdentityId";
    static final String PROVIDER_KEY = "provider";
    static final String SHARED_PREFERENCES_KEY = "com.amazonaws.mobile.client";
    static final String SIGN_IN_MODE = "signInMode";
    private static final String TAG = "AWSMobileClient";
    static final String TOKEN_KEY = "token";
    private static final String USER_POOLS = "CognitoUserPool";
    private static volatile AWSMobileClient singleton;
    AWSConfiguration awsConfiguration;
    private AWSCredentialsProvider awsCredentialsProvider;
    private AWSStartupHandler awsStartupHandler;
    private final LinkedHashMap clientMap;
    CognitoCachingCredentialsProvider cognitoIdentity;
    private Object federateWithCognitoIdentityLockObject;
    private Callback forgotPasswordCallback;
    private ForgotPasswordContinuation forgotPasswordContinuation;
    Auth hostedUI;
    private Object initLockObject;
    List listeners;
    CognitoUserSession mCognitoUserSession;
    Context mContext;
    DeviceOperations mDeviceOperations;
    Map mFederatedLoginsMap;
    private boolean mIsLegacyMode;
    boolean mIsPersistenceEnabled = true;
    OAuth2Client mOAuth2Client;
    private volatile CountDownLatch mSignedOutWaitLatch;
    KeyValueStore mStore;
    String mUserPoolPoolId;
    private Lock mWaitForSignInLock;
    AWSMobileClientCognitoIdentityProvider provider;
    private Object showSignInLockObject;
    private volatile CountDownLatch showSignInWaitLatch;
    private Callback signInCallback;
    private ChallengeContinuation signInChallengeContinuation;
    private MultiFactorAuthenticationContinuation signInMfaContinuation;
    private SignInProviderConfig[] signInProviderConfig;
    private SignInState signInState;
    private CognitoUser signUpUser;
    private StartupAuthResultHandler startupAuthResultHandler;
    String userAgentOverride;
    private UserStateDetails userStateDetails;
    CognitoUserPool userpool;
    AmazonCognitoIdentityProvider userpoolLL;
    String userpoolsLoginKey;

    public class 1 extends ReturningRunnable {
        public 1() {
        }

        public AWSCredentials run() {
            return AWSMobileClient.this.getCredentials();
        }
    }

    public class 10 implements GenericHandler {
        final /* synthetic */ Callback val$callback;

        public class 1 implements Callback {
            public 1() {
            }

            public void onError(Exception exc) {
                10.this.val$callback.onError(exc);
            }

            public void onResult(Void r2) {
                10.this.val$callback.onResult(r2);
            }
        }

        public 10(Callback callback) {
            this.val$callback = callback;
        }

        public void onFailure(Exception exc) {
            this.val$callback.onError(exc);
        }

        public void onSuccess() {
            AWSMobileClient.this.signOut(SignOutOptions.builder().signOutGlobally(true).invalidateTokens(true).build(), new 1());
        }
    }

    public class 11 implements Runnable {
        final /* synthetic */ boolean val$assignState;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$loginsMap;
        final /* synthetic */ String val$providerKey;
        final /* synthetic */ String val$token;

        public 11(Callback callback, String str, String str2, Map map, boolean z) {
            this.val$callback = callback;
            this.val$token = str;
            this.val$providerKey = str2;
            this.val$loginsMap = map;
            this.val$assignState = z;
        }

        private void end(UserStateDetails userStateDetails) {
            if (this.val$assignState) {
                AWSMobileClient.this.setUserState(userStateDetails);
            }
        }

        public void run() {
            try {
                AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                if (aWSMobileClient.cognitoIdentity == null) {
                    this.val$callback.onError(new Exception("Federation is not enabled, please check if you have CognitoIdentity configured."));
                    return;
                }
                if (!this.val$token.equals(aWSMobileClient.mFederatedLoginsMap.get(this.val$providerKey))) {
                    AWSMobileClient.this.cognitoIdentity.clear();
                    AWSMobileClient.this.cognitoIdentity.setLogins(this.val$loginsMap);
                }
                UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(true);
                AWSMobileClient.this.federateWithCognitoIdentity(this.val$providerKey, this.val$token);
                this.val$callback.onResult(userStateDetails);
                end(userStateDetails);
            } catch (Exception e) {
                Map hashMap = new HashMap();
                hashMap.put("provider", (Object) null);
                hashMap.put("token", (Object) null);
                hashMap.put("isFederationEnabled", (Object) null);
                hashMap.put("cognitoIdentityId", (Object) null);
                hashMap.put("customRoleArn", (Object) null);
                AWSMobileClient.this.mStore.set(hashMap);
                this.val$callback.onError(new RuntimeException("Error in federating the token.", e));
            }
        }
    }

    public class 12 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ boolean val$waitForSignIn;

        public class 1 implements AuthenticationHandler {
            public 1() {
            }

            private void signalTokensNotAvailable(Exception exc) {
                Log.w(AWSMobileClient.access$200(), "signalTokensNotAvailable");
                12.this.val$callback.onError(new Exception("No cached session.", exc));
            }

            public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
                signalTokensNotAvailable(null);
            }

            public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
                signalTokensNotAvailable(null);
            }

            public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                signalTokensNotAvailable(null);
            }

            public void onFailure(Exception exc) {
                signalTokensNotAvailable(exc);
            }

            public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                try {
                    12 r5 = 12.this;
                    AWSMobileClient.this.mCognitoUserSession = cognitoUserSession;
                    r5.val$callback.onResult(new Tokens(cognitoUserSession.getAccessToken().getJWTToken(), cognitoUserSession.getIdToken().getJWTToken(), cognitoUserSession.getRefreshToken().getToken()));
                } catch (Exception e) {
                    12.this.val$callback.onError(e);
                }
            }
        }

        public 12(Callback callback, boolean z) {
            this.val$callback = callback;
            this.val$waitForSignIn = z;
        }

        public void run() {
            String str = (String) AWSMobileClient.this.getSignInDetailsMap().get("provider");
            if (str != null && !AWSMobileClient.this.userpoolsLoginKey.equals(str)) {
                this.val$callback.onError(new Exception("getTokens does not support retrieving tokens for federated sign-in"));
                return;
            }
            if (this.val$waitForSignIn && !AWSMobileClient.this.waitForSignIn()) {
                this.val$callback.onError(new Exception("getTokens does not support retrieving tokens while signed-out"));
                return;
            }
            if (!AWSMobileClient.this.isUserpoolsSignedIn()) {
                this.val$callback.onError(new Exception("You must be signed-in with Cognito Userpools to be able to use getTokens"));
            }
            if (AWSMobileClient.this.getSignInMode().equals(SignInMode.HOSTED_UI)) {
                AWSMobileClient.access$900(AWSMobileClient.this, this.val$callback);
                return;
            }
            if (AWSMobileClient.this.getSignInMode().equals(SignInMode.OAUTH2)) {
                this.val$callback.onError(new Exception("Tokens are not supported for OAuth2"));
                return;
            }
            try {
                AWSMobileClient.this.userpool.getCurrentUser().getSession(Collections.emptyMap(), new 1());
            } catch (Exception e) {
                this.val$callback.onError(e);
            }
        }
    }

    public class 13 implements AuthHandler {
        final /* synthetic */ Callback val$callback;

        public 13(Callback callback) {
            this.val$callback = callback;
        }

        public void onFailure(Exception exc) {
            this.val$callback.onError(new Exception("No cached session.", exc));
        }

        public void onSignout() {
            this.val$callback.onError(new Exception("No cached session."));
        }

        public void onSuccess(AuthUserSession authUserSession) {
            this.val$callback.onResult(new Tokens(authUserSession.getAccessToken().getJWTToken(), authUserSession.getIdToken().getJWTToken(), authUserSession.getRefreshToken().getToken()));
        }
    }

    public class 14 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$password;
        final /* synthetic */ Map val$userAttributes;
        final /* synthetic */ String val$username;
        final /* synthetic */ Map val$validationData;

        public class 1 implements SignUpHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                14.this.val$callback.onError(exc);
            }

            public void onSuccess(CognitoUser cognitoUser, SignUpResult signUpResult) {
                AWSMobileClient.access$1002(AWSMobileClient.this, cognitoUser);
                if (signUpResult == null) {
                    14.this.val$callback.onError(new Exception("SignUpResult received is null"));
                } else if (signUpResult.getCodeDeliveryDetails() == null) {
                    14.this.val$callback.onResult(new com.amazonaws.mobile.client.results.SignUpResult(signUpResult.getUserConfirmed().booleanValue(), null, signUpResult.getUserSub()));
                } else {
                    14.this.val$callback.onResult(new com.amazonaws.mobile.client.results.SignUpResult(signUpResult.getUserConfirmed().booleanValue(), new UserCodeDeliveryDetails(signUpResult.getCodeDeliveryDetails().getDestination(), signUpResult.getCodeDeliveryDetails().getDeliveryMedium(), signUpResult.getCodeDeliveryDetails().getAttributeName()), signUpResult.getUserSub()));
                }
            }
        }

        public 14(Map map, String str, String str2, Map map2, Map map3, Callback callback) {
            this.val$userAttributes = map;
            this.val$username = str;
            this.val$password = str2;
            this.val$validationData = map2;
            this.val$clientMetadata = map3;
            this.val$callback = callback;
        }

        public void run() {
            CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
            for (String str : this.val$userAttributes.keySet()) {
                cognitoUserAttributes.addAttribute(str, (String) this.val$userAttributes.get(str));
            }
            AWSMobileClient.this.userpool.signUp(this.val$username, this.val$password, cognitoUserAttributes, this.val$validationData, this.val$clientMetadata, new 1());
        }
    }

    public class 15 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$signUpChallengeResponse;
        final /* synthetic */ String val$username;

        public class 1 implements GenericHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                15.this.val$callback.onError(exc);
            }

            public void onSuccess() {
                15.this.val$callback.onResult(new com.amazonaws.mobile.client.results.SignUpResult(true, null, null));
                AWSMobileClient.access$1002(AWSMobileClient.this, null);
            }
        }

        public 15(String str, String str2, Map map, Callback callback) {
            this.val$username = str;
            this.val$signUpChallengeResponse = str2;
            this.val$clientMetadata = map;
            this.val$callback = callback;
        }

        public void run() {
            AWSMobileClient.this.userpool.getUser(this.val$username).confirmSignUp(this.val$signUpChallengeResponse, false, this.val$clientMetadata, new 1());
        }
    }

    public class 16 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$username;

        public class 1 implements VerificationHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                16.this.val$callback.onError(exc);
            }

            public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                16.this.val$callback.onResult(new com.amazonaws.mobile.client.results.SignUpResult(false, new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()), null));
            }
        }

        public 16(String str, Map map, Callback callback) {
            this.val$username = str;
            this.val$clientMetadata = map;
            this.val$callback = callback;
        }

        public void run() {
            AWSMobileClient.this.userpool.getUser(this.val$username).resendConfirmationCodeInBackground(this.val$clientMetadata, new 1());
        }
    }

    public class 17 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$username;

        public class 1 implements ForgotPasswordHandler {
            public 1() {
            }

            public void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation) {
                AWSMobileClient.access$1202(AWSMobileClient.this, forgotPasswordContinuation);
                ForgotPasswordResult forgotPasswordResult = new ForgotPasswordResult(ForgotPasswordState.CONFIRMATION_CODE);
                CognitoUserCodeDeliveryDetails parameters = forgotPasswordContinuation.getParameters();
                forgotPasswordResult.setParameters(new UserCodeDeliveryDetails(parameters.getDestination(), parameters.getDeliveryMedium(), parameters.getAttributeName()));
                AWSMobileClient.access$1100(AWSMobileClient.this).onResult(forgotPasswordResult);
            }

            public void onFailure(Exception exc) {
                AWSMobileClient.access$1100(AWSMobileClient.this).onError(exc);
            }

            public void onSuccess() {
                AWSMobileClient.access$1100(AWSMobileClient.this).onResult(new ForgotPasswordResult(ForgotPasswordState.DONE));
            }
        }

        public 17(Callback callback, String str, Map map) {
            this.val$callback = callback;
            this.val$username = str;
            this.val$clientMetadata = map;
        }

        public void run() {
            AWSMobileClient.access$1102(AWSMobileClient.this, new InternalCallback(this.val$callback));
            AWSMobileClient.this.userpool.getUser(this.val$username).forgotPasswordInBackground(this.val$clientMetadata, new 1());
        }
    }

    public class 18 implements ForgotPasswordHandler {
        final /* synthetic */ Callback val$callback;

        public 18(Callback callback) {
            this.val$callback = callback;
        }

        public void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation) {
            this.val$callback.onResult(new ForgotPasswordResult(ForgotPasswordState.CONFIRMATION_CODE));
        }

        public void onFailure(Exception exc) {
            this.val$callback.onError(exc);
        }

        public void onSuccess() {
            this.val$callback.onResult(new ForgotPasswordResult(ForgotPasswordState.DONE));
        }
    }

    public class 19 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$forgotPasswordChallengeResponse;
        final /* synthetic */ String val$password;

        public 19(Callback callback, String str, String str2, Map map) {
            this.val$callback = callback;
            this.val$password = str;
            this.val$forgotPasswordChallengeResponse = str2;
            this.val$clientMetadata = map;
        }

        public void run() {
            if (AWSMobileClient.access$1200(AWSMobileClient.this) == null) {
                this.val$callback.onError(new IllegalStateException("confirmForgotPassword called before initiating forgotPassword"));
                return;
            }
            AWSMobileClient.access$1200(AWSMobileClient.this).setPassword(this.val$password);
            AWSMobileClient.access$1200(AWSMobileClient.this).setVerificationCode(this.val$forgotPasswordChallengeResponse);
            AWSMobileClient.access$1200(AWSMobileClient.this).setClientMetadata(this.val$clientMetadata);
            AWSMobileClient.access$1102(AWSMobileClient.this, new InternalCallback(this.val$callback));
            AWSMobileClient.access$1200(AWSMobileClient.this).continueTask();
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ AWSConfiguration val$awsConfiguration;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Context val$context;

        public class 1 implements SignInStateChangeListener {
            final /* synthetic */ IdentityManager val$identityManager;

            public class 1 implements Callback {
                public 1() {
                }

                public void onError(Exception exc) {
                    Log.w(AWSMobileClient.access$200(), "onError: User sign-in had errors from drop-in UI", exc);
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    aWSMobileClient.setUserState(aWSMobileClient.getUserStateDetails(false));
                    AWSMobileClient.this.getSignInUILatch().countDown();
                }

                public void onResult(UserStateDetails userStateDetails) {
                    Log.d(AWSMobileClient.access$200(), "onResult: showSignIn federated");
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    aWSMobileClient.setUserState(aWSMobileClient.getUserStateDetails(false));
                    AWSMobileClient.this.getSignInUILatch().countDown();
                }
            }

            public 1(IdentityManager identityManager) {
                this.val$identityManager = identityManager;
            }

            public void onUserSignedIn() {
                Log.d(AWSMobileClient.access$200(), "onUserSignedIn: Updating user state from drop-in UI");
                AWSMobileClient.access$302(AWSMobileClient.this, SignInState.DONE);
                com.amazonaws.mobile.auth.core.IdentityProvider currentIdentityProvider = this.val$identityManager.getCurrentIdentityProvider();
                String token = currentIdentityProvider.getToken();
                AWSMobileClient.this.federatedSignInWithoutAssigningState(currentIdentityProvider.getCognitoLoginKey(), token, new 1());
            }

            public void onUserSignedOut() {
                Log.d(AWSMobileClient.access$200(), "onUserSignedOut: Updating user state from drop-in UI");
                AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                aWSMobileClient.setUserState(aWSMobileClient.getUserStateDetails(false));
                AWSMobileClient.access$400(AWSMobileClient.this).countDown();
            }
        }

        public 2(Callback callback, AWSConfiguration aWSConfiguration, Context context) {
            this.val$callback = callback;
            this.val$awsConfiguration = aWSConfiguration;
            this.val$context = context;
        }

        public void run() {
            synchronized (AWSMobileClient.access$000(AWSMobileClient.this)) {
                try {
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    if (aWSMobileClient.awsConfiguration != null) {
                        this.val$callback.onResult(aWSMobileClient.getUserStateDetails(true));
                        return;
                    }
                    aWSMobileClient.mIsPersistenceEnabled = true;
                    try {
                        if (this.val$awsConfiguration.optJsonObject("Auth") != null && this.val$awsConfiguration.optJsonObject("Auth").has("Persistence")) {
                            AWSMobileClient.this.mIsPersistenceEnabled = this.val$awsConfiguration.optJsonObject("Auth").getBoolean("Persistence");
                        }
                        AWSMobileClient.this.userAgentOverride = this.val$awsConfiguration.getUserAgentOverride();
                        AWSMobileClient.this.mContext = this.val$context.getApplicationContext();
                        AWSMobileClient aWSMobileClient2 = AWSMobileClient.this;
                        aWSMobileClient2.mStore = new AWSMobileClientStore(aWSMobileClient2);
                        IdentityManager identityManager = new IdentityManager(AWSMobileClient.this.mContext);
                        identityManager.enableFederation(false);
                        identityManager.setConfiguration(this.val$awsConfiguration);
                        identityManager.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled);
                        IdentityManager.setDefaultIdentityManager(identityManager);
                        AWSMobileClient.access$100(AWSMobileClient.this, this.val$awsConfiguration);
                        identityManager.addSignInStateChangeListener(new 1(identityManager));
                        if (this.val$awsConfiguration.optJsonObject("CredentialsProvider") != null && this.val$awsConfiguration.optJsonObject("CredentialsProvider").optJSONObject("CognitoIdentity") != null) {
                            try {
                                JSONObject jSONObject = this.val$awsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.val$awsConfiguration.getConfiguration());
                                String string = jSONObject.getString("PoolId");
                                String string2 = jSONObject.getString("Region");
                                ClientConfiguration clientConfiguration = new ClientConfiguration();
                                clientConfiguration.setUserAgent("AWSMobileClient " + this.val$awsConfiguration.getUserAgent());
                                String str = AWSMobileClient.this.userAgentOverride;
                                if (str != null) {
                                    clientConfiguration.setUserAgentOverride(str);
                                }
                                AmazonCognitoIdentityClient amazonCognitoIdentityClient = new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration);
                                amazonCognitoIdentityClient.setRegion(Region.getRegion(string2));
                                AWSMobileClient.this.provider = new AWSMobileClientCognitoIdentityProvider(null, string, amazonCognitoIdentityClient);
                                AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                                AWSMobileClient aWSMobileClient4 = AWSMobileClient.this;
                                aWSMobileClient3.cognitoIdentity = new CognitoCachingCredentialsProvider(aWSMobileClient4.mContext, aWSMobileClient4.provider, Regions.fromName(string2));
                                AWSMobileClient aWSMobileClient5 = AWSMobileClient.this;
                                aWSMobileClient5.cognitoIdentity.setPersistenceEnabled(aWSMobileClient5.mIsPersistenceEnabled);
                                AWSMobileClient aWSMobileClient6 = AWSMobileClient.this;
                                String str2 = aWSMobileClient6.userAgentOverride;
                                if (str2 != null) {
                                    aWSMobileClient6.cognitoIdentity.setUserAgentOverride(str2);
                                }
                            } catch (Exception e) {
                                this.val$callback.onError(new RuntimeException("Failed to initialize Cognito Identity; please check your awsconfiguration.json", e));
                                return;
                            }
                        }
                        JSONObject optJsonObject = this.val$awsConfiguration.optJsonObject("CognitoUserPool");
                        if (optJsonObject != null) {
                            try {
                                AWSMobileClient.this.mUserPoolPoolId = optJsonObject.getString("PoolId");
                                String string3 = optJsonObject.getString("AppClientId");
                                String optString = optJsonObject.optString("AppClientSecret");
                                String pinpointEndpoint = CognitoPinpointSharedContext.getPinpointEndpoint(this.val$context, optJsonObject.optString("PinpointAppId"));
                                String optString2 = optJsonObject.optString("Endpoint");
                                ClientConfiguration clientConfiguration2 = new ClientConfiguration();
                                clientConfiguration2.setUserAgent("AWSMobileClient " + this.val$awsConfiguration.getUserAgent());
                                String str3 = AWSMobileClient.this.userAgentOverride;
                                if (str3 != null) {
                                    clientConfiguration2.setUserAgentOverride(str3);
                                }
                                AWSMobileClient.this.userpoolLL = new AmazonCognitoIdentityProviderClient(new AnonymousAWSCredentials(), clientConfiguration2);
                                AWSMobileClient.this.userpoolLL.setRegion(Region.getRegion(Regions.fromName(optJsonObject.getString("Region"))));
                                AWSMobileClient.this.userpoolsLoginKey = String.format("cognito-idp.%s.amazonaws.com/%s", new Object[]{optJsonObject.getString("Region"), optJsonObject.getString("PoolId")});
                                AWSMobileClient aWSMobileClient7 = AWSMobileClient.this;
                                AWSMobileClient aWSMobileClient8 = AWSMobileClient.this;
                                aWSMobileClient7.userpool = new CognitoUserPool(aWSMobileClient8.mContext, aWSMobileClient8.mUserPoolPoolId, string3, optString, aWSMobileClient8.userpoolLL, pinpointEndpoint, optString2);
                                AWSMobileClient aWSMobileClient9 = AWSMobileClient.this;
                                aWSMobileClient9.userpool.setPersistenceEnabled(aWSMobileClient9.mIsPersistenceEnabled);
                                AWSMobileClient aWSMobileClient10 = AWSMobileClient.this;
                                aWSMobileClient10.mDeviceOperations = new DeviceOperations(aWSMobileClient10, aWSMobileClient10.userpoolLL);
                            } catch (Exception e2) {
                                this.val$callback.onError(new RuntimeException("Failed to initialize Cognito Userpool; please check your awsconfiguration.json", e2));
                                return;
                            }
                        }
                        JSONObject hostedUIJSON = AWSMobileClient.this.getHostedUIJSON(this.val$awsConfiguration);
                        if (hostedUIJSON != null) {
                            try {
                                if (hostedUIJSON.has("TokenURI")) {
                                    Log.d(AWSMobileClient.access$200(), "initialize: OAuth2 client detected");
                                    AWSMobileClient aWSMobileClient11 = AWSMobileClient.this;
                                    AWSMobileClient aWSMobileClient12 = AWSMobileClient.this;
                                    aWSMobileClient11.mOAuth2Client = new OAuth2Client(aWSMobileClient12.mContext, aWSMobileClient12);
                                    AWSMobileClient aWSMobileClient13 = AWSMobileClient.this;
                                    aWSMobileClient13.mOAuth2Client.setPersistenceEnabled(aWSMobileClient13.mIsPersistenceEnabled);
                                    AWSMobileClient aWSMobileClient14 = AWSMobileClient.this;
                                    aWSMobileClient14.mOAuth2Client.setUserAgentOverride(aWSMobileClient14.userAgentOverride);
                                } else {
                                    AWSMobileClient.access$500(AWSMobileClient.this, hostedUIJSON);
                                }
                            } catch (Exception e3) {
                                this.val$callback.onError(new RuntimeException("Failed to initialize OAuth, please check your awsconfiguration.json", e3));
                            }
                        }
                        AWSMobileClient aWSMobileClient15 = AWSMobileClient.this;
                        if (aWSMobileClient15.cognitoIdentity == null && aWSMobileClient15.userpool == null) {
                            this.val$callback.onError(new RuntimeException("Neither Cognito Identity or Cognito UserPool was used. At least one must be present to use AWSMobileClient."));
                            return;
                        }
                        aWSMobileClient15.awsConfiguration = this.val$awsConfiguration;
                        UserStateDetails userStateDetails = aWSMobileClient15.getUserStateDetails(true);
                        this.val$callback.onResult(userStateDetails);
                        AWSMobileClient.this.setUserState(userStateDetails);
                    } catch (Exception e4) {
                        this.val$callback.onError(new RuntimeException("Failed to initialize AWSMobileClient; please check your awsconfiguration.json", e4));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class 20 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ String val$newPassword;
        final /* synthetic */ String val$oldPassword;

        public class 1 implements GenericHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                20.this.val$callback.onError(exc);
            }

            public void onSuccess() {
                20.this.val$callback.onResult(null);
            }
        }

        public 20(String str, String str2, Callback callback) {
            this.val$oldPassword = str;
            this.val$newPassword = str2;
            this.val$callback = callback;
        }

        public void run() {
            AWSMobileClient.this.userpool.getCurrentUser().changePassword(this.val$oldPassword, this.val$newPassword, new 1());
        }
    }

    public class 21 implements Runnable {
        final /* synthetic */ Callback val$callback;

        public class 1 implements GetDetailsHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                21.this.val$callback.onError(exc);
            }

            public void onSuccess(CognitoUserDetails cognitoUserDetails) {
                21.this.val$callback.onResult(cognitoUserDetails.getAttributes().getAttributes());
            }
        }

        public 21(Callback callback) {
            this.val$callback = callback;
        }

        public void run() {
            if (AWSMobileClient.this.waitForSignIn()) {
                AWSMobileClient.this.userpool.getCurrentUser().getDetails(new 1());
            } else {
                this.val$callback.onError(new Exception("Operation requires a signed-in state"));
            }
        }
    }

    public class 22 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ Map val$userAttributes;

        public class 1 implements UpdateAttributesHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                22.this.val$callback.onError(exc);
            }

            public void onSuccess(List list) {
                LinkedList linkedList = new LinkedList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails = (CognitoUserCodeDeliveryDetails) it.next();
                    linkedList.add(new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()));
                }
                22.this.val$callback.onResult(linkedList);
            }
        }

        public 22(Callback callback, Map map, Map map2) {
            this.val$callback = callback;
            this.val$userAttributes = map;
            this.val$clientMetadata = map2;
        }

        public void run() {
            if (!AWSMobileClient.this.waitForSignIn()) {
                this.val$callback.onError(new Exception("Operation requires a signed-in state"));
                return;
            }
            CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
            Map map = this.val$userAttributes;
            if (map != null) {
                for (String str : map.keySet()) {
                    cognitoUserAttributes.addAttribute(str, (String) this.val$userAttributes.get(str));
                }
            }
            AWSMobileClient.this.userpool.getCurrentUser().updateAttributes(cognitoUserAttributes, this.val$clientMetadata, new 1());
        }
    }

    public class 23 implements Runnable {
        final /* synthetic */ String val$attributeName;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;

        public class 1 implements VerificationHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                23.this.val$callback.onError(exc);
            }

            public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                23.this.val$callback.onResult(new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()));
            }
        }

        public 23(Callback callback, Map map, String str) {
            this.val$callback = callback;
            this.val$clientMetadata = map;
            this.val$attributeName = str;
        }

        public void run() {
            if (AWSMobileClient.this.waitForSignIn()) {
                AWSMobileClient.this.userpool.getCurrentUser().getAttributeVerificationCodeInBackground(this.val$clientMetadata, this.val$attributeName, new 1());
            } else {
                this.val$callback.onError(new Exception("Operation requires a signed-in state"));
            }
        }
    }

    public class 24 implements Runnable {
        final /* synthetic */ String val$attributeName;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ String val$updateUserAttributeChallengeResponse;

        public class 1 implements GenericHandler {
            public 1() {
            }

            public void onFailure(Exception exc) {
                24.this.val$callback.onError(exc);
            }

            public void onSuccess() {
                24.this.val$callback.onResult(null);
            }
        }

        public 24(Callback callback, String str, String str2) {
            this.val$callback = callback;
            this.val$attributeName = str;
            this.val$updateUserAttributeChallengeResponse = str2;
        }

        public void run() {
            if (AWSMobileClient.this.waitForSignIn()) {
                AWSMobileClient.this.userpool.getCurrentUser().verifyAttribute(this.val$attributeName, this.val$updateUserAttributeChallengeResponse, new 1());
            } else {
                this.val$callback.onError(new Exception("Operation requires a signed-in state"));
            }
        }
    }

    public class 25 implements Runnable {
        final /* synthetic */ Callback val$callback;

        public 25(Callback callback) {
            this.val$callback = callback;
        }

        public void run() {
            this.val$callback.onError(new Exception("showSignIn called without HostedUI options in awsconfiguration.json"));
        }
    }

    public class 26 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ SignInUIOptions val$signInUIOptions;

        public class 1 implements Callback {
            final /* synthetic */ HostedUIOptions val$hostedUIOptions;
            final /* synthetic */ Map val$tokensBody;
            final /* synthetic */ Uri val$tokensUri;

            public class 1 implements Callback {

                public class 1 implements Callback {
                    public 1() {
                    }

                    public void onError(Exception exc) {
                        UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                        26.this.val$callback.onResult(userStateDetails);
                        AWSMobileClient.this.setUserState(userStateDetails);
                    }

                    public void onResult(UserStateDetails userStateDetails) {
                        UserStateDetails userStateDetails2 = AWSMobileClient.this.getUserStateDetails(false);
                        26.this.val$callback.onResult(userStateDetails2);
                        AWSMobileClient.this.setUserState(userStateDetails2);
                    }
                }

                public 1() {
                }

                public void onError(Exception exc) {
                    26.this.val$callback.onError(exc);
                }

                public void onResult(OAuth2Tokens oAuth2Tokens) {
                    if (AWSMobileClient.this.isFederationEnabled()) {
                        1 r0 = 1.this;
                        AWSMobileClient.this.federatedSignInWithoutAssigningState(r0.val$hostedUIOptions.getFederationProviderName(), oAuth2Tokens.getIdToken(), new 1());
                    } else {
                        UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                        26.this.val$callback.onResult(userStateDetails);
                        AWSMobileClient.this.setUserState(userStateDetails);
                    }
                }
            }

            public 1(Uri uri, Map map, HostedUIOptions hostedUIOptions) {
                this.val$tokensUri = uri;
                this.val$tokensBody = map;
                this.val$hostedUIOptions = hostedUIOptions;
            }

            public void onError(Exception exc) {
                26.this.val$callback.onError(exc);
            }

            public void onResult(AuthorizeResponse authorizeResponse) {
                Log.i(AWSMobileClient.access$200(), "onResult: OAuth2 callback occurred, exchanging code for token");
                AWSMobileClient.this.mOAuth2Client.requestTokens(this.val$tokensUri, new HashMap(), this.val$tokensBody, authorizeResponse.getCode(), new 1());
            }
        }

        public 26(SignInUIOptions signInUIOptions, Callback callback) {
            this.val$signInUIOptions = signInUIOptions;
            this.val$callback = callback;
        }

        public void run() {
            KeyValueStore keyValueStore;
            HostedUIOptions hostedUIOptions = this.val$signInUIOptions.getHostedUIOptions();
            JSONObject hostedUIJSONFromJSON = AWSMobileClient.this.getHostedUIJSONFromJSON();
            if (hostedUIJSONFromJSON == null) {
                this.val$callback.onError(new Exception("Could not create OAuth configuration object"));
            }
            String str = "true";
            if (hostedUIOptions.getFederationEnabled() != null) {
                keyValueStore = AWSMobileClient.this.mStore;
                if (!hostedUIOptions.getFederationEnabled().booleanValue()) {
                    str = "false";
                }
            } else {
                keyValueStore = AWSMobileClient.this.mStore;
            }
            keyValueStore.set("isFederationEnabled", str);
            AWSMobileClient.this.mStore.set("signInMode", SignInMode.OAUTH2.toString());
            if (AWSMobileClient.this.isFederationEnabled() && hostedUIOptions.getFederationProviderName() == null) {
                throw new IllegalArgumentException("OAuth flow requires a federation provider name if federation is enabled.");
            }
            if (hostedUIOptions.getSignOutQueryParameters() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hostedUIOptions.getSignOutQueryParameters().entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    hostedUIJSONFromJSON.put("SignOutQueryParameters", jSONObject);
                } catch (JSONException e) {
                    this.val$callback.onError(new Exception("Failed to construct sign-out query parameters", e));
                    return;
                }
            }
            if (hostedUIOptions.getTokenQueryParameters() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry2 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                        jSONObject2.put((String) entry2.getKey(), entry2.getValue());
                    }
                    hostedUIJSONFromJSON.put("TokenQueryParameters", jSONObject2);
                } catch (JSONException e2) {
                    this.val$callback.onError(new Exception("Failed to construct token query parameters", e2));
                    return;
                }
            }
            AWSMobileClient.this.mStore.set("hostedUI", hostedUIJSONFromJSON.toString());
            try {
                Uri.Builder buildUpon = Uri.parse(hostedUIJSONFromJSON.getString("SignInURI")).buildUpon();
                if (hostedUIOptions.getSignInQueryParameters() != null) {
                    for (Map.Entry entry3 : hostedUIOptions.getSignInQueryParameters().entrySet()) {
                        buildUpon.appendQueryParameter((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
                buildUpon.appendQueryParameter("redirect_uri", hostedUIJSONFromJSON.getString("SignInRedirectURI"));
                buildUpon.appendQueryParameter("scopes", hostedUIJSONFromJSON.getJSONArray("Scopes").join(" "));
                buildUpon.appendQueryParameter("client_id", hostedUIJSONFromJSON.getString("AppClientId"));
                HashMap hashMap = new HashMap();
                try {
                    Uri.Builder buildUpon2 = Uri.parse(hostedUIJSONFromJSON.getString("TokenURI")).buildUpon();
                    if (hostedUIOptions.getTokenQueryParameters() != null) {
                        for (Map.Entry entry4 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                            buildUpon2.appendQueryParameter((String) entry4.getKey(), (String) entry4.getValue());
                        }
                    }
                    hashMap.put("client_id", hostedUIJSONFromJSON.getString("AppClientId"));
                    hashMap.put("redirect_uri", hostedUIJSONFromJSON.getString("SignInRedirectURI"));
                    AWSMobileClient.this.mOAuth2Client.authorize(buildUpon.build(), new 1(buildUpon2.build(), hashMap, hostedUIOptions));
                } catch (Exception e3) {
                    throw new RuntimeException("Failed to construct tokens url for OAuth", e3);
                }
            } catch (Exception e4) {
                throw new RuntimeException("Failed to construct authorization url for OAuth", e4);
            }
        }
    }

    public class 27 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Activity val$callingActivity;
        final /* synthetic */ SignInUIOptions val$signInUIOptions;

        public class 1 implements AuthHandler {
            boolean hasSucceededOnce = false;

            public class 1 implements Callback {
                public 1() {
                }

                public void onError(Exception exc) {
                    Log.e(AWSMobileClient.access$200(), "onError: Federation from the Hosted UI failed", exc);
                }

                public void onResult(UserStateDetails userStateDetails) {
                    Log.d(AWSMobileClient.access$200(), "onResult: Federation from the Hosted UI succeeded");
                }
            }

            public class 2 implements Runnable {
                public 2() {
                }

                public void run() {
                    UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                    27.this.val$callback.onResult(userStateDetails);
                    AWSMobileClient.this.setUserState(userStateDetails);
                }
            }

            public class 3 implements Runnable {
                final /* synthetic */ Exception val$e;

                public 3(Exception exc) {
                    this.val$e = exc;
                }

                public void run() {
                    27.this.val$callback.onError(this.val$e);
                }
            }

            public 1() {
            }

            public void onFailure(Exception exc) {
                if (this.hasSucceededOnce) {
                    Log.d(AWSMobileClient.access$200(), "onFailure: Ignoring failure because HostedUI has signaled success at least once.");
                } else {
                    new Thread(new 3(exc)).start();
                }
            }

            public void onSignout() {
                Log.d(AWSMobileClient.access$200(), "onSignout: HostedUI signed-out");
            }

            public void onSuccess(AuthUserSession authUserSession) {
                Log.d(AWSMobileClient.access$200(), "onSuccess: HostedUI signed-in");
                this.hasSucceededOnce = true;
                if (AWSMobileClient.this.isFederationEnabled()) {
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    aWSMobileClient.federatedSignInWithoutAssigningState(aWSMobileClient.userpoolsLoginKey, authUserSession.getIdToken().getJWTToken(), new 1());
                }
                new Thread(new 2()).start();
            }
        }

        public 27(SignInUIOptions signInUIOptions, Callback callback, Activity activity) {
            this.val$signInUIOptions = signInUIOptions;
            this.val$callback = callback;
            this.val$callingActivity = activity;
        }

        public void run() {
            JSONObject jSONObject;
            KeyValueStore keyValueStore;
            HostedUIOptions hostedUIOptions = this.val$signInUIOptions.getHostedUIOptions();
            HashSet hashSet = null;
            try {
                jSONObject = new JSONObject(AWSMobileClient.this.getHostedUIJSONFromJSON().toString());
            } catch (JSONException e) {
                this.val$callback.onError(new Exception("Could not create OAuth configuration object", e));
                jSONObject = null;
            }
            String str = "true";
            if (hostedUIOptions.getFederationEnabled() != null) {
                keyValueStore = AWSMobileClient.this.mStore;
                if (!hostedUIOptions.getFederationEnabled().booleanValue()) {
                    str = "false";
                }
            } else {
                keyValueStore = AWSMobileClient.this.mStore;
            }
            keyValueStore.set("isFederationEnabled", str);
            if (hostedUIOptions.getSignOutQueryParameters() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : hostedUIOptions.getSignOutQueryParameters().entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("SignOutQueryParameters", jSONObject2);
                } catch (JSONException e2) {
                    this.val$callback.onError(new Exception("Failed to construct sign-out query parameters", e2));
                    return;
                }
            }
            if (hostedUIOptions.getTokenQueryParameters() != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry entry2 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                        jSONObject3.put((String) entry2.getKey(), entry2.getValue());
                    }
                    jSONObject.put("TokenQueryParameters", jSONObject3);
                } catch (JSONException e3) {
                    this.val$callback.onError(new Exception("Failed to construct token query parameters", e3));
                    return;
                }
            }
            AWSMobileClient.this.mStore.set("hostedUI", jSONObject.toString());
            if (hostedUIOptions.getScopes() != null) {
                hashSet = new HashSet();
                Collections.addAll(hashSet, hostedUIOptions.getScopes());
            }
            String identityProvider = hostedUIOptions.getIdentityProvider();
            String idpIdentifier = hostedUIOptions.getIdpIdentifier();
            AWSMobileClient.this.mStore.set("signInMode", SignInMode.HOSTED_UI.toString());
            try {
                Auth.Builder hostedUI = AWSMobileClient.this.getHostedUI(jSONObject);
                hostedUI.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled).setAuthHandler(new 1());
                if (hashSet != null) {
                    hostedUI.setScopes(hashSet);
                }
                if (identityProvider != null) {
                    hostedUI.setIdentityProvider(identityProvider);
                }
                if (idpIdentifier != null) {
                    hostedUI.setIdpIdentifier(idpIdentifier);
                }
                AWSMobileClient.this.hostedUI = hostedUI.build();
                if (this.val$signInUIOptions.getBrowserPackage() != null) {
                    AWSMobileClient.this.hostedUI.setBrowserPackage(this.val$signInUIOptions.getBrowserPackage());
                }
                AWSMobileClient.this.hostedUI.getSession(this.val$callingActivity);
            } catch (JSONException e4) {
                throw new RuntimeException("Failed to construct HostedUI from awsconfiguration.json", e4);
            }
        }
    }

    public class 28 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Activity val$callingActivity;
        final /* synthetic */ SignInUIOptions val$signInUIOptions;

        public 28(Callback callback, SignInUIOptions signInUIOptions, Activity activity) {
            this.val$callback = callback;
            this.val$signInUIOptions = signInUIOptions;
            this.val$callingActivity = activity;
        }

        public void run() {
            synchronized (AWSMobileClient.access$1300(AWSMobileClient.this)) {
                try {
                    if (UserState.SIGNED_IN.equals(AWSMobileClient.this.getUserStateDetails(false).getUserState())) {
                        this.val$callback.onError(new RuntimeException("Called showSignIn while user is already signed-in"));
                        return;
                    }
                    AuthUIConfiguration.Builder isBackgroundColorFullScreen = new AuthUIConfiguration.Builder().canCancel(this.val$signInUIOptions.canCancel()).isBackgroundColorFullScreen(false);
                    if (this.val$signInUIOptions.getLogo() != null) {
                        isBackgroundColorFullScreen.logoResId(this.val$signInUIOptions.getLogo().intValue());
                    }
                    if (this.val$signInUIOptions.getBackgroundColor() != null) {
                        isBackgroundColorFullScreen.backgroundColor(this.val$signInUIOptions.getBackgroundColor().intValue());
                    }
                    if (AWSMobileClient.access$1400(AWSMobileClient.this, "CognitoUserPool")) {
                        isBackgroundColorFullScreen.userPools(true);
                    }
                    if (AWSMobileClient.access$1400(AWSMobileClient.this, "FacebookSignIn")) {
                        isBackgroundColorFullScreen.signInButton(FacebookButton.class);
                    }
                    if (AWSMobileClient.access$1400(AWSMobileClient.this, "GoogleSignIn")) {
                        isBackgroundColorFullScreen.signInButton(GoogleButton.class);
                    }
                    Class cls = this.val$signInUIOptions.nextActivity() == null ? this.val$callingActivity.getClass() : this.val$signInUIOptions.nextActivity();
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    aWSMobileClient.getClient(aWSMobileClient.mContext, SignInUI.class).login(this.val$callingActivity, cls).authUIConfiguration(isBackgroundColorFullScreen.build()).enableFederation(false).execute();
                    AWSMobileClient.access$402(AWSMobileClient.this, new CountDownLatch(1));
                    try {
                        AWSMobileClient.access$400(AWSMobileClient.this).await();
                        this.val$callback.onResult(AWSMobileClient.this.getUserStateDetails(false));
                        Log.d(AWSMobileClient.access$200(), "run: showSignIn completed");
                    } catch (InterruptedException e) {
                        this.val$callback.onError(e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ class 29 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$UserState;
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$results$SignInState;

        static {
            int[] iArr = new int[SignInState.values().length];
            $SwitchMap$com$amazonaws$mobile$client$results$SignInState = iArr;
            try {
                iArr[SignInState.SMS_MFA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState[SignInState.NEW_PASSWORD_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState[SignInState.CUSTOM_CHALLENGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState[SignInState.DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[UserState.values().length];
            $SwitchMap$com$amazonaws$mobile$client$UserState = iArr2;
            try {
                iArr2[UserState.SIGNED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.GUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public class 3 implements AuthHandler {
        public 3() {
        }

        public void onFailure(Exception exc) {
        }

        public void onSignout() {
        }

        public void onSuccess(AuthUserSession authUserSession) {
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ UserStateDetails val$details;
        final /* synthetic */ UserStateListener val$listener;

        public 4(UserStateListener userStateListener, UserStateDetails userStateDetails) {
            this.val$listener = userStateListener;
            this.val$details = userStateDetails;
        }

        public void run() {
            this.val$listener.onUserStateChanged(this.val$details);
        }
    }

    public class 5 extends ReturningRunnable {
        public 5() {
        }

        public UserStateDetails run() throws Exception {
            return AWSMobileClient.this.getUserStateDetails(false);
        }
    }

    public class 6 implements Runnable {
        final /* synthetic */ AuthFlowType val$authFlowType;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$password;
        final /* synthetic */ String val$username;
        final /* synthetic */ Map val$validationData;

        public class 1 implements AuthenticationHandler {
            public 1() {
            }

            public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
                try {
                    AWSMobileClient.access$302(AWSMobileClient.this, SignInState.valueOf(challengeContinuation.getChallengeName()));
                    AWSMobileClient.access$802(AWSMobileClient.this, challengeContinuation);
                    AWSMobileClient.access$600(AWSMobileClient.this).onResult(new SignInResult(AWSMobileClient.access$300(AWSMobileClient.this), challengeContinuation.getParameters()));
                } catch (IllegalArgumentException e) {
                    AWSMobileClient.access$600(AWSMobileClient.this).onError(e);
                }
            }

            public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
                AuthenticationDetails authenticationDetails;
                Log.d(AWSMobileClient.access$200(), "Sending password.");
                HashMap hashMap = new HashMap();
                boolean z = AWSMobileClient.this.awsConfiguration.optJsonObject("Auth") != null && AWSMobileClient.this.awsConfiguration.optJsonObject("Auth").has("authenticationFlowType");
                try {
                    AuthFlowType authFlowType = 6.this.val$authFlowType;
                    String name = authFlowType != null ? authFlowType.name() : null;
                    if (name == null && z) {
                        name = AWSMobileClient.this.awsConfiguration.optJsonObject("Auth").getString("authenticationFlowType");
                    }
                    if (name == null || !"CUSTOM_AUTH".equals(name)) {
                        if (name == null || !"USER_PASSWORD_AUTH".equals(name)) {
                            Log.d(AWSMobileClient.access$200(), "Using USER_SRP_AUTH for flow type.");
                            6 r0 = 6.this;
                            authenticationDetails = new AuthenticationDetails(r0.val$username, r0.val$password, r0.val$validationData);
                        } else {
                            6 r02 = 6.this;
                            authenticationDetails = new AuthenticationDetails(r02.val$username, r02.val$password, r02.val$validationData);
                            authenticationDetails.setAuthenticationType("USER_PASSWORD");
                        }
                        authenticationContinuation.setAuthenticationDetails(authenticationDetails);
                    } else {
                        6 r03 = 6.this;
                        String str2 = r03.val$password;
                        if (str2 != null) {
                            authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(r03.val$username, str2, hashMap, r03.val$validationData));
                        } else {
                            authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(r03.val$username, (Map) hashMap, r03.val$validationData));
                        }
                    }
                } catch (JSONException e) {
                    Log.w(AWSMobileClient.access$200(), "Exception while attempting to read authenticationFlowType from config.", e);
                }
                authenticationContinuation.continueTask();
            }

            public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                AWSMobileClient.access$702(AWSMobileClient.this, multiFactorAuthenticationContinuation);
                CognitoUserCodeDeliveryDetails parameters = multiFactorAuthenticationContinuation.getParameters();
                AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                SignInState signInState = SignInState.SMS_MFA;
                AWSMobileClient.access$302(aWSMobileClient, signInState);
                AWSMobileClient.access$600(AWSMobileClient.this).onResult(new SignInResult(signInState, new UserCodeDeliveryDetails(parameters.getDestination(), parameters.getDeliveryMedium(), parameters.getAttributeName())));
            }

            public void onFailure(Exception exc) {
                AWSMobileClient.access$600(AWSMobileClient.this).onError(exc);
            }

            public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                AWSMobileClient aWSMobileClient;
                UserStateDetails userStateDetails;
                try {
                    AWSMobileClient aWSMobileClient2 = AWSMobileClient.this;
                    aWSMobileClient2.mCognitoUserSession = cognitoUserSession;
                    AWSMobileClient.access$302(aWSMobileClient2, SignInState.DONE);
                } catch (Exception e) {
                    AWSMobileClient.access$600(AWSMobileClient.this).onError(e);
                    AWSMobileClient.access$602(AWSMobileClient.this, null);
                }
                try {
                    try {
                        if (AWSMobileClient.this.isFederationEnabled()) {
                            AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                            aWSMobileClient3.federatedSignInWithoutAssigningState(aWSMobileClient3.userpoolsLoginKey, aWSMobileClient3.mCognitoUserSession.getIdToken().getJWTToken());
                        }
                        AWSMobileClient.this.releaseSignInWait();
                        aWSMobileClient = AWSMobileClient.this;
                        userStateDetails = new UserStateDetails(UserState.SIGNED_IN, aWSMobileClient.getSignInDetailsMap());
                    } catch (Exception e2) {
                        Log.w(AWSMobileClient.access$200(), "Failed to federate tokens during sign-in", e2);
                        aWSMobileClient = AWSMobileClient.this;
                        userStateDetails = new UserStateDetails(UserState.SIGNED_IN, aWSMobileClient.getSignInDetailsMap());
                    }
                    aWSMobileClient.setUserState(userStateDetails);
                    AWSMobileClient.access$600(AWSMobileClient.this).onResult(SignInResult.DONE);
                } catch (Throwable th) {
                    AWSMobileClient aWSMobileClient4 = AWSMobileClient.this;
                    aWSMobileClient4.setUserState(new UserStateDetails(UserState.SIGNED_IN, aWSMobileClient4.getSignInDetailsMap()));
                    throw th;
                }
            }
        }

        public 6(String str, Map map, AuthFlowType authFlowType, String str2, Map map2, Callback callback) {
            this.val$username = str;
            this.val$clientMetadata = map;
            this.val$authFlowType = authFlowType;
            this.val$password = str2;
            this.val$validationData = map2;
            this.val$callback = callback;
        }

        public void run() {
            try {
                AWSMobileClient.this.userpool.getUser(this.val$username).getSession(this.val$clientMetadata, new 1());
            } catch (Exception e) {
                this.val$callback.onError(e);
            }
        }
    }

    public class 7 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetadata;
        final /* synthetic */ String val$signInChallengeResponse;
        final /* synthetic */ Map val$userAttributes;

        public 7(Callback callback, String str, Map map, Map map2) {
            this.val$callback = callback;
            this.val$signInChallengeResponse = str;
            this.val$clientMetadata = map;
            this.val$userAttributes = map2;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 259
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.AWSMobileClient.7.run():void");
        }
    }

    public class 8 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$clientMetaData;
        final /* synthetic */ Map val$signInChallengeResponse;

        public 8(Callback callback, Map map, Map map2) {
            this.val$callback = callback;
            this.val$signInChallengeResponse = map;
            this.val$clientMetaData = map2;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                com.amazonaws.mobile.client.AWSMobileClient r0 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobile.client.results.SignInState r0 = com.amazonaws.mobile.client.AWSMobileClient.access$300(r0)
                if (r0 != 0) goto L15
                com.amazonaws.mobile.client.Callback r0 = r4.val$callback
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "Cannot call confirmSignIn(Map<String, String>, Callback) without initiating sign-in. This call is used for CUSTOM_CHALLENGE sign-in state."
                r1.<init>(r2)
            L11:
                r0.onError(r1)
                return
            L15:
                int[] r0 = com.amazonaws.mobile.client.AWSMobileClient.29.$SwitchMap$com$amazonaws$mobile$client$results$SignInState
                com.amazonaws.mobile.client.AWSMobileClient r1 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobile.client.results.SignInState r1 = com.amazonaws.mobile.client.AWSMobileClient.access$300(r1)
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = 1
                if (r0 == r1) goto L47
                r1 = 2
                if (r0 == r1) goto L53
                r1 = 3
                if (r0 == r1) goto L53
                r1 = 4
                if (r0 == r1) goto L39
                com.amazonaws.mobile.client.Callback r0 = r4.val$callback
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "confirmSignIn called on unsupported operation, please file a feature request"
                r1.<init>(r2)
                goto L11
            L39:
                com.amazonaws.mobile.client.Callback r0 = r4.val$callback
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "confirmSignIn called after signIn has succeeded"
                r1.<init>(r2)
                r0.onError(r1)
                r0 = 0
                goto Laa
            L47:
                com.amazonaws.mobile.client.Callback r0 = r4.val$callback
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "Please use confirmSignIn(String, Callback) for SMS_MFA challenges"
                r1.<init>(r2)
                r0.onError(r1)
            L53:
                java.util.Map r0 = r4.val$signInChallengeResponse
                java.util.Set r0 = r0.keySet()
                java.util.Iterator r0 = r0.iterator()
            L5d:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L7b
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                com.amazonaws.mobile.client.AWSMobileClient r2 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation r2 = com.amazonaws.mobile.client.AWSMobileClient.access$800(r2)
                java.util.Map r3 = r4.val$signInChallengeResponse
                java.lang.Object r3 = r3.get(r1)
                java.lang.String r3 = (java.lang.String) r3
                r2.setChallengeResponse(r1, r3)
                goto L5d
            L7b:
                com.amazonaws.mobile.client.AWSMobileClient r0 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation r0 = com.amazonaws.mobile.client.AWSMobileClient.access$800(r0)
                com.amazonaws.mobile.client.AWSMobileClient r1 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobile.client.internal.InternalCallback r2 = new com.amazonaws.mobile.client.internal.InternalCallback
                com.amazonaws.mobile.client.Callback r3 = r4.val$callback
                r2.<init>(r3)
                com.amazonaws.mobile.client.AWSMobileClient.access$602(r1, r2)
                com.amazonaws.mobile.client.results.SignInState r1 = com.amazonaws.mobile.client.results.SignInState.CUSTOM_CHALLENGE
                com.amazonaws.mobile.client.AWSMobileClient r2 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobile.client.results.SignInState r2 = com.amazonaws.mobile.client.AWSMobileClient.access$300(r2)
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto Laa
                java.util.Map r1 = r4.val$clientMetaData
                if (r1 == 0) goto Laa
                com.amazonaws.mobile.client.AWSMobileClient r1 = com.amazonaws.mobile.client.AWSMobileClient.this
                com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation r1 = com.amazonaws.mobile.client.AWSMobileClient.access$800(r1)
                java.util.Map r2 = r4.val$clientMetaData
                r1.setClientMetaData(r2)
            Laa:
                if (r0 == 0) goto Laf
                r0.continueTask()
            Laf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.AWSMobileClient.8.run():void");
        }
    }

    public class 9 extends ReturningRunnable {
        final /* synthetic */ SignOutOptions val$signOutOptions;

        public class 1 implements Callback {
            final /* synthetic */ CountDownLatch val$latch;
            final /* synthetic */ Exception[] val$signOutError;

            public 1(CountDownLatch countDownLatch, Exception[] excArr) {
                this.val$latch = countDownLatch;
                this.val$signOutError = excArr;
            }

            public void onError(Exception exc) {
                this.val$signOutError[0] = exc;
                this.val$latch.countDown();
            }

            public void onResult(Void r1) {
                this.val$latch.countDown();
            }
        }

        public 9(SignOutOptions signOutOptions) {
            this.val$signOutOptions = signOutOptions;
        }

        public Void run() throws Exception {
            if (this.val$signOutOptions.isSignOutGlobally()) {
                GlobalSignOutRequest globalSignOutRequest = new GlobalSignOutRequest();
                globalSignOutRequest.setAccessToken(AWSMobileClient.this.getTokens().getAccessToken().getTokenString());
                AWSMobileClient.this.userpoolLL.globalSignOut(globalSignOutRequest);
            }
            if (this.val$signOutOptions.isInvalidateTokens()) {
                CognitoUserPool cognitoUserPool = AWSMobileClient.this.userpool;
                if (cognitoUserPool != null) {
                    cognitoUserPool.getCurrentUser().revokeTokens();
                }
                AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                if (aWSMobileClient.hostedUI != null) {
                    if (this.val$signOutOptions.getBrowserPackage() != null) {
                        AWSMobileClient.this.hostedUI.setBrowserPackage(this.val$signOutOptions.getBrowserPackage());
                    }
                    AWSMobileClient.this.hostedUI.signOut();
                } else if (aWSMobileClient.mOAuth2Client != null) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    JSONObject hostedUIJSON = AWSMobileClient.this.getHostedUIJSON();
                    Uri.Builder buildUpon = Uri.parse(hostedUIJSON.getString("SignOutURI")).buildUpon();
                    if (AWSMobileClient.this.getHostedUIJSON().optString("SignOutRedirectURI", (String) null) != null) {
                        buildUpon.appendQueryParameter("redirect_uri", AWSMobileClient.this.getHostedUIJSON().getString("SignOutRedirectURI"));
                    }
                    JSONObject jSONObject = hostedUIJSON.getJSONObject("SignOutQueryParameters");
                    if (jSONObject != null) {
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            buildUpon.appendQueryParameter(str, jSONObject.getString(str));
                        }
                    }
                    Throwable[] thArr = new Exception[1];
                    AWSMobileClient.this.mOAuth2Client.signOut(buildUpon.build(), new 1(countDownLatch, thArr));
                    countDownLatch.await();
                    Throwable th = thArr[0];
                    if (th != null) {
                        throw th;
                    }
                }
            }
            AWSMobileClient.this.signOut();
            return null;
        }
    }

    @Deprecated
    public class InitializeBuilder {
        private AWSConfiguration awsConfiguration;
        private Context context;
        private SignInProviderConfig[] signInProviderConfig;

        @Deprecated
        public InitializeBuilder() {
            this.context = null;
            this.awsConfiguration = null;
            this.signInProviderConfig = null;
        }

        @Deprecated
        public InitializeBuilder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfiguration = aWSConfiguration;
            return this;
        }

        @Deprecated
        public void execute() {
            AWSMobileClient.access$1500(AWSMobileClient.this, this);
        }

        @Deprecated
        public AWSConfiguration getAwsConfiguration() {
            return this.awsConfiguration;
        }

        @Deprecated
        public Context getContext() {
            return this.context;
        }

        @Deprecated
        public SignInProviderConfig[] getSignInProviderConfig() {
            return this.signInProviderConfig;
        }

        @Deprecated
        public InitializeBuilder signInProviders(SignInProviderConfig... signInProviderConfigArr) {
            this.signInProviderConfig = signInProviderConfigArr;
            return this;
        }

        @Deprecated
        public InitializeBuilder(Context context) {
            this.context = context;
            this.awsConfiguration = null;
            this.signInProviderConfig = null;
        }
    }

    public enum SignInMode {
        SIGN_IN("0"),
        FEDERATED_SIGN_IN("1"),
        HOSTED_UI("2"),
        OAUTH2("3"),
        UNKNOWN("-1");

        String encode;

        SignInMode(String str) {
            this.encode = str;
        }

        public static SignInMode fromString(String str) {
            return "0".equals(str) ? SIGN_IN : "1".equals(str) ? FEDERATED_SIGN_IN : "2".equals(str) ? HOSTED_UI : "3".equals(str) ? OAUTH2 : UNKNOWN;
        }

        public String toString() {
            return this.encode;
        }
    }

    @Deprecated
    public class SignInProviderConfig {

        @Deprecated
        private String[] providerPermissions;

        @Deprecated
        private Class signInProvider;

        @Deprecated
        public SignInProviderConfig(Class cls, String... strArr) {
            this.signInProvider = cls;
            this.providerPermissions = strArr;
        }

        @Deprecated
        public String[] getProviderPermissions() {
            return this.providerPermissions;
        }

        @Deprecated
        public Class getSignInProviderClass() {
            return this.signInProvider;
        }
    }

    private AWSMobileClient() {
        if (singleton != null) {
            throw new AssertionError();
        }
        this.clientMap = new LinkedHashMap();
        this.userpoolsLoginKey = "";
        this.mWaitForSignInLock = new ReentrantLock();
        this.mFederatedLoginsMap = new HashMap();
        this.listeners = new ArrayList();
        this.showSignInLockObject = new Object();
        this.federateWithCognitoIdentityLockObject = new Object();
        this.showSignInWaitLatch = new CountDownLatch(1);
        this.initLockObject = new Object();
        this.mStore = new DummyStore();
    }

    private Runnable _changePassword(String str, String str2, Callback callback) {
        return new 20(str, str2, callback);
    }

    private Runnable _confirmForgotPassword(String str, String str2, Map map, Callback callback) {
        return new 19(callback, str, str2, map);
    }

    private Runnable _confirmSignIn(String str, Map map, Map map2, Callback callback) {
        return new 7(callback, str, map, map2);
    }

    private Runnable _confirmSignUp(String str, String str2, Map map, Callback callback) {
        return new 15(str, str2, map, callback);
    }

    private Runnable _confirmUserAttribute(String str, String str2, Callback callback) {
        return new 24(callback, str, str2);
    }

    private Runnable _deleteUser(Callback callback) {
        return new b(this, callback);
    }

    private Runnable _federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions, Callback callback, boolean z) {
        HashMap hashMap = new HashMap();
        this.mStore.set("signInMode", SignInMode.FEDERATED_SIGN_IN.toString());
        try {
            hashMap.put(str, str2);
            Log.d(TAG, String.format("_federatedSignIn: Putting provider and token in store", new Object[0]));
            Map hashMap2 = new HashMap();
            hashMap2.put("provider", str);
            hashMap2.put("token", str2);
            hashMap2.put("isFederationEnabled", "true");
            if (IdentityProvider.DEVELOPER.equals(str)) {
                if (federatedSignInOptions == null) {
                    callback.onError(new Exception("Developer authenticated identities require theidentity id to be specified in FederatedSignInOptions"));
                }
                hashMap2.put("cognitoIdentityId", federatedSignInOptions.getCognitoIdentityId());
            }
            if (federatedSignInOptions != null && !StringUtils.isBlank(federatedSignInOptions.getCustomRoleARN())) {
                hashMap2.put("customRoleArn", federatedSignInOptions.getCustomRoleARN());
            }
            this.mStore.set(hashMap2);
        } catch (Exception e) {
            callback.onError(e);
        }
        return new 11(callback, str2, str, hashMap, z);
    }

    private Runnable _forgotPassword(String str, Map map, Callback callback) {
        return new 17(callback, str, map);
    }

    private ReturningRunnable _getAWSCredentials() {
        return new 1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _getHostedUITokens, reason: merged with bridge method [inline-methods] */
    public void lambda$getHostedUITokens$1(Callback callback) {
        Auth currentUser = this.hostedUI.getCurrentUser();
        this.hostedUI = currentUser;
        currentUser.setAuthHandler(new 13(callback));
        this.hostedUI.getSessionWithoutWebUI();
    }

    private Runnable _getTokens(Callback callback, boolean z) {
        return new 12(callback, z);
    }

    private Runnable _getUserAttributes(Callback callback) {
        return new 21(callback);
    }

    private void _initializeHostedUI(JSONObject jSONObject) throws JSONException {
        Log.d(TAG, "initialize: Cognito HostedUI client detected");
        JSONArray jSONArray = jSONObject.getJSONArray("Scopes");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        if (this.mUserPoolPoolId == null) {
            throw new IllegalStateException("User pool Id must be available through user pool setting");
        }
        this.hostedUI = getHostedUI(jSONObject).setPersistenceEnabled(this.mIsPersistenceEnabled).setAuthHandler(new 3()).build();
    }

    private Runnable _resendSignUp(String str, Map map, Callback callback) {
        return new 16(str, map, callback);
    }

    private Runnable _showSignIn(Activity activity, SignInUIOptions signInUIOptions, Callback callback) {
        if (signInUIOptions.getHostedUIOptions() == null) {
            return _showSignInDropInUI(activity, signInUIOptions, callback);
        }
        JSONObject hostedUIJSON = getHostedUIJSON();
        return hostedUIJSON == null ? new 25(callback) : hostedUIJSON.optString("TokenURI", (String) null) != null ? _showSignInOAuth2UI(activity, signInUIOptions, callback) : _showSignInHostedUI(activity, signInUIOptions, callback);
    }

    private Runnable _showSignInDropInUI(Activity activity, SignInUIOptions signInUIOptions, Callback callback) {
        return new 28(callback, signInUIOptions, activity);
    }

    private Runnable _showSignInHostedUI(Activity activity, SignInUIOptions signInUIOptions, Callback callback) {
        return new 27(signInUIOptions, callback, activity);
    }

    private Runnable _showSignInOAuth2UI(Activity activity, SignInUIOptions signInUIOptions, Callback callback) {
        return new 26(signInUIOptions, callback);
    }

    private Runnable _signIn(String str, String str2, Map map, Map map2, AuthFlowType authFlowType, Callback callback) {
        this.signInCallback = callback;
        this.signInState = null;
        this.mStore.set("signInMode", SignInMode.SIGN_IN.toString());
        return new 6(str, map2, authFlowType, str2, map, callback);
    }

    private ReturningRunnable _signOut(SignOutOptions signOutOptions) {
        return new 9(signOutOptions);
    }

    private Runnable _signUp(String str, String str2, Map map, Map map2, Map map3, Callback callback) {
        return new 14(map, str, str2, map2, map3, callback);
    }

    private Runnable _updateUserAttributes(Map map, Map map2, Callback callback) {
        return new 22(callback, map, map2);
    }

    private Runnable _verifyUserAttribute(String str, Map map, Callback callback) {
        return new 23(callback, map, str);
    }

    public static /* synthetic */ void a(AWSMobileClient aWSMobileClient, InternalCallback internalCallback) {
        aWSMobileClient.lambda$getHostedUITokens$1(internalCallback);
    }

    public static /* synthetic */ Object access$000(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.initLockObject;
    }

    public static /* synthetic */ void access$100(AWSMobileClient aWSMobileClient, AWSConfiguration aWSConfiguration) {
        aWSMobileClient.registerConfigSignInProviders(aWSConfiguration);
    }

    public static /* synthetic */ CognitoUser access$1002(AWSMobileClient aWSMobileClient, CognitoUser cognitoUser) {
        aWSMobileClient.signUpUser = cognitoUser;
        return cognitoUser;
    }

    public static /* synthetic */ Callback access$1100(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.forgotPasswordCallback;
    }

    public static /* synthetic */ Callback access$1102(AWSMobileClient aWSMobileClient, Callback callback) {
        aWSMobileClient.forgotPasswordCallback = callback;
        return callback;
    }

    public static /* synthetic */ ForgotPasswordContinuation access$1200(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.forgotPasswordContinuation;
    }

    public static /* synthetic */ ForgotPasswordContinuation access$1202(AWSMobileClient aWSMobileClient, ForgotPasswordContinuation forgotPasswordContinuation) {
        aWSMobileClient.forgotPasswordContinuation = forgotPasswordContinuation;
        return forgotPasswordContinuation;
    }

    public static /* synthetic */ Object access$1300(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.showSignInLockObject;
    }

    public static /* synthetic */ boolean access$1400(AWSMobileClient aWSMobileClient, String str) {
        return aWSMobileClient.isConfigurationKeyPresent(str);
    }

    public static /* synthetic */ void access$1500(AWSMobileClient aWSMobileClient, InitializeBuilder initializeBuilder) {
        aWSMobileClient.initializeWithBuilder(initializeBuilder);
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ SignInState access$300(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.signInState;
    }

    public static /* synthetic */ SignInState access$302(AWSMobileClient aWSMobileClient, SignInState signInState) {
        aWSMobileClient.signInState = signInState;
        return signInState;
    }

    public static /* synthetic */ CountDownLatch access$400(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.showSignInWaitLatch;
    }

    public static /* synthetic */ CountDownLatch access$402(AWSMobileClient aWSMobileClient, CountDownLatch countDownLatch) {
        aWSMobileClient.showSignInWaitLatch = countDownLatch;
        return countDownLatch;
    }

    public static /* synthetic */ void access$500(AWSMobileClient aWSMobileClient, JSONObject jSONObject) throws JSONException {
        aWSMobileClient._initializeHostedUI(jSONObject);
    }

    public static /* synthetic */ Callback access$600(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.signInCallback;
    }

    public static /* synthetic */ Callback access$602(AWSMobileClient aWSMobileClient, Callback callback) {
        aWSMobileClient.signInCallback = callback;
        return callback;
    }

    public static /* synthetic */ MultiFactorAuthenticationContinuation access$700(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.signInMfaContinuation;
    }

    public static /* synthetic */ MultiFactorAuthenticationContinuation access$702(AWSMobileClient aWSMobileClient, MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        aWSMobileClient.signInMfaContinuation = multiFactorAuthenticationContinuation;
        return multiFactorAuthenticationContinuation;
    }

    public static /* synthetic */ ChallengeContinuation access$800(AWSMobileClient aWSMobileClient) {
        return aWSMobileClient.signInChallengeContinuation;
    }

    public static /* synthetic */ ChallengeContinuation access$802(AWSMobileClient aWSMobileClient, ChallengeContinuation challengeContinuation) {
        aWSMobileClient.signInChallengeContinuation = challengeContinuation;
        return challengeContinuation;
    }

    public static /* synthetic */ void access$900(AWSMobileClient aWSMobileClient, Callback callback) {
        aWSMobileClient.lambda$getHostedUITokens$1(callback);
    }

    public static /* synthetic */ void b(AWSMobileClient aWSMobileClient, Callback callback) {
        aWSMobileClient.lambda$_deleteUser$0(callback);
    }

    private void fetchCognitoIdentity(Context context, StartupAuthResultHandler startupAuthResultHandler) {
        try {
            Log.d(TAG, "Fetching the Cognito Identity.");
            IdentityManager.setDefaultIdentityManager(new IdentityManager(context, this.awsConfiguration));
            if (this.signInProviderConfig == null) {
                registerConfigSignInProviders(this.awsConfiguration);
            } else {
                registerUserSignInProvidersWithPermissions();
            }
            resumeSession((Activity) context, startupAuthResultHandler);
        } catch (Exception e) {
            Log.e(TAG, "Error occurred in fetching the Cognito Identity and resuming the auth session", e);
        }
    }

    private Tokens getHostedUITokens() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(new a(this, internalCallback));
    }

    public static synchronized AWSMobileClient getInstance() {
        AWSMobileClient aWSMobileClient;
        synchronized (AWSMobileClient.class) {
            try {
                if (singleton == null) {
                    singleton = new AWSMobileClient();
                }
                aWSMobileClient = singleton;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aWSMobileClient;
    }

    private boolean hasFederatedToken(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        boolean equals = str2.equals(this.mFederatedLoginsMap.get(str));
        Log.d(TAG, "hasFederatedToken: " + equals + " provider: " + str);
        return equals;
    }

    private void initializeWithBuilder(InitializeBuilder initializeBuilder) {
        if (initializeBuilder.getAwsConfiguration() != null) {
            this.awsConfiguration = initializeBuilder.getAwsConfiguration();
        }
        if (initializeBuilder.getSignInProviderConfig() != null) {
            this.signInProviderConfig = initializeBuilder.getSignInProviderConfig();
        }
        try {
            fetchCognitoIdentity(initializeBuilder.getContext(), this.startupAuthResultHandler);
        } catch (Exception unused) {
            Log.e(TAG, "Error in initializing the AWSMobileClient. Check if AWS Cloud Config `awsconfiguration.json` is present in the application.");
        }
    }

    private boolean isConfigurationKeyPresent(String str) {
        return isConfigurationKeyPresent(str, this.awsConfiguration);
    }

    private /* synthetic */ void lambda$_deleteUser$0(Callback callback) {
        CognitoUserPool cognitoUserPool = this.userpool;
        if (cognitoUserPool == null) {
            callback.onError(new InvalidUserPoolConfigurationException("A user pool must be configured in order to delete a user."));
        } else {
            cognitoUserPool.getCurrentUser().deleteUserInBackground(new 10(callback));
        }
    }

    private void registerConfigSignInProviders(AWSConfiguration aWSConfiguration) {
        Log.d(TAG, "Using the SignInProviderConfig from `awsconfiguration.json`.");
        IdentityManager defaultIdentityManager = IdentityManager.getDefaultIdentityManager();
        try {
            if (isConfigurationKeyPresent("CognitoUserPool", aWSConfiguration)) {
                defaultIdentityManager.addSignInProvider(CognitoUserPoolsSignInProvider.class);
            }
            if (isConfigurationKeyPresent("FacebookSignIn", aWSConfiguration)) {
                defaultIdentityManager.addSignInProvider(FacebookSignInProvider.class);
            }
            if (isConfigurationKeyPresent("GoogleSignIn", aWSConfiguration)) {
                defaultIdentityManager.addSignInProvider(GoogleSignInProvider.class);
            }
        } catch (NoClassDefFoundError unused) {
        }
    }

    private void registerUserSignInProvidersWithPermissions() {
        Log.d(TAG, "Using the SignInProviderConfig supplied by the user.");
        IdentityManager defaultIdentityManager = IdentityManager.getDefaultIdentityManager();
        for (SignInProviderConfig signInProviderConfig : this.signInProviderConfig) {
            defaultIdentityManager.addSignInProvider(signInProviderConfig.getSignInProviderClass());
            if (signInProviderConfig.getProviderPermissions() != null) {
                if (FacebookSignInProvider.class.isInstance(signInProviderConfig.getSignInProviderClass())) {
                    FacebookSignInProvider.setPermissions(signInProviderConfig.getProviderPermissions());
                }
                if (GoogleSignInProvider.class.isInstance(signInProviderConfig.getSignInProviderClass())) {
                    GoogleSignInProvider.setPermissions(signInProviderConfig.getProviderPermissions());
                }
            }
        }
    }

    private void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        IdentityManager.getDefaultIdentityManager().resumeSession(activity, startupAuthResultHandler);
    }

    public ReturningRunnable _currentUserState() {
        return new 5();
    }

    public String _getCachedIdentityId() {
        return this.mStore.get("cognitoIdentityId");
    }

    public Runnable _initialize(Context context, AWSConfiguration aWSConfiguration, Callback callback) {
        return new 2(callback, aWSConfiguration, context);
    }

    public void addUserStateListener(UserStateListener userStateListener) {
        synchronized (this.listeners) {
            this.listeners.add(userStateListener);
        }
    }

    public void changePassword(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_changePassword(str, str2, internalCallback));
    }

    public ForgotPasswordResult confirmForgotPassword(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_confirmForgotPassword(str, str2, Collections.emptyMap(), internalCallback));
    }

    public SignInResult confirmSignIn(String str) throws Exception {
        return confirmSignIn(str, Collections.emptyMap());
    }

    public com.amazonaws.mobile.client.results.SignUpResult confirmSignUp(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (com.amazonaws.mobile.client.results.SignUpResult) internalCallback.await(_confirmSignUp(str, str2, Collections.emptyMap(), internalCallback));
    }

    public void confirmUpdateUserAttribute(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmVerifyUserAttribute(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_confirmUserAttribute(str, str2, internalCallback));
    }

    public UserStateDetails currentUserState() {
        try {
            return (UserStateDetails) _currentUserState().await();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user state.", e);
        }
    }

    public void deleteUser() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_deleteUser(internalCallback));
    }

    public void federateWithCognitoIdentity(String str, String str2) {
        synchronized (this.federateWithCognitoIdentityLockObject) {
            try {
                if (!hasFederatedToken(str, str2)) {
                    if (IdentityProvider.DEVELOPER.equals(str)) {
                        this.provider.setDeveloperAuthenticated(this.mStore.get("cognitoIdentityId"), str2);
                    } else {
                        this.provider.setNotDeveloperAuthenticated();
                    }
                    String str3 = this.mStore.get("customRoleArn");
                    if (!StringUtils.isBlank(str3)) {
                        this.cognitoIdentity.setCustomRoleArn(str3);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(str, str2);
                    this.cognitoIdentity.setLogins(hashMap);
                    this.cognitoIdentity.refresh();
                    this.mStore.set("cognitoIdentityId", this.cognitoIdentity.getIdentityId());
                    this.mFederatedLoginsMap = this.cognitoIdentity.getLogins();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public UserStateDetails federatedSignIn(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_federatedSignIn(str, str2, null, internalCallback, true));
    }

    public void federatedSignInWithoutAssigningState(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_federatedSignIn(str, str2, null, internalCallback, false));
    }

    public ForgotPasswordResult forgotPassword(String str) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_forgotPassword(str, Collections.emptyMap(), internalCallback));
    }

    public AWSCredentials getAWSCredentials() throws Exception {
        return (AWSCredentials) _getAWSCredentials().await();
    }

    public AWSConfigurable getClient(Context context, Class cls) {
        String str = TAG;
        Log.d(str, "Retrieving the client instance for class: " + cls);
        AWSConfigurable aWSConfigurable = (AWSConfigurable) this.clientMap.get(cls);
        if (aWSConfigurable != null) {
            return aWSConfigurable;
        }
        try {
            aWSConfigurable = ((AWSConfigurable) cls.newInstance()).initialize(context.getApplicationContext(), this.awsConfiguration);
            this.clientMap.put(cls, aWSConfigurable);
            Log.d(str, "Created the new client: " + aWSConfigurable.toString());
            return aWSConfigurable;
        } catch (Exception e) {
            Log.e(TAG, "Error occurred in creating and initializing client. Check the context and the clientClass passed in: " + cls, e);
            return aWSConfigurable;
        }
    }

    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }

    public AWSCredentials getCredentials() {
        if (isLegacyMode()) {
            return IdentityManager.getDefaultIdentityManager().getCredentialsProvider().getCredentials();
        }
        if (this.cognitoIdentity == null) {
            throw new AmazonClientException("Cognito Identity not configured");
        }
        try {
            if (waitForSignIn()) {
                Log.d(TAG, "getCredentials: Validated user is signed-in");
            }
            AWSSessionCredentials credentials = this.cognitoIdentity.getCredentials();
            this.mStore.set("cognitoIdentityId", this.cognitoIdentity.getIdentityId());
            return credentials;
        } catch (NotAuthorizedException e) {
            Log.w(TAG, "getCredentials: Failed to getCredentials from Cognito Identity", e);
            throw new AmazonClientException("Failed to get credentials from Cognito Identity", e);
        } catch (Exception e2) {
            throw new AmazonClientException("Failed to get credentials from Cognito Identity", e2);
        }
    }

    public DeviceOperations getDeviceOperations() {
        DeviceOperations deviceOperations = this.mDeviceOperations;
        if (deviceOperations != null) {
            return deviceOperations;
        }
        throw new AmazonClientException("Please check if userpools is configured.");
    }

    public Auth.Builder getHostedUI(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("Scopes");
        Set hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return new Auth.Builder().setApplicationContext(this.mContext).setUserPoolId(this.mUserPoolPoolId).setAppClientId(jSONObject.getString("AppClientId")).setAppClientSecret(jSONObject.optString("AppClientSecret", (String) null)).setAppCognitoWebDomain(jSONObject.getString("WebDomain")).setSignInRedirect(jSONObject.getString("SignInRedirectURI")).setSignOutRedirect(jSONObject.getString("SignOutRedirectURI")).setScopes(hashSet).setAdvancedSecurityDataCollection(false).setIdentityProvider(jSONObject.optString("IdentityProvider")).setIdpIdentifier(jSONObject.optString("IdpIdentifier"));
    }

    public JSONObject getHostedUIJSON() {
        return getHostedUIJSON(this.awsConfiguration);
    }

    public JSONObject getHostedUIJSONFromJSON() {
        return getHostedUIJSONFromJSON(this.awsConfiguration);
    }

    public String getIdentityId() {
        if (isLegacyMode()) {
            return IdentityManager.getDefaultIdentityManager().getCachedUserID();
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider == null) {
            throw new RuntimeException("Cognito Identity not configured");
        }
        String cachedIdentityId = cognitoCachingCredentialsProvider.getCachedIdentityId();
        return cachedIdentityId == null ? this.mStore.get("cognitoIdentityId") : cachedIdentityId;
    }

    public String getLoginKey() {
        return this.userpoolsLoginKey;
    }

    public Map getSignInDetailsMap() {
        return this.mStore.get("provider", "token");
    }

    public SignInMode getSignInMode() {
        return SignInMode.fromString(this.mStore.get("signInMode"));
    }

    public CountDownLatch getSignInUILatch() {
        return this.showSignInWaitLatch;
    }

    public Tokens getTokens() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(_getTokens(internalCallback, false));
    }

    public Map getUserAttributes() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Map) internalCallback.await(_getUserAttributes(internalCallback));
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    public com.amazonaws.mobile.client.UserStateDetails getUserStateDetails(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r13v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    public String getUserSub() {
        try {
            if (this.userpoolsLoginKey.equals(this.mStore.get("provider"))) {
                return CognitoJWTParser.getClaim(this.mStore.get("token"), "sub");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getUsername() {
        try {
            if (this.userpoolsLoginKey.equals(this.mStore.get("provider"))) {
                return this.userpool.getCurrentUser().getUserId();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean handleAuthResponse(Intent intent) {
        Auth auth = this.hostedUI;
        if (auth == null) {
            OAuth2Client oAuth2Client = this.mOAuth2Client;
            return (oAuth2Client == null || intent == null || !oAuth2Client.handleRedirect(intent.getData())) ? false : true;
        }
        if (intent != null) {
            auth.getTokens(intent.getData());
        } else {
            auth.handleFlowCancelled();
        }
        return true;
    }

    public void initialize(Context context, Callback callback) {
        Context applicationContext = context.getApplicationContext();
        initialize(applicationContext, new AWSConfiguration(applicationContext), callback);
    }

    public boolean isFederationEnabled() {
        String str = this.mStore.get("isFederationEnabled");
        if (str != null) {
            return str.equals("true");
        }
        return true;
    }

    public boolean isLegacyMode() {
        return this.mIsLegacyMode;
    }

    public boolean isNetworkAvailable(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && E.b.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Could not access network state", e);
        }
        return false;
    }

    public boolean isSignedIn() {
        int i = 29.$SwitchMap$com$amazonaws$mobile$client$UserState[getUserStateDetails(true).getUserState().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        if (i == 4 || i == 5) {
            return false;
        }
        throw new IllegalStateException("Unknown user state, please report this exception");
    }

    public boolean isSignedOutRelatedException(Exception exc) {
        if (exc == null) {
            return false;
        }
        if (exc instanceof NotAuthorizedException) {
            return true;
        }
        return "No cached session.".equals(exc.getMessage()) && exc.getCause() == null;
    }

    public boolean isUserpoolsSignedIn() {
        return this.userpoolsLoginKey.equals(this.mStore.get("provider"));
    }

    public void refresh() {
        if (isLegacyMode()) {
            IdentityManager.getDefaultIdentityManager().getCredentialsProvider().refresh();
            return;
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider == null) {
            throw new AmazonClientException("Cognito Identity not configured");
        }
        cognitoCachingCredentialsProvider.refresh();
        this.mStore.set("cognitoIdentityId", this.cognitoIdentity.getIdentityId());
    }

    public void releaseSignInWait() {
        if (this.mSignedOutWaitLatch != null) {
            this.mSignedOutWaitLatch.countDown();
        }
    }

    public boolean removeUserStateListener(UserStateListener userStateListener) {
        synchronized (this.listeners) {
            try {
                int indexOf = this.listeners.indexOf(userStateListener);
                if (indexOf == -1) {
                    return false;
                }
                this.listeners.remove(indexOf);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public com.amazonaws.mobile.client.results.SignUpResult resendSignUp(String str) throws Exception {
        return resendSignUp(str, Collections.emptyMap());
    }

    public void setUserPool(CognitoUserPool cognitoUserPool) {
        this.userpool = cognitoUserPool;
    }

    public void setUserState(UserStateDetails userStateDetails) {
        boolean z = !userStateDetails.equals(this.userStateDetails);
        this.userStateDetails = userStateDetails;
        if (z) {
            synchronized (this.listeners) {
                try {
                    Iterator it = this.listeners.iterator();
                    while (it.hasNext()) {
                        new Thread(new 4((UserStateListener) it.next(), userStateDetails)).start();
                    }
                } finally {
                }
            }
        }
    }

    public UserStateDetails showSignIn(Activity activity) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_showSignIn(activity, SignInUIOptions.builder().build(), internalCallback));
    }

    public SignInResult signIn(String str, String str2, Map map) throws Exception {
        return signIn(str, str2, map, Collections.emptyMap());
    }

    public void signOut() {
        String str = null;
        this.mCognitoUserSession = null;
        CognitoUserPool cognitoUserPool = this.userpool;
        if (cognitoUserPool != null) {
            cognitoUserPool.getCurrentUser().signOut();
            this.userpool.getUser().signOut();
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            cognitoCachingCredentialsProvider.clear();
        }
        if (IdentityManager.getDefaultIdentityManager() != null) {
            IdentityManager.getDefaultIdentityManager().signOut();
        }
        this.mFederatedLoginsMap.clear();
        this.mStore.clear();
        if (this.awsConfiguration.optJsonObject("Auth") != null && this.awsConfiguration.optJsonObject("Auth").has("OAuth")) {
            try {
                str = this.awsConfiguration.optJsonObject("Auth").getJSONObject("OAuth").toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Auth auth = this.hostedUI;
            if (auth != null) {
                auth.signOut(true);
            }
            OAuth2Client oAuth2Client = this.mOAuth2Client;
            if (oAuth2Client != null) {
                oAuth2Client.signOut();
            }
        }
        this.mStore.set("hostedUI", str);
        setUserState(getUserStateDetails(false));
        releaseSignInWait();
    }

    public com.amazonaws.mobile.client.results.SignUpResult signUp(String str, String str2, Map map, Map map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (com.amazonaws.mobile.client.results.SignUpResult) internalCallback.await(_signUp(str, str2, map, map2, Collections.emptyMap(), internalCallback));
    }

    public List updateUserAttributes(Map map) throws Exception {
        return updateUserAttributes(map, Collections.emptyMap());
    }

    public UserCodeDeliveryDetails verifyUserAttribute(String str) throws Exception {
        return verifyUserAttribute(str, Collections.emptyMap());
    }

    public boolean waitForSignIn() {
        try {
            try {
                this.mWaitForSignInLock.lock();
                this.mSignedOutWaitLatch = new CountDownLatch(1);
                boolean z = false;
                UserStateDetails userStateDetails = getUserStateDetails(false);
                Log.d(TAG, "waitForSignIn: userState:" + userStateDetails.getUserState());
                int i = 29.$SwitchMap$com$amazonaws$mobile$client$UserState[userStateDetails.getUserState().ordinal()];
                if (i == 1) {
                    setUserState(userStateDetails);
                    return true;
                }
                if (i == 2 || i == 3) {
                    if (userStateDetails.getException() != null && !isSignedOutRelatedException(userStateDetails.getException())) {
                        throw userStateDetails.getException();
                    }
                    setUserState(userStateDetails);
                    this.mSignedOutWaitLatch.await();
                    z = getUserStateDetails(false).getUserState().equals(UserState.SIGNED_IN);
                } else {
                    if (i != 4 && i != 5) {
                        return false;
                    }
                    setUserState(userStateDetails);
                }
                return z;
            } catch (Exception e) {
                throw new AmazonClientException("Operation requires a signed-in state", e);
            }
        } finally {
            this.mWaitForSignInLock.unlock();
        }
    }

    private Runnable _confirmSignIn(Map map, Callback callback, Map map2) {
        return new 8(callback, map, map2);
    }

    public static synchronized AWSMobileClient getInstance(boolean z) {
        AWSMobileClient aWSMobileClient;
        synchronized (AWSMobileClient.class) {
            if (z) {
                try {
                    singleton = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            aWSMobileClient = new AWSMobileClient();
        }
        return aWSMobileClient;
    }

    private boolean isConfigurationKeyPresent(String str, AWSConfiguration aWSConfiguration) {
        try {
            JSONObject optJsonObject = aWSConfiguration.optJsonObject(str);
            if (!str.equals("GoogleSignIn")) {
                return optJsonObject != null;
            }
            if (optJsonObject != null) {
                return optJsonObject.getString("ClientId-WebApp") != null;
            }
            return false;
        } catch (Exception unused) {
            Log.d(TAG, str + " not found in `awsconfiguration.json`");
            return false;
        }
    }

    public void changePassword(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_changePassword(str, str2, internalCallback));
    }

    public ForgotPasswordResult confirmForgotPassword(String str, Map map, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_confirmForgotPassword(str, str2, map, internalCallback));
    }

    public SignInResult confirmSignIn(String str, Map map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(str, map, Collections.emptyMap(), internalCallback));
    }

    public com.amazonaws.mobile.client.results.SignUpResult confirmSignUp(String str, String str2, Map map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (com.amazonaws.mobile.client.results.SignUpResult) internalCallback.await(_confirmSignUp(str, str2, map, internalCallback));
    }

    public void confirmUpdateUserAttribute(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmVerifyUserAttribute(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void currentUserState(Callback callback) {
        _currentUserState().async(callback);
    }

    public void deleteUser(Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_deleteUser(internalCallback));
    }

    public UserStateDetails federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_federatedSignIn(str, str2, federatedSignInOptions, internalCallback, true));
    }

    public void federatedSignInWithoutAssigningState(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, null, internalCallback, false));
    }

    public ForgotPasswordResult forgotPassword(String str, Map map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_forgotPassword(str, map, internalCallback));
    }

    public void getAWSCredentials(Callback callback) {
        _getAWSCredentials().async(callback);
    }

    public JSONObject getHostedUIJSON(AWSConfiguration aWSConfiguration) {
        JSONObject jSONObject;
        try {
            JSONObject hostedUIJSONFromJSON = getHostedUIJSONFromJSON(aWSConfiguration);
            try {
                jSONObject = new JSONObject(this.mStore.get("hostedUI"));
            } catch (Exception e) {
                Log.w(TAG, "Failed to parse HostedUI settings from store", e);
                jSONObject = null;
            }
            if (hostedUIJSONFromJSON == null) {
                return jSONObject;
            }
            if (jSONObject != null && jSONObject.toString() == hostedUIJSONFromJSON.toString()) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(hostedUIJSONFromJSON.toString());
            this.mStore.set("hostedUI", jSONObject2.toString());
            return jSONObject2;
        } catch (Exception e2) {
            Log.d(TAG, "getHostedUIJSON: Failed to read config", e2);
            return null;
        }
    }

    public JSONObject getHostedUIJSONFromJSON(AWSConfiguration aWSConfiguration) {
        JSONObject optJsonObject = aWSConfiguration.optJsonObject("Auth");
        if (optJsonObject == null || !optJsonObject.has("OAuth")) {
            return null;
        }
        try {
            return optJsonObject.getJSONObject("OAuth");
        } catch (Exception e) {
            Log.w(TAG, "getHostedUIJSONFromJSON: Failed to read config", e);
            return null;
        }
    }

    public Tokens getTokens(boolean z) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(_getTokens(internalCallback, z));
    }

    public void getUserAttributes(Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_getUserAttributes(internalCallback));
    }

    public void initialize(Context context, AWSConfiguration aWSConfiguration, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_initialize(context, aWSConfiguration, internalCallback));
    }

    public com.amazonaws.mobile.client.results.SignUpResult resendSignUp(String str, Map map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (com.amazonaws.mobile.client.results.SignUpResult) internalCallback.await(_resendSignUp(str, map, internalCallback));
    }

    public UserStateDetails showSignIn(Activity activity, SignInUIOptions signInUIOptions) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_showSignIn(activity, signInUIOptions, internalCallback));
    }

    public SignInResult signIn(String str, String str2, Map map, Map map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_signIn(str, str2, map, map2, null, internalCallback));
    }

    public void signOut(SignOutOptions signOutOptions) throws Exception {
        _signOut(signOutOptions).await();
    }

    public com.amazonaws.mobile.client.results.SignUpResult signUp(String str, String str2, Map map, Map map2, Map map3) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (com.amazonaws.mobile.client.results.SignUpResult) internalCallback.await(_signUp(str, str2, map, map3, map2, internalCallback));
    }

    public List updateUserAttributes(Map map, Map map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (List) internalCallback.await(_updateUserAttributes(map, map2, internalCallback));
    }

    public UserCodeDeliveryDetails verifyUserAttribute(String str, Map map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserCodeDeliveryDetails) internalCallback.await(_verifyUserAttribute(str, map, internalCallback));
    }

    @Deprecated
    public void confirmForgotPassword(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmForgotPassword(str, str2, Collections.emptyMap(), internalCallback));
    }

    public SignInResult confirmSignIn(String str, Map map, Map map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(str, map, map2, internalCallback));
    }

    public void confirmSignUp(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignUp(str, str2, Collections.emptyMap(), internalCallback));
    }

    public void federatedSignIn(String str, String str2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, null, internalCallback, true));
    }

    public void forgotPassword(String str, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_forgotPassword(str, Collections.emptyMap(), internalCallback));
    }

    public void getTokens(Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_getTokens(internalCallback, false));
    }

    public void resendSignUp(String str, Callback callback) {
        resendSignUp(str, Collections.emptyMap(), callback);
    }

    public void showSignIn(Activity activity, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_showSignIn(activity, SignInUIOptions.builder().build(), internalCallback));
    }

    public SignInResult signIn(String str, String str2, Map map, Map map2, AuthFlowType authFlowType) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_signIn(str, str2, map, map2, authFlowType, internalCallback));
    }

    public void signOut(SignOutOptions signOutOptions, Callback callback) {
        _signOut(signOutOptions).async(callback);
    }

    public void signUp(String str, String str2, Map map, Map map2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signUp(str, str2, map, map2, Collections.emptyMap(), internalCallback));
    }

    public void updateUserAttributes(Map map, Callback callback) {
        updateUserAttributes(map, Collections.emptyMap(), callback);
    }

    public void verifyUserAttribute(String str, Callback callback) {
        verifyUserAttribute(str, Collections.emptyMap(), callback);
    }

    public void confirmForgotPassword(String str, String str2, String str3, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        this.forgotPasswordContinuation = new ForgotPasswordContinuation(this.userpool.getUser(str), null, true, new 18(callback));
        internalCallback.async(_confirmForgotPassword(str2, str3, Collections.emptyMap(), internalCallback));
    }

    public SignInResult confirmSignIn(Map map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(map, internalCallback, null));
    }

    public void confirmSignUp(String str, String str2, Map map, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignUp(str, str2, map, internalCallback));
    }

    public void federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, federatedSignInOptions, internalCallback, true));
    }

    public void forgotPassword(String str, Map map, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_forgotPassword(str, map, internalCallback));
    }

    public void resendSignUp(String str, Map map, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_resendSignUp(str, map, internalCallback));
    }

    public void showSignIn(Activity activity, SignInUIOptions signInUIOptions, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_showSignIn(activity, signInUIOptions, internalCallback));
    }

    public void signIn(String str, String str2, Map map, Callback callback) {
        signIn(str, str2, map, Collections.emptyMap(), callback);
    }

    public void signUp(String str, String str2, Map map, Map map2, Map map3, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signUp(str, str2, map, map2, map3, internalCallback));
    }

    public void updateUserAttributes(Map map, Map map2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_updateUserAttributes(map, map2, internalCallback));
    }

    public void verifyUserAttribute(String str, Map map, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_verifyUserAttribute(str, map, internalCallback));
    }

    public void confirmForgotPassword(String str, String str2, Map map, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmForgotPassword(str, str2, map, internalCallback));
    }

    public SignInResult confirmSignIn(Map map, Map map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(map, internalCallback, map2));
    }

    public void signIn(String str, String str2, Map map, Map map2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signIn(str, str2, map, map2, null, internalCallback));
    }

    public void confirmSignIn(String str, Callback callback) {
        confirmSignIn(str, Collections.emptyMap(), callback);
    }

    public void signIn(String str, String str2, Map map, Map map2, AuthFlowType authFlowType, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signIn(str, str2, map, map2, authFlowType, internalCallback));
    }

    public void confirmSignIn(String str, Map map, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(str, map, Collections.emptyMap(), internalCallback));
    }

    public void confirmSignIn(String str, Map map, Map map2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(str, map, map2, internalCallback));
    }

    public void confirmSignIn(Map map, Callback callback) {
        confirmSignIn(map, (Map) null, callback);
    }

    public void confirmSignIn(Map map, Map map2, Callback callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(map, internalCallback, map2));
    }
}
