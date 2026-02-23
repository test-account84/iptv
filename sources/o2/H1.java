package O2;

import O2.k1;
import android.util.Pair;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class h1 implements Runnable {
    public final /* synthetic */ k1.a a;
    public final /* synthetic */ Pair c;
    public final /* synthetic */ B3.u d;
    public final /* synthetic */ B3.x e;
    public final /* synthetic */ IOException f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ h1(k1.a aVar, Pair pair, B3.u uVar, B3.x xVar, IOException iOException, boolean z) {
        this.a = aVar;
        this.c = pair;
        this.d = uVar;
        this.e = xVar;
        this.f = iOException;
        this.g = z;
    }

    public final void run() {
        k1.a.a(this.a, this.c, this.d, this.e, this.f, this.g);
    }
}
