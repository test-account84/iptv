package M4;

import java.lang.Thread;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e2 implements Thread.UncaughtExceptionHandler {
    public final String a;
    public final /* synthetic */ i2 b;

    public e2(i2 i2Var, String str) {
        this.b = i2Var;
        com.google.android.gms.common.internal.r.m(str);
        this.a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.b.a.d().r().b(this.a, th);
    }
}
