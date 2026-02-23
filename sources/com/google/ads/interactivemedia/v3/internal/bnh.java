package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnh extends bkl {
    private static final bjy b(boh bohVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            return new bkd(bohVar.h());
        }
        if (i2 == 6) {
            return new bkd(new blb(bohVar.h()));
        }
        if (i2 == 7) {
            return new bkd(Boolean.valueOf(bohVar.q()));
        }
        if (i2 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(boi.a(i)));
        }
        bohVar.m();
        return bka.a;
    }

    private static final bjy c(boh bohVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            bohVar.i();
            return new bjw();
        }
        if (i2 != 2) {
            return null;
        }
        bohVar.j();
        return new bkb();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void write(boj bojVar, bjy bjyVar) throws IOException {
        if (bjyVar == null || (bjyVar instanceof bka)) {
            bojVar.g();
            return;
        }
        if (bjyVar instanceof bkd) {
            bkd bkdVar = (bkd) bjyVar;
            if (bkdVar.e()) {
                bojVar.k(bkdVar.a());
                return;
            } else if (bkdVar.d()) {
                bojVar.m(bkdVar.c());
                return;
            } else {
                bojVar.l(bkdVar.b());
                return;
            }
        }
        if (bjyVar instanceof bjw) {
            bojVar.b();
            Iterator it = ((bjw) bjyVar).iterator();
            while (it.hasNext()) {
                write(bojVar, (bjy) it.next());
            }
            bojVar.d();
            return;
        }
        if (!(bjyVar instanceof bkb)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(bjyVar.getClass())));
        }
        bojVar.c();
        for (Map.Entry entry : ((bkb) bjyVar).a()) {
            bojVar.f((String) entry.getKey());
            write(bojVar, (bjy) entry.getValue());
        }
        bojVar.e();
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar instanceof bmc) {
            return ((bmc) bohVar).d();
        }
        int r = bohVar.r();
        bjy c = c(bohVar, r);
        if (c == null) {
            return b(bohVar, r);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (bohVar.p()) {
                String g = c instanceof bkb ? bohVar.g() : null;
                int r2 = bohVar.r();
                bjy c2 = c(bohVar, r2);
                bjy b = c2 == null ? b(bohVar, r2) : c2;
                if (c instanceof bjw) {
                    ((bjw) c).a(b);
                } else {
                    ((bkb) c).b(g, b);
                }
                if (c2 != null) {
                    arrayDeque.addLast(c);
                    c = b;
                }
            } else {
                if (c instanceof bjw) {
                    bohVar.k();
                } else {
                    bohVar.l();
                }
                if (arrayDeque.isEmpty()) {
                    return c;
                }
                c = (bjy) arrayDeque.removeLast();
            }
        }
    }
}
