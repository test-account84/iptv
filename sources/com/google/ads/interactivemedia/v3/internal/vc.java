package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class vc extends uu {
    private byte[] a;
    private volatile boolean b;

    public vc(cy cyVar, dc dcVar, s sVar, int i, byte[] bArr) {
        super(cyVar, dcVar, 3, sVar, i, -9223372036854775807L, -9223372036854775807L);
        this.a = bArr == null ? cq.f : bArr;
    }

    public abstract void a(byte[] bArr, int i) throws IOException;

    public final byte[] c() {
        return this.a;
    }

    public final void e() throws IOException {
        try {
            this.n.b(this.g);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.b) {
                byte[] bArr = this.a;
                int length = bArr.length;
                if (length < i2 + 16384) {
                    this.a = Arrays.copyOf(bArr, length + 16384);
                }
                i = this.n.a(this.a, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.b) {
                a(this.a, i2);
            }
            af.e(this.n);
        } catch (Throwable th) {
            af.e(this.n);
            throw th;
        }
    }

    public final void r() {
        this.b = true;
    }
}
