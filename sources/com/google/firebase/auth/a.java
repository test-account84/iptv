package com.google.firebase.auth;

import G5.u;
import H5.D;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends D {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ u c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ FirebaseAuth f;

    public a(FirebaseAuth firebaseAuth, String str, boolean z, u uVar, String str2, String str3) {
        this.f = firebaseAuth;
        this.a = str;
        this.b = z;
        this.c = uVar;
        this.d = str2;
        this.e = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [H5.Q, com.google.firebase.auth.FirebaseAuth$b] */
    public final Task d(String str) {
        String str2;
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.a;
            sb = new StringBuilder("Logging in as ");
            sb.append(str3);
            str2 = " with empty reCAPTCHA token";
        } else {
            str2 = this.a;
            sb = new StringBuilder("Got reCAPTCHA token for login with email ");
        }
        sb.append(str2);
        Log.i("FirebaseAuth", sb.toString());
        return this.b ? FirebaseAuth.z(this.f).zzb(FirebaseAuth.l(this.f), (u) r.m(this.c), this.a, this.d, this.e, str, new FirebaseAuth.b(this.f)) : FirebaseAuth.z(this.f).zzb(FirebaseAuth.l(this.f), this.a, this.d, this.e, str, new FirebaseAuth.a(this.f));
    }
}
