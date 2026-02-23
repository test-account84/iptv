package l3;

import O2.l1;
import d3.t;
import d4.M;
import java.util.ArrayList;
import java.util.List;
import w3.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m {
    public static final r5.p d = r5.p.d(':');
    public static final r5.p e = r5.p.d('*');
    public final List a = new ArrayList();
    public int b = 0;
    public int c;

    public static final class a {
        public final int a;
        public final long b;
        public final int c;

        public a(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    public static int b(String str) {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw l1.a("Invalid SEF name", null);
        }
    }

    public static w3.c f(M m, int i) {
        ArrayList arrayList = new ArrayList();
        List f = e.f(m.E(i));
        for (int i2 = 0; i2 < f.size(); i2++) {
            List f2 = d.f((CharSequence) f.get(i2));
            if (f2.size() != 3) {
                throw l1.a(null, null);
            }
            try {
                arrayList.add(new c.b(Long.parseLong((String) f2.get(0)), Long.parseLong((String) f2.get(1)), 1 << (Integer.parseInt((String) f2.get(2)) - 1)));
            } catch (NumberFormatException e2) {
                throw l1.a(null, e2);
            }
        }
        return new w3.c(arrayList);
    }

    public final void a(d3.j jVar, t tVar) {
        M m = new M(8);
        jVar.m(m.e(), 0, 8);
        this.c = m.u() + 8;
        if (m.q() != 1397048916) {
            tVar.a = 0L;
        } else {
            tVar.a = jVar.getPosition() - (this.c - 12);
            this.b = 2;
        }
    }

    public int c(d3.j jVar, t tVar, List list) {
        int i = this.b;
        long j = 0;
        if (i == 0) {
            long length = jVar.getLength();
            if (length != -1 && length >= 8) {
                j = length - 8;
            }
            tVar.a = j;
            this.b = 1;
        } else if (i == 1) {
            a(jVar, tVar);
        } else if (i == 2) {
            d(jVar, tVar);
        } else {
            if (i != 3) {
                throw new IllegalStateException();
            }
            e(jVar, list);
            tVar.a = 0L;
        }
        return 1;
    }

    public final void d(d3.j jVar, t tVar) {
        long j;
        long length = jVar.getLength();
        int i = this.c - 20;
        M m = new M(i);
        jVar.m(m.e(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            m.V(2);
            short w = m.w();
            if (w == 2192 || w == 2816 || w == 2817 || w == 2819 || w == 2820) {
                this.a.add(new a(w, (length - this.c) - m.u(), m.u()));
            } else {
                m.V(8);
            }
        }
        if (this.a.isEmpty()) {
            j = 0;
        } else {
            this.b = 3;
            j = ((a) this.a.get(0)).b;
        }
        tVar.a = j;
    }

    public final void e(d3.j jVar, List list) {
        long position = jVar.getPosition();
        int length = (int) ((jVar.getLength() - jVar.getPosition()) - this.c);
        M m = new M(length);
        jVar.m(m.e(), 0, length);
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = (a) this.a.get(i);
            m.U((int) (aVar.b - position));
            m.V(4);
            int u = m.u();
            int b = b(m.E(u));
            int i2 = aVar.c - (u + 8);
            if (b == 2192) {
                list.add(f(m, i2));
            } else if (b != 2816 && b != 2817 && b != 2819 && b != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.a.clear();
        this.b = 0;
    }
}
