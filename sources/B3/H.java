package B3;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h implements Z {
    public final Z[] a;

    public h(Z[] zArr) {
        this.a = zArr;
    }

    public boolean b() {
        for (Z z : this.a) {
            if (z.b()) {
                return true;
            }
        }
        return false;
    }

    public final long c() {
        long j = Long.MAX_VALUE;
        for (Z z : this.a) {
            long c = z.c();
            if (c != Long.MIN_VALUE) {
                j = Math.min(j, c);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public boolean f(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long c = c();
            if (c == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (Z z3 : this.a) {
                long c2 = z3.c();
                boolean z4 = c2 != Long.MIN_VALUE && c2 <= j;
                if (c2 == c || z4) {
                    z |= z3.f(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final long g() {
        long j = Long.MAX_VALUE;
        for (Z z : this.a) {
            long g = z.g();
            if (g != Long.MIN_VALUE) {
                j = Math.min(j, g);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final void h(long j) {
        for (Z z : this.a) {
            z.h(j);
        }
    }
}
