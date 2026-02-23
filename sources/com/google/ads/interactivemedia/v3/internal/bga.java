package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bga {
    private ArrayList a = new ArrayList();
    private bfx b = bfx.a;
    private Integer c = null;

    public final bgc a() throws GeneralSecurityException {
        if (this.a == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        Integer num = this.c;
        if (num != null) {
            int intValue = num.intValue();
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (((bgb) arrayList.get(i)).a() != intValue) {
                    i = i2;
                }
            }
            throw new GeneralSecurityException("primary key ID is not present in entries");
        }
        bgc bgcVar = new bgc(this.b, Collections.unmodifiableList(this.a), this.c);
        this.a = null;
        return bgcVar;
    }

    public final void b(bfx bfxVar) {
        if (this.a == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }
        this.b = bfxVar;
    }

    public final void c(int i) {
        if (this.a == null) {
            throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
        }
        this.c = Integer.valueOf(i);
    }

    public final void d(bac bacVar, int i, azh azhVar) {
        ArrayList arrayList = this.a;
        if (arrayList == null) {
            throw new IllegalStateException("addEntry cannot be called after build()");
        }
        arrayList.add(new bgb(bacVar, i, azhVar, null));
    }
}
