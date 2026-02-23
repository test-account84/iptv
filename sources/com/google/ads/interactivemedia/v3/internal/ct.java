package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ct implements cy {
    private final boolean a;
    private final ArrayList b = new ArrayList(1);
    private int c;
    private dc d;

    public ct(boolean z) {
        this.a = z;
    }

    public /* synthetic */ Map e() {
        return Collections.emptyMap();
    }

    public final void f(dw dwVar) {
        af.s(dwVar);
        if (this.b.contains(dwVar)) {
            return;
        }
        this.b.add(dwVar);
        this.c++;
    }

    public final void g(int i) {
        dc dcVar = this.d;
        int i2 = cq.a;
        for (int i3 = 0; i3 < this.c; i3++) {
            ((dw) this.b.get(i3)).a(dcVar, this.a, i);
        }
    }

    public final void h() {
        dc dcVar = this.d;
        int i = cq.a;
        for (int i2 = 0; i2 < this.c; i2++) {
            ((dw) this.b.get(i2)).b(dcVar, this.a);
        }
        this.d = null;
    }

    public final void i(dc dcVar) {
        for (int i = 0; i < this.c; i++) {
            ((dw) this.b.get(i)).c();
        }
    }

    public final void j(dc dcVar) {
        this.d = dcVar;
        for (int i = 0; i < this.c; i++) {
            ((dw) this.b.get(i)).d(dcVar, this.a);
        }
    }
}
