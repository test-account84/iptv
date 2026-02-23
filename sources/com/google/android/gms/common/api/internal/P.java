package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p {
    public final o a;
    public final v b;
    public final Runnable c;

    public static class a {
        public q a;
        public q b;
        public k d;
        public w4.d[] e;
        public int g;
        public Runnable c = B0.a;
        public boolean f = true;

        public /* synthetic */ a(E0 e0) {
        }

        public static /* bridge */ /* synthetic */ q g(a aVar) {
            return aVar.a;
        }

        public static /* bridge */ /* synthetic */ q h(a aVar) {
            return aVar.b;
        }

        public p a() {
            com.google.android.gms.common.internal.r.b(this.a != null, "Must set register function");
            com.google.android.gms.common.internal.r.b(this.b != null, "Must set unregister function");
            com.google.android.gms.common.internal.r.b(this.d != null, "Must set holder");
            return new p(new C0(this, this.d, this.e, this.f, this.g), new D0(this, (k.a) com.google.android.gms.common.internal.r.n(this.d.b(), "Key must not be null")), this.c, null);
        }

        public a b(q qVar) {
            this.a = qVar;
            return this;
        }

        public a c(w4.d... dVarArr) {
            this.e = dVarArr;
            return this;
        }

        public a d(int i) {
            this.g = i;
            return this;
        }

        public a e(q qVar) {
            this.b = qVar;
            return this;
        }

        public a f(k kVar) {
            this.d = kVar;
            return this;
        }
    }

    public /* synthetic */ p(o oVar, v vVar, Runnable runnable, F0 f0) {
        this.a = oVar;
        this.b = vVar;
        this.c = runnable;
    }

    public static a a() {
        return new a(null);
    }
}
