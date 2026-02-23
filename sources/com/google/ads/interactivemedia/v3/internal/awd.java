package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class awd extends avv {
    private final Comparator d;

    public awd(Comparator comparator) {
        atp.k(comparator);
        this.d = comparator;
    }

    public final /* synthetic */ void b(Object obj) {
        super.b(obj);
    }

    public final /* synthetic */ avv f(Object obj) {
        super.b(obj);
        return this;
    }

    public final awf h() {
        axg axgVar;
        Object[] objArr = this.a;
        Comparator comparator = this.d;
        int i = this.b;
        if (i == 0) {
            axgVar = awf.w(comparator);
        } else {
            axo.l(objArr, i);
            Arrays.sort(objArr, 0, i, comparator);
            int i2 = 1;
            for (int i3 = 1; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (comparator.compare(obj, objArr[i2 - 1]) != 0) {
                    objArr[i2] = obj;
                    i2++;
                }
            }
            Arrays.fill(objArr, i2, i, (Object) null);
            if (i2 < (objArr.length >> 1)) {
                objArr = Arrays.copyOf(objArr, i2);
            }
            axgVar = new axg(avo.l(objArr, i2), comparator);
        }
        this.b = axgVar.size();
        this.c = true;
        return axgVar;
    }

    public final void i(Object... objArr) {
        super.g(objArr);
    }
}
