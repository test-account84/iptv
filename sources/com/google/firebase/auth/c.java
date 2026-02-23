package com.google.firebase.auth;

import G5.g;
import G5.h;
import G5.u;
import H5.D;
import H5.Q;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends D {
    public final /* synthetic */ u a;
    public final /* synthetic */ h b;
    public final /* synthetic */ FirebaseAuth c;

    public c(FirebaseAuth firebaseAuth, u uVar, h hVar) {
        this.c = firebaseAuth;
        this.a = uVar;
        this.b = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [H5.Q, com.google.firebase.auth.FirebaseAuth$b] */
    public final Task d(String str) {
        Log.i("FirebaseAuth", TextUtils.isEmpty(str) ? "Linking email account with empty reCAPTCHA token" : "Got reCAPTCHA token for linking email account");
        return FirebaseAuth.z(this.c).zza(FirebaseAuth.l(this.c), this.a, (g) this.b, str, (Q) new FirebaseAuth.b(this.c));
    }
}
