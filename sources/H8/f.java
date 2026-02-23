package H8;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import k8.j;
import k8.k;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class f {
    public static final e a;

    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object b;
        try {
            j.a aVar = j.c;
            b = j.b(new d(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            j.a aVar2 = j.c;
            b = j.b(k.a(th));
        }
        a = (e) (j.f(b) ? null : b);
    }

    public static final Handler a(Looper looper, boolean z) {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
        if (invoke != null) {
            return (Handler) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
