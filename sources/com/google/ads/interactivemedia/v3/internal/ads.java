package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ads {
    private static final byte[] d = {0, 0, 1};
    public int a;
    public int b;
    public byte[] c = new byte[128];
    private boolean e;

    public final void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            int i3 = i2 - i;
            byte[] bArr2 = this.c;
            int length = bArr2.length;
            int i4 = this.a + i3;
            if (length < i4) {
                this.c = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.c, this.a, i3);
            this.a += i3;
        }
    }

    public final void b() {
        this.e = false;
        this.a = 0;
        this.b = 0;
    }

    public final boolean c(int i, int i2) {
        if (this.e) {
            int i3 = this.a - i2;
            this.a = i3;
            if (this.b != 0 || i != 181) {
                this.e = false;
                return true;
            }
            this.b = i3;
        } else if (i == 179) {
            this.e = true;
        }
        a(d, 0, 3);
        return false;
    }
}
