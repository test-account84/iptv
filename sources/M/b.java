package m;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements Iterable {
    public c a;
    public c c;
    public WeakHashMap d = new WeakHashMap();
    public int e = 0;

    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        public c b(c cVar) {
            return cVar.e;
        }

        public c c(c cVar) {
            return cVar.d;
        }
    }

    public static class b extends e {
        public b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        public c b(c cVar) {
            return cVar.d;
        }

        public c c(c cVar) {
            return cVar.e;
        }
    }

    public static class c implements Map.Entry {
        public final Object a;
        public final Object c;
        public c d;
        public c e;

        public c(Object obj, Object obj2) {
            this.a = obj;
            this.c = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.c.equals(cVar.c);
        }

        public Object getKey() {
            return this.a;
        }

        public Object getValue() {
            return this.c;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.c.hashCode();
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + "=" + this.c;
        }
    }

    public class d implements Iterator, f {
        public c a;
        public boolean c = true;

        public d() {
        }

        public void a(c cVar) {
            c cVar2 = this.a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.e;
                this.a = cVar3;
                this.c = cVar3 == null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar;
            if (this.c) {
                this.c = false;
                cVar = b.this.a;
            } else {
                c cVar2 = this.a;
                cVar = cVar2 != null ? cVar2.d : null;
            }
            this.a = cVar;
            return this.a;
        }

        public boolean hasNext() {
            if (this.c) {
                return b.this.a != null;
            }
            c cVar = this.a;
            return (cVar == null || cVar.d == null) ? false : true;
        }
    }

    public static abstract class e implements Iterator, f {
        public c a;
        public c c;

        public e(c cVar, c cVar2) {
            this.a = cVar2;
            this.c = cVar;
        }

        public void a(c cVar) {
            if (this.a == cVar && cVar == this.c) {
                this.c = null;
                this.a = null;
            }
            c cVar2 = this.a;
            if (cVar2 == cVar) {
                this.a = b(cVar2);
            }
            if (this.c == cVar) {
                this.c = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.c;
            this.c = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.c;
            c cVar2 = this.a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        public boolean hasNext() {
            return this.c != null;
        }
    }

    public interface f {
        void a(c cVar);
    }

    public Map.Entry d() {
        return this.a;
    }

    public Iterator descendingIterator() {
        b bVar = new b(this.c, this.a);
        this.d.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public c e(Object obj) {
        c cVar = this.a;
        while (cVar != null && !cVar.a.equals(obj)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public d f() {
        d dVar = new d();
        this.d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry g() {
        return this.c;
    }

    public c h(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.e++;
        c cVar2 = this.c;
        if (cVar2 == null) {
            this.a = cVar;
        } else {
            cVar2.d = cVar;
            cVar.e = cVar2;
        }
        this.c = cVar;
        return cVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public Object i(Object obj, Object obj2) {
        c e2 = e(obj);
        if (e2 != null) {
            return e2.c;
        }
        h(obj, obj2);
        return null;
    }

    public Iterator iterator() {
        a aVar = new a(this.a, this.c);
        this.d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Object j(Object obj) {
        c e2 = e(obj);
        if (e2 == null) {
            return null;
        }
        this.e--;
        if (!this.d.isEmpty()) {
            Iterator it = this.d.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(e2);
            }
        }
        c cVar = e2.e;
        c cVar2 = e2.d;
        if (cVar != null) {
            cVar.d = cVar2;
        } else {
            this.a = cVar2;
        }
        c cVar3 = e2.d;
        if (cVar3 != null) {
            cVar3.e = cVar;
        } else {
            this.c = cVar;
        }
        e2.d = null;
        e2.e = null;
        return e2.c;
    }

    public int size() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
