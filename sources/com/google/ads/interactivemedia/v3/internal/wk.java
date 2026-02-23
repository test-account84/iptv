package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class wk {
    public final int a;
    public final hj[] b;
    public final we[] c;
    public final bk d;
    public final Object e;

    public wk(hj[] hjVarArr, we[] weVarArr, bk bkVar, Object obj) {
        this.b = hjVarArr;
        this.c = (we[]) weVarArr.clone();
        this.d = bkVar;
        this.e = obj;
        this.a = hjVarArr.length;
    }

    public final boolean a(wk wkVar, int i) {
        return wkVar != null && cq.V(this.b[i], wkVar.b[i]) && cq.V(this.c[i], wkVar.c[i]);
    }

    public final boolean b(int i) {
        return this.b[i] != null;
    }
}
