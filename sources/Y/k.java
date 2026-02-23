package y;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k {
    public static int h;
    public m c;
    public m d;
    public int f;
    public int g;
    public int a = 0;
    public boolean b = false;
    public ArrayList e = new ArrayList();

    public k(m mVar, int i) {
        this.c = null;
        this.d = null;
        int i2 = h;
        this.f = i2;
        h = i2 + 1;
        this.c = mVar;
        this.d = mVar;
        this.g = i;
    }

    public void a(m mVar) {
        this.e.add(mVar);
        this.d = mVar;
    }

    public long b(x.f fVar, int i) {
        long j;
        m mVar;
        long j2;
        long j3;
        m mVar2 = this.c;
        if (mVar2 instanceof c) {
            if (((c) mVar2).f != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(mVar2 instanceof j)) {
                return 0L;
            }
        } else if (!(mVar2 instanceof l)) {
            return 0L;
        }
        f fVar2 = (i == 0 ? fVar.e : fVar.f).h;
        f fVar3 = (i == 0 ? fVar.e : fVar.f).i;
        boolean contains = mVar2.h.l.contains(fVar2);
        boolean contains2 = this.c.i.l.contains(fVar3);
        long j4 = this.c.j();
        if (!contains || !contains2) {
            if (contains) {
                j3 = d(this.c.h, r13.f);
                j2 = this.c.h.f + j4;
            } else if (contains2) {
                j2 = (-this.c.i.f) + j4;
                j3 = -c(this.c.i, r13.f);
            } else {
                j = r13.h.f + this.c.j();
                mVar = this.c;
            }
            return Math.max(j3, j2);
        }
        long d = d(this.c.h, 0L);
        long c = c(this.c.i, 0L);
        long j5 = d - j4;
        m mVar3 = this.c;
        int i2 = mVar3.i.f;
        if (j5 >= (-i2)) {
            j5 += i2;
        }
        int i3 = mVar3.h.f;
        long j6 = ((-c) - j4) - i3;
        if (j6 >= i3) {
            j6 -= i3;
        }
        float m = mVar3.b.m(i);
        float f = m > 0.0f ? (long) ((j6 / m) + (j5 / (1.0f - m))) : 0L;
        long j7 = ((long) ((f * m) + 0.5f)) + j4 + ((long) ((f * (1.0f - m)) + 0.5f));
        mVar = this.c;
        j = mVar.h.f + j7;
        return j - mVar.i.f;
    }

    public final long c(f fVar, long j) {
        m mVar = fVar.d;
        if (mVar instanceof i) {
            return j;
        }
        int size = fVar.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            d dVar = (d) fVar.k.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != mVar) {
                    j2 = Math.min(j2, c(fVar2, fVar2.f + j));
                }
            }
        }
        if (fVar != mVar.i) {
            return j2;
        }
        long j3 = j - mVar.j();
        return Math.min(Math.min(j2, c(mVar.h, j3)), j3 - mVar.h.f);
    }

    public final long d(f fVar, long j) {
        m mVar = fVar.d;
        if (mVar instanceof i) {
            return j;
        }
        int size = fVar.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            d dVar = (d) fVar.k.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != mVar) {
                    j2 = Math.max(j2, d(fVar2, fVar2.f + j));
                }
            }
        }
        if (fVar != mVar.h) {
            return j2;
        }
        long j3 = j + mVar.j();
        return Math.max(Math.max(j2, d(mVar.i, j3)), j3 - mVar.i.f);
    }
}
