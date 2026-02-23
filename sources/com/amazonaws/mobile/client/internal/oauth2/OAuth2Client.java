package com.amazonaws.mobile.client.internal.oauth2;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import p.b;
import p.c;
import p.d;
import p.e;
import p.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class OAuth2Client {
    public static final String CREATE_DATE = "createDate";
    public static final String CUSTOM_TABS_PACKAGE_NAME = "com.android.chrome";
    private static final long REFRESH_THRESHOLD = 60000;
    public static final String SHARED_PREFERENCES_KEY = "com.amazonaws.mobile.client.oauth2";
    public static final String SIGN_IN_REDIRECT_URI_KEY = "signInRedirectUri";
    public static final String SIGN_OUT_REDIRECT_URI_KEY = "signOutRedirectUri";
    public static final String TAG = "OAuth2Client";
    public static final String TOKEN_URI_KEY = "tokenUri";
    Callback mAuthorizeCallback;
    private boolean mAuthorizeOrSignOutRedirectReceived;
    private String mClientId;
    final Context mContext;
    c mCustomTabsClient;
    final e mCustomTabsServiceConnection;
    f mCustomTabsSession;
    private String mError;
    private String mErrorDescription;
    private String mErrorUriString;
    final AWSMobileClient mMobileClient;
    private Callback mSignOutCallback;
    String mState;
    private String userAgentOverride;
    boolean mIsPersistenceEnabled = true;
    PKCEMode mPKCEMode = PKCEMode.S256;
    private final OAuth2ClientStore mStore = new OAuth2ClientStore(this);
    b mCustomTabsCallback = new 1();

    public class 1 extends b {
        public 1() {
        }

        public void onNavigationEvent(int i, Bundle bundle) {
            super.onNavigationEvent(i, bundle);
            if (i != 6 || OAuth2Client.access$000(OAuth2Client.this)) {
                return;
            }
            if (OAuth2Client.access$100(OAuth2Client.this) != null) {
                OAuth2Client.access$100(OAuth2Client.this).onError(new Exception("User cancelled flow or flow interrupted."));
                OAuth2Client.access$102(OAuth2Client.this, null);
                return;
            }
            Callback callback = OAuth2Client.this.mAuthorizeCallback;
            if (callback != null) {
                callback.onError(new Exception("User cancelled flow or flow interrupted."));
                OAuth2Client.this.mAuthorizeCallback = null;
            }
        }
    }

    public class 2 extends e {
        public 2() {
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, c cVar) {
            OAuth2Client.this.mCustomTabsClient = cVar;
            cVar.g(0L);
            OAuth2Client oAuth2Client = OAuth2Client.this;
            oAuth2Client.mCustomTabsSession = oAuth2Client.mCustomTabsClient.e(oAuth2Client.mCustomTabsCallback);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            OAuth2Client.this.mCustomTabsClient = null;
        }
    }

    public static /* synthetic */ class 3 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode;

        static {
            int[] iArr = new int[PKCEMode.values().length];
            $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode = iArr;
            try {
                iArr[PKCEMode.S256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode[PKCEMode.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum PKCEMode {
        NONE(""),
        S256("S256");

        private String encode;

        PKCEMode(String str) {
            this.encode = str;
        }

        public boolean equals(PKCEMode pKCEMode) {
            return pKCEMode.encode.equals(this.encode);
        }

        public String toString() {
            return this.encode;
        }
    }

    public OAuth2Client(Context context, AWSMobileClient aWSMobileClient) {
        this.mMobileClient = aWSMobileClient;
        this.mContext = context;
        2 r3 = new 2();
        this.mCustomTabsServiceConnection = r3;
        if (c.a(context, "com.android.chrome", r3)) {
            return;
        }
        Log.d(TAG, "OAuth2Client: Failed to pre-warm custom tab, first page load may be slower");
    }

    public static /* synthetic */ boolean access$000(OAuth2Client oAuth2Client) {
        return oAuth2Client.mAuthorizeOrSignOutRedirectReceived;
    }

    public static /* synthetic */ Callback access$100(OAuth2Client oAuth2Client) {
        return oAuth2Client.mSignOutCallback;
    }

    public static /* synthetic */ Callback access$102(OAuth2Client oAuth2Client, Callback callback) {
        oAuth2Client.mSignOutCallback = callback;
        return callback;
    }

    public void authorize(Uri uri, Callback callback) {
        this.mAuthorizeCallback = callback;
        try {
            Uri.Builder buildUpon = uri.buildUpon();
            int i = 3.$SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode[this.mPKCEMode.ordinal()];
            if (i == 1) {
                String generateRandom = Pkce.generateRandom();
                String generateHash = Pkce.generateHash(generateRandom);
                this.mStore.set("proofKey", generateRandom);
                this.mStore.set("proofKeyHash", generateHash);
                buildUpon.appendQueryParameter("code_challenge_method", this.mPKCEMode.toString()).appendQueryParameter("code_challenge", generateHash).build();
            } else if (i != 2) {
                throw new IllegalArgumentException("Unsupported PKCE mode was chosen, please choose another");
            }
            Uri build = buildUpon.build();
            String queryParameter = build.getQueryParameter("client_id");
            this.mClientId = queryParameter;
            if (queryParameter == null) {
                throw new IllegalArgumentException("The authorize URI must contain a client_id");
            }
            String queryParameter2 = build.getQueryParameter("redirect_uri");
            if (queryParameter2 == null) {
                throw new IllegalArgumentException("The authorize URI must contain a redirect_uri");
            }
            this.mStore.set("signInRedirectUri", queryParameter2);
            Uri.parse(queryParameter2);
            if (build.getQueryParameter("response_type") == null) {
                buildUpon.appendQueryParameter("response_type", "code").build();
            }
            String queryParameter3 = build.getQueryParameter("state");
            this.mState = queryParameter3;
            if (queryParameter3 == null) {
                String generateRandom2 = Pkce.generateRandom();
                this.mState = generateRandom2;
                buildUpon.appendQueryParameter("state", generateRandom2).build();
            }
            this.mStore.set("state", this.mState);
            open(buildUpon.build());
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getTokens(Callback callback) {
        String str;
        try {
            OAuth2Tokens tokens = this.mStore.getTokens();
            if (tokens.expiresIn != null && (tokens.createDate.longValue() + tokens.expiresIn.longValue()) - System.currentTimeMillis() < 60000) {
                if (tokens.refreshToken == null || (str = this.mStore.get("tokenUri")) == null) {
                    callback.onError(new Exception("No cached tokens available, refresh not available."));
                } else {
                    refresh(Uri.parse(str), new HashMap(), new HashMap(), callback);
                }
            }
            callback.onResult(tokens);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public boolean handleRedirect(Uri uri) {
        if (uri == null) {
            return false;
        }
        String str = this.mStore.get("signInRedirectUri");
        String str2 = this.mStore.get("signOutRedirectUri");
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (uri.getScheme().equals(parse.getScheme()) && uri.getAuthority().equals(parse.getAuthority()) && uri.getPath().equals(parse.getPath()) && uri.getQueryParameterNames().containsAll(parse.getQueryParameterNames())) {
                String queryParameter = uri.getQueryParameter("code");
                if (!this.mStore.get("state").equals(uri.getQueryParameter("state"))) {
                    return false;
                }
                this.mError = uri.getQueryParameter("error");
                this.mErrorDescription = uri.getQueryParameter("error_description");
                this.mErrorUriString = uri.getQueryParameter("error_uri");
                this.mAuthorizeOrSignOutRedirectReceived = true;
                if (this.mError != null) {
                    Callback callback = this.mAuthorizeCallback;
                    if (callback != null) {
                        callback.onError(new OAuth2Exception("Authorization call failed with response from authorization server", this.mError, this.mErrorDescription, this.mErrorUriString));
                        this.mAuthorizeCallback = null;
                    }
                    return true;
                }
                if (queryParameter == null) {
                    return false;
                }
                if (this.mAuthorizeCallback != null) {
                    AuthorizeResponse authorizeResponse = new AuthorizeResponse();
                    authorizeResponse.code = queryParameter;
                    authorizeResponse.responseUri = uri;
                    this.mAuthorizeCallback.onResult(authorizeResponse);
                    this.mAuthorizeCallback = null;
                }
                return true;
            }
        }
        if (str2 != null) {
            Uri parse2 = Uri.parse(str2);
            if (uri.getScheme().equals(parse2.getScheme()) && uri.getAuthority().equals(parse2.getAuthority()) && uri.getPath().equals(parse2.getPath()) && uri.getQueryParameterNames().containsAll(parse2.getQueryParameterNames())) {
                this.mAuthorizeOrSignOutRedirectReceived = true;
                Callback callback2 = this.mSignOutCallback;
                if (callback2 != null) {
                    callback2.onResult(null);
                    this.mSignOutCallback = null;
                }
                return true;
            }
        }
        return false;
    }

    public void open(Uri uri) {
        d a = new d.a(this.mCustomTabsSession).a();
        a.a.setPackage("com.android.chrome");
        a.a.addFlags(1073741824);
        a.a.addFlags(268435456);
        this.mAuthorizeOrSignOutRedirectReceived = false;
        a.a(this.mContext, uri);
    }

    public void refresh(Uri uri, Map map, Map map2, Callback callback) {
        String str = this.mStore.get(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString());
        if (str == null) {
            callback.onError(new IllegalStateException("Refresh called without refresh token available"));
        }
        try {
            if (map2.get("grant_type") == null) {
                map2.put("grant_type", OAuth2Constants.GrantTypes.REFRESH_TOKEN.toString());
            }
            if (map2.get("refresh_token") == null) {
                if (str == null) {
                    throw new IllegalArgumentException("The refresh flow must contain a refresh_token");
                }
                map2.put("refresh_token", str);
            }
            OAuth2Tokens parseHttpResponse = HTTPUtil.parseHttpResponse(HTTPUtil.httpPost(new URL(uri.toString()), map, map2, this.userAgentOverride));
            this.mStore.set(parseHttpResponse);
            callback.onResult(parseHttpResponse);
        } catch (Exception e) {
            callback.onError(new Exception("Failed to refresh tokens with service", e));
        }
    }

    public void requestTokens(Uri uri, Map map, Map map2, String str, Callback callback) {
        String str2 = this.mStore.get("proofKey");
        if (str2 == null && !this.mPKCEMode.equals(PKCEMode.NONE)) {
            callback.onError(new Exception("Proof key could not be found from current session."));
        }
        try {
            if (map2.get("client_id") == null) {
                throw new IllegalArgumentException("The token exchange must contain a client_id");
            }
            if (map2.get("redirect_uri") == null) {
                throw new IllegalArgumentException("The token exchange must contain a redirect_uri");
            }
            if (map2.get("code") == null) {
                if (str == null) {
                    throw new IllegalArgumentException("The token exchange must contain a code");
                }
                map2.put("code", str);
            }
            if (map2.get("code_verifier") == null) {
                if (str2 == null) {
                    throw new IllegalStateException("The token exchange must contain a code verifier");
                }
                map2.put("code_verifier", str2);
            }
            if (map2.get("grant_type") == null) {
                map2.put("grant_type", OAuth2Constants.GrantTypes.AUTHORIZATION_CODE.toString());
            }
            this.mStore.set("tokenUri", uri.toString());
            OAuth2Tokens parseHttpResponse = HTTPUtil.parseHttpResponse(HTTPUtil.httpPost(new URL(uri.toString()), map, map2, this.userAgentOverride));
            this.mStore.set(parseHttpResponse);
            callback.onResult(parseHttpResponse);
        } catch (Exception e) {
            callback.onError(new Exception("Failed to exchange code for tokens", e));
        }
    }

    public void setPKCEMode(PKCEMode pKCEMode) {
        this.mPKCEMode = pKCEMode;
    }

    public void setPersistenceEnabled(boolean z) {
        this.mIsPersistenceEnabled = z;
        this.mStore.setPersistenceEnabled(z);
    }

    public void setUserAgentOverride(String str) {
        this.userAgentOverride = str;
    }

    public void signOut() {
        this.mStore.clear();
        this.mSignOutCallback = null;
        this.mAuthorizeCallback = null;
        this.mPKCEMode = PKCEMode.S256;
        this.mState = null;
        this.mClientId = null;
        this.mError = null;
        this.mErrorDescription = null;
        this.mErrorUriString = null;
    }

    public void signOut(Uri uri, Callback callback) {
        this.mSignOutCallback = callback;
        String queryParameter = uri.getQueryParameter("redirect_uri");
        if (queryParameter == null) {
            throw new IllegalArgumentException("The sign-out URI must contain a redirect_uri");
        }
        this.mStore.set("signOutRedirectUri", queryParameter);
        Uri.parse(queryParameter);
        open(uri);
    }
}
