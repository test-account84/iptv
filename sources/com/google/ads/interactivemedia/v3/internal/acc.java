package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class acc extends ace {
    public final long a;
    public final List b;
    public final List c;

    public acc(int i, long j) {
        super(i);
        this.a = j;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final acc a(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            acc accVar = (acc) this.c.get(i2);
            if (accVar.d == i) {
                return accVar;
            }
        }
        return null;
    }

    public final acd b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            acd acdVar = (acd) this.b.get(i2);
            if (acdVar.d == i) {
                return acdVar;
            }
        }
        return null;
    }

    public final void c(acc accVar) {
        this.c.add(accVar);
    }

    public final void d(acd acdVar) {
        this.b.add(acdVar);
    }

    public final String toString() {
        return ace.g(this.d) + " leaves: " + Arrays.toString(this.b.toArray()) + " containers: " + Arrays.toString(this.c.toArray());
    }
}
