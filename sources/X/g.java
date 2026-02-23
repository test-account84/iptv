package x;

import x.d;
import x.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends e {
    public float w0 = -1.0f;
    public int x0 = -1;
    public int y0 = -1;
    public d z0 = this.C;
    public int A0 = 0;
    public int B0 = 0;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.K.clear();
        this.K.add(this.z0);
        int length = this.J.length;
        for (int i = 0; i < length; i++) {
            this.J[i] = this.z0;
        }
    }

    public void F0(w.d dVar) {
        if (E() == null) {
            return;
        }
        int x = dVar.x(this.z0);
        if (this.A0 == 1) {
            B0(x);
            C0(0);
            e0(E().t());
            A0(0);
            return;
        }
        B0(0);
        C0(x);
        A0(E().N());
        e0(0);
    }

    public int G0() {
        return this.A0;
    }

    public int H0() {
        return this.x0;
    }

    public int I0() {
        return this.y0;
    }

    public float J0() {
        return this.w0;
    }

    public void K0(int i) {
        if (i > -1) {
            this.w0 = -1.0f;
            this.x0 = i;
            this.y0 = -1;
        }
    }

    public void L0(int i) {
        if (i > -1) {
            this.w0 = -1.0f;
            this.x0 = -1;
            this.y0 = i;
        }
    }

    public void M0(float f) {
        if (f > -1.0f) {
            this.w0 = f;
            this.x0 = -1;
            this.y0 = -1;
        }
    }

    public void N0(int i) {
        if (this.A0 == i) {
            return;
        }
        this.A0 = i;
        this.K.clear();
        this.z0 = this.A0 == 1 ? this.B : this.C;
        this.K.add(this.z0);
        int length = this.J.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.J[i2] = this.z0;
        }
    }

    public void f(w.d dVar) {
        f fVar = (f) E();
        if (fVar == null) {
            return;
        }
        d k = fVar.k(d.b.LEFT);
        d k2 = fVar.k(d.b.RIGHT);
        e eVar = this.N;
        boolean z = eVar != null && eVar.M[0] == e.b.WRAP_CONTENT;
        if (this.A0 == 0) {
            k = fVar.k(d.b.TOP);
            k2 = fVar.k(d.b.BOTTOM);
            e eVar2 = this.N;
            z = eVar2 != null && eVar2.M[1] == e.b.WRAP_CONTENT;
        }
        if (this.x0 != -1) {
            w.i q = dVar.q(this.z0);
            dVar.e(q, dVar.q(k), this.x0, 8);
            if (z) {
                dVar.h(dVar.q(k2), q, 0, 5);
                return;
            }
            return;
        }
        if (this.y0 == -1) {
            if (this.w0 != -1.0f) {
                dVar.d(w.d.s(dVar, dVar.q(this.z0), dVar.q(k2), this.w0));
                return;
            }
            return;
        }
        w.i q2 = dVar.q(this.z0);
        w.i q3 = dVar.q(k2);
        dVar.e(q2, q3, -this.y0, 8);
        if (z) {
            dVar.h(q2, dVar.q(k), 0, 5);
            dVar.h(q3, q2, 0, 5);
        }
    }

    public boolean g() {
        return true;
    }

    public d k(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.A0 == 1) {
                    return this.z0;
                }
                break;
            case 3:
            case 4:
                if (this.A0 == 0) {
                    return this.z0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}
