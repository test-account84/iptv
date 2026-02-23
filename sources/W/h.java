package w;

import java.util.Arrays;
import java.util.Comparator;
import w.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends w.b {
    public int g;
    public i[] h;
    public i[] i;
    public int j;
    public b k;
    public c l;

    public class a implements Comparator {
        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.c - iVar2.c;
        }
    }

    public class b implements Comparable {
        public i a;
        public h c;

        public b(h hVar) {
            this.c = hVar;
        }

        public boolean a(i iVar, float f) {
            boolean z = true;
            if (!this.a.a) {
                for (int i = 0; i < 9; i++) {
                    float f2 = iVar.i[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.a.i[i] = f3;
                    } else {
                        this.a.i[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.a.i;
                float f4 = fArr[i2] + (iVar.i[i2] * f);
                fArr[i2] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.a.i[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                h.E(h.this, this.a);
            }
            return false;
        }

        public void b(i iVar) {
            this.a = iVar;
        }

        public int compareTo(Object obj) {
            return this.a.c - ((i) obj).c;
        }

        public final boolean h() {
            for (int i = 8; i >= 0; i--) {
                float f = this.a.i[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean i(i iVar) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f = iVar.i[i];
                float f2 = this.a.i[i];
                if (f2 == f) {
                    i--;
                } else if (f2 < f) {
                    return true;
                }
            }
            return false;
        }

        public void j() {
            Arrays.fill(this.a.i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.a.i[i] + " ";
                }
            }
            return str + "] " + this.a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.g = 128;
        this.h = new i[128];
        this.i = new i[128];
        this.j = 0;
        this.k = new b(this);
        this.l = cVar;
    }

    public static /* synthetic */ void E(h hVar, i iVar) {
        hVar.G(iVar);
    }

    public void C(w.b bVar, boolean z) {
        i iVar = bVar.a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.e;
        int i = aVar.i();
        for (int i2 = 0; i2 < i; i2++) {
            i b2 = aVar.b(i2);
            float j = aVar.j(i2);
            this.k.b(b2);
            if (this.k.a(iVar, j)) {
                F(b2);
            }
            this.b += bVar.b * j;
        }
        G(iVar);
    }

    public final void F(i iVar) {
        int i;
        int i2 = this.j + 1;
        i[] iVarArr = this.h;
        if (i2 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.h = iVarArr2;
            this.i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.h;
        int i3 = this.j;
        iVarArr3[i3] = iVar;
        int i4 = i3 + 1;
        this.j = i4;
        if (i4 > 1 && iVarArr3[i3].c > iVar.c) {
            int i5 = 0;
            while (true) {
                i = this.j;
                if (i5 >= i) {
                    break;
                }
                this.i[i5] = this.h[i5];
                i5++;
            }
            Arrays.sort(this.i, 0, i, new a());
            for (int i6 = 0; i6 < this.j; i6++) {
                this.h[i6] = this.i[i6];
            }
        }
        iVar.a = true;
        iVar.a(this);
    }

    public final void G(i iVar) {
        int i = 0;
        while (i < this.j) {
            if (this.h[i] == iVar) {
                while (true) {
                    int i2 = this.j;
                    if (i >= i2 - 1) {
                        this.j = i2 - 1;
                        iVar.a = false;
                        return;
                    } else {
                        i[] iVarArr = this.h;
                        int i3 = i + 1;
                        iVarArr[i] = iVarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public w.i a(w.d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = -1
        L3:
            int r2 = r4.j
            if (r0 >= r2) goto L30
            w.i[] r2 = r4.h
            r2 = r2[r0]
            int r3 = r2.c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2d
        L12:
            w.h$b r3 = r4.k
            r3.b(r2)
            w.h$b r2 = r4.k
            if (r1 != r5) goto L22
            boolean r2 = r2.h()
            if (r2 == 0) goto L2d
            goto L2c
        L22:
            w.i[] r3 = r4.h
            r3 = r3[r1]
            boolean r2 = r2.i(r3)
            if (r2 == 0) goto L2d
        L2c:
            r1 = r0
        L2d:
            int r0 = r0 + 1
            goto L3
        L30:
            if (r1 != r5) goto L34
            r5 = 0
            return r5
        L34:
            w.i[] r5 = r4.h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w.h.a(w.d, boolean[]):w.i");
    }

    public void c(i iVar) {
        this.k.b(iVar);
        this.k.j();
        iVar.i[iVar.e] = 1.0f;
        F(iVar);
    }

    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    public String toString() {
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.j; i++) {
            this.k.b(this.h[i]);
            str = str + this.k + " ";
        }
        return str;
    }
}
