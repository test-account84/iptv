package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class blu extends bkl {
    public static final bkm a = new blw(1);
    private final Class b;
    private final bkl c;

    public blu(bjt bjtVar, bkl bklVar, Class cls) {
        this.c = new bmp(bjtVar, bklVar, cls);
        this.b = cls;
    }

    public final Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bohVar.i();
        while (bohVar.p()) {
            arrayList.add(this.c.read(bohVar));
        }
        bohVar.k();
        int size = arrayList.size();
        if (!this.b.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.b, size));
        }
        Object newInstance = Array.newInstance(this.b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        if (obj == null) {
            bojVar.g();
            return;
        }
        bojVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.write(bojVar, Array.get(obj, i));
        }
        bojVar.d();
    }
}
