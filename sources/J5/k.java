package J5;

import J5.p;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class k implements Callable {
    public final /* synthetic */ o a;
    public final /* synthetic */ Callable b;
    public final /* synthetic */ p.b c;

    public /* synthetic */ k(o oVar, Callable callable, p.b bVar) {
        this.a = oVar;
        this.b = callable;
        this.c = bVar;
    }

    public final Object call() {
        return o.g(this.a, this.b, this.c);
    }
}
