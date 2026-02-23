package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class sv implements cy {
    private final cy a;
    private final int b;
    private final su c;
    private final byte[] d;
    private int e;

    public sv(cy cyVar, int i, su suVar) {
        af.u(i > 0);
        this.a = cyVar;
        this.b = i;
        this.c = suVar;
        this.d = new byte[1];
        this.e = i;
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        if (i3 == 0) {
            int i4 = 0;
            if (this.a.a(this.d, 0, 1) != -1) {
                int i5 = (this.d[0] & 255) << 4;
                if (i5 != 0) {
                    byte[] bArr2 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int a = this.a.a(bArr2, i4, i6);
                        if (a != -1) {
                            i4 += a;
                            i6 -= a;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.c.a(new cj(bArr2, i5));
                    }
                }
                i3 = this.b;
                this.e = i3;
            }
            return -1;
        }
        int a2 = this.a.a(bArr, i, Math.min(i3, i2));
        if (a2 != -1) {
            this.e -= a2;
        }
        return a2;
    }

    public final long b(dc dcVar) {
        throw new UnsupportedOperationException();
    }

    public final Uri c() {
        return this.a.c();
    }

    public final void d() {
        throw new UnsupportedOperationException();
    }

    public final Map e() {
        return this.a.e();
    }

    public final void f(dw dwVar) {
        af.s(dwVar);
        this.a.f(dwVar);
    }
}
