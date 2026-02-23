package O2;

import O2.k1;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class f1 implements Runnable {
    public final /* synthetic */ k1.a a;
    public final /* synthetic */ Pair c;
    public final /* synthetic */ int d;

    public /* synthetic */ f1(k1.a aVar, Pair pair, int i) {
        this.a = aVar;
        this.c = pair;
        this.d = i;
    }

    public final void run() {
        k1.a.u(this.a, this.c, this.d);
    }
}
