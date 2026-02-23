package q6;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b0 {
    public static WeakReference d;
    public final SharedPreferences a;
    public Y b;
    public final Executor c;

    public b0(SharedPreferences sharedPreferences, Executor executor) {
        this.c = executor;
        this.a = sharedPreferences;
    }

    public static synchronized b0 b(Context context, Executor executor) {
        synchronized (b0.class) {
            try {
                WeakReference weakReference = d;
                b0 b0Var = weakReference != null ? (b0) weakReference.get() : null;
                if (b0Var != null) {
                    return b0Var;
                }
                b0 b0Var2 = new b0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                b0Var2.d();
                d = new WeakReference(b0Var2);
                return b0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized boolean a(a0 a0Var) {
        return this.b.b(a0Var.e());
    }

    public synchronized a0 c() {
        return a0.a(this.b.f());
    }

    public final synchronized void d() {
        this.b = Y.d(this.a, "topic_operation_queue", ",", this.c);
    }

    public synchronized boolean e(a0 a0Var) {
        return this.b.g(a0Var.e());
    }
}
