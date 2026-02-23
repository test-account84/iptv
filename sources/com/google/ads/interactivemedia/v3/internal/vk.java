package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vk {
    private final Object a;

    public vk() {
        this.a = bn.a;
    }

    public static vk e(byte[] bArr) {
        return new vk(bjj.b(bArr));
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.ads.interactivemedia.v3.internal.bn, java.lang.Object] */
    public final vl a(bf bfVar, int[] iArr, wq wqVar, avo avoVar) {
        return new vl(bfVar, iArr, wqVar, avoVar, this.a);
    }

    public final co b(int i) {
        co coVar = (co) ((SparseArray) this.a).get(i);
        if (coVar != null) {
            return coVar;
        }
        co coVar2 = new co(9223372036854775806L);
        ((SparseArray) this.a).put(i, coVar2);
        return coVar2;
    }

    public final void c() {
        ((SparseArray) this.a).clear();
    }

    public final int d() {
        return ((bjj) this.a).a();
    }

    private vk(bjj bjjVar) {
        this.a = bjjVar;
    }

    public vk(byte[] bArr) {
        this.a = new SparseArray();
    }
}
