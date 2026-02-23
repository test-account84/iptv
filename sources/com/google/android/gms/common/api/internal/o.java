package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o {
    public final k a;
    public final w4.d[] b;
    public final boolean c;
    public final int d;

    public o(k kVar, w4.d[] dVarArr, boolean z, int i) {
        this.a = kVar;
        this.b = dVarArr;
        this.c = z;
        this.d = i;
    }

    public void a() {
        this.a.a();
    }

    public k.a b() {
        return this.a.b();
    }

    public w4.d[] c() {
        return this.b;
    }

    public abstract void d(a.b bVar, TaskCompletionSource taskCompletionSource);

    public final int e() {
        return this.d;
    }

    public final boolean f() {
        return this.c;
    }
}
