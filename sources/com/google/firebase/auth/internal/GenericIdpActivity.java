package com.google.firebase.auth.internal;

import A5.f;
import C4.h;
import C4.j;
import H5.A;
import H5.P;
import H5.S;
import H5.V;
import H5.W;
import H5.Y;
import H5.m;
import H5.u;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.zzaci;
import com.google.android.gms.internal.firebase-auth-api.zzacj;
import com.google.android.gms.internal.firebase-auth-api.zzack;
import com.google.android.gms.internal.firebase-auth-api.zzaed;
import com.google.android.gms.internal.firebase-auth-api.zzagt;
import com.google.android.gms.internal.firebase-auth-api.zzb;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import d.D;
import j6.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p0.a;

@KeepName
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class GenericIdpActivity extends e implements zzack {
    public static long c;
    public static final S d = S.c();
    public boolean a = false;

    public static String i1(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(str, string);
                }
            }
        } catch (JSONException unused) {
            Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
        }
        return jSONObject.toString();
    }

    public final Uri.Builder h1(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        String i1 = i1(intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS"));
        String uuid = UUID.randomUUID().toString();
        String zza = zzacj.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str3 = join;
        W.b().e(getApplicationContext(), str, uuid, zza, action, stringExtra2, stringExtra3, stringExtra4);
        String b = Y.a(getApplicationContext(), f.n(stringExtra4).q()).b();
        if (TextUtils.isEmpty(b)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            j1(m.a("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        if (zza == null) {
            return null;
        }
        builder.appendQueryParameter("eid", "p").appendQueryParameter("v", "X" + stringExtra5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", zza).appendQueryParameter("eventId", uuid).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", b);
        if (!TextUtils.isEmpty(str3)) {
            builder.appendQueryParameter("scopes", str3);
        }
        if (!TextUtils.isEmpty(i1)) {
            builder.appendQueryParameter("customParameters", i1);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            builder.appendQueryParameter("tid", stringExtra3);
        }
        return builder;
    }

    public final void j1(Status status) {
        c = 0L;
        this.a = false;
        Intent intent = new Intent();
        P.b(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (k1(intent)) {
            d.a(this);
        } else {
            A.b(getApplicationContext(), status);
        }
        finish();
    }

    public final boolean k1(Intent intent) {
        return a.b(this).d(intent);
    }

    public final void l1() {
        c = 0L;
        this.a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (k1(intent)) {
            d.a(this);
        } else {
            A.b(this, m.a("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("GenericIdpActivity", "Could not do operation - unknown action: " + action);
            l1();
            return;
        }
        long a = h.c().a();
        if (a - c < 30000) {
            Log.e("GenericIdpActivity", "Could not start operation - already in progress");
            return;
        }
        c = a;
        if (bundle != null) {
            this.a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.a) {
                l1();
                return;
            }
            String packageName = getPackageName();
            try {
                String lowerCase = j.b(C4.a.a(this, packageName)).toLowerCase(Locale.US);
                f n = f.n(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(n);
                if (zzaed.zza(n)) {
                    zza(h1(Uri.parse(zzaed.zza(n.p().b())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.B());
                } else {
                    new zzaci(packageName, lowerCase, getIntent(), n, this).executeOnExecutor(firebaseAuth.D(), new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName + " " + String.valueOf(e));
                zzacj.zzb(this, packageName);
            }
            this.a = true;
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("firebaseError")) {
            j1(P.a(intent.getStringExtra("firebaseError")));
            return;
        }
        if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
            l1();
            return;
        }
        String stringExtra = intent.getStringExtra("link");
        String stringExtra2 = intent.getStringExtra("eventId");
        String packageName2 = getPackageName();
        boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
        V a = W.b().a(this, packageName2, stringExtra2);
        if (a == null) {
            l1();
        }
        if (booleanExtra) {
            stringExtra = Y.a(getApplicationContext(), f.n(a.a()).q()).c(stringExtra);
        }
        zzagt zzagtVar = new zzagt(a, stringExtra);
        String e2 = a.e();
        String b = a.b();
        zzagtVar.zzb(e2);
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(b) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(b) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(b)) {
            Log.e("GenericIdpActivity", "unsupported operation: " + b);
            l1();
            return;
        }
        c = 0L;
        this.a = false;
        Intent intent2 = new Intent();
        y4.e.d(zzagtVar, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
        intent2.putExtra("com.google.firebase.auth.internal.OPERATION", b);
        intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (k1(intent2)) {
            d.a(this);
        } else {
            A.c(getApplicationContext(), zzagtVar, b, e2);
        }
        finish();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.a);
    }

    public final Context zza() {
        return getApplicationContext();
    }

    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return h1(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    public final String zza(String str) {
        return zzaed.zzb(str);
    }

    public final HttpURLConnection zza(URL url) {
        try {
            return zzb.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    public final void zza(Uri uri, String str, b bVar) {
        D.a(bVar.get());
        Tasks.forResult(uri).addOnCompleteListener(new u(this, str));
    }

    public final void zza(String str, Status status) {
        if (status == null) {
            l1();
        } else {
            j1(status);
        }
    }
}
