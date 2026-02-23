package s5;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import s5.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f implements J {
    public transient Collection a;
    public transient Set c;
    public transient Collection d;
    public transient Map e;

    public class a extends L.b {
        public a() {
        }

        public J d() {
            return f.this;
        }

        public Iterator iterator() {
            return f.this.i();
        }
    }

    public class b extends AbstractCollection {
        public b() {
        }

        public void clear() {
            f.this.clear();
        }

        public boolean contains(Object obj) {
            return f.this.d(obj);
        }

        public Iterator iterator() {
            return f.this.j();
        }

        public int size() {
            return f.this.size();
        }
    }

    public Collection a() {
        Collection collection = this.a;
        if (collection != null) {
            return collection;
        }
        Collection f = f();
        this.a = f;
        return f;
    }

    public Map b() {
        Map map = this.e;
        if (map != null) {
            return map;
        }
        Map e = e();
        this.e = e;
        return e;
    }

    public boolean c(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean d(Object obj) {
        Iterator it = b().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map e();

    public boolean equals(Object obj) {
        return L.a(this, obj);
    }

    public abstract Collection f();

    public abstract Set g();

    public abstract Collection h();

    public int hashCode() {
        return b().hashCode();
    }

    public abstract Iterator i();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract Iterator j();

    public Set keySet() {
        Set set = this.c;
        if (set != null) {
            return set;
        }
        Set g = g();
        this.c = g;
        return g;
    }

    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return b().toString();
    }

    public Collection values() {
        Collection collection = this.d;
        if (collection != null) {
            return collection;
        }
        Collection h = h();
        this.d = h;
        return h;
    }
}
