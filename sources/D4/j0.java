package d4;

import java.util.concurrent.ThreadFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class j0 implements ThreadFactory {
    public final /* synthetic */ String a;

    public /* synthetic */ j0(String str) {
        this.a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return k0.a(this.a, runnable);
    }
}
