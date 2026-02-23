package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class xi {
    private static final Comparator a = xg.b;
    private static final Comparator b = xg.a;
    private int g;
    private int h;
    private int i;
    private final int c = 2000;
    private final xh[] e = new xh[5];
    private final ArrayList d = new ArrayList();
    private int f = -1;

    public xi(int i) {
    }

    public final void a(int i, float f) {
        xh xhVar;
        int i2;
        xh xhVar2;
        int i3;
        if (this.f != 1) {
            Collections.sort(this.d, a);
            this.f = 1;
        }
        int i4 = this.i;
        if (i4 > 0) {
            xh[] xhVarArr = this.e;
            int i5 = i4 - 1;
            this.i = i5;
            xhVar = xhVarArr[i5];
        } else {
            xhVar = new xh(null);
        }
        int i6 = this.g;
        this.g = i6 + 1;
        xhVar.a = i6;
        xhVar.b = i;
        xhVar.c = f;
        this.d.add(xhVar);
        int i7 = this.h + i;
        while (true) {
            this.h = i7;
            while (true) {
                int i8 = this.h;
                if (i8 <= 2000) {
                    return;
                }
                i2 = i8 - 2000;
                xhVar2 = (xh) this.d.get(0);
                i3 = xhVar2.b;
                if (i3 <= i2) {
                    this.h -= i3;
                    this.d.remove(0);
                    int i9 = this.i;
                    if (i9 < 5) {
                        xh[] xhVarArr2 = this.e;
                        this.i = i9 + 1;
                        xhVarArr2[i9] = xhVar2;
                    }
                }
            }
            xhVar2.b = i3 - i2;
            i7 = this.h - i2;
        }
    }

    public final void b() {
        this.d.clear();
        this.f = -1;
        this.g = 0;
        this.h = 0;
    }

    public final float c() {
        if (this.f != 0) {
            Collections.sort(this.d, b);
            this.f = 0;
        }
        float f = this.h * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            xh xhVar = (xh) this.d.get(i2);
            i += xhVar.b;
            if (i >= f) {
                return xhVar.c;
            }
        }
        if (this.d.isEmpty()) {
            return Float.NaN;
        }
        return ((xh) this.d.get(r0.size() - 1)).c;
    }
}
