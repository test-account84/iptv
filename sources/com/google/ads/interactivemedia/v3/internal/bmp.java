package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmp extends bkl {
    private final bjt a;
    private final bkl b;
    private final Type c;

    public bmp(bjt bjtVar, bkl bklVar, Type type) {
        this.a = bjtVar;
        this.b = bklVar;
        this.c = type;
    }

    public final Object read(boh bohVar) throws IOException {
        return this.b.read(bohVar);
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        bkl bklVar = this.b;
        Class cls = this.c;
        Class cls2 = (obj == null || !(cls == Object.class || (cls instanceof TypeVariable) || (cls instanceof Class))) ? cls : obj.getClass();
        if (cls2 != cls) {
            bklVar = this.a.a(bof.b(cls2));
            if (bklVar instanceof bmj) {
                bkl bklVar2 = this.b;
                if (!(bklVar2 instanceof bmj)) {
                    bklVar = bklVar2;
                }
            }
        }
        bklVar.write(bojVar, obj);
    }
}
