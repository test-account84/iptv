package w4;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class v implements Callable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ A c;

    public /* synthetic */ v(boolean z, String str, A a) {
        this.a = z;
        this.b = str;
        this.c = a;
    }

    public final Object call() {
        return E.c(this.a, this.b, this.c);
    }
}
