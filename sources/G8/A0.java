package G8;

import k8.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a0 {
    public static final void a(Z z, int i) {
        o8.d c = z.c();
        boolean z2 = i == 4;
        if (z2 || !(c instanceof kotlinx.coroutines.internal.f) || b(i) != b(z.d)) {
            d(z, c, z2);
            return;
        }
        H h = ((kotlinx.coroutines.internal.f) c).e;
        o8.g context = c.getContext();
        if (h.d0(context)) {
            h.c0(context, z);
        } else {
            e(z);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final void d(Z z, o8.d dVar, boolean z2) {
        Object e;
        Object h = z.h();
        Throwable d = z.d(h);
        if (d != null) {
            j.a aVar = k8.j.c;
            e = k8.k.a(d);
        } else {
            j.a aVar2 = k8.j.c;
            e = z.e(h);
        }
        Object b = k8.j.b(e);
        if (!z2) {
            dVar.resumeWith(b);
            return;
        }
        kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) dVar;
        o8.d dVar2 = fVar.f;
        Object obj = fVar.h;
        o8.g context = dVar2.getContext();
        Object c = kotlinx.coroutines.internal.C.c(context, obj);
        b1 g = c != kotlinx.coroutines.internal.C.a ? G.g(dVar2, context, c) : null;
        try {
            fVar.f.resumeWith(b);
            k8.q qVar = k8.q.a;
        } finally {
            if (g == null || g.P0()) {
                kotlinx.coroutines.internal.C.a(context, c);
            }
        }
    }

    public static final void e(Z z) {
        h0 b = U0.a.b();
        if (b.m0()) {
            b.i0(z);
            return;
        }
        b.k0(true);
        try {
            d(z, z.c(), true);
            do {
            } while (b.p0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
