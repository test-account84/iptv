package com.amazonaws.mobileconnectors.cognitoauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.cognito.clientcontext.data.UserContextDataProvider;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthClientException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthInvalidGrantException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthNavigationException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthServiceException;
import com.amazonaws.mobileconnectors.cognitoauth.handlers.AuthHandler;
import com.amazonaws.mobileconnectors.cognitoauth.util.AuthHttpClient;
import com.amazonaws.mobileconnectors.cognitoauth.util.AuthHttpResponseParser;
import com.amazonaws.mobileconnectors.cognitoauth.util.LocalDataManager;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p.c;
import p.d;
import p.e;
import p.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthClient {
    private static final String BAD_REQUEST_ERROR = "invalid_request";
    public static final int CUSTOM_TABS_ACTIVITY_CODE = 49281;
    private static final String REDIRECT_ACTIVITY_NAME = "HostedUIRedirectActivity";
    private static final long REDIRECT_TIMEOUT_SECONDS = 10;
    private static final String TAG = "AuthClient";
    private final Context context;
    private CountDownLatch cookiesCleared;
    private String customTabsPackageName;
    private boolean isBrowserInstalled;
    private boolean isCustomTabSupported;
    private boolean isRedirectActivityDeclared;
    private c mCustomTabsClient;
    private d mCustomTabsIntent;
    private e mCustomTabsServiceConnection;
    private f mCustomTabsSession;
    private final Auth pool;
    private String proofKey;
    private String proofKeyHash;
    private String state;
    private AuthHandler userHandler;
    private String userId;

    public class 1 implements Runnable {
        final Handler handler;
        Runnable returnCallback = new 1();
        final /* synthetic */ AuthHandler val$callback;
        final /* synthetic */ Uri val$uri;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                1.this.val$callback.onFailure(new InvalidParameterException());
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ String val$errorMessage;

            public 2(String str) {
                this.val$errorMessage = str;
            }

            public void run() {
                1.this.val$callback.onFailure(new AuthServiceException(this.val$errorMessage));
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ AuthUserSession val$session;

            public 3(AuthUserSession authUserSession) {
                this.val$session = authUserSession;
            }

            public void run() {
                1.this.val$callback.onSuccess(this.val$session);
            }
        }

        public class 4 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 4(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                1.this.val$callback.onFailure(this.val$e);
            }
        }

        public class 5 implements Runnable {
            public 5() {
            }

            public void run() {
                1.this.val$callback.onSignout();
            }
        }

        public 1(AuthHandler authHandler, Uri uri) {
            this.val$callback = authHandler;
            this.val$uri = uri;
            this.handler = new Handler(AuthClient.access$000(AuthClient.this).getMainLooper());
        }

        public void run() {
            Runnable runnable;
            Uri build = new Uri.Builder().scheme("https").authority(AuthClient.access$100(AuthClient.this).getAppWebDomain()).appendPath("oauth2").appendPath("token").build();
            String queryParameter = this.val$uri.getQueryParameter("state");
            if (queryParameter != null) {
                Set cachedScopes = LocalDataManager.getCachedScopes(AuthClient.access$100(AuthClient.this).awsKeyValueStore, AuthClient.access$000(AuthClient.this), queryParameter);
                String cachedProofKey = LocalDataManager.getCachedProofKey(AuthClient.access$100(AuthClient.this).awsKeyValueStore, AuthClient.access$000(AuthClient.this), queryParameter);
                if (cachedProofKey == null) {
                    return;
                }
                String queryParameter2 = this.val$uri.getQueryParameter("error");
                if (queryParameter2 == null) {
                    try {
                        AuthUserSession parseHttpResponse = AuthHttpResponseParser.parseHttpResponse(new AuthHttpClient().httpPost(new URL(build.toString()), AuthClient.access$200(AuthClient.this), AuthClient.access$300(AuthClient.this, this.val$uri, cachedProofKey)));
                        AuthClient.access$402(AuthClient.this, parseHttpResponse.getUsername());
                        LocalDataManager.cacheSession(AuthClient.access$100(AuthClient.this).awsKeyValueStore, AuthClient.access$000(AuthClient.this), AuthClient.access$100(AuthClient.this).getAppId(), AuthClient.access$400(AuthClient.this), parseHttpResponse, cachedScopes);
                        this.returnCallback = new 3(parseHttpResponse);
                    } catch (Exception e) {
                        this.returnCallback = new 4(e);
                    }
                    this.handler.post(this.returnCallback);
                }
                String queryParameter3 = this.val$uri.getQueryParameter("error_description");
                if (queryParameter2.equals("invalid_request") && queryParameter3 != null) {
                    queryParameter2 = queryParameter3.trim();
                }
                runnable = new 2(queryParameter2);
            } else {
                if (AuthClient.access$500(AuthClient.this) != null) {
                    AuthClient.access$500(AuthClient.this).countDown();
                    Log.d(AuthClient.access$600(), "Sign-out was successful.");
                }
                runnable = new 5();
            }
            this.returnCallback = runnable;
            this.handler.post(this.returnCallback);
        }
    }

    public class 2 implements Runnable {
        final Handler handler;
        Runnable returnCallback;
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String val$browserPackage;
        final /* synthetic */ AuthHandler val$callback;
        final /* synthetic */ String val$redirectUri;
        final /* synthetic */ AuthUserSession val$session;
        final /* synthetic */ boolean val$showSignInIfExpired;
        final /* synthetic */ Set val$tokenScopes;

        public class 1 implements Runnable {
            final /* synthetic */ AuthUserSession val$refreshedSession;

            public 1(AuthUserSession authUserSession) {
                this.val$refreshedSession = authUserSession;
            }

            public void run() {
                2.this.val$callback.onSuccess(this.val$refreshedSession);
            }
        }

        public class 2 implements Runnable {
            public 2() {
            }

            public void run() {
                2 r0 = 2.this;
                AuthClient.access$800(AuthClient.this, r0.val$redirectUri, r0.val$tokenScopes, r0.val$activity, r0.val$browserPackage);
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ AuthInvalidGrantException val$invg;

            public 3(AuthInvalidGrantException authInvalidGrantException) {
                this.val$invg = authInvalidGrantException;
            }

            public void run() {
                AuthClient.access$900(AuthClient.this).onFailure(this.val$invg);
            }
        }

        public class 4 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 4(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                2.this.val$callback.onFailure(this.val$e);
            }
        }

        public 2(String str, AuthUserSession authUserSession, AuthHandler authHandler, boolean z, Set set, Activity activity, String str2) {
            this.val$redirectUri = str;
            this.val$session = authUserSession;
            this.val$callback = authHandler;
            this.val$showSignInIfExpired = z;
            this.val$tokenScopes = set;
            this.val$activity = activity;
            this.val$browserPackage = str2;
            this.handler = new Handler(AuthClient.access$000(AuthClient.this).getMainLooper());
        }

        public void run() {
            Runnable runnable;
            Uri build = new Uri.Builder().scheme("https").authority(AuthClient.access$100(AuthClient.this).getAppWebDomain()).appendPath("oauth2").appendPath("token").build();
            try {
                AuthUserSession parseHttpResponse = AuthHttpResponseParser.parseHttpResponse(new AuthHttpClient().httpPost(new URL(build.toString()), AuthClient.access$200(AuthClient.this), AuthClient.access$700(AuthClient.this, this.val$redirectUri, this.val$session)));
                AuthUserSession authUserSession = new AuthUserSession(parseHttpResponse.getIdToken(), parseHttpResponse.getAccessToken(), this.val$session.getRefreshToken());
                LocalDataManager.cacheSession(AuthClient.access$100(AuthClient.this).awsKeyValueStore, AuthClient.access$000(AuthClient.this), AuthClient.access$100(AuthClient.this).getAppId(), authUserSession.getUsername(), authUserSession, AuthClient.access$100(AuthClient.this).getScopes());
                this.returnCallback = new 1(authUserSession);
            } catch (AuthInvalidGrantException e) {
                if (this.val$showSignInIfExpired) {
                    this.returnCallback = new 2();
                } else {
                    runnable = new 3(e);
                    this.returnCallback = runnable;
                }
            } catch (Exception e2) {
                runnable = new 4(e2);
                this.returnCallback = runnable;
            }
            this.handler.post(this.returnCallback);
        }
    }

    public class 3 extends e {
        public 3() {
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, c cVar) {
            AuthClient.access$1002(AuthClient.this, cVar);
            AuthClient.access$1000(AuthClient.this).g(0L);
            AuthClient authClient = AuthClient.this;
            AuthClient.access$1102(authClient, AuthClient.access$1000(authClient).e(null));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            AuthClient.access$1002(AuthClient.this, null);
        }
    }

    public AuthClient(Context context, Auth auth) {
        this(context, auth, null);
    }

    public static /* synthetic */ Context access$000(AuthClient authClient) {
        return authClient.context;
    }

    public static /* synthetic */ Auth access$100(AuthClient authClient) {
        return authClient.pool;
    }

    public static /* synthetic */ c access$1000(AuthClient authClient) {
        return authClient.mCustomTabsClient;
    }

    public static /* synthetic */ c access$1002(AuthClient authClient, c cVar) {
        authClient.mCustomTabsClient = cVar;
        return cVar;
    }

    public static /* synthetic */ f access$1102(AuthClient authClient, f fVar) {
        authClient.mCustomTabsSession = fVar;
        return fVar;
    }

    public static /* synthetic */ Map access$200(AuthClient authClient) {
        return authClient.getHttpHeader();
    }

    public static /* synthetic */ Map access$300(AuthClient authClient, Uri uri, String str) {
        return authClient.generateTokenExchangeRequest(uri, str);
    }

    public static /* synthetic */ String access$400(AuthClient authClient) {
        return authClient.userId;
    }

    public static /* synthetic */ String access$402(AuthClient authClient, String str) {
        authClient.userId = str;
        return str;
    }

    public static /* synthetic */ CountDownLatch access$500(AuthClient authClient) {
        return authClient.cookiesCleared;
    }

    public static /* synthetic */ String access$600() {
        return TAG;
    }

    public static /* synthetic */ Map access$700(AuthClient authClient, String str, AuthUserSession authUserSession) {
        return authClient.generateTokenRefreshRequest(str, authUserSession);
    }

    public static /* synthetic */ void access$800(AuthClient authClient, String str, Set set, Activity activity, String str2) {
        authClient.launchCognitoAuth(str, set, activity, str2);
    }

    public static /* synthetic */ AuthHandler access$900(AuthClient authClient) {
        return authClient.userHandler;
    }

    private void endSession(String str) throws AuthClientException {
        try {
            this.cookiesCleared = new CountDownLatch(1);
            launchSignOut(this.pool.getSignOutRedirectUri(), str);
            if (!isRedirectActivityDeclared()) {
                this.cookiesCleared.countDown();
            }
            if (!this.cookiesCleared.await(10L, TimeUnit.SECONDS)) {
                throw new AuthServiceException("Timed out while waiting for sign-out redirect response.");
            }
        } catch (InterruptedException unused) {
            throw new AuthNavigationException("User cancelled sign-out.");
        }
    }

    private Map generateTokenExchangeRequest(Uri uri, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "authorization_code");
        hashMap.put("client_id", this.pool.getAppId());
        hashMap.put("redirect_uri", this.pool.getSignInRedirectUri());
        hashMap.put("code_verifier", str);
        hashMap.put("code", uri.getQueryParameter("code"));
        return hashMap;
    }

    private Map generateTokenRefreshRequest(String str, AuthUserSession authUserSession) {
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "refresh_token");
        hashMap.put("redirect_uri", str);
        hashMap.put("client_id", this.pool.getAppId());
        hashMap.put("refresh_token", authUserSession.getRefreshToken().getToken());
        String userContextData = getUserContextData();
        if (userContextData != null) {
            hashMap.put("userContextData", userContextData);
        }
        return hashMap;
    }

    private Map getHttpHeader() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        if (this.pool.getAppSecret() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Basic ");
            sb.append(Pkce.encodeBase64(this.pool.getAppId() + ":" + this.pool.getAppSecret()));
            hashMap.put("Authorization", sb.toString());
        }
        return hashMap;
    }

    private List getSupportedCustomTabsPackages() {
        List queryIntentServices = this.context.getPackageManager().queryIntentServices(new Intent().setAction("android.support.customtabs.action.CustomTabsService"), 0);
        ArrayList arrayList = new ArrayList();
        Iterator it = queryIntentServices.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).serviceInfo.packageName);
        }
        return arrayList;
    }

    private String getUserContextData() {
        if (this.pool.isAdvancedSecurityDataCollectionEnabled()) {
            return UserContextDataProvider.getInstance().getEncodedContextData(this.context, this.userId, this.pool.getUserPoolId(), this.pool.getAppId());
        }
        return null;
    }

    private boolean isBrowserInstalled() {
        if (this.isBrowserInstalled) {
            return true;
        }
        if (new Intent("android.intent.action.VIEW", Uri.parse("https://docs.amplify.aws/")).resolveActivity(this.context.getPackageManager()) == null) {
            return false;
        }
        this.isBrowserInstalled = true;
        return true;
    }

    private boolean isCustomTabSupported() {
        if (this.isCustomTabSupported) {
            return true;
        }
        List supportedCustomTabsPackages = getSupportedCustomTabsPackages();
        if (supportedCustomTabsPackages.size() <= 0) {
            return false;
        }
        this.isCustomTabSupported = true;
        this.customTabsPackageName = c.c(this.context, supportedCustomTabsPackages);
        return true;
    }

    private boolean isRedirectActivityDeclared() {
        if (this.isRedirectActivityDeclared) {
            return true;
        }
        Context context = this.context;
        if (context == null) {
            Log.w(TAG, "Context is null. Failed to inspect packages.");
            return false;
        }
        try {
            Iterator it = context.getPackageManager().getInstalledPackages(1).iterator();
            while (it.hasNext()) {
                ActivityInfo[] activityInfoArr = ((PackageInfo) it.next()).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (activityInfo.name.contains("HostedUIRedirectActivity")) {
                            this.isRedirectActivityDeclared = true;
                            return true;
                        }
                    }
                }
            }
            Log.w(TAG, "HostedUIRedirectActivity is not declared in AndroidManifest.");
        } catch (Exception unused) {
            Log.w(TAG, "Failed to inspect packages.");
        }
        return false;
    }

    private void launchCognitoAuth(String str, Set set, Activity activity, String str2) {
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(this.pool.getAppWebDomain()).appendPath("oauth2").appendPath("authorize").appendQueryParameter("client_id", this.pool.getAppId()).appendQueryParameter("redirect_uri", str).appendQueryParameter("response_type", "code").appendQueryParameter("code_challenge", this.proofKeyHash).appendQueryParameter("code_challenge_method", "S256").appendQueryParameter("state", this.state).appendQueryParameter("userContextData", getUserContextData());
        if (!TextUtils.isEmpty(this.pool.getIdentityProvider())) {
            appendQueryParameter.appendQueryParameter("identity_provider", this.pool.getIdentityProvider());
        }
        if (!TextUtils.isEmpty(this.pool.getIdpIdentifier())) {
            appendQueryParameter.appendQueryParameter("idp_identifier", this.pool.getIdpIdentifier());
        }
        int size = set.size();
        if (size > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator it = set.iterator();
            int i = 0;
            while (it.hasNext()) {
                sb.append((String) it.next());
                int i2 = i + 1;
                if (i < size - 1) {
                    sb.append(" ");
                }
                i = i2;
            }
            appendQueryParameter.appendQueryParameter("scope", sb.toString());
        }
        Uri build = appendQueryParameter.build();
        LocalDataManager.cacheState(this.pool.awsKeyValueStore, this.context, this.state, this.proofKey, set);
        launchCustomTabs(build, activity, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[Catch: Exception -> 0x0013, TryCatch #0 {Exception -> 0x0013, blocks: (B:2:0x0000, B:4:0x0006, B:7:0x0015, B:9:0x002a, B:11:0x0039, B:12:0x003d, B:13:0x004a, B:15:0x0053, B:17:0x0064, B:19:0x0041, B:21:0x0045), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: Exception -> 0x0013, TRY_LEAVE, TryCatch #0 {Exception -> 0x0013, blocks: (B:2:0x0000, B:4:0x0006, B:7:0x0015, B:9:0x002a, B:11:0x0039, B:12:0x003d, B:13:0x004a, B:15:0x0053, B:17:0x0064, B:19:0x0041, B:21:0x0045), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void launchCustomTabs(android.net.Uri r3, android.app.Activity r4, java.lang.String r5) {
        /*
            r2 = this;
            boolean r0 = r2.isBrowserInstalled()     // Catch: java.lang.Exception -> L13
            if (r0 != 0) goto L15
            com.amazonaws.mobileconnectors.cognitoauth.handlers.AuthHandler r3 = r2.userHandler     // Catch: java.lang.Exception -> L13
            com.amazonaws.mobileconnectors.cognitoauth.exceptions.BrowserNotInstalledException r4 = new com.amazonaws.mobileconnectors.cognitoauth.exceptions.BrowserNotInstalledException     // Catch: java.lang.Exception -> L13
            java.lang.String r5 = "No browsers installed."
            r4.<init>(r5)     // Catch: java.lang.Exception -> L13
            r3.onFailure(r4)     // Catch: java.lang.Exception -> L13
            return
        L13:
            r3 = move-exception
            goto L79
        L15:
            p.d$a r0 = new p.d$a     // Catch: java.lang.Exception -> L13
            p.f r1 = r2.mCustomTabsSession     // Catch: java.lang.Exception -> L13
            r0.<init>(r1)     // Catch: java.lang.Exception -> L13
            p.d r0 = r0.a()     // Catch: java.lang.Exception -> L13
            r2.mCustomTabsIntent = r0     // Catch: java.lang.Exception -> L13
            com.amazonaws.mobileconnectors.cognitoauth.Auth r0 = r2.pool     // Catch: java.lang.Exception -> L13
            android.os.Bundle r0 = r0.getCustomTabExtras()     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto L37
            p.d r0 = r2.mCustomTabsIntent     // Catch: java.lang.Exception -> L13
            android.content.Intent r0 = r0.a     // Catch: java.lang.Exception -> L13
            com.amazonaws.mobileconnectors.cognitoauth.Auth r1 = r2.pool     // Catch: java.lang.Exception -> L13
            android.os.Bundle r1 = r1.getCustomTabExtras()     // Catch: java.lang.Exception -> L13
            r0.putExtras(r1)     // Catch: java.lang.Exception -> L13
        L37:
            if (r5 == 0) goto L41
            p.d r0 = r2.mCustomTabsIntent     // Catch: java.lang.Exception -> L13
            android.content.Intent r0 = r0.a     // Catch: java.lang.Exception -> L13
        L3d:
            r0.setPackage(r5)     // Catch: java.lang.Exception -> L13
            goto L4a
        L41:
            java.lang.String r5 = r2.customTabsPackageName     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L4a
            p.d r0 = r2.mCustomTabsIntent     // Catch: java.lang.Exception -> L13
            android.content.Intent r0 = r0.a     // Catch: java.lang.Exception -> L13
            goto L3d
        L4a:
            p.d r5 = r2.mCustomTabsIntent     // Catch: java.lang.Exception -> L13
            android.content.Intent r5 = r5.a     // Catch: java.lang.Exception -> L13
            r5.setData(r3)     // Catch: java.lang.Exception -> L13
            if (r4 == 0) goto L64
            android.content.Context r3 = r2.context     // Catch: java.lang.Exception -> L13
            p.d r5 = r2.mCustomTabsIntent     // Catch: java.lang.Exception -> L13
            android.content.Intent r5 = r5.a     // Catch: java.lang.Exception -> L13
            android.content.Intent r3 = com.amazonaws.mobileconnectors.cognitoauth.activities.CustomTabsManagerActivity.createStartIntent(r3, r5)     // Catch: java.lang.Exception -> L13
            r5 = 49281(0xc081, float:6.9057E-41)
            r4.startActivityForResult(r3, r5)     // Catch: java.lang.Exception -> L13
            goto L7e
        L64:
            android.content.Context r3 = r2.context     // Catch: java.lang.Exception -> L13
            p.d r4 = r2.mCustomTabsIntent     // Catch: java.lang.Exception -> L13
            android.content.Intent r4 = r4.a     // Catch: java.lang.Exception -> L13
            android.content.Intent r3 = com.amazonaws.mobileconnectors.cognitoauth.activities.CustomTabsManagerActivity.createStartIntent(r3, r4)     // Catch: java.lang.Exception -> L13
            r4 = 1342177280(0x50000000, float:8.5899346E9)
            r3.addFlags(r4)     // Catch: java.lang.Exception -> L13
            android.content.Context r4 = r2.context     // Catch: java.lang.Exception -> L13
            r4.startActivity(r3)     // Catch: java.lang.Exception -> L13
            goto L7e
        L79:
            com.amazonaws.mobileconnectors.cognitoauth.handlers.AuthHandler r4 = r2.userHandler
            r4.onFailure(r3)
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.cognitoauth.AuthClient.launchCustomTabs(android.net.Uri, android.app.Activity, java.lang.String):void");
    }

    private void launchSignOut(String str, String str2) {
        launchCustomTabs(new Uri.Builder().scheme("https").authority(this.pool.getAppWebDomain()).appendPath("logout").appendQueryParameter("client_id", this.pool.getAppId()).appendQueryParameter("logout_uri", str).build(), null, str2);
    }

    private void preWarmCustomTabs() {
        if (this.customTabsPackageName == null) {
            return;
        }
        3 r0 = new 3();
        this.mCustomTabsServiceConnection = r0;
        c.a(this.context, this.customTabsPackageName, r0);
    }

    private void refreshSession(AuthUserSession authUserSession, String str, Set set, AuthHandler authHandler, boolean z, String str2, Activity activity) {
        new Thread(new 2(str, authUserSession, authHandler, z, set, activity, str2)).start();
    }

    public void getSession(boolean z, Activity activity) {
        getSession(z, activity, null);
    }

    public void getTokens(Uri uri) {
        if (uri == null) {
            return;
        }
        getTokens(uri, this.userHandler);
    }

    public String getUsername() {
        return this.userId;
    }

    public void handleCustomTabsCancelled() {
        this.userHandler.onFailure(new AuthNavigationException("user cancelled"));
    }

    public boolean isAuthenticated() {
        Auth auth = this.pool;
        return LocalDataManager.getCachedSession(auth.awsKeyValueStore, this.context, auth.getAppId(), this.userId, this.pool.getScopes()).isValidForThreshold();
    }

    public void setUserHandler(AuthHandler authHandler) {
        if (authHandler == null) {
            throw new InvalidParameterException("Callback handler cannot be null");
        }
        this.userHandler = authHandler;
    }

    public void setUsername(String str) {
        this.userId = str;
    }

    public void signOut() {
        signOut((String) null);
    }

    public void unbindServiceConnection() {
        e eVar = this.mCustomTabsServiceConnection;
        if (eVar != null) {
            this.context.unbindService(eVar);
        }
    }

    public AuthClient(Context context, Auth auth, String str) {
        this.context = context;
        this.pool = auth;
        this.userId = str;
        this.isRedirectActivityDeclared = false;
        this.isBrowserInstalled = false;
        this.isCustomTabSupported = false;
        if (isCustomTabSupported()) {
            preWarmCustomTabs();
        }
    }

    private void getTokens(Uri uri, AuthHandler authHandler) {
        new Thread(new 1(authHandler, uri)).start();
    }

    public void getSession(boolean z, Activity activity, String str) {
        try {
            String generateRandom = Pkce.generateRandom();
            this.proofKey = generateRandom;
            this.proofKeyHash = Pkce.generateHash(generateRandom);
            this.state = Pkce.generateRandom();
        } catch (Exception e) {
            this.userHandler.onFailure(e);
        }
        Auth auth = this.pool;
        AuthUserSession cachedSession = LocalDataManager.getCachedSession(auth.awsKeyValueStore, this.context, auth.getAppId(), this.userId, this.pool.getScopes());
        if (cachedSession.isValidForThreshold()) {
            this.userHandler.onSuccess(cachedSession);
            return;
        }
        if (cachedSession.getRefreshToken() != null && cachedSession.getRefreshToken().getToken() != null) {
            refreshSession(cachedSession, this.pool.getSignInRedirectUri(), this.pool.getScopes(), this.userHandler, z, str, activity);
        } else if (z) {
            launchCognitoAuth(this.pool.getSignInRedirectUri(), this.pool.getScopes(), activity, str);
        } else {
            this.userHandler.onFailure(new Exception("No cached session"));
        }
    }

    public void signOut(String str) {
        signOut(false, str);
    }

    public void signOut(boolean z) {
        signOut(z, null);
    }

    public void signOut(boolean z, String str) {
        if (!z) {
            endSession(str);
        }
        Auth auth = this.pool;
        LocalDataManager.clearCache(auth.awsKeyValueStore, this.context, auth.getAppId(), this.userId);
    }
}
