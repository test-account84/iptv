package f3;

import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public c(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static c b(M m) {
        int u = m.u();
        m.V(8);
        int u2 = m.u();
        int u3 = m.u();
        m.V(4);
        int u4 = m.u();
        m.V(12);
        return new c(u, u2, u3, u4);
    }

    public boolean a() {
        return (this.b & 16) == 16;
    }

    public int getType() {
        return 1751742049;
    }
}
