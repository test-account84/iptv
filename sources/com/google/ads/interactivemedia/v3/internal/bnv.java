package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnv extends bkl {
    private final Map a = new HashMap();
    private final Map b = new HashMap();
    private final Map c = new HashMap();

    public bnv(Class cls) {
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new bnu(cls))) {
                Enum r4 = (Enum) field.get((Object) null);
                String name = r4.name();
                String str = r4.toString();
                bko bkoVar = (bko) field.getAnnotation(bko.class);
                if (bkoVar != null) {
                    name = bkoVar.a();
                    for (String str2 : bkoVar.b()) {
                        this.a.put(str2, r4);
                    }
                }
                this.a.put(name, r4);
                this.b.put(str, r4);
                this.c.put(r4, name);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        Enum r0 = (Enum) this.a.get(h);
        return r0 != null ? r0 : (Enum) this.b.get(h);
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Enum r3 = (Enum) obj;
        bojVar.l(r3 == null ? null : (String) this.c.get(r3));
    }
}
