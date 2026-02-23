package com.amazonaws.mobile.auth.core.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.IdentityProvider;
import com.amazonaws.mobile.auth.core.SignInResultHandler;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignInManager {
    private static final String LOG_TAG = "SignInManager";
    private static volatile SignInManager singleton;
    private SignInProviderResultAdapter resultsAdapter;
    private volatile SignInResultHandler signInResultHandler;
    private final Map signInProviders = new HashMap();
    private final SparseArray providersHandlingPermissions = new SparseArray();

    public class SignInProviderResultAdapter implements SignInProviderResultHandler {
        private final Activity activity;
        private final SignInProviderResultHandler handler;

        public class 1 implements Runnable {
            final /* synthetic */ IdentityProvider val$provider;

            public 1(IdentityProvider identityProvider) {
                this.val$provider = identityProvider;
            }

            public void run() {
                SignInProviderResultAdapter.access$000(SignInProviderResultAdapter.this).onSuccess(this.val$provider);
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ IdentityProvider val$provider;

            public 2(IdentityProvider identityProvider) {
                this.val$provider = identityProvider;
            }

            public void run() {
                SignInProviderResultAdapter.access$000(SignInProviderResultAdapter.this).onCancel(this.val$provider);
            }
        }

        public class 3 implements Runnable {
            final /* synthetic */ Exception val$ex;
            final /* synthetic */ IdentityProvider val$provider;

            public 3(IdentityProvider identityProvider, Exception exc) {
                this.val$provider = identityProvider;
                this.val$ex = exc;
            }

            public void run() {
                SignInProviderResultAdapter.access$000(SignInProviderResultAdapter.this).onError(this.val$provider, this.val$ex);
            }
        }

        private SignInProviderResultAdapter(Activity activity, SignInProviderResultHandler signInProviderResultHandler) {
            this.handler = signInProviderResultHandler;
            this.activity = activity;
        }

        public static /* synthetic */ SignInProviderResultHandler access$000(SignInProviderResultAdapter signInProviderResultAdapter) {
            return signInProviderResultAdapter.handler;
        }

        public static /* synthetic */ Activity access$200(SignInProviderResultAdapter signInProviderResultAdapter) {
            return signInProviderResultAdapter.getActivity();
        }

        private Activity getActivity() {
            return this.activity;
        }

        public void onCancel(IdentityProvider identityProvider) {
            ThreadUtils.runOnUiThread(new 2(identityProvider));
        }

        public void onError(IdentityProvider identityProvider, Exception exc) {
            ThreadUtils.runOnUiThread(new 3(identityProvider, exc));
        }

        public void onSuccess(IdentityProvider identityProvider) {
            ThreadUtils.runOnUiThread(new 1(identityProvider));
        }

        public /* synthetic */ SignInProviderResultAdapter(SignInManager signInManager, Activity activity, SignInProviderResultHandler signInProviderResultHandler, 1 r4) {
            this(activity, signInProviderResultHandler);
        }
    }

    private SignInManager(Context context) {
        String str;
        StringBuilder sb;
        for (Class cls : IdentityManager.getDefaultIdentityManager().getSignInProviderClasses()) {
            try {
                SignInProvider signInProvider = (SignInProvider) cls.newInstance();
                if (signInProvider != null) {
                    signInProvider.initialize(context, IdentityManager.getDefaultIdentityManager().getConfiguration());
                    this.signInProviders.put(cls, signInProvider);
                    if (signInProvider instanceof SignInPermissionsHandler) {
                        SignInPermissionsHandler signInPermissionsHandler = (SignInPermissionsHandler) signInProvider;
                        this.providersHandlingPermissions.put(signInPermissionsHandler.getPermissionRequestCode(), signInPermissionsHandler);
                    }
                }
            } catch (IllegalAccessException unused) {
                str = LOG_TAG;
                sb = new StringBuilder();
                sb.append("Unable to instantiate ");
                sb.append(cls.getSimpleName());
                sb.append(" . Skipping this provider.");
                Log.e(str, sb.toString());
            } catch (InstantiationException unused2) {
                str = LOG_TAG;
                sb = new StringBuilder();
                sb.append("Unable to instantiate ");
                sb.append(cls.getSimpleName());
                sb.append(" . Skipping this provider.");
                Log.e(str, sb.toString());
            }
        }
        singleton = this;
    }

    public static synchronized void dispose() {
        synchronized (SignInManager.class) {
            singleton = null;
        }
    }

    private SignInProvider findProvider(Class cls) {
        SignInProvider signInProvider = (SignInProvider) this.signInProviders.get(cls);
        if (signInProvider != null) {
            return signInProvider;
        }
        throw new IllegalArgumentException("No such provider : " + cls.getName());
    }

    public static synchronized SignInManager getInstance() {
        SignInManager signInManager;
        synchronized (SignInManager.class) {
            signInManager = singleton;
        }
        return signInManager;
    }

    public SignInProvider getPreviouslySignedInProvider() {
        Log.d(LOG_TAG, "Providers: " + Collections.singletonList(this.signInProviders));
        for (SignInProvider signInProvider : this.signInProviders.values()) {
            if (signInProvider.refreshUserSignInState()) {
                Log.d(LOG_TAG, "Refreshing provider: " + signInProvider.getDisplayName());
                return signInProvider;
            }
        }
        return null;
    }

    public SignInResultHandler getResultHandler() {
        return this.signInResultHandler;
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        for (SignInProvider signInProvider : this.signInProviders.values()) {
            if (signInProvider.isRequestCodeOurs(i)) {
                signInProvider.handleActivityResult(i, i2, intent);
                return true;
            }
        }
        return false;
    }

    public void handleRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        SignInPermissionsHandler signInPermissionsHandler = (SignInPermissionsHandler) this.providersHandlingPermissions.get(i);
        if (signInPermissionsHandler != null) {
            signInPermissionsHandler.handleRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public View.OnClickListener initializeSignInButton(Class cls, View view) {
        return findProvider(cls).initializeSignInButton(SignInProviderResultAdapter.access$200(this.resultsAdapter), view, IdentityManager.getDefaultIdentityManager().getResultsAdapter());
    }

    public void refreshCredentialsWithProvider(Activity activity, IdentityProvider identityProvider, SignInProviderResultHandler signInProviderResultHandler) {
        if (identityProvider == null) {
            throw new IllegalArgumentException("The sign-in provider cannot be null.");
        }
        if (identityProvider.getToken() == null) {
            signInProviderResultHandler.onError(identityProvider, new IllegalArgumentException("Given provider not previously logged in."));
        }
        this.resultsAdapter = new SignInProviderResultAdapter(this, activity, signInProviderResultHandler, null);
        IdentityManager.getDefaultIdentityManager().setProviderResultsHandler(this.resultsAdapter);
        IdentityManager.getDefaultIdentityManager().federateWithProvider(identityProvider);
    }

    public void setProviderResultsHandler(Activity activity, SignInProviderResultHandler signInProviderResultHandler) {
        this.resultsAdapter = new SignInProviderResultAdapter(this, activity, signInProviderResultHandler, null);
        IdentityManager.getDefaultIdentityManager().setProviderResultsHandler(this.resultsAdapter);
    }

    public void setResultHandler(SignInResultHandler signInResultHandler) {
        this.signInResultHandler = signInResultHandler;
    }

    public static synchronized SignInManager getInstance(Context context) {
        SignInManager signInManager;
        synchronized (SignInManager.class) {
            try {
                if (singleton == null) {
                    singleton = new SignInManager(context);
                }
                signInManager = singleton;
            } catch (Throwable th) {
                throw th;
            }
        }
        return signInManager;
    }
}
