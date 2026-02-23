package h3;

import d3.h;
import d4.M;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends e {
    public long b;
    public long[] c;
    public long[] d;

    public d() {
        super(new h());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    public static Boolean g(M m) {
        return Boolean.valueOf(m.H() == 1);
    }

    public static Object h(M m, int i) {
        if (i == 0) {
            return j(m);
        }
        if (i == 1) {
            return g(m);
        }
        if (i == 2) {
            return n(m);
        }
        if (i == 3) {
            return l(m);
        }
        if (i == 8) {
            return k(m);
        }
        if (i == 10) {
            return m(m);
        }
        if (i != 11) {
            return null;
        }
        return i(m);
    }

    public static Date i(M m) {
        Date date = new Date((long) j(m).doubleValue());
        m.V(2);
        return date;
    }

    public static Double j(M m) {
        return Double.valueOf(Double.longBitsToDouble(m.A()));
    }

    public static HashMap k(M m) {
        int L = m.L();
        HashMap hashMap = new HashMap(L);
        for (int i = 0; i < L; i++) {
            String n = n(m);
            Object h = h(m, o(m));
            if (h != null) {
                hashMap.put(n, h);
            }
        }
        return hashMap;
    }

    public static HashMap l(M m) {
        HashMap hashMap = new HashMap();
        while (true) {
            String n = n(m);
            int o = o(m);
            if (o == 9) {
                return hashMap;
            }
            Object h = h(m, o);
            if (h != null) {
                hashMap.put(n, h);
            }
        }
    }

    public static ArrayList m(M m) {
        int L = m.L();
        ArrayList arrayList = new ArrayList(L);
        for (int i = 0; i < L; i++) {
            Object h = h(m, o(m));
            if (h != null) {
                arrayList.add(h);
            }
        }
        return arrayList;
    }

    public static String n(M m) {
        int N = m.N();
        int f = m.f();
        m.V(N);
        return new String(m.e(), f, N);
    }

    public static int o(M m) {
        return m.H();
    }

    public boolean b(M m) {
        return true;
    }

    public boolean c(M m, long j) {
        if (o(m) != 2 || !"onMetaData".equals(n(m)) || m.a() == 0 || o(m) != 8) {
            return false;
        }
        HashMap k = k(m);
        Object obj = k.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = k.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.b;
    }

    public long[] e() {
        return this.d;
    }

    public long[] f() {
        return this.c;
    }
}
