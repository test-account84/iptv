package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmf extends bkl {
    private final bkl a;
    private final bkl b;
    private final blk c;

    public bmf(bjt bjtVar, Type type, bkl bklVar, Type type2, bkl bklVar2, blk blkVar) {
        this.a = new bmp(bjtVar, bklVar, type);
        this.b = new bmp(bjtVar, bklVar2, type2);
        this.c = blkVar;
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        int r = bohVar.r();
        if (r == 9) {
            bohVar.m();
            return null;
        }
        Map map = (Map) this.c.a();
        if (r == 1) {
            bohVar.i();
            while (bohVar.p()) {
                bohVar.i();
                Object read = this.a.read(bohVar);
                if (map.put(read, this.b.read(bohVar)) != null) {
                    throw new bkf("duplicate key: ".concat(String.valueOf(read)));
                }
                bohVar.k();
            }
            bohVar.k();
        } else {
            bohVar.j();
            while (bohVar.p()) {
                bla.a.a(bohVar);
                Object read2 = this.a.read(bohVar);
                if (map.put(read2, this.b.read(bohVar)) != null) {
                    throw new bkf("duplicate key: ".concat(String.valueOf(read2)));
                }
            }
            bohVar.l();
        }
        return map;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            bojVar.g();
            return;
        }
        bojVar.c();
        for (Map.Entry entry : map.entrySet()) {
            bojVar.f(String.valueOf(entry.getKey()));
            this.b.write(bojVar, entry.getValue());
        }
        bojVar.e();
    }
}
