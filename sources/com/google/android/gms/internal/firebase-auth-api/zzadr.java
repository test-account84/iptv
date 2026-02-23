package com.google.android.gms.internal.firebase-auth-api;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.RecaptchaActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzadr {
    private final FirebaseAuth zza;
    private final Activity zzb;

    public zzadr(FirebaseAuth firebaseAuth, Activity activity) {
        this.zza = firebaseAuth;
        this.zzb = activity;
    }

    public final void zza() {
        Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent.setClass(this.zzb, RecaptchaActivity.class);
        intent.setPackage(this.zzb.getPackageName());
        intent.putExtra("com.google.firebase.auth.KEY_API_KEY", this.zza.b().p().b());
        if (!TextUtils.isEmpty(this.zza.f())) {
            intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", this.zza.f());
        }
        intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzacr.zza().zzb());
        intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", this.zza.b().o());
        intent.putExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", this.zza.d());
        this.zzb.startActivity(intent);
    }
}
