package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class s {
    public static final s d = new s(true);
    public final h0 a;
    public boolean b;
    public boolean c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[r0.b.values().length];
            b = iArr;
            try {
                iArr[r0.b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[r0.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[r0.b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[r0.b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[r0.b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[r0.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[r0.b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[r0.b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[r0.b.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[r0.b.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[r0.b.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[r0.b.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[r0.b.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[r0.b.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[r0.b.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[r0.b.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[r0.b.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[r0.b.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[r0.c.values().length];
            a = iArr2;
            try {
                iArr2[r0.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[r0.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[r0.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[r0.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[r0.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[r0.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[r0.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[r0.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[r0.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public interface b extends Comparable {
        int getNumber();

        boolean isPacked();

        boolean k();

        r0.b m();
    }

    public s() {
        this.a = h0.s(16);
    }

    public static int b(r0.b bVar, int i, Object obj) {
        int P = j.P(i);
        if (bVar == r0.b.GROUP) {
            P *= 2;
        }
        return P + c(bVar, obj);
    }

    public static int c(r0.b bVar, Object obj) {
        switch (a.b[bVar.ordinal()]) {
            case 1:
                return j.i(((Double) obj).doubleValue());
            case 2:
                return j.q(((Float) obj).floatValue());
            case 3:
                return j.x(((Long) obj).longValue());
            case 4:
                return j.T(((Long) obj).longValue());
            case 5:
                return j.v(((Integer) obj).intValue());
            case 6:
                return j.o(((Long) obj).longValue());
            case 7:
                return j.m(((Integer) obj).intValue());
            case 8:
                return j.d(((Boolean) obj).booleanValue());
            case 9:
                return j.s((O) obj);
            case 10:
                return j.A((O) obj);
            case 11:
                return obj instanceof g ? j.g((g) obj) : j.O((String) obj);
            case 12:
                return obj instanceof g ? j.g((g) obj) : j.e((byte[]) obj);
            case 13:
                return j.R(((Integer) obj).intValue());
            case 14:
                return j.G(((Integer) obj).intValue());
            case 15:
                return j.I(((Long) obj).longValue());
            case 16:
                return j.K(((Integer) obj).intValue());
            case 17:
                return j.M(((Long) obj).longValue());
            case 18:
                return j.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        r0.b m = bVar.m();
        int number = bVar.getNumber();
        if (!bVar.k()) {
            return b(m, number, obj);
        }
        int i = 0;
        List list = (List) obj;
        if (bVar.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i += c(m, it.next());
            }
            return j.P(number) + i + j.E(i);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i += b(m, number, it2.next());
        }
        return i;
    }

    public static int i(r0.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.getWireType();
    }

    public static boolean l(Map.Entry entry) {
        d.D.a(entry.getKey());
        throw null;
    }

    public static boolean m(r0.b bVar, Object obj) {
        y.a(obj);
        switch (a.a[bVar.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof g) || (obj instanceof byte[]);
            case 8:
                return obj instanceof Integer;
            case 9:
                return obj instanceof O;
            default:
                return false;
        }
    }

    public static s r() {
        return new s();
    }

    public static void u(j jVar, r0.b bVar, int i, Object obj) {
        if (bVar == r0.b.GROUP) {
            jVar.r0(i, (O) obj);
        } else {
            jVar.N0(i, i(bVar, false));
            v(jVar, bVar, obj);
        }
    }

    public static void v(j jVar, r0.b bVar, Object obj) {
        switch (a.b[bVar.ordinal()]) {
            case 1:
                jVar.i0(((Double) obj).doubleValue());
                return;
            case 2:
                jVar.q0(((Float) obj).floatValue());
                return;
            case 3:
                jVar.y0(((Long) obj).longValue());
                return;
            case 4:
                jVar.R0(((Long) obj).longValue());
                return;
            case 5:
                jVar.w0(((Integer) obj).intValue());
                return;
            case 6:
                jVar.o0(((Long) obj).longValue());
                return;
            case 7:
                jVar.m0(((Integer) obj).intValue());
                return;
            case 8:
                jVar.c0(((Boolean) obj).booleanValue());
                return;
            case 9:
                jVar.t0((O) obj);
                return;
            case 10:
                jVar.A0((O) obj);
                return;
            case 11:
                if (!(obj instanceof g)) {
                    jVar.M0((String) obj);
                    return;
                }
                break;
            case 12:
                if (!(obj instanceof g)) {
                    jVar.d0((byte[]) obj);
                    return;
                }
                break;
            case 13:
                jVar.P0(((Integer) obj).intValue());
                return;
            case 14:
                jVar.E0(((Integer) obj).intValue());
                return;
            case 15:
                jVar.G0(((Long) obj).longValue());
                return;
            case 16:
                jVar.I0(((Integer) obj).intValue());
                return;
            case 17:
                jVar.K0(((Long) obj).longValue());
                return;
            case 18:
                jVar.k0(((Integer) obj).intValue());
                return;
            default:
                return;
        }
        jVar.g0((g) obj);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public s clone() {
        s r = r();
        for (int i = 0; i < this.a.m(); i++) {
            Map.Entry k = this.a.k(i);
            d.D.a(k.getKey());
            r.s(null, k.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            d.D.a(entry.getKey());
            r.s(null, entry.getValue());
        }
        r.c = this.c;
        return r;
    }

    public Iterator e() {
        return this.c ? new B(this.a.i().iterator()) : this.a.i().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return this.a.equals(((s) obj).a);
        }
        return false;
    }

    public int f() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.m(); i2++) {
            i += g(this.a.k(i2));
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            i += g((Map.Entry) it.next());
        }
        return i;
    }

    public final int g(Map.Entry entry) {
        d.D.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public int h() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.m(); i2++) {
            Map.Entry k = this.a.k(i2);
            d.D.a(k.getKey());
            i += d(null, k.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            d.D.a(entry.getKey());
            i += d(null, entry.getValue());
        }
        return i;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean j() {
        return this.a.isEmpty();
    }

    public boolean k() {
        for (int i = 0; i < this.a.m(); i++) {
            if (!l(this.a.k(i))) {
                return false;
            }
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        return this.c ? new B(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public void o() {
        if (this.b) {
            return;
        }
        this.a.r();
        this.b = true;
    }

    public void p(s sVar) {
        for (int i = 0; i < sVar.a.m(); i++) {
            q(sVar.a.k(i));
        }
        Iterator it = sVar.a.o().iterator();
        while (it.hasNext()) {
            q((Map.Entry) it.next());
        }
    }

    public final void q(Map.Entry entry) {
        d.D.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public void s(b bVar, Object obj) {
        if (!bVar.k()) {
            t(bVar.m(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t(bVar.m(), it.next());
            }
            obj = arrayList;
        }
        this.a.t(bVar, obj);
    }

    public final void t(r0.b bVar, Object obj) {
        if (!m(bVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public s(h0 h0Var) {
        this.a = h0Var;
        o();
    }

    public s(boolean z) {
        this(h0.s(0));
        o();
    }
}
