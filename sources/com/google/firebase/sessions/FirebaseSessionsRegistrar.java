package com.google.firebase.sessions;

import A5.f;
import E5.b;
import G8.H;
import I5.F;
import I5.c;
import I5.e;
import I5.r;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import k6.h;
import l8.k;
import org.jetbrains.annotations.NotNull;
import t6.l;
import t6.m;
import z2.g;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {

    @NotNull
    private static final String LIBRARY_NAME = "fire-sessions";

    @NotNull
    public static final a Companion = new a(null);
    private static final F firebaseApp = F.b(f.class);
    private static final F firebaseInstallationsApi = F.b(h.class);
    private static final F backgroundDispatcher = F.a(E5.a.class, H.class);
    private static final F blockingDispatcher = F.a(b.class, H.class);
    private static final F transportFactory = F.b(g.class);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static /* synthetic */ l a(e eVar) {
        return getComponents$lambda-0(eVar);
    }

    private static final l getComponents$lambda-0(e eVar) {
        Object b = eVar.b(firebaseApp);
        kotlin.jvm.internal.l.d(b, "container.get(firebaseApp)");
        f fVar = (f) b;
        Object b2 = eVar.b(firebaseInstallationsApi);
        kotlin.jvm.internal.l.d(b2, "container.get(firebaseInstallationsApi)");
        h hVar = (h) b2;
        Object b3 = eVar.b(backgroundDispatcher);
        kotlin.jvm.internal.l.d(b3, "container.get(backgroundDispatcher)");
        H h = (H) b3;
        Object b4 = eVar.b(blockingDispatcher);
        kotlin.jvm.internal.l.d(b4, "container.get(blockingDispatcher)");
        H h2 = (H) b4;
        j6.b e = eVar.e(transportFactory);
        kotlin.jvm.internal.l.d(e, "container.getProvider(transportFactory)");
        return new l(fVar, hVar, h, h2, e);
    }

    @NotNull
    public List getComponents() {
        return k.h(new c[]{c.e(l.class).h("fire-sessions").b(r.j(firebaseApp)).b(r.j(firebaseInstallationsApi)).b(r.j(backgroundDispatcher)).b(r.j(blockingDispatcher)).b(r.l(transportFactory)).f(new m()).d(), s6.h.b("fire-sessions", "1.0.2")});
    }
}
