package N6;

import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final int a;
    public final int[] b;
    public final q[] c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.b = iArr;
        float f = i2;
        float f2 = i4;
        this.c = new q[]{new q(f, f2), new q(i3, f2)};
    }

    public q[] a() {
        return this.c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
