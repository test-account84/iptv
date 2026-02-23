package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ng implements ms {
    private final Set a = new HashSet();
    private my b;

    public final void a() {
        this.b = null;
        avo m = avo.m(this.a);
        this.a.clear();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            ((my) m.get(i)).j();
        }
    }

    public final void b(Exception exc, boolean z) {
        this.b = null;
        avo m = avo.m(this.a);
        this.a.clear();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            ((my) m.get(i)).k(exc, z);
        }
    }

    public final void c(my myVar) {
        this.a.add(myVar);
        if (this.b != null) {
            return;
        }
        this.b = myVar;
        myVar.l();
    }

    public final void d(my myVar) {
        this.a.remove(myVar);
        if (this.b == myVar) {
            this.b = null;
            if (this.a.isEmpty()) {
                return;
            }
            my myVar2 = (my) this.a.iterator().next();
            this.b = myVar2;
            myVar2.l();
        }
    }
}
