package androidx.leanback.widget;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c0 {
    public int a = 0;
    public final a b;
    public final a c;
    public a d;
    public a e;

    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e = 2;
        public int f = 3;
        public int g = 0;
        public float h = 50.0f;
        public int i;
        public int j;
        public int k;
        public boolean l;
        public String m;

        public a(String str) {
            s();
            this.m = str;
        }

        public final void A(float f) {
            if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.h = f;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        
            r4.c = (r4.a - r4.j) - r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        
            r2 = r4.b - r4.j;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void B(int r5, int r6, int r7, int r8) {
            /*
                r4 = this;
                r4.b = r5
                r4.a = r6
                int r5 = r4.c()
                int r6 = r4.a()
                boolean r0 = r4.p()
                boolean r1 = r4.o()
                if (r0 != 0) goto L34
                boolean r2 = r4.l
                if (r2 != 0) goto L21
                int r2 = r4.f
                r2 = r2 & 1
                if (r2 == 0) goto L2f
                goto L27
            L21:
                int r2 = r4.f
                r2 = r2 & 2
                if (r2 == 0) goto L2f
            L27:
                int r2 = r4.b
                int r3 = r4.j
                int r2 = r2 - r3
            L2c:
                r4.d = r2
                goto L34
            L2f:
                int r2 = r4.b(r7, r6)
                goto L2c
            L34:
                if (r1 != 0) goto L56
                boolean r2 = r4.l
                if (r2 != 0) goto L41
                int r2 = r4.f
                r2 = r2 & 2
                if (r2 == 0) goto L50
                goto L47
            L41:
                int r2 = r4.f
                r2 = r2 & 1
                if (r2 == 0) goto L50
            L47:
                int r2 = r4.a
                int r3 = r4.j
                int r2 = r2 - r3
                int r2 = r2 - r5
                r4.c = r2
                goto L56
            L50:
                int r5 = r4.b(r8, r6)
                r4.c = r5
            L56:
                if (r1 != 0) goto Lba
                if (r0 != 0) goto Lba
                boolean r5 = r4.l
                if (r5 != 0) goto La2
                int r5 = r4.f
                r0 = r5 & 1
                if (r0 == 0) goto L81
                boolean r5 = r4.r()
                if (r5 == 0) goto L76
            L6a:
                int r5 = r4.d
                int r6 = r4.b(r8, r6)
                int r5 = java.lang.Math.min(r5, r6)
                r4.d = r5
            L76:
                int r5 = r4.d
                int r6 = r4.c
                int r5 = java.lang.Math.max(r5, r6)
                r4.c = r5
                goto Lba
            L81:
                r5 = r5 & 2
                if (r5 == 0) goto Lba
                boolean r5 = r4.q()
                if (r5 == 0) goto L97
            L8b:
                int r5 = r4.c
                int r6 = r4.b(r7, r6)
                int r5 = java.lang.Math.max(r5, r6)
                r4.c = r5
            L97:
                int r5 = r4.d
                int r6 = r4.c
                int r5 = java.lang.Math.min(r5, r6)
                r4.d = r5
                goto Lba
            La2:
                int r5 = r4.f
                r0 = r5 & 1
                if (r0 == 0) goto Laf
                boolean r5 = r4.r()
                if (r5 == 0) goto L97
                goto L8b
            Laf:
                r5 = r5 & 2
                if (r5 == 0) goto Lba
                boolean r5 = r4.q()
                if (r5 == 0) goto L76
                goto L6a
            Lba:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.c0.a.B(int, int, int, int):void");
        }

        public final int a() {
            if (this.l) {
                int i = this.g;
                int i2 = i >= 0 ? this.i - i : -i;
                float f = this.h;
                return f != -1.0f ? i2 - ((int) ((this.i * f) / 100.0f)) : i2;
            }
            int i3 = this.g;
            if (i3 < 0) {
                i3 += this.i;
            }
            float f2 = this.h;
            return f2 != -1.0f ? i3 + ((int) ((this.i * f2) / 100.0f)) : i3;
        }

        public final int b(int i, int i2) {
            return i - i2;
        }

        public final int c() {
            return (this.i - this.j) - this.k;
        }

        public final int d() {
            return this.c;
        }

        public final int e() {
            return this.d;
        }

        public final int f() {
            return this.k;
        }

        public final int g() {
            return this.j;
        }

        public final int h(int i) {
            int i2;
            int i3;
            int i4 = i();
            int a = a();
            boolean p = p();
            boolean o = o();
            if (!p) {
                int i5 = this.j;
                int i6 = a - i5;
                if (this.l ? (this.f & 2) != 0 : (this.f & 1) != 0) {
                    int i7 = this.b;
                    if (i - i7 <= i6) {
                        int i8 = i7 - i5;
                        return (o || i8 <= (i3 = this.c)) ? i8 : i3;
                    }
                }
            }
            if (!o) {
                int i9 = this.k;
                int i10 = (i4 - a) - i9;
                if (this.l ? (this.f & 1) != 0 : (this.f & 2) != 0) {
                    int i11 = this.a;
                    if (i11 - i <= i10) {
                        int i12 = i11 - (i4 - i9);
                        return (p || i12 >= (i2 = this.d)) ? i12 : i2;
                    }
                }
            }
            return b(i, a);
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.f;
        }

        public final int k() {
            return this.g;
        }

        public final float l() {
            return this.h;
        }

        public final void m() {
            this.a = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
        }

        public final void n() {
            this.b = Integer.MIN_VALUE;
            this.d = Integer.MIN_VALUE;
        }

        public final boolean o() {
            return this.a == Integer.MAX_VALUE;
        }

        public final boolean p() {
            return this.b == Integer.MIN_VALUE;
        }

        public final boolean q() {
            return (this.e & 2) != 0;
        }

        public final boolean r() {
            return (this.e & 1) != 0;
        }

        public void s() {
            this.b = Integer.MIN_VALUE;
            this.a = Integer.MAX_VALUE;
        }

        public final void t(int i, int i2) {
            this.j = i;
            this.k = i2;
        }

        public String toString() {
            return " min:" + this.b + " " + this.d + " max:" + this.a + " " + this.c;
        }

        public final void u(boolean z) {
            this.e = z ? this.e | 2 : this.e & (-3);
        }

        public final void v(boolean z) {
            this.e = z ? this.e | 1 : this.e & (-2);
        }

        public final void w(boolean z) {
            this.l = z;
        }

        public final void x(int i) {
            this.i = i;
        }

        public final void y(int i) {
            this.f = i;
        }

        public final void z(int i) {
            this.g = i;
        }
    }

    public c0() {
        a aVar = new a("vertical");
        this.b = aVar;
        a aVar2 = new a("horizontal");
        this.c = aVar2;
        this.d = aVar2;
        this.e = aVar;
    }

    public final a a() {
        return this.d;
    }

    public final void b() {
        a().s();
    }

    public final a c() {
        return this.e;
    }

    public final void d(int i) {
        a aVar;
        this.a = i;
        if (i == 0) {
            this.d = this.c;
            aVar = this.b;
        } else {
            this.d = this.b;
            aVar = this.c;
        }
        this.e = aVar;
    }

    public String toString() {
        return "horizontal=" + this.c + "; vertical=" + this.b;
    }
}
