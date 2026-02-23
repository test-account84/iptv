package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yr {
    public final List a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final String f;

    private yr(List list, int i, int i2, int i3, float f, String str) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = str;
    }

    public static yr a(cj cjVar) throws as {
        String str;
        int i;
        int i2;
        float f;
        try {
            cjVar.G(4);
            int i3 = (cjVar.i() & 3) + 1;
            if (i3 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int i4 = cjVar.i() & 31;
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(b(cjVar));
            }
            int i6 = cjVar.i();
            for (int i7 = 0; i7 < i6; i7++) {
                arrayList.add(b(cjVar));
            }
            if (i4 > 0) {
                zv c = zw.c((byte[]) arrayList.get(0), i3, ((byte[]) arrayList.get(0)).length);
                int i8 = c.e;
                int i9 = c.f;
                float f2 = c.g;
                str = bo.a(c.a, c.b, c.c);
                i = i8;
                i2 = i9;
                f = f2;
            } else {
                str = null;
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new yr(arrayList, i3, i, i2, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw as.a("Error parsing AVC config", e);
        }
    }

    private static byte[] b(cj cjVar) {
        int m = cjVar.m();
        int c = cjVar.c();
        cjVar.G(m);
        return bo.c(cjVar.H(), c, m);
    }
}
