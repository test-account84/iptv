package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class avz extends avq {
    private transient Object[] d;
    private transient Object[] e;
    private final Comparator f;

    public avz(Comparator comparator) {
        atp.k(comparator);
        this.f = comparator;
        this.d = new Object[4];
        this.e = new Object[4];
    }

    public final /* bridge */ /* synthetic */ avq a(Object obj, Object obj2) {
        int i = this.b + 1;
        int length = this.d.length;
        if (i > length) {
            int e = avh.e(length, i);
            this.d = Arrays.copyOf(this.d, e);
            this.e = Arrays.copyOf(this.e, e);
        }
        axo.I(obj, obj2);
        Object[] objArr = this.d;
        int i2 = this.b;
        objArr[i2] = obj;
        this.e[i2] = obj2;
        this.b = i2 + 1;
        return this;
    }

    public final /* bridge */ /* synthetic */ avs b() {
        int i = this.b;
        if (i == 0) {
            return awb.l(this.f);
        }
        if (i == 1) {
            Comparator comparator = this.f;
            Object obj = this.d[0];
            obj.getClass();
            Object obj2 = this.e[0];
            obj2.getClass();
            avo p = avo.p(obj);
            atp.k(comparator);
            return new awb(new axg(p, comparator), avo.p(obj2));
        }
        Object[] copyOf = Arrays.copyOf(this.d, i);
        Arrays.sort(copyOf, this.f);
        Object[] objArr = new Object[this.b];
        for (int i2 = 0; i2 < this.b; i2++) {
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (this.f.compare(copyOf[i3], copyOf[i2]) == 0) {
                    throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i3] + " and " + copyOf[i2]);
                }
            }
            Object obj3 = this.d[i2];
            obj3.getClass();
            int binarySearch = Arrays.binarySearch(copyOf, obj3, this.f);
            Object obj4 = this.e[i2];
            obj4.getClass();
            objArr[binarySearch] = obj4;
        }
        return new awb(new axg(avo.k(copyOf), this.f), avo.k(objArr));
    }

    public final /* synthetic */ void c(Map.Entry entry) {
        super.c(entry);
    }
}
