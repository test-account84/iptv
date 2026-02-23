package com.google.firebase.auth;

import G5.h;
import G5.u;
import H5.D;
import H5.Q;
import H5.T;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends D {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ u b;
    public final /* synthetic */ h c;
    public final /* synthetic */ FirebaseAuth d;

    public b(FirebaseAuth firebaseAuth, boolean z, u uVar, h hVar) {
        this.d = firebaseAuth;
        this.a = z;
        this.b = uVar;
        this.c = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [H5.Q, com.google.firebase.auth.FirebaseAuth$b] */
    public final Task d(String str) {
        Log.i("FirebaseAuth", TextUtils.isEmpty(str) ? "Email link login/reauth with empty reCAPTCHA token" : "Got reCAPTCHA token for login/reauth with email link");
        return this.a ? FirebaseAuth.z(this.d).zzb(FirebaseAuth.l(this.d), (u) r.m(this.b), this.c, str, (Q) new FirebaseAuth.b(this.d)) : FirebaseAuth.z(this.d).zza(FirebaseAuth.l(this.d), this.c, str, (T) new FirebaseAuth.a(this.d));
    }
}
