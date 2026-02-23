package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bjr extends bkl {
    final /* synthetic */ bkl a;

    public bjr(bkl bklVar) {
        this.a = bklVar;
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bohVar.i();
        while (bohVar.p()) {
            arrayList.add(Long.valueOf(((Number) this.a.read(bohVar)).longValue()));
        }
        bohVar.k();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        bojVar.b();
        int length = atomicLongArray.length();
        for (int i = 0; i < length; i++) {
            this.a.write(bojVar, Long.valueOf(atomicLongArray.get(i)));
        }
        bojVar.d();
    }
}
