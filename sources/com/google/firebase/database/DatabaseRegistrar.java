package com.google.firebase.database;

import A5.f;
import H5.a;
import I5.c;
import I5.e;
import I5.r;
import X5.b;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import s6.h;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class DatabaseRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rtdb";

    public static /* synthetic */ b a(e eVar) {
        return lambda$getComponents$0(eVar);
    }

    private static /* synthetic */ b lambda$getComponents$0(e eVar) {
        return new b((f) eVar.a(f.class), eVar.i(a.class), eVar.i(F5.a.class));
    }

    public List getComponents() {
        return Arrays.asList(new c[]{c.e(b.class).h("fire-rtdb").b(r.k(f.class)).b(r.a(a.class)).b(r.a(F5.a.class)).f(new X5.a()).d(), h.b("fire-rtdb", "20.3.0")});
    }
}
