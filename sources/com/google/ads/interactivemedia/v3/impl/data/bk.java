package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = ab.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bk {
    public static bk create(long j, bi biVar, bj bjVar) {
        return new ab(j, biVar, bjVar, null);
    }

    public abstract bi component();

    public abstract bo loggableException();

    public abstract bj method();

    public abstract long timestamp();

    public static bk create(long j, bi biVar, bj bjVar, bo boVar) {
        return new ab(j, biVar, bjVar, boVar);
    }

    public static bk create(long j, bi biVar, bj bjVar, Throwable th) {
        return create(j, biVar, bjVar, bo.create(th));
    }
}
