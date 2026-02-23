package M4;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s2 implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ D2 d;

    public s2(D2 d2, String str, String str2, String str3) {
        this.d = d2;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        D2.Z(this.d).e();
        return D2.Z(this.d).V().a0(this.a, this.b, this.c);
    }
}
