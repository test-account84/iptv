package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class hf extends eg {
    private final int b;
    private final int c;
    private final int[] d;
    private final int[] e;
    private final be[] f;
    private final Object[] g;
    private final HashMap h;

    public hf(Collection collection, ui uiVar) {
        super(uiVar);
        int size = collection.size();
        this.d = new int[size];
        this.e = new int[size];
        this.f = new be[size];
        this.g = new Object[size];
        this.h = new HashMap();
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            gu guVar = (gu) it.next();
            this.f[i3] = guVar.a();
            this.e[i3] = i;
            this.d[i3] = i2;
            i += this.f[i3].c();
            i2 += this.f[i3].b();
            this.g[i3] = guVar.b();
            this.h.put(this.g[i3], Integer.valueOf(i3));
            i3++;
        }
        this.b = i;
        this.c = i2;
    }

    public final List A() {
        return Arrays.asList(this.f);
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public final int r(Object obj) {
        Integer num = (Integer) this.h.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final int s(int i) {
        return cq.b(this.d, i + 1, false, false);
    }

    public final int t(int i) {
        return cq.b(this.e, i + 1, false, false);
    }

    public final int u(int i) {
        return this.d[i];
    }

    public final int v(int i) {
        return this.e[i];
    }

    public final be w(int i) {
        return this.f[i];
    }

    public final Object z(int i) {
        return this.g[i];
    }
}
