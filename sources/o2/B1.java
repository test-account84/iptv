package O2;

import O2.k1;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class b1 implements Runnable {
    public final /* synthetic */ k1.a a;
    public final /* synthetic */ Pair c;
    public final /* synthetic */ B3.x d;

    public /* synthetic */ b1(k1.a aVar, Pair pair, B3.x xVar) {
        this.a = aVar;
        this.c = pair;
        this.d = xVar;
    }

    public final void run() {
        k1.a.B(this.a, this.c, this.d);
    }
}
