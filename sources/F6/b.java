package f6;

import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends OutputStream {
    public long a = 0;

    public long a() {
        return this.a;
    }

    public void write(int i) {
        this.a++;
    }

    public void write(byte[] bArr) {
        this.a += bArr.length;
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.a += i2;
    }
}
