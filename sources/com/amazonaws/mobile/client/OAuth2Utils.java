package com.amazonaws.mobile.client;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import java.util.Map;
import p.c;
import p.d;
import p.e;
import p.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class OAuth2Utils {
    private p.b customTabsCallback = new p.b();
    private final Context mContext;
    private c mCustomTabsClient;
    private e mCustomTabsServiceConnection;
    private f mCustomTabsSession;
    private String mError;
    private String mErrorDescription;
    private final Uri mSignInRedirectUri;
    private String mState;

    public class 1 extends e {
        public 1() {
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, c cVar) {
            OAuth2Utils.access$002(OAuth2Utils.this, cVar);
            OAuth2Utils.access$000(OAuth2Utils.this).g(0L);
            OAuth2Utils oAuth2Utils = OAuth2Utils.this;
            OAuth2Utils.access$102(oAuth2Utils, OAuth2Utils.access$000(oAuth2Utils).e(OAuth2Utils.access$200(OAuth2Utils.this)));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            OAuth2Utils.access$002(OAuth2Utils.this, null);
        }
    }

    public OAuth2Utils(Context context, Uri uri) {
        this.mContext = context;
        this.mSignInRedirectUri = uri;
    }

    public static /* synthetic */ c access$000(OAuth2Utils oAuth2Utils) {
        return oAuth2Utils.mCustomTabsClient;
    }

    public static /* synthetic */ c access$002(OAuth2Utils oAuth2Utils, c cVar) {
        oAuth2Utils.mCustomTabsClient = cVar;
        return cVar;
    }

    public static /* synthetic */ f access$102(OAuth2Utils oAuth2Utils, f fVar) {
        oAuth2Utils.mCustomTabsSession = fVar;
        return fVar;
    }

    public static /* synthetic */ p.b access$200(OAuth2Utils oAuth2Utils) {
        return oAuth2Utils.customTabsCallback;
    }

    public void authorize(String str, String str2, Map map) {
        this.mState = Pkce.generateRandom();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        if (!map.containsKey("code")) {
            buildUpon.appendQueryParameter("response_type", "code");
        }
        if (!map.containsKey("client_id")) {
            if (str2 == null) {
                throw new IllegalArgumentException("Client id must be specified for an authorization request.");
            }
            buildUpon.appendQueryParameter("client_id", str2);
        }
        buildUpon.appendQueryParameter("state", this.mState);
        navigate(buildUpon.build());
    }

    public Uri exchangeCode(String str) {
        return null;
    }

    public void navigate(Uri uri) {
        d a = new d.a(this.mCustomTabsSession).a();
        a.a.setPackage("com.android.chrome");
        a.a.addFlags(1073741824);
        a.a.addFlags(268435456);
        a.a(this.mContext, uri);
    }

    public boolean parse(Uri uri) {
        if (uri.getScheme().equals(this.mSignInRedirectUri.getScheme()) && uri.getAuthority().equals(this.mSignInRedirectUri.getAuthority()) && uri.getPath().equals(this.mSignInRedirectUri.getPath()) && uri.getQueryParameterNames().containsAll(this.mSignInRedirectUri.getQueryParameterNames())) {
            uri.getQueryParameter("code");
            if (!this.mState.equals(uri.getQueryParameter("state"))) {
                return false;
            }
            this.mError = uri.getQueryParameter("error");
            this.mErrorDescription = uri.getQueryParameter("error_description");
            if (this.mError != null) {
                return true;
            }
        }
        return false;
    }

    public void preWarm() {
        1 r0 = new 1();
        this.mCustomTabsServiceConnection = r0;
        c.a(this.mContext, "com.android.chrome", r0);
    }
}
