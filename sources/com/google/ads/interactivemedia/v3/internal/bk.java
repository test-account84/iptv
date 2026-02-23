package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bk {
    public static final bk a = new bk(avo.o());
    private final avo b;

    public bk(List list) {
        this.b = avo.m(list);
    }

    public final avo a() {
        return this.b;
    }

    public final boolean b(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            bj bjVar = (bj) this.b.get(i2);
            if (bjVar.c() && bjVar.a() == i) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bk.class != obj.getClass()) {
            return false;
        }
        return this.b.equals(((bk) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
