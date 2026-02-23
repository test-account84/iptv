package com.google.firebase.auth;

import A5.f;
import E5.d;
import G5.T;
import H5.h0;
import I5.F;
import I5.e;
import I5.r;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import h6.h;
import h6.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseAuthRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseAuth lambda$getComponents$0(F f, F f2, F f3, F f4, F f5, e eVar) {
        return new h0((f) eVar.a(f.class), eVar.g(F5.a.class), eVar.g(i.class), (Executor) eVar.b(f), (Executor) eVar.b(f2), (Executor) eVar.b(f3), (ScheduledExecutorService) eVar.b(f4), (Executor) eVar.b(f5));
    }

    @Keep
    public List getComponents() {
        F a = F.a(E5.a.class, Executor.class);
        F a2 = F.a(E5.b.class, Executor.class);
        F a3 = F.a(E5.c.class, Executor.class);
        F a4 = F.a(E5.c.class, ScheduledExecutorService.class);
        F a5 = F.a(d.class, Executor.class);
        return Arrays.asList(new I5.c[]{I5.c.f(FirebaseAuth.class, H5.a.class).b(r.k(f.class)).b(r.m(i.class)).b(r.j(a)).b(r.j(a2)).b(r.j(a3)).b(r.j(a4)).b(r.j(a5)).b(r.i(F5.a.class)).f(new T(a, a2, a3, a4, a5)).d(), h.a(), s6.h.b("fire-auth", "22.3.0")});
    }
}
