package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class wr {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private bdz[] e;

    public wr() {
        af.u(true);
        af.u(true);
        this.d = 0;
        this.e = new bdz[100];
        this.a = null;
    }

    public final synchronized int a() {
        return this.c * 65536;
    }

    public final synchronized void b(wl wlVar) {
        while (wlVar != null) {
            try {
                bdz[] bdzVarArr = this.e;
                int i = this.d;
                this.d = i + 1;
                bdzVarArr[i] = wlVar.e();
                this.c--;
                wlVar = wlVar.c();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    public final synchronized void c() {
        d(0);
    }

    public final synchronized void d(int i) {
        int i2 = this.b;
        this.b = i;
        if (i < i2) {
            e();
        }
    }

    public final synchronized void e() {
        int max = Math.max(0, cq.c(this.b, 65536) - this.c);
        int i = this.d;
        if (max >= i) {
            return;
        }
        Arrays.fill(this.e, max, i, (Object) null);
        this.d = max;
    }

    public final synchronized bdz f() {
        bdz bdzVar;
        try {
            this.c++;
            int i = this.d;
            if (i > 0) {
                bdz[] bdzVarArr = this.e;
                int i2 = i - 1;
                this.d = i2;
                bdzVar = bdzVarArr[i2];
                af.s(bdzVar);
                this.e[this.d] = null;
            } else {
                bdzVar = new bdz(new byte[65536], 0);
                int i3 = this.c;
                bdz[] bdzVarArr2 = this.e;
                int length = bdzVarArr2.length;
                if (i3 > length) {
                    this.e = (bdz[]) Arrays.copyOf(bdzVarArr2, length + length);
                    return bdzVar;
                }
            }
            return bdzVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void g(bdz bdzVar) {
        bdz[] bdzVarArr = this.e;
        int i = this.d;
        this.d = i + 1;
        bdzVarArr[i] = bdzVar;
        this.c--;
        notifyAll();
    }
}
