package com.amazonaws.mobile.auth.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSBasicCognitoIdentityProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import com.amazonaws.mobile.auth.core.signin.AuthException;
import com.amazonaws.mobile.auth.core.signin.CognitoAuthException;
import com.amazonaws.mobile.auth.core.signin.ProviderAuthException;
import com.amazonaws.mobile.auth.core.signin.SignInManager;
import com.amazonaws.mobile.auth.core.signin.SignInProvider;
import com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class IdentityManager {
    private static final String AWS_CONFIGURATION_FILE = "awsconfiguration.json";
    private static final String EXPIRATION_KEY = "expirationDate";
    private static final String LOG_TAG = "IdentityManager";
    private static final String SHARED_PREF_NAME = "com.amazonaws.android.auth";
    private static IdentityManager defaultIdentityManager;
    private final Context appContext;
    private AWSConfiguration awsConfiguration;
    private AWSKeyValueStore awsKeyValueStore;
    private final ClientConfiguration clientConfiguration;
    private final AWSCredentialsProviderHolder credentialsProviderHolder;
    private SignInProviderResultAdapter resultsAdapter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final CountDownLatch startupAuthTimeoutLatch = new CountDownLatch(1);
    private final Set signInProviderClasses = new HashSet();
    private volatile IdentityProvider currentIdentityProvider = null;
    private final HashSet signInStateChangeListeners = new HashSet();
    private boolean isPersistenceEnabled = true;
    boolean shouldFederate = true;

    public class 1 implements Runnable {
        Exception exception = null;
        final /* synthetic */ IdentityHandler val$handler;

        public class 1 implements Runnable {
            final /* synthetic */ String val$result;

            public 1(String str) {
                this.val$result = str;
            }

            public void run() {
                1 r0 = 1.this;
                Exception exc = r0.exception;
                IdentityHandler identityHandler = r0.val$handler;
                if (exc != null) {
                    identityHandler.handleError(exc);
                } else {
                    identityHandler.onIdentityId(this.val$result);
                }
            }
        }

        public 1(IdentityHandler identityHandler) {
            this.val$handler = identityHandler;
        }

        public void run() {
            Runnable runnable = "Got Amazon Cognito Federated Identity ID: ";
            String str = null;
            try {
                try {
                    str = AWSCredentialsProviderHolder.access$300(IdentityManager.access$400(IdentityManager.this)).getIdentityId();
                    Log.d(IdentityManager.access$500(), "Got Amazon Cognito Federated Identity ID: " + str);
                    runnable = this.val$handler;
                } catch (Exception e) {
                    this.exception = e;
                    Log.e(IdentityManager.access$500(), e.getMessage(), e);
                    Log.d(IdentityManager.access$500(), "Got Amazon Cognito Federated Identity ID: " + ((String) null));
                    runnable = this.val$handler;
                    if (runnable != null) {
                        runnable = new 1(null);
                    }
                }
                if (runnable != null) {
                    runnable = new 1(str);
                    ThreadUtils.runOnUiThread(runnable);
                }
            } catch (Throwable th) {
                Log.d(IdentityManager.access$500(), runnable + str);
                if (this.val$handler != null) {
                    ThreadUtils.runOnUiThread(new 1(str));
                }
                throw th;
            }
        }
    }

    public class 2 implements Runnable {
        public 2() {
        }

        public void run() {
            IdentityManager.access$000(IdentityManager.this).signOut();
            IdentityManager identityManager = IdentityManager.this;
            if (identityManager.shouldFederate) {
                AWSCredentialsProviderHolder.access$300(IdentityManager.access$400(identityManager)).clear();
            }
            IdentityManager.access$002(IdentityManager.this, null);
            synchronized (IdentityManager.access$600(IdentityManager.this)) {
                try {
                    Iterator it = IdentityManager.access$600(IdentityManager.this).iterator();
                    while (it.hasNext()) {
                        ((SignInStateChangeListener) it.next()).onUserSignedOut();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ Map val$loginMap;

        public 3(Map map) {
            this.val$loginMap = map;
        }

        public void run() {
            try {
                IdentityManager identityManager = IdentityManager.this;
                if (identityManager.shouldFederate) {
                    IdentityManager.access$800(identityManager, this.val$loginMap);
                }
                SignInProviderResultAdapter.access$1100(IdentityManager.access$900(IdentityManager.this));
                synchronized (IdentityManager.access$600(IdentityManager.this)) {
                    try {
                        Iterator it = IdentityManager.access$600(IdentityManager.this).iterator();
                        while (it.hasNext()) {
                            ((SignInStateChangeListener) it.next()).onUserSignedIn();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                SignInProviderResultAdapter.access$1000(IdentityManager.access$900(IdentityManager.this), e);
            }
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ AuthException val$ex;
        final /* synthetic */ StartupAuthResultHandler val$startupAuthResultHandler;

        public 4(StartupAuthResultHandler startupAuthResultHandler, AuthException authException) {
            this.val$startupAuthResultHandler = startupAuthResultHandler;
            this.val$ex = authException;
        }

        public void run() {
            this.val$startupAuthResultHandler.onComplete(new StartupAuthResult(IdentityManager.this, new StartupAuthErrorDetails(this.val$ex, null)));
        }
    }

    public class 5 implements Runnable {
        final /* synthetic */ Activity val$callingActivity;
        final /* synthetic */ Runnable val$runnable;

        public 5(Activity activity, Runnable runnable) {
            this.val$callingActivity = activity;
            this.val$runnable = runnable;
        }

        public void run() {
            try {
                IdentityManager.access$1200(IdentityManager.this).await();
            } catch (InterruptedException unused) {
                Log.d(IdentityManager.access$500(), "Interrupted while waiting for startup auth minimum delay.");
            }
            this.val$callingActivity.runOnUiThread(this.val$runnable);
        }
    }

    public class 6 implements Runnable {
        final /* synthetic */ Activity val$callingActivity;
        final /* synthetic */ long val$minimumDelay;
        final /* synthetic */ StartupAuthResultHandler val$startupAuthResultHandler;

        public class 1 implements SignInProviderResultHandler {

            public class 1 implements Runnable {
                public 1() {
                }

                public void run() {
                    6 r0 = 6.this;
                    r0.val$startupAuthResultHandler.onComplete(new StartupAuthResult(IdentityManager.this, null));
                }
            }

            public 1() {
            }

            public void onCancel(IdentityProvider identityProvider) {
                Log.wtf(IdentityManager.access$500(), "Cancel can't happen when handling a previously signed-in user.");
            }

            public void onError(IdentityProvider identityProvider, Exception exc) {
                Log.e(IdentityManager.access$500(), identityProvider != null ? String.format("Federate with Cognito with %s Sign-in provider failed. Error: %s", new Object[]{identityProvider.getDisplayName(), exc.getMessage()}) : String.format("Federate with Cognito failed. Error: %s", new Object[]{exc.getMessage()}), exc);
                if (exc instanceof AuthException) {
                    6 r7 = 6.this;
                    IdentityManager.access$1400(IdentityManager.this, r7.val$callingActivity, r7.val$startupAuthResultHandler, (AuthException) exc);
                } else {
                    6 r0 = 6.this;
                    IdentityManager.access$1400(IdentityManager.this, r0.val$callingActivity, r0.val$startupAuthResultHandler, new AuthException(identityProvider, exc));
                }
            }

            public void onSuccess(IdentityProvider identityProvider) {
                Log.d(IdentityManager.access$500(), "Successfully got AWS Credentials.");
                6 r3 = 6.this;
                IdentityManager.access$1300(IdentityManager.this, r3.val$callingActivity, new 1());
            }
        }

        public 6(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j) {
            this.val$callingActivity = activity;
            this.val$startupAuthResultHandler = startupAuthResultHandler;
            this.val$minimumDelay = j;
        }

        public void run() {
            Log.d(IdentityManager.access$500(), "Looking for a previously signed-in session.");
            SignInManager signInManager = SignInManager.getInstance(this.val$callingActivity.getApplicationContext());
            SignInProvider previouslySignedInProvider = signInManager.getPreviouslySignedInProvider();
            if (previouslySignedInProvider != null) {
                Log.d(IdentityManager.access$500(), "Refreshing credentials with sign-in provider " + previouslySignedInProvider.getDisplayName());
                signInManager.refreshCredentialsWithProvider(this.val$callingActivity, previouslySignedInProvider, new 1());
            } else {
                IdentityManager.access$1400(IdentityManager.this, this.val$callingActivity, this.val$startupAuthResultHandler, null);
            }
            long j = this.val$minimumDelay;
            if (j > 0) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                    Log.i(IdentityManager.access$500(), "Interrupted while waiting for resume session timeout.");
                }
            }
            IdentityManager.access$1200(IdentityManager.this).countDown();
        }
    }

    public class AWSCredentialsProviderHolder implements AWSCredentialsProvider {
        private volatile CognitoCachingCredentialsProvider underlyingProvider;

        private AWSCredentialsProviderHolder() {
        }

        public static /* synthetic */ void access$200(AWSCredentialsProviderHolder aWSCredentialsProviderHolder, CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider) {
            aWSCredentialsProviderHolder.setUnderlyingProvider(cognitoCachingCredentialsProvider);
        }

        public static /* synthetic */ CognitoCachingCredentialsProvider access$300(AWSCredentialsProviderHolder aWSCredentialsProviderHolder) {
            return aWSCredentialsProviderHolder.getUnderlyingProvider();
        }

        private CognitoCachingCredentialsProvider getUnderlyingProvider() {
            return this.underlyingProvider;
        }

        private void setUnderlyingProvider(CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider) {
            this.underlyingProvider = cognitoCachingCredentialsProvider;
        }

        public AWSCredentials getCredentials() {
            return this.underlyingProvider.getCredentials();
        }

        public void refresh() {
            this.underlyingProvider.refresh();
        }

        public /* synthetic */ AWSCredentialsProviderHolder(IdentityManager identityManager, 1 r2) {
            this();
        }
    }

    public class AWSRefreshingCognitoIdentityProvider extends AWSBasicCognitoIdentityProvider {
        private final String LOG_TAG;

        public AWSRefreshingCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration, Regions regions) {
            super(str, str2, clientConfiguration);
            this.LOG_TAG = AWSRefreshingCognitoIdentityProvider.class.getSimpleName();
            this.cib.setRegion(Region.getRegion(regions));
        }

        public String refresh() {
            if (IdentityManager.access$000(IdentityManager.this) != null) {
                Log.d(this.LOG_TAG, "Storing the Refresh token in the loginsMap.");
                getLogins().put(IdentityManager.access$000(IdentityManager.this).getCognitoLoginKey(), IdentityManager.access$000(IdentityManager.this).refreshToken());
            }
            return super.refresh();
        }
    }

    public class SignInProviderResultAdapter implements SignInProviderResultHandler {
        private final SignInProviderResultHandler handler;

        private SignInProviderResultAdapter(SignInProviderResultHandler signInProviderResultHandler) {
            this.handler = signInProviderResultHandler;
        }

        public static /* synthetic */ void access$1000(SignInProviderResultAdapter signInProviderResultAdapter, Exception exc) {
            signInProviderResultAdapter.onCognitoError(exc);
        }

        public static /* synthetic */ void access$1100(SignInProviderResultAdapter signInProviderResultAdapter) {
            signInProviderResultAdapter.onCognitoSuccess();
        }

        private void onCognitoError(Exception exc) {
            Log.d(IdentityManager.access$500(), "SignInProviderResultAdapter.onCognitoError()", exc);
            IdentityProvider access$000 = IdentityManager.access$000(IdentityManager.this);
            IdentityManager.this.signOut();
            this.handler.onError(access$000, new CognitoAuthException(access$000, exc));
        }

        private void onCognitoSuccess() {
            Log.d(IdentityManager.access$500(), "SignInProviderResultAdapter.onCognitoSuccess()");
            this.handler.onSuccess(IdentityManager.access$000(IdentityManager.this));
        }

        public void onCancel(IdentityProvider identityProvider) {
            Log.d(IdentityManager.access$500(), String.format("SignInProviderResultAdapter.onCancel(): %s provider sign-in canceled.", new Object[]{identityProvider.getDisplayName()}));
            this.handler.onCancel(identityProvider);
        }

        public void onError(IdentityProvider identityProvider, Exception exc) {
            Log.e(IdentityManager.access$500(), String.format("SignInProviderResultAdapter.onError(): %s provider error. %s", new Object[]{identityProvider.getDisplayName(), exc.getMessage()}), exc);
            this.handler.onError(identityProvider, new ProviderAuthException(identityProvider, exc));
        }

        public void onSuccess(IdentityProvider identityProvider) {
            Log.d(IdentityManager.access$500(), String.format("SignInProviderResultAdapter.onSuccess(): %s provider sign-in succeeded.", new Object[]{identityProvider.getDisplayName()}));
            IdentityManager.this.federateWithProvider(identityProvider);
        }

        public /* synthetic */ SignInProviderResultAdapter(IdentityManager identityManager, SignInProviderResultHandler signInProviderResultHandler, 1 r3) {
            this(signInProviderResultHandler);
        }
    }

    public IdentityManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = null;
        this.clientConfiguration = null;
        this.credentialsProviderHolder = null;
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, "com.amazonaws.android.auth", this.isPersistenceEnabled);
    }

    public static /* synthetic */ IdentityProvider access$000(IdentityManager identityManager) {
        return identityManager.currentIdentityProvider;
    }

    public static /* synthetic */ IdentityProvider access$002(IdentityManager identityManager, IdentityProvider identityProvider) {
        identityManager.currentIdentityProvider = identityProvider;
        return identityProvider;
    }

    public static /* synthetic */ CountDownLatch access$1200(IdentityManager identityManager) {
        return identityManager.startupAuthTimeoutLatch;
    }

    public static /* synthetic */ void access$1300(IdentityManager identityManager, Activity activity, Runnable runnable) {
        identityManager.runAfterStartupAuthDelay(activity, runnable);
    }

    public static /* synthetic */ void access$1400(IdentityManager identityManager, Activity activity, StartupAuthResultHandler startupAuthResultHandler, AuthException authException) {
        identityManager.completeHandler(activity, startupAuthResultHandler, authException);
    }

    public static /* synthetic */ AWSCredentialsProviderHolder access$400(IdentityManager identityManager) {
        return identityManager.credentialsProviderHolder;
    }

    public static /* synthetic */ String access$500() {
        return LOG_TAG;
    }

    public static /* synthetic */ HashSet access$600(IdentityManager identityManager) {
        return identityManager.signInStateChangeListeners;
    }

    public static /* synthetic */ void access$800(IdentityManager identityManager, Map map) {
        identityManager.refreshCredentialWithLogins(map);
    }

    public static /* synthetic */ SignInProviderResultAdapter access$900(IdentityManager identityManager) {
        return identityManager.resultsAdapter;
    }

    private void completeHandler(Activity activity, StartupAuthResultHandler startupAuthResultHandler, AuthException authException) {
        runAfterStartupAuthDelay(activity, new 4(startupAuthResultHandler, authException));
    }

    private void createCredentialsProvider(Context context, ClientConfiguration clientConfiguration) {
        Log.d(LOG_TAG, "Creating the Cognito Caching Credentials Provider with a refreshing Cognito Identity Provider.");
        if (this.shouldFederate) {
            JSONObject cognitoIdentityPoolConfig = getCognitoIdentityPoolConfig();
            try {
                String string = cognitoIdentityPoolConfig.getString("Region");
                String string2 = cognitoIdentityPoolConfig.getString("PoolId");
                Regions fromName = Regions.fromName(string);
                CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = new CognitoCachingCredentialsProvider(context, new AWSRefreshingCognitoIdentityProvider(null, string2, clientConfiguration, fromName), fromName, clientConfiguration);
                cognitoCachingCredentialsProvider.setPersistenceEnabled(this.isPersistenceEnabled);
                if (clientConfiguration.getUserAgentOverride() != null) {
                    cognitoCachingCredentialsProvider.setUserAgentOverride(clientConfiguration.getUserAgentOverride());
                }
                AWSCredentialsProviderHolder.access$200(this.credentialsProviderHolder, cognitoCachingCredentialsProvider);
            } catch (JSONException e) {
                throw new IllegalArgumentException("Failed to read configuration for CognitoIdentity", e);
            }
        }
    }

    private JSONObject getCognitoIdentityPoolConfig() throws IllegalArgumentException {
        try {
            return this.awsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.awsConfiguration.getConfiguration());
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot access Cognito IdentityPoolId from the awsconfiguration.json file.", e);
        }
    }

    public static IdentityManager getDefaultIdentityManager() {
        return defaultIdentityManager;
    }

    private void refreshCredentialWithLogins(Map map) {
        CognitoCachingCredentialsProvider access$300 = AWSCredentialsProviderHolder.access$300(this.credentialsProviderHolder);
        if (this.shouldFederate) {
            access$300.clear();
            access$300.withLogins(map);
            Log.d(LOG_TAG, "refresh credentials");
            access$300.refresh();
            this.awsKeyValueStore.put(access$300.getIdentityPoolId() + ".expirationDate", String.valueOf(System.currentTimeMillis() + 510000));
        }
    }

    private void runAfterStartupAuthDelay(Activity activity, Runnable runnable) {
        this.executorService.submit(new 5(activity, runnable));
    }

    public static void setDefaultIdentityManager(IdentityManager identityManager) {
        defaultIdentityManager = identityManager;
    }

    public void addSignInProvider(Class cls) {
        this.signInProviderClasses.add(cls);
    }

    public void addSignInStateChangeListener(SignInStateChangeListener signInStateChangeListener) {
        synchronized (this.signInStateChangeListeners) {
            this.signInStateChangeListeners.add(signInStateChangeListener);
        }
    }

    public boolean areCredentialsExpired() {
        String str;
        String sb;
        if (!this.shouldFederate) {
            throw new IllegalStateException("Federation is not enabled and does not support credentials");
        }
        Date sessionCredentialsExpiration = AWSCredentialsProviderHolder.access$300(this.credentialsProviderHolder).getSessionCredentialsExpiration();
        if (sessionCredentialsExpiration == null) {
            str = LOG_TAG;
            sb = "Credentials are EXPIRED.";
        } else {
            r1 = sessionCredentialsExpiration.getTime() - (System.currentTimeMillis() - (SDKGlobalConfiguration.getGlobalTimeOffset() * 1000)) < 0;
            str = LOG_TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Credentials are ");
            sb2.append(r1 ? "EXPIRED." : "OK");
            sb = sb2.toString();
        }
        Log.d(str, sb);
        return r1;
    }

    @Deprecated
    public void doStartupAuth(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        resumeSession(activity, startupAuthResultHandler, 0L);
    }

    public void enableFederation(boolean z) {
        this.shouldFederate = z;
    }

    public void expireSignInTimeout() {
        this.startupAuthTimeoutLatch.countDown();
    }

    public void federateWithProvider(IdentityProvider identityProvider) {
        Log.d(LOG_TAG, "federate with provider: Populate loginsMap with token.");
        HashMap hashMap = new HashMap();
        hashMap.put(identityProvider.getCognitoLoginKey(), identityProvider.getToken());
        this.currentIdentityProvider = identityProvider;
        this.executorService.submit(new 3(hashMap));
    }

    public String getCachedUserID() {
        if (this.shouldFederate) {
            return AWSCredentialsProviderHolder.access$300(this.credentialsProviderHolder).getCachedIdentityId();
        }
        throw new IllegalStateException("Federation is not enabled and does not support user id");
    }

    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }

    public AWSCredentialsProvider getCredentialsProvider() {
        return this.credentialsProviderHolder;
    }

    public IdentityProvider getCurrentIdentityProvider() {
        return this.currentIdentityProvider;
    }

    public SignInProviderResultAdapter getResultsAdapter() {
        return this.resultsAdapter;
    }

    public Collection getSignInProviderClasses() {
        return this.signInProviderClasses;
    }

    public CognitoCachingCredentialsProvider getUnderlyingProvider() {
        return AWSCredentialsProviderHolder.access$300(this.credentialsProviderHolder);
    }

    public void getUserID(IdentityHandler identityHandler) {
        if (!this.shouldFederate) {
            throw new IllegalStateException("Federation is not enabled and does not support user id");
        }
        this.executorService.submit(new 1(identityHandler));
    }

    public boolean isUserSignedIn() {
        Map logins = AWSCredentialsProviderHolder.access$300(this.credentialsProviderHolder).getLogins();
        return (logins == null || logins.size() == 0) ? false : true;
    }

    public void login(Context context, SignInResultHandler signInResultHandler) {
        try {
            SignInManager.getInstance(context.getApplicationContext()).setResultHandler(signInResultHandler);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error in instantiating SignInManager. Check the context and completion handler.", e);
        }
    }

    public void removeSignInStateChangeListener(SignInStateChangeListener signInStateChangeListener) {
        synchronized (this.signInStateChangeListeners) {
            this.signInStateChangeListeners.remove(signInStateChangeListener);
        }
    }

    public void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        resumeSession(activity, startupAuthResultHandler, 0L);
    }

    public void setConfiguration(AWSConfiguration aWSConfiguration) {
        this.awsConfiguration = aWSConfiguration;
    }

    public void setPersistenceEnabled(boolean z) {
        this.isPersistenceEnabled = z;
        this.awsKeyValueStore.setPersistenceEnabled(z);
    }

    public void setProviderResultsHandler(SignInProviderResultHandler signInProviderResultHandler) {
        if (signInProviderResultHandler == null) {
            throw new IllegalArgumentException("signInProviderResultHandler cannot be null.");
        }
        this.resultsAdapter = new SignInProviderResultAdapter(this, signInProviderResultHandler, null);
    }

    @Deprecated
    public void setUpToAuthenticate(Context context, SignInResultHandler signInResultHandler) {
        login(context, signInResultHandler);
    }

    public void signOut() {
        Log.d(LOG_TAG, "Signing out...");
        if (this.currentIdentityProvider != null) {
            this.executorService.submit(new 2());
        }
    }

    public IdentityManager(Context context, CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider, ClientConfiguration clientConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.clientConfiguration = clientConfiguration;
        AWSCredentialsProviderHolder aWSCredentialsProviderHolder = new AWSCredentialsProviderHolder(this, null);
        this.credentialsProviderHolder = aWSCredentialsProviderHolder;
        AWSCredentialsProviderHolder.access$200(aWSCredentialsProviderHolder, cognitoCachingCredentialsProvider);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, "com.amazonaws.android.auth", this.isPersistenceEnabled);
    }

    @Deprecated
    public void doStartupAuth(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j) {
        resumeSession(activity, startupAuthResultHandler, j);
    }

    public void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j) {
        Log.d(LOG_TAG, "Resume Session called.");
        this.executorService.submit(new 6(activity, startupAuthResultHandler, j));
    }

    public IdentityManager(Context context, AWSConfiguration aWSConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = aWSConfiguration;
        ClientConfiguration withUserAgentOverride = new ClientConfiguration().withUserAgent(aWSConfiguration.getUserAgent()).withUserAgentOverride(aWSConfiguration.getUserAgentOverride());
        this.clientConfiguration = withUserAgentOverride;
        this.credentialsProviderHolder = new AWSCredentialsProviderHolder(this, null);
        createCredentialsProvider(applicationContext, withUserAgentOverride);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, "com.amazonaws.android.auth", this.isPersistenceEnabled);
    }

    public IdentityManager(Context context, AWSConfiguration aWSConfiguration, ClientConfiguration clientConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = aWSConfiguration;
        this.clientConfiguration = clientConfiguration;
        String userAgent = aWSConfiguration.getUserAgent();
        String userAgent2 = clientConfiguration.getUserAgent();
        userAgent2 = userAgent2 == null ? "" : userAgent2;
        if (userAgent != null && userAgent != userAgent2) {
            clientConfiguration.setUserAgent(userAgent2.trim() + " " + userAgent);
        }
        this.credentialsProviderHolder = new AWSCredentialsProviderHolder(this, null);
        createCredentialsProvider(applicationContext, clientConfiguration);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, "com.amazonaws.android.auth", this.isPersistenceEnabled);
    }
}
