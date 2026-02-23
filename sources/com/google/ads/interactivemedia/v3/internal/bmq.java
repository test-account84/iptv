package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmq extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bohVar.i();
        while (bohVar.p()) {
            try {
                arrayList.add(Integer.valueOf(bohVar.b()));
            } catch (NumberFormatException e) {
                throw new bkf((Throwable) e);
            }
        }
        bohVar.k();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        bojVar.b();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i = 0; i < length; i++) {
            bojVar.i(r6.get(i));
        }
        bojVar.d();
    }
}
