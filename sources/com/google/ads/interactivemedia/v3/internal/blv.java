package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class blv extends bkl {
    private final bkl a;
    private final blk b;

    public blv(bjt bjtVar, Type type, bkl bklVar, blk blkVar) {
        this.a = new bmp(bjtVar, bklVar, type);
        this.b = blkVar;
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        Collection collection = (Collection) this.b.a();
        bohVar.i();
        while (bohVar.p()) {
            collection.add(this.a.read(bohVar));
        }
        bohVar.k();
        return collection;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Collection collection = (Collection) obj;
        if (collection == null) {
            bojVar.g();
            return;
        }
        bojVar.b();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.a.write(bojVar, it.next());
        }
        bojVar.d();
    }
}
