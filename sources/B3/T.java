package B3;

import android.net.Uri;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t implements b4.o {
    public final b4.o a;
    public final int b;
    public final a c;
    public final byte[] d;
    public int e;

    public interface a {
        void b(d4.M m);
    }

    public t(b4.o oVar, int i, a aVar) {
        d4.a.a(i > 0);
        this.a = oVar;
        this.b = i;
        this.c = aVar;
        this.d = new byte[1];
        this.e = i;
    }

    public long a(b4.s sVar) {
        throw new UnsupportedOperationException();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public Map e() {
        return this.a.e();
    }

    public void g(b4.S s) {
        d4.a.e(s);
        this.a.g(s);
    }

    public Uri getUri() {
        return this.a.getUri();
    }

    public final boolean j() {
        if (this.a.read(this.d, 0, 1) == -1) {
            return false;
        }
        int i = (this.d[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int read = this.a.read(bArr, i3, i2);
            if (read == -1) {
                return false;
            }
            i3 += read;
            i2 -= read;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.c.b(new d4.M(bArr, i));
        }
        return true;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.e == 0) {
            if (!j()) {
                return -1;
            }
            this.e = this.b;
        }
        int read = this.a.read(bArr, i, Math.min(this.e, i2));
        if (read != -1) {
            this.e -= read;
        }
        return read;
    }
}
