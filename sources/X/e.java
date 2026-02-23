package x;

import java.util.ArrayList;
import x.d;
import y.l;
import y.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public static float v0 = 0.5f;
    public d I;
    public d[] J;
    public ArrayList K;
    public boolean[] L;
    public b[] M;
    public e N;
    public int O;
    public int P;
    public float Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public float b0;
    public y.c c;
    public float c0;
    public y.c d;
    public Object d0;
    public int e0;
    public int f0;
    public String g0;
    public String h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public int m0;
    public int n0;
    public boolean o0;
    public boolean p0;
    public float[] q0;
    public e[] r0;
    public e[] s0;
    public e t0;
    public e u0;
    public boolean z;
    public boolean a = false;
    public m[] b = new m[2];
    public y.j e = new y.j(this);
    public l f = new l(this);
    public boolean[] g = {true, true};
    public int[] h = {0, 0, 0, 0};
    public boolean i = false;
    public int j = -1;
    public int k = -1;
    public int l = 0;
    public int m = 0;
    public int[] n = new int[2];
    public int o = 0;
    public int p = 0;
    public float q = 1.0f;
    public int r = 0;
    public int s = 0;
    public float t = 1.0f;
    public int u = -1;
    public float v = 1.0f;
    public int[] w = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float x = 0.0f;
    public boolean y = false;
    public boolean A = false;
    public d B = new d(this, d.b.LEFT);
    public d C = new d(this, d.b.TOP);
    public d D = new d(this, d.b.RIGHT);
    public d E = new d(this, d.b.BOTTOM);
    public d F = new d(this, d.b.BASELINE);
    public d G = new d(this, d.b.CENTER_X);
    public d H = new d(this, d.b.CENTER_Y);

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.I = dVar;
        this.J = new d[]{this.B, this.D, this.C, this.E, this.F, dVar};
        this.K = new ArrayList();
        this.L = new boolean[2];
        b bVar = b.FIXED;
        this.M = new b[]{bVar, bVar};
        this.N = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f = v0;
        this.b0 = f;
        this.c0 = f;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = null;
        this.h0 = null;
        this.k0 = false;
        this.l0 = false;
        this.m0 = 0;
        this.n0 = 0;
        this.q0 = new float[]{-1.0f, -1.0f};
        this.r0 = new e[]{null, null};
        this.s0 = new e[]{null, null};
        this.t0 = null;
        this.u0 = null;
        d();
    }

    public int A() {
        return this.w[0];
    }

    public void A0(int i) {
        this.O = i;
        int i2 = this.Z;
        if (i < i2) {
            this.O = i2;
        }
    }

    public int B() {
        return this.a0;
    }

    public void B0(int i) {
        this.S = i;
    }

    public int C() {
        return this.Z;
    }

    public void C0(int i) {
        this.T = i;
    }

    public e D(int i) {
        d dVar;
        d dVar2;
        if (i != 0) {
            if (i == 1 && (dVar2 = (dVar = this.E).d) != null && dVar2.d == dVar) {
                return dVar2.b;
            }
            return null;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.d;
        if (dVar4 == null || dVar4.d != dVar3) {
            return null;
        }
        return dVar4.b;
    }

    public void D0(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.u == -1) {
            if (z3 && !z4) {
                this.u = 0;
            } else if (!z3 && z4) {
                this.u = 1;
                if (this.R == -1) {
                    this.v = 1.0f / this.v;
                }
            }
        }
        if (this.u == 0 && (!this.C.i() || !this.E.i())) {
            this.u = 1;
        } else if (this.u == 1 && (!this.B.i() || !this.D.i())) {
            this.u = 0;
        }
        if (this.u == -1 && (!this.C.i() || !this.E.i() || !this.B.i() || !this.D.i())) {
            if (this.C.i() && this.E.i()) {
                this.u = 0;
            } else if (this.B.i() && this.D.i()) {
                this.v = 1.0f / this.v;
                this.u = 1;
            }
        }
        if (this.u == -1) {
            int i = this.o;
            if (i > 0 && this.r == 0) {
                this.u = 0;
            } else {
                if (i != 0 || this.r <= 0) {
                    return;
                }
                this.v = 1.0f / this.v;
                this.u = 1;
            }
        }
    }

    public e E() {
        return this.N;
    }

    public void E0(boolean z, boolean z2) {
        int i;
        int i2;
        boolean k = z & this.e.k();
        boolean k2 = z2 & this.f.k();
        y.j jVar = this.e;
        int i3 = jVar.h.g;
        l lVar = this.f;
        int i4 = lVar.h.g;
        int i5 = jVar.i.g;
        int i6 = lVar.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (k) {
            this.S = i3;
        }
        if (k2) {
            this.T = i4;
        }
        if (this.f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        if (k) {
            if (this.M[0] == b.FIXED && i8 < (i2 = this.O)) {
                i8 = i2;
            }
            this.O = i8;
            int i10 = this.Z;
            if (i8 < i10) {
                this.O = i10;
            }
        }
        if (k2) {
            if (this.M[1] == b.FIXED && i9 < (i = this.P)) {
                i9 = i;
            }
            this.P = i9;
            int i11 = this.a0;
            if (i9 < i11) {
                this.P = i11;
            }
        }
    }

    public e F(int i) {
        d dVar;
        d dVar2;
        if (i != 0) {
            if (i == 1 && (dVar2 = (dVar = this.C).d) != null && dVar2.d == dVar) {
                return dVar2.b;
            }
            return null;
        }
        d dVar3 = this.B;
        d dVar4 = dVar3.d;
        if (dVar4 == null || dVar4.d != dVar3) {
            return null;
        }
        return dVar4.b;
    }

    public void F0(w.d dVar) {
        int x = dVar.x(this.B);
        int x2 = dVar.x(this.C);
        int x3 = dVar.x(this.D);
        int x4 = dVar.x(this.E);
        y.j jVar = this.e;
        y.f fVar = jVar.h;
        if (fVar.j) {
            y.f fVar2 = jVar.i;
            if (fVar2.j) {
                x = fVar.g;
                x3 = fVar2.g;
            }
        }
        l lVar = this.f;
        y.f fVar3 = lVar.h;
        if (fVar3.j) {
            y.f fVar4 = lVar.i;
            if (fVar4.j) {
                x2 = fVar3.g;
                x4 = fVar4.g;
            }
        }
        int i = x4 - x2;
        if (x3 - x < 0 || i < 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE || x2 == Integer.MIN_VALUE || x2 == Integer.MAX_VALUE || x3 == Integer.MIN_VALUE || x3 == Integer.MAX_VALUE || x4 == Integer.MIN_VALUE || x4 == Integer.MAX_VALUE) {
            x = 0;
            x4 = 0;
            x2 = 0;
            x3 = 0;
        }
        c0(x, x2, x3, x4);
    }

    public int G() {
        return O() + this.O;
    }

    public m H(int i) {
        if (i == 0) {
            return this.e;
        }
        if (i == 1) {
            return this.f;
        }
        return null;
    }

    public float I() {
        return this.c0;
    }

    public int J() {
        return this.n0;
    }

    public b K() {
        return this.M[1];
    }

    public int L() {
        int i = this.B != null ? this.C.e : 0;
        return this.D != null ? i + this.E.e : i;
    }

    public int M() {
        return this.f0;
    }

    public int N() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.O;
    }

    public int O() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.S : ((f) eVar).C0 + this.S;
    }

    public int P() {
        e eVar = this.N;
        return (eVar == null || !(eVar instanceof f)) ? this.T : ((f) eVar).D0 + this.T;
    }

    public boolean Q() {
        return this.y;
    }

    public void R(d.b bVar, e eVar, d.b bVar2, int i, int i2) {
        k(bVar).a(eVar.k(bVar2), i, i2, true);
    }

    public final boolean S(int i) {
        d dVar;
        d dVar2;
        int i2 = i * 2;
        d[] dVarArr = this.J;
        d dVar3 = dVarArr[i2];
        d dVar4 = dVar3.d;
        return (dVar4 == null || dVar4.d == dVar3 || (dVar2 = (dVar = dVarArr[i2 + 1]).d) == null || dVar2.d != dVar) ? false : true;
    }

    public boolean T() {
        d dVar = this.B;
        d dVar2 = dVar.d;
        if (dVar2 != null && dVar2.d == dVar) {
            return true;
        }
        d dVar3 = this.D;
        d dVar4 = dVar3.d;
        return dVar4 != null && dVar4.d == dVar3;
    }

    public boolean U() {
        return this.z;
    }

    public boolean V() {
        d dVar = this.C;
        d dVar2 = dVar.d;
        if (dVar2 != null && dVar2.d == dVar) {
            return true;
        }
        d dVar3 = this.E;
        d dVar4 = dVar3.d;
        return dVar4 != null && dVar4.d == dVar3;
    }

    public void W() {
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.N = null;
        this.x = 0.0f;
        this.O = 0;
        this.P = 0;
        this.Q = 0.0f;
        this.R = -1;
        this.S = 0;
        this.T = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        float f = v0;
        this.b0 = f;
        this.c0 = f;
        b[] bVarArr = this.M;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.d0 = null;
        this.e0 = 0;
        this.f0 = 0;
        this.h0 = null;
        this.i0 = false;
        this.j0 = false;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = false;
        this.p0 = false;
        float[] fArr = this.q0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.j = -1;
        this.k = -1;
        int[] iArr = this.w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.l = 0;
        this.m = 0;
        this.q = 1.0f;
        this.t = 1.0f;
        this.p = Integer.MAX_VALUE;
        this.s = Integer.MAX_VALUE;
        this.o = 0;
        this.r = 0;
        this.i = false;
        this.u = -1;
        this.v = 1.0f;
        this.k0 = false;
        this.l0 = false;
        boolean[] zArr = this.g;
        zArr[0] = true;
        zArr[1] = true;
        this.A = false;
        boolean[] zArr2 = this.L;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void X(w.c cVar) {
        this.B.l(cVar);
        this.C.l(cVar);
        this.D.l(cVar);
        this.E.l(cVar);
        this.F.l(cVar);
        this.I.l(cVar);
        this.G.l(cVar);
        this.H.l(cVar);
    }

    public void Y(int i) {
        this.Y = i;
        this.y = i > 0;
    }

    public void Z(Object obj) {
        this.d0 = obj;
    }

    public void a0(String str) {
        this.g0 = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0087 A[PHI: r0
      0x0087: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:43:0x0086, B:41:0x007f, B:22:0x0051, B:24:0x0057, B:26:0x0063, B:28:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0087 -> B:31:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b0(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L91
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L91
        Lb:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L39
            int r6 = r1 + (-1)
            if (r2 >= r6) goto L39
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2b
            goto L36
        L2b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L35
            r3 = 1
            goto L36
        L35:
            r3 = -1
        L36:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L39:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L77
            int r1 = r1 - r4
            if (r2 >= r1) goto L77
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L87
            int r2 = r9.length()
            if (r2 <= 0) goto L87
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L87
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L87
            if (r5 != r4) goto L71
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L88
        L71:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
            goto L88
        L77:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L87
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L88
        L86:
        L87:
            r9 = 0
        L88:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L90
            r8.Q = r9
            r8.R = r5
        L90:
            return
        L91:
            r8.Q = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.b0(java.lang.String):void");
    }

    public void c0(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.S = i;
        this.T = i2;
        if (this.f0 == 8) {
            this.O = 0;
            this.P = 0;
            return;
        }
        b[] bVarArr = this.M;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i7 < (i6 = this.O)) {
            i7 = i6;
        }
        if (bVarArr[1] == bVar2 && i8 < (i5 = this.P)) {
            i8 = i5;
        }
        this.O = i7;
        this.P = i8;
        int i9 = this.a0;
        if (i8 < i9) {
            this.P = i9;
        }
        int i10 = this.Z;
        if (i7 < i10) {
            this.O = i10;
        }
    }

    public final void d() {
        this.K.add(this.B);
        this.K.add(this.C);
        this.K.add(this.D);
        this.K.add(this.E);
        this.K.add(this.G);
        this.K.add(this.H);
        this.K.add(this.I);
        this.K.add(this.F);
    }

    public void d0(boolean z) {
        this.y = z;
    }

    public boolean e() {
        return this instanceof g;
    }

    public void e0(int i) {
        this.P = i;
        int i2 = this.a0;
        if (i < i2) {
            this.P = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0396  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(w.d r48) {
        /*
            Method dump skipped, instructions count: 1211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.f(w.d):void");
    }

    public void f0(float f) {
        this.b0 = f;
    }

    public boolean g() {
        return this.f0 != 8;
    }

    public void g0(int i) {
        this.m0 = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0301 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(w.d r32, boolean r33, boolean r34, boolean r35, boolean r36, w.i r37, w.i r38, x.e.b r39, boolean r40, x.d r41, x.d r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instructions count: 1071
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.h(w.d, boolean, boolean, boolean, boolean, w.i, w.i, x.e$b, boolean, x.d, x.d, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void h0(int i, int i2) {
        this.S = i;
        int i3 = i2 - i;
        this.O = i3;
        int i4 = this.Z;
        if (i3 < i4) {
            this.O = i4;
        }
    }

    public void i(e eVar, float f, int i) {
        d.b bVar = d.b.CENTER;
        R(bVar, eVar, bVar, i, 0);
        this.x = f;
    }

    public void i0(b bVar) {
        this.M[0] = bVar;
    }

    public void j(w.d dVar) {
        dVar.q(this.B);
        dVar.q(this.C);
        dVar.q(this.D);
        dVar.q(this.E);
        if (this.Y > 0) {
            dVar.q(this.F);
        }
    }

    public void j0(int i, int i2, int i3, float f) {
        this.l = i;
        this.o = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.p = i3;
        this.q = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.l = 2;
    }

    public d k(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return this.B;
            case 2:
                return this.C;
            case 3:
                return this.D;
            case 4:
                return this.E;
            case 5:
                return this.F;
            case 6:
                return this.I;
            case 7:
                return this.G;
            case 8:
                return this.H;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void k0(float f) {
        this.q0[0] = f;
    }

    public int l() {
        return this.Y;
    }

    public void l0(int i, boolean z) {
        this.L[i] = z;
    }

    public float m(int i) {
        if (i == 0) {
            return this.b0;
        }
        if (i == 1) {
            return this.c0;
        }
        return -1.0f;
    }

    public void m0(boolean z) {
        this.z = z;
    }

    public int n() {
        return P() + this.P;
    }

    public void n0(int i) {
        this.w[1] = i;
    }

    public Object o() {
        return this.d0;
    }

    public void o0(int i) {
        this.w[0] = i;
    }

    public String p() {
        return this.g0;
    }

    public void p0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.a0 = i;
    }

    public b q(int i) {
        if (i == 0) {
            return w();
        }
        if (i == 1) {
            return K();
        }
        return null;
    }

    public void q0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.Z = i;
    }

    public float r() {
        return this.Q;
    }

    public void r0(int i, int i2) {
        this.S = i;
        this.T = i2;
    }

    public int s() {
        return this.R;
    }

    public void s0(e eVar) {
        this.N = eVar;
    }

    public int t() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.P;
    }

    public void t0(float f) {
        this.c0 = f;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.h0 != null) {
            str = "type: " + this.h0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.g0 != null) {
            str2 = "id: " + this.g0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.S);
        sb.append(", ");
        sb.append(this.T);
        sb.append(") - (");
        sb.append(this.O);
        sb.append(" x ");
        sb.append(this.P);
        sb.append(")");
        return sb.toString();
    }

    public float u() {
        return this.b0;
    }

    public void u0(int i) {
        this.n0 = i;
    }

    public int v() {
        return this.m0;
    }

    public void v0(int i, int i2) {
        this.T = i;
        int i3 = i2 - i;
        this.P = i3;
        int i4 = this.a0;
        if (i3 < i4) {
            this.P = i4;
        }
    }

    public b w() {
        return this.M[0];
    }

    public void w0(b bVar) {
        this.M[1] = bVar;
    }

    public int x() {
        d dVar = this.B;
        int i = dVar != null ? dVar.e : 0;
        d dVar2 = this.D;
        return dVar2 != null ? i + dVar2.e : i;
    }

    public void x0(int i, int i2, int i3, float f) {
        this.m = i;
        this.r = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.s = i3;
        this.t = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.m = 2;
    }

    public int y(int i) {
        if (i == 0) {
            return N();
        }
        if (i == 1) {
            return t();
        }
        return 0;
    }

    public void y0(float f) {
        this.q0[1] = f;
    }

    public int z() {
        return this.w[1];
    }

    public void z0(int i) {
        this.f0 = i;
    }
}
