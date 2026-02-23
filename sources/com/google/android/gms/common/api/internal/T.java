package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class t {
    public final w4.d[] a;
    public final boolean b;
    public final int c;

    public static class a {
        public q a;
        public w4.d[] c;
        public boolean b = true;
        public int d = 0;

        public /* synthetic */ a(L0 l0) {
        }

        public static /* bridge */ /* synthetic */ q f(a aVar) {
            return aVar.a;
        }

        public t a() {
            com.google.android.gms.common.internal.r.b(this.a != null, "execute parameter required");
            return new K0(this, this.c, this.b, this.d);
        }

        public a b(q qVar) {
            this.a = qVar;
            return this;
        }

        public a c(boolean z) {
            this.b = z;
            return this;
        }

        public a d(w4.d... dVarArr) {
            this.c = dVarArr;
            return this;
        }

        public a e(int i) {
            this.d = i;
            return this;
        }
    }

    public t(w4.d[] dVarArr, boolean z, int i) {
        this.a = dVarArr;
        boolean z2 = false;
        if (dVarArr != null && z) {
            z2 = true;
        }
        this.b = z2;
        this.c = i;
    }

    public static a a() {
        return new a(null);
    }

    public abstract void b(a.b bVar, TaskCompletionSource taskCompletionSource);

    public boolean c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final w4.d[] e() {
        return this.a;
    }
}
