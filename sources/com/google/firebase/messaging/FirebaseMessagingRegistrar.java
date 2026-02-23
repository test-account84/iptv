package com.google.firebase.messaging;

import A5.f;
import I5.c;
import I5.e;
import I5.r;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import d.D;
import g6.d;
import h6.j;
import java.util.Arrays;
import java.util.List;
import k6.h;
import q6.A;
import s6.i;
import z2.g;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(e eVar) {
        f fVar = (f) eVar.a(f.class);
        D.a(eVar.a(i6.a.class));
        return new FirebaseMessaging(fVar, null, eVar.g(i.class), eVar.g(j.class), (h) eVar.a(h.class), (g) eVar.a(g.class), (d) eVar.a(d.class));
    }

    @Keep
    public List getComponents() {
        return Arrays.asList(new c[]{c.e(FirebaseMessaging.class).b(r.k(f.class)).b(r.h(i6.a.class)).b(r.i(i.class)).b(r.i(j.class)).b(r.h(g.class)).b(r.k(h.class)).b(r.k(d.class)).f(A.a).c().d(), s6.h.b("fire-fcm", "23.0.0")});
    }
}
