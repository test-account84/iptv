package O2;

import O2.k1;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class g1 implements Runnable {
    public final /* synthetic */ k1.a a;
    public final /* synthetic */ Pair c;
    public final /* synthetic */ B3.u d;
    public final /* synthetic */ B3.x e;

    public /* synthetic */ g1(k1.a aVar, Pair pair, B3.u uVar, B3.x xVar) {
        this.a = aVar;
        this.c = pair;
        this.d = uVar;
        this.e = xVar;
    }

    public final void run() {
        k1.a.j(this.a, this.c, this.d, this.e);
    }
}
