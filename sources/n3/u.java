package n3;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u {
    public final int a;
    public boolean b;
    public boolean c;
    public byte[] d;
    public int e;

    public u(int i, int i2) {
        this.a = i;
        byte[] bArr = new byte[i2 + 3];
        this.d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i4 = this.e;
            if (length < i4 + i3) {
                this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.d, this.e, i3);
            this.e += i3;
        }
    }

    public boolean b(int i) {
        if (!this.b) {
            return false;
        }
        this.e -= i;
        this.b = false;
        this.c = true;
        return true;
    }

    public boolean c() {
        return this.c;
    }

    public void d() {
        this.b = false;
        this.c = false;
    }

    public void e(int i) {
        d4.a.g(!this.b);
        boolean z = i == this.a;
        this.b = z;
        if (z) {
            this.e = 3;
            this.c = false;
        }
    }
}
