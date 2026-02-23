package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ul {
    private int a;
    private final SparseArray b;
    private final bp c;

    public ul() {
        uk ukVar = uk.a;
        throw null;
    }

    public final Object a(int i) {
        if (this.a == -1) {
            this.a = 0;
        }
        while (true) {
            int i2 = this.a;
            if (i2 > 0 && i < this.b.keyAt(i2)) {
                this.a--;
            }
        }
        while (this.a < this.b.size() - 1 && i >= this.b.keyAt(this.a + 1)) {
            this.a++;
        }
        return this.b.valueAt(this.a);
    }

    public final Object b() {
        return this.b.valueAt(r0.size() - 1);
    }

    public final void c(int i, Object obj) {
        if (this.a == -1) {
            af.w(this.b.size() == 0);
            this.a = 0;
        }
        if (this.b.size() > 0) {
            int keyAt = this.b.keyAt(r0.size() - 1);
            af.u(i >= keyAt);
            if (keyAt == i) {
                this.c.a(this.b.valueAt(r1.size() - 1));
            }
        }
        this.b.append(i, obj);
    }

    public final void d() {
        for (int i = 0; i < this.b.size(); i++) {
            this.c.a(this.b.valueAt(i));
        }
        this.a = -1;
        this.b.clear();
    }

    public final void e(int i) {
        for (int size = this.b.size() - 1; size >= 0 && i < this.b.keyAt(size); size--) {
            this.c.a(this.b.valueAt(size));
            this.b.removeAt(size);
        }
        this.a = this.b.size() > 0 ? Math.min(this.a, this.b.size() - 1) : -1;
    }

    public final void f(int i) {
        int i2 = 0;
        while (i2 < this.b.size() - 1) {
            int i3 = i2 + 1;
            if (i < this.b.keyAt(i3)) {
                return;
            }
            this.c.a(this.b.valueAt(i2));
            this.b.removeAt(i2);
            int i4 = this.a;
            if (i4 > 0) {
                this.a = i4 - 1;
            }
            i2 = i3;
        }
    }

    public final boolean g() {
        return this.b.size() == 0;
    }

    public ul(bp bpVar) {
        this.b = new SparseArray();
        this.c = bpVar;
        this.a = -1;
    }
}
