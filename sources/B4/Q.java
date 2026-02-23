package b4;

import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q extends InputStream {
    public final o a;
    public final s c;
    public long g;
    public boolean e = false;
    public boolean f = false;
    public final byte[] d = new byte[1];

    public q(o oVar, s sVar) {
        this.a = oVar;
        this.c = sVar;
    }

    public final void a() {
        if (this.e) {
            return;
        }
        this.a.a(this.c);
        this.e = true;
    }

    public void c() {
        a();
    }

    public void close() {
        if (this.f) {
            return;
        }
        this.a.close();
        this.f = true;
    }

    public int read() {
        if (read(this.d) == -1) {
            return -1;
        }
        return this.d[0] & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        d4.a.g(!this.f);
        a();
        int read = this.a.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.g += read;
        return read;
    }
}
