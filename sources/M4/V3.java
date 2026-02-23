package M4;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class v3 implements Runnable {
    public final /* synthetic */ w3 a;
    public final /* synthetic */ int c;
    public final /* synthetic */ Exception d;
    public final /* synthetic */ byte[] e;
    public final /* synthetic */ Map f;

    public /* synthetic */ v3(w3 w3Var, int i, Exception exc, byte[] bArr, Map map) {
        this.a = w3Var;
        this.c = i;
        this.d = exc;
        this.e = bArr;
        this.f = map;
    }

    public final void run() {
        this.a.a(this.c, this.d, this.e, this.f);
    }
}
