package x6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class l extends i {
    public final byte[] c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public l(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        if (z) {
            h(i5, i6);
        }
    }

    public byte[] b() {
        int d = d();
        int a = a();
        int i = this.d;
        if (d == i && a == this.e) {
            return this.c;
        }
        int i2 = d * a;
        byte[] bArr = new byte[i2];
        int i3 = (this.g * i) + this.f;
        if (d == i) {
            System.arraycopy(this.c, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < a; i4++) {
            System.arraycopy(this.c, i3, bArr, i4 * d, d);
            i3 += this.d;
        }
        return bArr;
    }

    public byte[] c(int i, byte[] bArr) {
        if (i < 0 || i >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int d = d();
        if (bArr == null || bArr.length < d) {
            bArr = new byte[d];
        }
        System.arraycopy(this.c, ((i + this.g) * this.d) + this.f, bArr, 0, d);
        return bArr;
    }

    public final void h(int i, int i2) {
        byte[] bArr = this.c;
        int i3 = (this.g * this.d) + this.f;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.d;
        }
    }
}
