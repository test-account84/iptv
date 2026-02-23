package E3;

import D3.m;
import F3.j;
import O2.z0;
import b4.o;
import b4.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class g {
    public static s a(j jVar, String str, F3.i iVar, int i) {
        return new s.b().i(iVar.b(str)).h(iVar.a).g(iVar.b).f(g(jVar, iVar)).b(i).a();
    }

    public static com.google.android.exoplayer2.extractor.b b(o oVar, int i, j jVar) {
        return c(oVar, i, jVar, 0);
    }

    public static com.google.android.exoplayer2.extractor.b c(o oVar, int i, j jVar, int i2) {
        if (jVar.n() == null) {
            return null;
        }
        D3.g f = f(i, jVar.b);
        try {
            d(f, oVar, jVar, i2, true);
            f.release();
            return f.b();
        } catch (Throwable th) {
            f.release();
            throw th;
        }
    }

    public static void d(D3.g gVar, o oVar, j jVar, int i, boolean z) {
        F3.i iVar = (F3.i) d4.a.e(jVar.n());
        if (z) {
            F3.i m = jVar.m();
            if (m == null) {
                return;
            }
            F3.i a = iVar.a(m, ((F3.b) jVar.c.get(i)).a);
            if (a == null) {
                e(oVar, jVar, i, gVar, iVar);
                iVar = m;
            } else {
                iVar = a;
            }
        }
        e(oVar, jVar, i, gVar, iVar);
    }

    public static void e(o oVar, j jVar, int i, D3.g gVar, F3.i iVar) {
        new m(oVar, a(jVar, ((F3.b) jVar.c.get(i)).a, iVar, 0), jVar.b, 0, null, gVar).a();
    }

    public static D3.g f(int i, z0 z0Var) {
        String str = z0Var.l;
        return new D3.e((str == null || !(str.startsWith("video/webm") || str.startsWith("audio/webm"))) ? new l3.g() : new j3.e(), i, z0Var);
    }

    public static String g(j jVar, F3.i iVar) {
        String a = jVar.a();
        return a != null ? a : iVar.b(((F3.b) jVar.c.get(0)).a).toString();
    }
}
