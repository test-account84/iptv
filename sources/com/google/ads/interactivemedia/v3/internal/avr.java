package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class avr implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object a;
    private final Object b;

    public avr(avs avsVar) {
        Object[] objArr = new Object[avsVar.size()];
        Object[] objArr2 = new Object[avsVar.size()];
        axq e = avsVar.g().e();
        int i = 0;
        while (e.hasNext()) {
            Map.Entry entry = (Map.Entry) e.next();
            objArr[i] = entry.getKey();
            objArr2[i] = entry.getValue();
            i++;
        }
        this.a = objArr;
        this.b = objArr2;
    }

    public avq a(int i) {
        return new avq(i);
    }

    public final Object readResolve() {
        Object obj = this.a;
        if (obj instanceof avx) {
            avx avxVar = (avx) obj;
            avi aviVar = (avi) this.b;
            avq a = a(avxVar.size());
            axq e = avxVar.e();
            axq it = aviVar.iterator();
            while (e.hasNext()) {
                a.a(e.next(), it.next());
            }
            return a.b();
        }
        Object[] objArr = (Object[]) obj;
        Object[] objArr2 = (Object[]) this.b;
        avq a2 = a(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            a2.a(objArr[i], objArr2[i]);
        }
        return a2.b();
    }
}
