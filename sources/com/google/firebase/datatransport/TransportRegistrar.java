package com.google.firebase.datatransport;

import A2.a;
import C2.u;
import I5.c;
import I5.e;
import I5.r;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import s6.h;
import z2.g;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ g a(e eVar) {
        return lambda$getComponents$0(eVar);
    }

    private static /* synthetic */ g lambda$getComponents$0(e eVar) {
        u.f((Context) eVar.a(Context.class));
        return u.c().g(a.h);
    }

    public List getComponents() {
        return Arrays.asList(new c[]{c.e(g.class).h("fire-transport").b(r.k(Context.class)).f(new a6.a()).d(), h.b("fire-transport", "18.1.8")});
    }
}
