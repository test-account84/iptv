package com.google.firebase.auth.internal;

import A5.f;
import C4.h;
import C4.j;
import H5.A;
import H5.B;
import H5.P;
import H5.S;
import H5.W;
import H5.Y;
import H5.m;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.zzaci;
import com.google.android.gms.internal.firebase-auth-api.zzacj;
import com.google.android.gms.internal.firebase-auth-api.zzack;
import com.google.android.gms.internal.firebase-auth-api.zzacw;
import com.google.android.gms.internal.firebase-auth-api.zzaed;
import com.google.android.gms.internal.firebase-auth-api.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import d.D;
import j6.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import p.d;
import p0.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class RecaptchaActivity extends e implements zzack {
    public static final String c = "RecaptchaActivity";
    public static long d;
    public static final S e = S.c();
    public boolean a = false;

    private final Uri.Builder h1(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        f n = f.n(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(n);
        W.b().d(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String b = Y.a(getApplicationContext(), n.q()).b();
        if (TextUtils.isEmpty(b)) {
            Log.e(c, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            i1(m.a("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", !TextUtils.isEmpty(firebaseAuth.e()) ? firebaseAuth.e() : zzacw.zza()).appendQueryParameter("eventId", uuid).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", b);
        return builder;
    }

    private final void i1(Status status) {
        d = 0L;
        this.a = false;
        Intent intent = new Intent();
        P.b(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        k1(intent);
        e.a(this);
        finish();
    }

    private final boolean k1(Intent intent) {
        return a.b(this).d(intent);
    }

    private final void l1() {
        d = 0L;
        this.a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        k1(intent);
        e.a(this);
        finish();
    }

    public final /* synthetic */ void j1(String str, Task task) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e(c, "Device cannot resolve intent for: android.intent.action.VIEW");
            zzacj.zzb(this, str);
            return;
        }
        List queryIntentServices = getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            d a = new d.a().a();
            a.a.addFlags(1073741824);
            a.a.addFlags(268435456);
            a.a(this, (Uri) task.getResult());
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
        intent.putExtra("com.android.browser.application_id", str);
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e(c, "Could not do operation - unknown action: " + action);
            l1();
            return;
        }
        long a = h.c().a();
        if (a - d < 30000) {
            Log.e(c, "Could not start operation - already in progress");
            return;
        }
        d = a;
        if (bundle != null) {
            this.a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
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
            Intent intent = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = j.b(C4.a.a(this, packageName)).toLowerCase(Locale.US);
                f n = f.n(intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(n);
                if (zzaed.zza(n)) {
                    zza(h1(Uri.parse(zzaed.zza(n.p().b())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.B());
                } else {
                    new zzaci(packageName, lowerCase, intent, n, this).executeOnExecutor(firebaseAuth.D(), new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(c, "Could not get package signature: " + packageName + " " + String.valueOf(e2));
                zzacj.zzb(this, packageName);
            }
            this.a = true;
            return;
        }
        Intent intent2 = getIntent();
        if (intent2.hasExtra("firebaseError")) {
            i1(P.a(intent2.getStringExtra("firebaseError")));
            return;
        }
        if (!intent2.hasExtra("link") || !intent2.hasExtra("eventId")) {
            l1();
            return;
        }
        String stringExtra = intent2.getStringExtra("link");
        String g = W.b().g(getApplicationContext(), getPackageName(), intent2.getStringExtra("eventId"));
        if (TextUtils.isEmpty(g)) {
            Log.e(c, "Failed to find registration for this event - failing to prevent session injection.");
            i1(m.a("Failed to find registration for this reCAPTCHA event"));
        }
        if (intent2.getBooleanExtra("encryptionEnabled", true)) {
            stringExtra = Y.a(getApplicationContext(), f.n(g).q()).c(stringExtra);
        }
        String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
        d = 0L;
        this.a = false;
        Intent intent3 = new Intent();
        intent3.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
        intent3.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent3.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (k1(intent3)) {
            e.a(this);
        } else {
            A.d(getApplicationContext(), queryParameter, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        }
        finish();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.a);
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
            zzack.zza.c("Error generating connection", new Object[0]);
            return null;
        }
    }

    public final void zza(Uri uri, String str, b bVar) {
        D.a(bVar.get());
        Tasks.forResult(uri).addOnCompleteListener(new B(this, str));
    }

    public final void zza(String str, Status status) {
        if (status == null) {
            l1();
        } else {
            i1(status);
        }
    }
}
