package G;

import F.e;
import M.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l {
    public ConcurrentHashMap a = new ConcurrentHashMap();

    public class a implements b {
        public a() {
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(g.b bVar) {
            return bVar.e();
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(g.b bVar) {
            return bVar.f();
        }
    }

    public interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object e(Object[] objArr, int i, b bVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        Object obj = null;
        int i3 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = (Math.abs(bVar.b(obj2) - i2) * 2) + (bVar.a(obj2) == z ? 0 : 1);
            if (obj == null || i3 > abs) {
                obj = obj2;
                i3 = abs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, e.c cVar, Resources resources, int i);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i);

    public Typeface c(Context context, InputStream inputStream) {
        File e = m.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (m.d(e, inputStream)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File e = m.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (m.c(e, resources, i)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public g.b f(g.b[] bVarArr, int i) {
        return (g.b) e(bVarArr, i, new a());
    }
}
