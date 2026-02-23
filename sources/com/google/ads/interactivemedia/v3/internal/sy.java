package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class sy extends st {
    public static final Object c = new Object();
    private final Object d;
    private final Object e;

    private sy(be beVar, Object obj, Object obj2) {
        super(beVar);
        this.d = obj;
        this.e = obj2;
    }

    public static sy s(ai aiVar) {
        return new sy(new sz(aiVar), bd.a, c);
    }

    public static sy t(be beVar, Object obj, Object obj2) {
        return new sy(beVar, obj, obj2);
    }

    public static /* bridge */ /* synthetic */ Object u(sy syVar) {
        return syVar.e;
    }

    public final int a(Object obj) {
        Object obj2;
        be beVar = this.b;
        if (c.equals(obj) && (obj2 = this.e) != null) {
            obj = obj2;
        }
        return beVar.a(obj);
    }

    public final bc d(int i, bc bcVar, boolean z) {
        this.b.d(i, bcVar, z);
        if (cq.V(bcVar.b, this.e) && z) {
            bcVar.b = c;
        }
        return bcVar;
    }

    public final bd e(int i, bd bdVar, long j) {
        this.b.e(i, bdVar, j);
        if (cq.V(bdVar.b, this.d)) {
            bdVar.b = bd.a;
        }
        return bdVar;
    }

    public final Object f(int i) {
        Object f = this.b.f(i);
        return cq.V(f, this.e) ? c : f;
    }

    public final sy r(be beVar) {
        return new sy(beVar, this.d, this.e);
    }
}
