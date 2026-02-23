package y;

import x.d;
import x.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class m implements d {
    public int a;
    public x.e b;
    public k c;
    public e.b d;
    public g e = new g(this);
    public int f = 0;
    public boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    public b j = b.NONE;

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
                a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public m(x.e eVar) {
        this.b = eVar;
    }

    public abstract void a(d dVar);

    public final void b(f fVar, f fVar2, int i) {
        fVar.l.add(fVar2);
        fVar.f = i;
        fVar2.k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.e);
        fVar.h = i;
        fVar.i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        int max;
        if (i2 == 0) {
            x.e eVar = this.b;
            int i3 = eVar.p;
            max = Math.max(eVar.o, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            x.e eVar2 = this.b;
            int i4 = eVar2.s;
            max = Math.max(eVar2.r, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public final f h(x.d dVar) {
        m mVar;
        m mVar2;
        x.d dVar2 = dVar.d;
        if (dVar2 == null) {
            return null;
        }
        x.e eVar = dVar2.b;
        int i = a.a[dVar2.c.ordinal()];
        if (i != 1) {
            if (i == 2) {
                mVar2 = eVar.e;
            } else if (i == 3) {
                mVar = eVar.f;
            } else {
                if (i == 4) {
                    return eVar.f.k;
                }
                if (i != 5) {
                    return null;
                }
                mVar2 = eVar.f;
            }
            return mVar2.i;
        }
        mVar = eVar.e;
        return mVar.h;
    }

    public final f i(x.d dVar, int i) {
        x.d dVar2 = dVar.d;
        if (dVar2 == null) {
            return null;
        }
        x.e eVar = dVar2.b;
        m mVar = i == 0 ? eVar.e : eVar.f;
        int i2 = a.a[dVar2.c.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return mVar.i;
        }
        return mVar.h;
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }

    public final void l(int i, int i2) {
        g gVar;
        int g;
        int i3 = this.a;
        if (i3 == 0) {
            gVar = this.e;
            g = g(i2, i);
        } else if (i3 == 1) {
            int g2 = g(this.e.m, i);
            gVar = this.e;
            g = Math.min(g2, i2);
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                x.e eVar = this.b;
                m mVar = eVar.e;
                e.b bVar = mVar.d;
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && mVar.a == 3) {
                    l lVar = eVar.f;
                    if (lVar.d == bVar2 && lVar.a == 3) {
                        return;
                    }
                }
                if (i == 0) {
                    mVar = eVar.f;
                }
                if (mVar.e.j) {
                    float r = eVar.r();
                    this.e.d(i == 1 ? (int) ((mVar.e.g / r) + 0.5f) : (int) ((r * mVar.e.g) + 0.5f));
                    return;
                }
                return;
            }
            x.e E = this.b.E();
            if (E == null) {
                return;
            }
            if (!(i == 0 ? E.e : E.f).e.j) {
                return;
            }
            x.e eVar2 = this.b;
            i2 = (int) ((r9.g * (i == 0 ? eVar2.q : eVar2.t)) + 0.5f);
            gVar = this.e;
            g = g(i2, i);
        }
        gVar.d(g);
    }

    public abstract boolean m();

    public void n(d dVar, x.d dVar2, x.d dVar3, int i) {
        f fVar;
        f h = h(dVar2);
        f h2 = h(dVar3);
        if (h.j && h2.j) {
            int b2 = h.g + dVar2.b();
            int b3 = h2.g - dVar3.b();
            int i2 = b3 - b2;
            if (!this.e.j && this.d == e.b.MATCH_CONSTRAINT) {
                l(i, i2);
            }
            g gVar = this.e;
            if (gVar.j) {
                if (gVar.g == i2) {
                    this.h.d(b2);
                    fVar = this.i;
                } else {
                    x.e eVar = this.b;
                    float u = i == 0 ? eVar.u() : eVar.I();
                    if (h == h2) {
                        b2 = h.g;
                        b3 = h2.g;
                        u = 0.5f;
                    }
                    this.h.d((int) (b2 + 0.5f + (((b3 - b2) - this.e.g) * u)));
                    fVar = this.i;
                    b3 = this.h.g + this.e.g;
                }
                fVar.d(b3);
            }
        }
    }

    public void o(d dVar) {
    }

    public void p(d dVar) {
    }
}
