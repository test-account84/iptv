package g1;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class Z implements Callable {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ Z(d dVar, String str, String str2) {
        this.a = dVar;
        this.b = str;
        this.c = str2;
    }

    public final Object call() {
        return this.a.U(this.b, this.c);
    }
}
