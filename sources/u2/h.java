package U2;

import O2.z0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h {
    public final String a;
    public final z0 b;
    public final z0 c;
    public final int d;
    public final int e;

    public h(String str, z0 z0Var, z0 z0Var2, int i, int i2) {
        d4.a.a(i == 0 || i2 == 0);
        this.a = d4.a.d(str);
        this.b = (z0) d4.a.e(z0Var);
        this.c = (z0) d4.a.e(z0Var2);
        this.d = i;
        this.e = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.d == hVar.d && this.e == hVar.e && this.a.equals(hVar.a) && this.b.equals(hVar.b) && this.c.equals(hVar.c);
    }

    public int hashCode() {
        return ((((((((527 + this.d) * 31) + this.e) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
