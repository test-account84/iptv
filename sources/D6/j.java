package D6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class j extends h {
    public b e;

    public j(x6.i iVar) {
        super(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x009c A[PHI: r5
      0x009c: PHI (r5v3 int) = (r5v2 int), (r5v6 int), (r5v6 int) binds: [B:39:0x007b, B:41:0x007f, B:42:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[][] i(byte[] r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: D6.j.i(byte[], int, int, int, int):int[][]");
    }

    public static void j(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        int i5 = i4 - 8;
        int i6 = i3 - 8;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 << 3;
            int i9 = i8 > i5 ? i5 : i8;
            int k = k(i7, i2 - 3);
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 << 3;
                int i12 = i11 > i6 ? i6 : i11;
                int k2 = k(i10, i - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[k + i14];
                    i13 += iArr2[k2 - 2] + iArr2[k2 - 1] + iArr2[k2] + iArr2[k2 + 1] + iArr2[2 + k2];
                }
                l(bArr, i12, i9, i13 / 25, i3, bVar);
            }
        }
    }

    public static int k(int i, int i2) {
        if (i < 2) {
            return 2;
        }
        return Math.min(i, i2);
    }

    public static void l(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bVar.n(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    public x6.b a(x6.i iVar) {
        return new j(iVar);
    }

    public b b() {
        b b;
        b bVar = this.e;
        if (bVar != null) {
            return bVar;
        }
        x6.i e = e();
        int d = e.d();
        int a = e.a();
        if (d < 40 || a < 40) {
            b = super.b();
        } else {
            byte[] b2 = e.b();
            int i = d >> 3;
            if ((d & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = a >> 3;
            if ((a & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] i5 = i(b2, i2, i4, d, a);
            b = new b(d, a);
            j(b2, i2, i4, d, a, i5, b);
        }
        this.e = b;
        return this.e;
    }
}
