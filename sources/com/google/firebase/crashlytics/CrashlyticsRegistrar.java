package com.google.firebase.crashlytics;

import A5.f;
import I5.c;
import I5.e;
import I5.r;
import K5.g;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import k6.h;
import t6.l;
import u6.a;
import u6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    static {
        a.a.a(b.a.CRASHLYTICS);
    }

    public static /* synthetic */ g a(CrashlyticsRegistrar crashlyticsRegistrar, e eVar) {
        return crashlyticsRegistrar.b(eVar);
    }

    public final g b(e eVar) {
        return g.a((f) eVar.a(f.class), (h) eVar.a(h.class), (l) eVar.a(l.class), eVar.i(L5.a.class), eVar.i(C5.a.class));
    }

    public List getComponents() {
        return Arrays.asList(new c[]{c.e(g.class).h("fire-cls").b(r.k(f.class)).b(r.k(h.class)).b(r.k(l.class)).b(r.a(L5.a.class)).b(r.a(C5.a.class)).f(new K5.f(this)).e().d(), s6.h.b("fire-cls", "18.4.1")});
    }
}
