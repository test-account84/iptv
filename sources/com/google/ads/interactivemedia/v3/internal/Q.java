package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseBooleanArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q {
    private final SparseBooleanArray a;

    public /* synthetic */ q(SparseBooleanArray sparseBooleanArray) {
        this.a = sparseBooleanArray;
    }

    public final int a(int i) {
        af.y(i, b());
        return this.a.keyAt(i);
    }

    public final int b() {
        return this.a.size();
    }

    public final boolean c(int i) {
        return this.a.get(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (cq.a >= 24) {
            return this.a.equals(qVar.a);
        }
        if (b() != qVar.b()) {
            return false;
        }
        for (int i = 0; i < b(); i++) {
            if (a(i) != qVar.a(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (cq.a >= 24) {
            return this.a.hashCode();
        }
        int b = b();
        for (int i = 0; i < b(); i++) {
            b = (b * 31) + a(i);
        }
        return b;
    }
}
