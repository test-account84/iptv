package M4;

import android.content.ComponentName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d4 implements Runnable {
    public final /* synthetic */ ComponentName a;
    public final /* synthetic */ h4 c;

    public d4(h4 h4Var, ComponentName componentName) {
        this.c = h4Var;
        this.a = componentName;
    }

    public final void run() {
        i4.M(this.c.d, this.a);
    }
}
