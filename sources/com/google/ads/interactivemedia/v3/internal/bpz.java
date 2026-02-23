package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bpz {
    final brs a;
    final bqm b;

    public bpz() {
    }

    public final btk a() {
        return this.b.c;
    }

    public final boolean b() {
        return this.b.d;
    }

    public bpz(brs brsVar, brs brsVar2, bqm bqmVar) {
        this();
        if (brsVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (bqmVar.c == btk.k && brsVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.a = brsVar2;
        this.b = bqmVar;
    }
}
