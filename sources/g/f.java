package G;

import F.e;
import F.h;
import M.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {
    public static final l a;
    public static final s.g b;

    public static class a extends g.c {
        public h.e a;

        public a(h.e eVar) {
            this.a = eVar;
        }

        public void a(int i) {
            h.e eVar = this.a;
            if (eVar != null) {
                eVar.f(i);
            }
        }

        public void b(Typeface typeface) {
            h.e eVar = this.a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        a = i >= 29 ? new k() : i >= 28 ? new j() : i >= 26 ? new i() : (i < 24 || !h.i()) ? new g() : new h();
        b = new s.g(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i) {
        return a.b(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface c(Context context, e.b bVar, Resources resources, int i, String str, int i2, int i3, h.e eVar, Handler handler, boolean z) {
        Typeface a2;
        if (bVar instanceof e.e) {
            e.e eVar2 = (e.e) bVar;
            Typeface g = g(eVar2.c());
            if (g != null) {
                if (eVar != null) {
                    eVar.d(g, handler);
                }
                return g;
            }
            a2 = M.g.c(context, eVar2.b(), i3, !z ? eVar != null : eVar2.a() != 0, z ? eVar2.d() : -1, h.e.e(handler), new a(eVar));
        } else {
            a2 = a.a(context, (e.c) bVar, resources, i3);
            if (eVar != null) {
                if (a2 != null) {
                    eVar.d(a2, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (a2 != null) {
            b.put(e(resources, i, str, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface d = a.d(context, resources, i, str, i3);
        if (d != null) {
            b.put(e(resources, i, str, i2, i3), d);
        }
        return d;
    }

    public static String e(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface f(Resources resources, int i, String str, int i2, int i3) {
        return (Typeface) b.get(e(resources, i, str, i2, i3));
    }

    public static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
