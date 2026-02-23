package Q0;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class u {
    public static u f(Context context) {
        return R0.j.m(context);
    }

    public static void g(Context context, androidx.work.a aVar) {
        R0.j.g(context, aVar);
    }

    public abstract n a(String str);

    public final n b(v vVar) {
        return c(Collections.singletonList(vVar));
    }

    public abstract n c(List list);

    public n d(String str, d dVar, m mVar) {
        return e(str, dVar, Collections.singletonList(mVar));
    }

    public abstract n e(String str, d dVar, List list);
}
