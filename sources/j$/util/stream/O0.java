package j$.util.stream;

import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class o0 implements Supplier {
    public final /* synthetic */ int a;
    public final /* synthetic */ v0 b;

    public /* synthetic */ o0(v0 v0Var, int i) {
        this.a = i;
        this.b = v0Var;
    }

    public final Object get() {
        switch (this.a) {
            case 0:
                return new s0(this.b);
            case 1:
                return new r0(this.b);
            default:
                return new t0(this.b);
        }
    }
}
