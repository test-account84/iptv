package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agz {
    private static final agz a = new agz();
    private final ArrayList b = new ArrayList();
    private final ArrayList c = new ArrayList();

    private agz() {
    }

    public static agz a() {
        return a;
    }

    public final Collection b() {
        return Collections.unmodifiableCollection(this.c);
    }

    public final Collection c() {
        return Collections.unmodifiableCollection(this.b);
    }

    public final void d(agt agtVar) {
        this.b.add(agtVar);
    }

    public final void e(agt agtVar) {
        boolean g = g();
        this.b.remove(agtVar);
        this.c.remove(agtVar);
        if (!g || g()) {
            return;
        }
        ahe.b().f();
    }

    public final void f(agt agtVar) {
        boolean g = g();
        this.c.add(agtVar);
        if (g) {
            return;
        }
        ahe.b().e();
    }

    public final boolean g() {
        return this.c.size() > 0;
    }
}
