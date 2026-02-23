package O2;

import O2.k1;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class d1 implements Runnable {
    public final /* synthetic */ k1.a a;
    public final /* synthetic */ Pair c;
    public final /* synthetic */ Exception d;

    public /* synthetic */ d1(k1.a aVar, Pair pair, Exception exc) {
        this.a = aVar;
        this.c = pair;
        this.d = exc;
    }

    public final void run() {
        k1.a.F(this.a, this.c, this.d);
    }
}
