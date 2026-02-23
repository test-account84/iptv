package com.google.android.gms.common.api.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m0 {
    public final b a;
    public final w4.d b;

    public /* synthetic */ m0(b bVar, w4.d dVar, l0 l0Var) {
        this.a = bVar;
        this.b = dVar;
    }

    public static /* bridge */ /* synthetic */ w4.d a(m0 m0Var) {
        return m0Var.b;
    }

    public static /* bridge */ /* synthetic */ b b(m0 m0Var) {
        return m0Var.a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof m0)) {
            m0 m0Var = (m0) obj;
            if (com.google.android.gms.common.internal.q.b(this.a, m0Var.a) && com.google.android.gms.common.internal.q.b(this.b, m0Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.a, this.b);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.q.d(this).a("key", this.a).a("feature", this.b).toString();
    }
}
