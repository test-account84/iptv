package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class atg implements bkm {
    public final bkl a(bjt bjtVar, bof bofVar) {
        Class c = bofVar.c();
        atf atfVar = (atf) c.getAnnotation(atf.class);
        if (atfVar == null || c == atfVar.a()) {
            return null;
        }
        return bjtVar.b(atfVar.a());
    }
}
