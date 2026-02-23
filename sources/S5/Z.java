package s5;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import s5.A;
import s5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class z extends B implements F {

    public static final class a extends B.c {
        public z d() {
            return (z) super.a();
        }

        public a e(Object obj, Object obj2) {
            super.c(obj, obj2);
            return this;
        }
    }

    public z(A a2, int i) {
        super(a2, i);
    }

    public static z s(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return u();
        }
        A.a aVar = new A.a(collection.size());
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            y r = comparator == null ? y.r(collection2) : y.F(comparator, collection2);
            if (!r.isEmpty()) {
                aVar.f(key, r);
                i += r.size();
            }
        }
        return new z(aVar.c(), i);
    }

    public static z u() {
        return r.h;
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public y get(Object obj) {
        y yVar = (y) this.f.get(obj);
        return yVar == null ? y.z() : yVar;
    }
}
