package f4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final a a;
    public final a b;
    public final int c;
    public final boolean d;

    public static final class a {
        public final b[] a;

        public a(b... bVarArr) {
            this.a = bVarArr;
        }

        public b a(int i) {
            return this.a[i];
        }

        public int b() {
            return this.a.length;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final float[] c;
        public final float[] d;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.a = i;
            d4.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.c = fArr;
            this.d = fArr2;
            this.b = i2;
        }

        public int a() {
            return this.c.length / 3;
        }
    }

    public e(a aVar, int i) {
        this(aVar, aVar, i);
    }

    public static e a(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        float f4;
        float f5;
        int i5;
        int i6;
        int i7 = i;
        d4.a.a(f > 0.0f);
        d4.a.a(i7 >= 1);
        d4.a.a(i2 >= 1);
        d4.a.a(f2 > 0.0f && f2 <= 180.0f);
        d4.a.a(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
        float f6 = radians / i7;
        float f7 = radians2 / i2;
        int i8 = i2 + 1;
        int i9 = ((i8 * 2) + 2) * i7;
        float[] fArr = new float[i9 * 3];
        float[] fArr2 = new float[i9 * 2];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < i7) {
            float f8 = radians / 2.0f;
            float f9 = (i10 * f6) - f8;
            int i13 = i10 + 1;
            float f10 = (i13 * f6) - f8;
            int i14 = 0;
            while (true) {
                i4 = i13;
                if (i14 < i8) {
                    float f11 = f9;
                    int i15 = i12;
                    int i16 = 0;
                    while (i16 < 2) {
                        if (i16 == 0) {
                            f4 = f11;
                            f5 = f10;
                        } else {
                            f4 = f10;
                            f5 = f4;
                        }
                        float f12 = i14 * f7;
                        float f13 = f7;
                        float f14 = radians;
                        double d = f;
                        int i17 = i8;
                        double d2 = (f12 + 3.1415927f) - (radians2 / 2.0f);
                        int i18 = i14;
                        double d3 = f4;
                        float f15 = radians2;
                        int i19 = i16;
                        fArr[i11] = -((float) (Math.sin(d2) * d * Math.cos(d3)));
                        float f16 = f6;
                        fArr[i11 + 1] = (float) (d * Math.sin(d3));
                        int i20 = i11 + 3;
                        fArr[i11 + 2] = (float) (d * Math.cos(d2) * Math.cos(d3));
                        fArr2[i15] = f12 / f15;
                        int i21 = i15 + 2;
                        fArr2[i15 + 1] = ((i10 + i19) * f16) / f14;
                        if (i18 == 0 && i19 == 0) {
                            i6 = i19;
                            i5 = i18;
                        } else {
                            i5 = i18;
                            i6 = i19;
                            if (i5 != i2 || i6 != 1) {
                                i15 = i21;
                                i11 = i20;
                            }
                            i14 = i5;
                            f6 = f16;
                            i16 = i6 + 1;
                            f10 = f5;
                            f7 = f13;
                            radians = f14;
                            i8 = i17;
                            radians2 = f15;
                        }
                        System.arraycopy(fArr, i11, fArr, i20, 3);
                        i11 += 6;
                        System.arraycopy(fArr2, i15, fArr2, i21, 2);
                        i15 += 4;
                        i14 = i5;
                        f6 = f16;
                        i16 = i6 + 1;
                        f10 = f5;
                        f7 = f13;
                        radians = f14;
                        i8 = i17;
                        radians2 = f15;
                    }
                    i13 = i4;
                    f9 = f11;
                    i12 = i15;
                    i14++;
                    f10 = f10;
                    radians = radians;
                    radians2 = radians2;
                }
            }
            i7 = i;
            i10 = i4;
        }
        return new e(new a(new b(0, fArr, fArr2, 1)), i3);
    }

    public static e b(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public e(a aVar, a aVar2, int i) {
        this.a = aVar;
        this.b = aVar2;
        this.c = i;
        this.d = aVar == aVar2;
    }
}
