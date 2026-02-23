package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bmj extends bkl {
    private final blk a;
    private final Map b;

    public bmj(blk blkVar, Map map) {
        this.a = blkVar;
        this.b = map;
    }

    public final Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        Object a = this.a.a();
        try {
            bohVar.j();
            while (bohVar.p()) {
                bmk bmkVar = (bmk) this.b.get(bohVar.g());
                if (bmkVar == null || !bmkVar.c) {
                    bohVar.o();
                } else {
                    bmkVar.a(bohVar, a);
                }
            }
            bohVar.l();
            return a;
        } catch (IllegalAccessException e) {
            throw blo.e(e);
        } catch (IllegalStateException e2) {
            throw new bkf((Throwable) e2);
        }
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        if (obj == null) {
            bojVar.g();
            return;
        }
        bojVar.c();
        try {
            Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                ((bmk) it.next()).b(bojVar, obj);
            }
            bojVar.e();
        } catch (IllegalAccessException e) {
            throw blo.e(e);
        }
    }
}
