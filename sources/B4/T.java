package b4;

import b4.b;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t implements b {
    public final boolean a;
    public final int b;
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public a[] g;

    public t(boolean z, int i) {
        this(z, i, 0);
    }

    public synchronized void a(a aVar) {
        a[] aVarArr = this.g;
        int i = this.f;
        this.f = i + 1;
        aVarArr[i] = aVar;
        this.e--;
        notifyAll();
    }

    public synchronized a b() {
        a aVar;
        try {
            this.e++;
            int i = this.f;
            if (i > 0) {
                a[] aVarArr = this.g;
                int i2 = i - 1;
                this.f = i2;
                aVar = (a) d4.a.e(aVarArr[i2]);
                this.g[this.f] = null;
            } else {
                aVar = new a(new byte[this.b], 0);
                int i3 = this.e;
                a[] aVarArr2 = this.g;
                if (i3 > aVarArr2.length) {
                    this.g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public synchronized void c(b.a aVar) {
        while (aVar != null) {
            try {
                a[] aVarArr = this.g;
                int i = this.f;
                this.f = i + 1;
                aVarArr[i] = aVar.a();
                this.e--;
                aVar = aVar.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    public synchronized void d() {
        try {
            int i = 0;
            int max = Math.max(0, k0.l(this.d, this.b) - this.e);
            int i2 = this.f;
            if (max >= i2) {
                return;
            }
            if (this.c != null) {
                int i3 = i2 - 1;
                while (i <= i3) {
                    a aVar = (a) d4.a.e(this.g[i]);
                    if (aVar.a == this.c) {
                        i++;
                    } else {
                        a aVar2 = (a) d4.a.e(this.g[i3]);
                        if (aVar2.a != this.c) {
                            i3--;
                        } else {
                            a[] aVarArr = this.g;
                            aVarArr[i] = aVar2;
                            aVarArr[i3] = aVar;
                            i3--;
                            i++;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.f) {
                    return;
                }
            }
            Arrays.fill(this.g, max, this.f, (Object) null);
            this.f = max;
        } catch (Throwable th) {
            throw th;
        }
    }

    public int e() {
        return this.b;
    }

    public synchronized int f() {
        return this.e * this.b;
    }

    public synchronized void g() {
        if (this.a) {
            h(0);
        }
    }

    public synchronized void h(int i) {
        boolean z = i < this.d;
        this.d = i;
        if (z) {
            d();
        }
    }

    public t(boolean z, int i, int i2) {
        d4.a.a(i > 0);
        d4.a.a(i2 >= 0);
        this.a = z;
        this.b = i;
        this.f = i2;
        this.g = new a[i2 + 100];
        if (i2 <= 0) {
            this.c = null;
            return;
        }
        this.c = new byte[i2 * i];
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i3] = new a(this.c, i3 * i);
        }
    }
}
