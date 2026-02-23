package O2;

import O2.k1;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class c1 implements Runnable {
    public final /* synthetic */ k1.a a;
    public final /* synthetic */ Pair c;

    public /* synthetic */ c1(k1.a aVar, Pair pair) {
        this.a = aVar;
        this.c = pair;
    }

    public final void run() {
        k1.a.k(this.a, this.c);
    }
}
