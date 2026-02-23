package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bmi extends bkl {
    private static final bkm a = b(bki.DOUBLE);
    private final bjt b;
    private final bkj c;

    public /* synthetic */ bmi(bjt bjtVar, bkj bkjVar) {
        this.b = bjtVar;
        this.c = bkjVar;
    }

    public static bkm a(bkj bkjVar) {
        return bkjVar == bki.DOUBLE ? a : b(bkjVar);
    }

    private static bkm b(bkj bkjVar) {
        return new bmh(bkjVar, 0);
    }

    private final Object c(boh bohVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            return bohVar.h();
        }
        if (i2 == 6) {
            return this.c.a(bohVar);
        }
        if (i2 == 7) {
            return Boolean.valueOf(bohVar.q());
        }
        if (i2 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(boi.a(i)));
        }
        bohVar.m();
        return null;
    }

    private static final Object d(boh bohVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            bohVar.i();
            return new ArrayList();
        }
        if (i2 != 2) {
            return null;
        }
        bohVar.j();
        return new blj();
    }

    public final Object read(boh bohVar) throws IOException {
        int r = bohVar.r();
        Object d = d(bohVar, r);
        if (d == null) {
            return c(bohVar, r);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (bohVar.p()) {
                String g = d instanceof Map ? bohVar.g() : null;
                int r2 = bohVar.r();
                Object d2 = d(bohVar, r2);
                Object c = d2 == null ? c(bohVar, r2) : d2;
                if (d instanceof List) {
                    ((List) d).add(c);
                } else {
                    ((Map) d).put(g, c);
                }
                if (d2 != null) {
                    arrayDeque.addLast(d);
                    d = c;
                }
            } else {
                if (d instanceof List) {
                    bohVar.k();
                } else {
                    bohVar.l();
                }
                if (arrayDeque.isEmpty()) {
                    return d;
                }
                d = arrayDeque.removeLast();
            }
        }
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        if (obj == null) {
            bojVar.g();
            return;
        }
        bkl b = this.b.b(obj.getClass());
        if (!(b instanceof bmi)) {
            b.write(bojVar, obj);
        } else {
            bojVar.c();
            bojVar.e();
        }
    }
}
