package Z1;

import android.content.Context;
import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class q implements l {
    public final Context a;
    public final l b;

    public q(Context context, l lVar) {
        this.a = context;
        this.b = lVar;
    }

    public static boolean e(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    public abstract T1.c b(Context context, String str);

    public abstract T1.c c(Context context, Uri uri);

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final T1.c a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (e(scheme)) {
            if (!a.a(uri)) {
                return c(this.a, uri);
            }
            return b(this.a, a.b(uri));
        }
        if (this.b == null || !("http".equals(scheme) || "https".equals(scheme))) {
            return null;
        }
        return this.b.a(new d(uri.toString()), i, i2);
    }
}
