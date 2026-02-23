package f3;

import d4.B;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public static d c(M m) {
        int u = m.u();
        m.V(12);
        int u2 = m.u();
        int u3 = m.u();
        int u4 = m.u();
        m.V(4);
        int u5 = m.u();
        int u6 = m.u();
        m.V(8);
        return new d(u, u2, u3, u4, u5, u6);
    }

    public long a() {
        return k0.c1(this.e, this.c * 1000000, this.d);
    }

    public int b() {
        int i = this.a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        B.j("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.a));
        return -1;
    }

    public int getType() {
        return 1752331379;
    }
}
