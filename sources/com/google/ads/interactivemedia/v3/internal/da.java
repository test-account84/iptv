package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class da extends InputStream {
    private final cy a;
    private final dc b;
    private long f;
    private boolean d = false;
    private boolean e = false;
    private final byte[] c = new byte[1];

    public da(cy cyVar, dc dcVar) {
        this.a = cyVar;
        this.b = dcVar;
    }

    private final void b() throws IOException {
        if (this.d) {
            return;
        }
        this.a.b(this.b);
        this.d = true;
    }

    public final void a() throws IOException {
        b();
    }

    public final void close() throws IOException {
        if (this.e) {
            return;
        }
        this.a.d();
        this.e = true;
    }

    public final int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        af.w(!this.e);
        b();
        int a = this.a.a(bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        this.f += a;
        return a;
    }
}
