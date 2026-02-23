package F1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v1.f;
import v1.k;
import v1.m;
import v1.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements o {
    public final f.b a;
    public final K1.d b;
    public final Map c = new LinkedHashMap();

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.b.values().length];
            a = iArr;
            try {
                iArr[k.b.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.b.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b {
        public final k a;
        public final Object b;

        public b(k kVar, Object obj) {
            this.a = kVar;
            this.b = obj;
        }
    }

    public static final class c implements o.a {
        public final f.b a;
        public final K1.d b;
        public Object c;

        public c(f.b bVar, K1.d dVar) {
            this.a = bVar;
            this.b = dVar;
        }

        public void a(m mVar) {
            b bVar = new b(this.a, this.b);
            mVar.marshal(bVar);
            this.c = bVar.c;
        }
    }

    public b(f.b bVar, K1.d dVar) {
        this.a = bVar;
        this.b = dVar;
    }

    public static void e(k kVar, Object obj) {
        if (!kVar.i() && obj == null) {
            throw new NullPointerException(String.format("Mandatory response field `%s` resolved with null value", new Object[]{kVar.k()}));
        }
    }

    public void a(k kVar, List list, o.b bVar) {
        e(kVar, list);
        if (list == null) {
            this.c.put(kVar.k(), new b(kVar, null));
        } else {
            this.c.put(kVar.k(), new b(kVar, l(list, bVar)));
        }
    }

    public void b(k kVar, String str) {
        m(kVar, str);
    }

    public void c(k.a aVar, Object obj) {
        m(aVar, obj != null ? this.b.a(aVar.m()).encode(obj) : null);
    }

    public void d(k kVar, m mVar) {
        e(kVar, mVar);
        if (mVar == null) {
            this.c.put(kVar.k(), new b(kVar, null));
            return;
        }
        b bVar = new b(this.a, this.b);
        mVar.marshal(bVar);
        this.c.put(kVar.k(), new b(kVar, bVar.c));
    }

    public Collection f(h hVar) {
        g(this.a, hVar, this.c);
        return hVar.m();
    }

    public final void g(f.b bVar, h hVar, Map map) {
        Map j = j(map);
        for (String str : map.keySet()) {
            b bVar2 = (b) map.get(str);
            Object obj = j.get(str);
            hVar.h(bVar2.a, bVar);
            int i = a.a[bVar2.a.l().ordinal()];
            if (i == 1) {
                i(bVar2, (Map) obj, hVar);
            } else if (i == 2) {
                h(bVar2.a, (List) bVar2.b, (List) obj, hVar);
            } else if (obj == null) {
                hVar.g();
            } else {
                hVar.c(obj);
            }
            hVar.i(bVar2.a, bVar);
        }
    }

    public final void h(k kVar, List list, List list2, h hVar) {
        if (list == null) {
            hVar.g();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            hVar.f(i);
            Object obj = list.get(i);
            if (obj instanceof Map) {
                hVar.b(kVar, x1.d.d((Map) list2.get(i)));
                g(this.a, hVar, (Map) obj);
                hVar.d(kVar, x1.d.d((Map) list2.get(i)));
            } else if (obj instanceof List) {
                h(kVar, (List) obj, (List) list2.get(i), hVar);
            } else {
                hVar.c(list2.get(i));
            }
            hVar.e(i);
        }
        hVar.a(list2);
    }

    public final void i(b bVar, Map map, h hVar) {
        hVar.b(bVar.a, x1.d.d(map));
        Object obj = bVar.b;
        if (obj == null) {
            hVar.g();
        } else {
            g(this.a, hVar, (Map) obj);
        }
        hVar.d(bVar.a, x1.d.d(map));
    }

    public final Map j(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object obj = ((b) entry.getValue()).b;
            if (obj == null) {
                obj = null;
            } else if (obj instanceof Map) {
                obj = j((Map) obj);
            } else if (obj instanceof List) {
                obj = k((List) obj);
            }
            linkedHashMap.put(str, obj);
        }
        return linkedHashMap;
    }

    public final List k(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Map) {
                obj = j((Map) obj);
            } else if (obj instanceof List) {
                obj = k((List) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final List l(List list, o.b bVar) {
        Object obj;
        c cVar = new c(this.a, this.b);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof List) {
                obj = l((List) obj2, bVar);
            } else {
                bVar.write(obj2, cVar);
                obj = cVar.c;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final void m(k kVar, Object obj) {
        e(kVar, obj);
        this.c.put(kVar.k(), new b(kVar, obj));
    }
}
