package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class buq {
    private int a = 0;

    public final int a() {
        return this.a;
    }

    public final buq b(Object obj, Object obj2) {
        c(obj, obj2);
        return this;
    }

    public final void c(Object obj, Object obj2) {
        if (this.a == 0 && obj != obj2) {
            if (obj == null) {
                this.a = -1;
                return;
            }
            if (obj2 == null) {
                this.a = 1;
                return;
            }
            if (!obj.getClass().isArray()) {
                this.a = ((Comparable) obj).compareTo(obj2);
                return;
            }
            int i = 0;
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                if (this.a == 0 && jArr != jArr2) {
                    int length = jArr.length;
                    int length2 = jArr2.length;
                    if (length != length2) {
                        this.a = length >= length2 ? 1 : -1;
                        return;
                    }
                    while (i < jArr.length && this.a == 0) {
                        this.a = (jArr[i] > jArr2[i] ? 1 : (jArr[i] == jArr2[i] ? 0 : -1));
                        i++;
                    }
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int[] iArr2 = (int[]) obj2;
                if (this.a != 0 || iArr == iArr2) {
                    return;
                }
                int length3 = iArr.length;
                int length4 = iArr2.length;
                if (length3 != length4) {
                    this.a = length3 >= length4 ? 1 : -1;
                    return;
                }
                for (int i2 = 0; i2 < iArr.length && this.a == 0; i2++) {
                    int i3 = iArr[i2];
                    int i4 = iArr2[i2];
                    this.a = i3 == i4 ? 0 : i3 < i4 ? -1 : 1;
                }
                return;
            }
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                short[] sArr2 = (short[]) obj2;
                if (this.a != 0 || sArr == sArr2) {
                    return;
                }
                int length5 = sArr.length;
                int length6 = sArr2.length;
                if (length5 != length6) {
                    this.a = length5 >= length6 ? 1 : -1;
                    return;
                }
                while (i < sArr.length && this.a == 0) {
                    this.a = sArr[i] - sArr2[i];
                    i++;
                }
                return;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                char[] cArr2 = (char[]) obj2;
                if (this.a != 0 || cArr == cArr2) {
                    return;
                }
                int length7 = cArr.length;
                int length8 = cArr2.length;
                if (length7 != length8) {
                    this.a = length7 >= length8 ? 1 : -1;
                    return;
                }
                while (i < cArr.length && this.a == 0) {
                    this.a = cArr[i] - cArr2[i];
                    i++;
                }
                return;
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (this.a != 0 || bArr == bArr2) {
                    return;
                }
                int length9 = bArr.length;
                int length10 = bArr2.length;
                if (length9 != length10) {
                    this.a = length9 >= length10 ? 1 : -1;
                    return;
                }
                while (i < bArr.length && this.a == 0) {
                    this.a = bArr[i] - bArr2[i];
                    i++;
                }
                return;
            }
            if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                if (this.a != 0 || dArr == dArr2) {
                    return;
                }
                int length11 = dArr.length;
                int length12 = dArr2.length;
                if (length11 != length12) {
                    this.a = length11 >= length12 ? 1 : -1;
                    return;
                }
                while (i < dArr.length && this.a == 0) {
                    this.a = Double.compare(dArr[i], dArr2[i]);
                    i++;
                }
                return;
            }
            if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                if (this.a != 0 || fArr == fArr2) {
                    return;
                }
                int length13 = fArr.length;
                int length14 = fArr2.length;
                if (length13 != length14) {
                    this.a = length13 >= length14 ? 1 : -1;
                    return;
                }
                while (i < fArr.length && this.a == 0) {
                    this.a = Float.compare(fArr[i], fArr2[i]);
                    i++;
                }
                return;
            }
            if (!(obj instanceof boolean[])) {
                Object[] objArr = (Object[]) obj;
                Object[] objArr2 = (Object[]) obj2;
                if (this.a != 0 || objArr == objArr2) {
                    return;
                }
                int length15 = objArr.length;
                int length16 = objArr2.length;
                if (length15 != length16) {
                    this.a = length15 >= length16 ? 1 : -1;
                    return;
                }
                while (i < objArr.length && this.a == 0) {
                    c(objArr[i], objArr2[i]);
                    i++;
                }
                return;
            }
            boolean[] zArr = (boolean[]) obj;
            boolean[] zArr2 = (boolean[]) obj2;
            if (this.a != 0 || zArr == zArr2) {
                return;
            }
            int length17 = zArr.length;
            int length18 = zArr2.length;
            if (length17 != length18) {
                this.a = length17 >= length18 ? 1 : -1;
                return;
            }
            while (i < zArr.length && this.a == 0) {
                boolean z = zArr[i];
                if (z != zArr2[i]) {
                    if (z) {
                        this.a = 1;
                    } else {
                        this.a = -1;
                    }
                }
                i++;
            }
        }
    }
}
