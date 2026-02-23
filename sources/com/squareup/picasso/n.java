package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class n extends InputStream {
    public final InputStream a;
    public long c;
    public long d;
    public long e;
    public long f;

    public n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public void a(long j) {
        if (this.c > this.e || j < this.d) {
            throw new IOException("Cannot reset");
        }
        this.a.reset();
        e(this.d, j);
        this.c = j;
    }

    public int available() {
        return this.a.available();
    }

    public long c(int i) {
        long j = this.c + i;
        if (this.e < j) {
            d(j);
        }
        return this.c;
    }

    public void close() {
        this.a.close();
    }

    public final void d(long j) {
        try {
            long j2 = this.d;
            long j3 = this.c;
            if (j2 >= j3 || j3 > this.e) {
                this.d = j3;
                this.a.mark((int) (j - j3));
            } else {
                this.a.reset();
                this.a.mark((int) (j - this.d));
                e(this.d, this.c);
            }
            this.e = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public final void e(long j, long j2) {
        while (j < j2) {
            long skip = this.a.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    skip = 1;
                }
            }
            j += skip;
        }
    }

    public void mark(int i) {
        this.f = c(i);
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }

    public int read() {
        int read = this.a.read();
        if (read != -1) {
            this.c++;
        }
        return read;
    }

    public void reset() {
        a(this.f);
    }

    public long skip(long j) {
        long skip = this.a.skip(j);
        this.c += skip;
        return skip;
    }

    public n(InputStream inputStream, int i) {
        this.f = -1L;
        this.a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    public int read(byte[] bArr) {
        int read = this.a.read(bArr);
        if (read != -1) {
            this.c += read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.a.read(bArr, i, i2);
        if (read != -1) {
            this.c += read;
        }
        return read;
    }
}
