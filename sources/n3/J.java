package n3;

import O2.z0;
import android.util.SparseArray;
import d4.M;
import java.util.ArrayList;
import java.util.List;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j implements I.c {
    public final int a;
    public final List b;

    public j(int i) {
        this(i, s5.y.z());
    }

    public SparseArray a() {
        return new SparseArray();
    }

    public I b(int i, I.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new w(new t(bVar.b));
            }
            if (i == 21) {
                return new w(new r());
            }
            if (i == 27) {
                if (f(4)) {
                    return null;
                }
                return new w(new p(c(bVar), f(1), f(8)));
            }
            if (i == 36) {
                return new w(new q(c(bVar)));
            }
            if (i == 89) {
                return new w(new l(bVar.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new w(new f(bVar.b));
                }
                if (i == 257) {
                    return new C(new v("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (f(16)) {
                        return null;
                    }
                    return new C(new v("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (!f(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case 17:
                            if (!f(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 130:
                                    if (!f(64)) {
                                    }
                                    break;
                            }
                    }
                    return null;
                }
                return new w(new c(bVar.b));
            }
            return new w(new k(bVar.b));
        }
        return new w(new n(d(bVar)));
    }

    public final D c(I.b bVar) {
        return new D(e(bVar));
    }

    public final K d(I.b bVar) {
        return new K(e(bVar));
    }

    public final List e(I.b bVar) {
        String str;
        int i;
        if (f(32)) {
            return this.b;
        }
        M m = new M(bVar.d);
        ArrayList arrayList = this.b;
        while (m.a() > 0) {
            int H = m.H();
            int f = m.f() + m.H();
            if (H == 134) {
                arrayList = new ArrayList();
                int H2 = m.H() & 31;
                for (int i2 = 0; i2 < H2; i2++) {
                    String E = m.E(3);
                    int H3 = m.H();
                    boolean z = (H3 & 128) != 0;
                    if (z) {
                        i = H3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte H4 = (byte) m.H();
                    m.V(1);
                    arrayList.add(new z0.b().g0(str).X(E).H(i).V(z ? d4.f.b((H4 & 64) != 0) : null).G());
                }
            }
            m.U(f);
        }
        return arrayList;
    }

    public final boolean f(int i) {
        return (i & this.a) != 0;
    }

    public j(int i, List list) {
        this.a = i;
        this.b = list;
    }
}
