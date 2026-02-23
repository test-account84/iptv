package M4;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class m2 implements Runnable {
    public final /* synthetic */ D2 a;
    public final /* synthetic */ String c;
    public final /* synthetic */ Bundle d;

    public /* synthetic */ m2(D2 d2, String str, Bundle bundle) {
        this.a = d2;
        this.c = str;
        this.d = bundle;
    }

    public final void run() {
        this.a.c1(this.c, this.d);
    }
}
