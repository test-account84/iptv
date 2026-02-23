package com.google.firebase.installations;

import A5.f;
import E5.a;
import E5.b;
import I5.F;
import I5.c;
import I5.e;
import I5.r;
import J5.A;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import h6.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k6.g;
import k6.h;
import k6.j;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ h a(e eVar) {
        return lambda$getComponents$0(eVar);
    }

    private static /* synthetic */ h lambda$getComponents$0(e eVar) {
        return new g((f) eVar.a(f.class), eVar.g(i.class), (ExecutorService) eVar.b(F.a(a.class, ExecutorService.class)), A.a((Executor) eVar.b(F.a(b.class, Executor.class))));
    }

    public List getComponents() {
        return Arrays.asList(new c[]{c.e(h.class).h("fire-installations").b(r.k(f.class)).b(r.i(i.class)).b(r.j(F.a(a.class, ExecutorService.class))).b(r.j(F.a(b.class, Executor.class))).f(new j()).d(), h6.h.a(), s6.h.b("fire-installations", "17.1.3")});
    }
}
