package m3;

import d3.l;
import d4.M;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final f a = new f();
    public final M b = new M(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            f fVar = this.a;
            if (i5 >= fVar.g) {
                break;
            }
            int[] iArr = fVar.j;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public f b() {
        return this.a;
    }

    public M c() {
        return this.b;
    }

    public boolean d(d3.j jVar) {
        int i;
        d4.a.g(jVar != null);
        if (this.e) {
            this.e = false;
            this.b.Q(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(jVar) || !this.a.a(jVar, true)) {
                    return false;
                }
                f fVar = this.a;
                int i2 = fVar.h;
                if ((fVar.b & 1) == 1 && this.b.g() == 0) {
                    i2 += a(0);
                    i = this.d;
                } else {
                    i = 0;
                }
                if (!l.e(jVar, i2)) {
                    return false;
                }
                this.c = i;
            }
            int a = a(this.c);
            int i3 = this.c + this.d;
            if (a > 0) {
                M m = this.b;
                m.c(m.g() + a);
                if (!l.d(jVar, this.b.e(), this.b.g(), a)) {
                    return false;
                }
                M m2 = this.b;
                m2.T(m2.g() + a);
                this.e = this.a.j[i3 + (-1)] != 255;
            }
            if (i3 == this.a.g) {
                i3 = -1;
            }
            this.c = i3;
        }
        return true;
    }

    public void e() {
        this.a.b();
        this.b.Q(0);
        this.c = -1;
        this.e = false;
    }

    public void f() {
        if (this.b.e().length == 65025) {
            return;
        }
        M m = this.b;
        m.S(Arrays.copyOf(m.e(), Math.max(65025, this.b.g())), this.b.g());
    }
}
