package M4;

import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class n4 implements Runnable {
    public final /* synthetic */ q4 a;
    public final /* synthetic */ int c;
    public final /* synthetic */ z1 d;
    public final /* synthetic */ Intent e;

    public /* synthetic */ n4(q4 q4Var, int i, z1 z1Var, Intent intent) {
        this.a = q4Var;
        this.c = i;
        this.d = z1Var;
        this.e = intent;
    }

    public final void run() {
        this.a.c(this.c, this.d, this.e);
    }
}
