package y;

import x.e;
import y.f;
import y.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l extends m {
    public f k;
    public g l;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[m.b.values().length];
            a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(x.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.k = fVar;
        this.l = null;
        this.h.e = f.a.TOP;
        this.i.e = f.a.BOTTOM;
        fVar.e = f.a.BASELINE;
        this.f = 1;
    }

    public void a(d dVar) {
        int i;
        float r;
        int i2 = a.a[this.j.ordinal()];
        if (i2 == 1) {
            p(dVar);
        } else if (i2 == 2) {
            o(dVar);
        } else if (i2 == 3) {
            x.e eVar = this.b;
            n(dVar, eVar.C, eVar.E, 1);
            return;
        }
        g gVar = this.e;
        if (gVar.c && !gVar.j && this.d == e.b.MATCH_CONSTRAINT) {
            x.e eVar2 = this.b;
            int i3 = eVar2.m;
            if (i3 == 2) {
                x.e E = eVar2.E();
                if (E != null) {
                    if (E.f.e.j) {
                        i = (int) ((r7.g * this.b.t) + 0.5f);
                        this.e.d(i);
                    }
                }
            } else if (i3 == 3 && eVar2.e.e.j) {
                int s = eVar2.s();
                if (s == -1) {
                    r = r7.e.e.g / this.b.r();
                    i = (int) (r + 0.5f);
                    this.e.d(i);
                } else if (s != 0) {
                    if (s != 1) {
                        i = 0;
                        this.e.d(i);
                    }
                    r = r7.e.e.g / this.b.r();
                    i = (int) (r + 0.5f);
                    this.e.d(i);
                } else {
                    r = r7.e.e.g * this.b.r();
                    i = (int) (r + 0.5f);
                    this.e.d(i);
                }
            }
        }
        f fVar = this.h;
        if (fVar.c) {
            f fVar2 = this.i;
            if (fVar2.c) {
                if (fVar.j && fVar2.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == e.b.MATCH_CONSTRAINT) {
                    x.e eVar3 = this.b;
                    if (eVar3.l == 0 && !eVar3.V()) {
                        f fVar3 = (f) this.h.l.get(0);
                        f fVar4 = (f) this.i.l.get(0);
                        int i4 = fVar3.g;
                        f fVar5 = this.h;
                        int i5 = i4 + fVar5.f;
                        int i6 = fVar4.g + this.i.f;
                        fVar5.d(i5);
                        this.i.d(i6);
                        this.e.d(i6 - i5);
                        return;
                    }
                }
                if (!this.e.j && this.d == e.b.MATCH_CONSTRAINT && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    f fVar6 = (f) this.h.l.get(0);
                    int i7 = (((f) this.i.l.get(0)).g + this.i.f) - (fVar6.g + this.h.f);
                    g gVar2 = this.e;
                    int i8 = gVar2.m;
                    if (i7 < i8) {
                        gVar2.d(i7);
                    } else {
                        gVar2.d(i8);
                    }
                }
                if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    f fVar7 = (f) this.h.l.get(0);
                    f fVar8 = (f) this.i.l.get(0);
                    int i9 = fVar7.g + this.h.f;
                    int i10 = fVar8.g + this.i.f;
                    float I = this.b.I();
                    if (fVar7 == fVar8) {
                        i9 = fVar7.g;
                        i10 = fVar8.g;
                        I = 0.5f;
                    }
                    this.h.d((int) (i9 + 0.5f + (((i10 - i9) - this.e.g) * I)));
                    this.i.d(this.h.g + this.e.g);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02d9, code lost:
    
        if (r10.b.Q() != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02db, code lost:
    
        r0 = r10.k;
        r1 = r10.h;
        r2 = r10.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x035e, code lost:
    
        if (r10.b.Q() != false) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03d5 A[PHI: r0
      0x03d5: PHI (r0v32 y.j) = (r0v23 y.j), (r0v47 y.j) binds: [B:146:0x03d3, B:121:0x032e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 1022
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y.l.d():void");
    }

    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.b.C0(fVar.g);
        }
    }

    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    public boolean m() {
        return this.d != e.b.MATCH_CONSTRAINT || this.b.m == 0;
    }

    public void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "VerticalRun " + this.b.p();
    }
}
