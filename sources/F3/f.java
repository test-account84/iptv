package f3;

import d4.M;
import s5.c0;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements a {
    public final y a;
    public final int b;

    public f(int i, y yVar) {
        this.b = i;
        this.a = yVar;
    }

    public static a a(int i, int i2, M m) {
        switch (i) {
            case 1718776947:
                return g.d(i2, m);
            case 1751742049:
                return c.b(m);
            case 1752331379:
                return d.c(m);
            case 1852994675:
                return h.a(m);
            default:
                return null;
        }
    }

    public static f c(int i, M m) {
        y.a aVar = new y.a();
        int g = m.g();
        int i2 = -2;
        while (m.a() > 8) {
            int u = m.u();
            int f = m.f() + m.u();
            m.T(f);
            a c = u == 1414744396 ? c(m.u(), m) : a(u, i2, m);
            if (c != null) {
                if (c.getType() == 1752331379) {
                    i2 = ((d) c).b();
                }
                aVar.h(c);
            }
            m.U(f);
            m.T(g);
        }
        return new f(i, aVar.k());
    }

    public a b(Class cls) {
        c0 l = this.a.l();
        while (l.hasNext()) {
            a aVar = (a) l.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    public int getType() {
        return this.b;
    }
}
