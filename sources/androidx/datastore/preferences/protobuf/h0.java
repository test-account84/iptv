package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h0 extends AbstractMap {
    public final int a;
    public List c;
    public Map d;
    public boolean e;
    public volatile g f;
    public Map g;
    public volatile c h;

    public static class a extends h0 {
        public a(int i) {
            super(i, null);
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            d.D.a(obj);
            return super.t(null, obj2);
        }

        public void r() {
            if (!q()) {
                if (m() > 0) {
                    d.D.a(k(0).getKey());
                    throw null;
                }
                Iterator it = o().iterator();
                if (it.hasNext()) {
                    d.D.a(((Map.Entry) it.next()).getKey());
                    throw null;
                }
            }
            super.r();
        }
    }

    public class b implements Iterator {
        public int a;
        public Iterator c;

        public b() {
            this.a = h0.c(h0.this).size();
        }

        public final Iterator b() {
            if (this.c == null) {
                this.c = h0.f(h0.this).entrySet().iterator();
            }
            return this.c;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Object obj;
            if (b().hasNext()) {
                obj = b().next();
            } else {
                List c = h0.c(h0.this);
                int i = this.a - 1;
                this.a = i;
                obj = c.get(i);
            }
            return (Map.Entry) obj;
        }

        public boolean hasNext() {
            int i = this.a;
            return (i > 0 && i <= h0.c(h0.this).size()) || b().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(h0 h0Var, a aVar) {
            this();
        }
    }

    public class c extends g {
        public c() {
            super(h0.this, null);
        }

        public Iterator iterator() {
            return new b(h0.this, null);
        }

        public /* synthetic */ c(h0 h0Var, a aVar) {
            this();
        }
    }

    public static class d {
        public static final Iterator a = new a();
        public static final Iterable b = new b();

        public static class a implements Iterator {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static class b implements Iterable {
            public Iterator iterator() {
                return d.a();
            }
        }

        public static /* synthetic */ Iterator a() {
            return a;
        }

        public static Iterable b() {
            return b;
        }
    }

    public class e implements Map.Entry, Comparable {
        public final Comparable a;
        public Object c;

        public e(Comparable comparable, Object obj) {
            this.a = comparable;
            this.c = obj;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.a, entry.getKey()) && b(this.c, entry.getValue());
        }

        public Object getValue() {
            return this.c;
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.a;
        }

        public int hashCode() {
            Comparable comparable = this.a;
            int hashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.c;
            return hashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        public Object setValue(Object obj) {
            h0.a(h0.this);
            Object obj2 = this.c;
            this.c = obj;
            return obj2;
        }

        public String toString() {
            return this.a + "=" + this.c;
        }

        public e(h0 h0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }
    }

    public class f implements Iterator {
        public int a;
        public boolean c;
        public Iterator d;

        public f() {
            this.a = -1;
        }

        public final Iterator b() {
            if (this.d == null) {
                this.d = h0.d(h0.this).entrySet().iterator();
            }
            return this.d;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.c = true;
            int i = this.a + 1;
            this.a = i;
            return (Map.Entry) (i < h0.c(h0.this).size() ? h0.c(h0.this).get(this.a) : b().next());
        }

        public boolean hasNext() {
            if (this.a + 1 >= h0.c(h0.this).size()) {
                return !h0.d(h0.this).isEmpty() && b().hasNext();
            }
            return true;
        }

        public void remove() {
            if (!this.c) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.c = false;
            h0.a(h0.this);
            if (this.a >= h0.c(h0.this).size()) {
                b().remove();
                return;
            }
            h0 h0Var = h0.this;
            int i = this.a;
            this.a = i - 1;
            h0.e(h0Var, i);
        }

        public /* synthetic */ f(h0 h0Var, a aVar) {
            this();
        }
    }

    public class g extends AbstractSet {
        public g() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            h0.this.t((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            h0.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = h0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator iterator() {
            return new f(h0.this, null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            h0.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return h0.this.size();
        }

        public /* synthetic */ g(h0 h0Var, a aVar) {
            this();
        }
    }

    public h0(int i) {
        this.a = i;
        this.c = Collections.emptyList();
        this.d = Collections.emptyMap();
        this.g = Collections.emptyMap();
    }

    public static /* synthetic */ void a(h0 h0Var) {
        h0Var.h();
    }

    public static /* synthetic */ List c(h0 h0Var) {
        return h0Var.c;
    }

    public static /* synthetic */ Map d(h0 h0Var) {
        return h0Var.d;
    }

    public static /* synthetic */ Object e(h0 h0Var, int i) {
        return h0Var.u(i);
    }

    public static /* synthetic */ Map f(h0 h0Var) {
        return h0Var.g;
    }

    public static h0 s(int i) {
        return new a(i);
    }

    public void clear() {
        h();
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
        if (this.d.isEmpty()) {
            return;
        }
        this.d.clear();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.d.containsKey(comparable);
    }

    public Set entrySet() {
        if (this.f == null) {
            this.f = new g(this, null);
        }
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return super.equals(obj);
        }
        h0 h0Var = (h0) obj;
        int size = size();
        if (size != h0Var.size()) {
            return false;
        }
        int m = m();
        if (m != h0Var.m()) {
            return entrySet().equals(h0Var.entrySet());
        }
        for (int i = 0; i < m; i++) {
            if (!k(i).equals(h0Var.k(i))) {
                return false;
            }
        }
        if (m != size) {
            return this.d.equals(h0Var.d);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int g(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.c
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.c
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.h0$e r2 = (androidx.datastore.preferences.protobuf.h0.e) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r5 = -r0
            return r5
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.c
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.h0$e r3 = (androidx.datastore.preferences.protobuf.h0.e) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h0.g(java.lang.Comparable):int");
    }

    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int g2 = g(comparable);
        return g2 >= 0 ? ((e) this.c.get(g2)).getValue() : this.d.get(comparable);
    }

    public final void h() {
        if (this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public int hashCode() {
        int m = m();
        int i = 0;
        for (int i2 = 0; i2 < m; i2++) {
            i += ((e) this.c.get(i2)).hashCode();
        }
        return n() > 0 ? i + this.d.hashCode() : i;
    }

    public Set i() {
        if (this.h == null) {
            this.h = new c(this, null);
        }
        return this.h;
    }

    public final void j() {
        h();
        if (!this.c.isEmpty() || (this.c instanceof ArrayList)) {
            return;
        }
        this.c = new ArrayList(this.a);
    }

    public Map.Entry k(int i) {
        return (Map.Entry) this.c.get(i);
    }

    public int m() {
        return this.c.size();
    }

    public int n() {
        return this.d.size();
    }

    public Iterable o() {
        return this.d.isEmpty() ? d.b() : this.d.entrySet();
    }

    public final SortedMap p() {
        h();
        if (this.d.isEmpty() && !(this.d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.d = treeMap;
            this.g = treeMap.descendingMap();
        }
        return this.d;
    }

    public boolean q() {
        return this.e;
    }

    public void r() {
        if (this.e) {
            return;
        }
        this.d = this.d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.d);
        this.g = this.g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.g);
        this.e = true;
    }

    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int g2 = g(comparable);
        if (g2 >= 0) {
            return u(g2);
        }
        if (this.d.isEmpty()) {
            return null;
        }
        return this.d.remove(comparable);
    }

    public int size() {
        return this.c.size() + this.d.size();
    }

    public Object t(Comparable comparable, Object obj) {
        h();
        int g2 = g(comparable);
        if (g2 >= 0) {
            return ((e) this.c.get(g2)).setValue(obj);
        }
        j();
        int i = -(g2 + 1);
        if (i >= this.a) {
            return p().put(comparable, obj);
        }
        int size = this.c.size();
        int i2 = this.a;
        if (size == i2) {
            e eVar = (e) this.c.remove(i2 - 1);
            p().put(eVar.getKey(), eVar.getValue());
        }
        this.c.add(i, new e(comparable, obj));
        return null;
    }

    public final Object u(int i) {
        h();
        Object value = ((e) this.c.remove(i)).getValue();
        if (!this.d.isEmpty()) {
            Iterator it = p().entrySet().iterator();
            this.c.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public /* synthetic */ h0(int i, a aVar) {
        this(i);
    }
}
