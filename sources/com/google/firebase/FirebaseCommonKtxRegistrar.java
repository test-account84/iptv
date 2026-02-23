package com.google.firebase;

import G8.H;
import G8.p0;
import I5.F;
import I5.e;
import I5.h;
import I5.r;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.l;
import l8.k;
import org.jetbrains.annotations.NotNull;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    public static final class a implements h {
        public static final a a = new a();

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final H a(e eVar) {
            Object b = eVar.b(F.a(E5.a.class, Executor.class));
            l.d(b, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return p0.a((Executor) b);
        }
    }

    public static final class b implements h {
        public static final b a = new b();

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final H a(e eVar) {
            Object b = eVar.b(F.a(E5.c.class, Executor.class));
            l.d(b, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return p0.a((Executor) b);
        }
    }

    public static final class c implements h {
        public static final c a = new c();

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final H a(e eVar) {
            Object b = eVar.b(F.a(E5.b.class, Executor.class));
            l.d(b, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return p0.a((Executor) b);
        }
    }

    public static final class d implements h {
        public static final d a = new d();

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final H a(e eVar) {
            Object b = eVar.b(F.a(E5.d.class, Executor.class));
            l.d(b, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return p0.a((Executor) b);
        }
    }

    @NotNull
    public List getComponents() {
        I5.c d2 = I5.c.c(F.a(E5.a.class, H.class)).b(r.j(F.a(E5.a.class, Executor.class))).f(a.a).d();
        l.d(d2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        I5.c d3 = I5.c.c(F.a(E5.c.class, H.class)).b(r.j(F.a(E5.c.class, Executor.class))).f(b.a).d();
        l.d(d3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        I5.c d4 = I5.c.c(F.a(E5.b.class, H.class)).b(r.j(F.a(E5.b.class, Executor.class))).f(c.a).d();
        l.d(d4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        I5.c d5 = I5.c.c(F.a(E5.d.class, H.class)).b(r.j(F.a(E5.d.class, Executor.class))).f(d.a).d();
        l.d(d5, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return k.h(new I5.c[]{d2, d3, d4, d5});
    }
}
