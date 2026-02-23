package s5;

import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import s5.I;
import s5.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d extends s5.f implements Serializable {
    public transient Map f;
    public transient int g;

    public class b extends d {
        public b(d dVar) {
            super();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj, Object obj2) {
            return I.d(obj, obj2);
        }
    }

    public class c extends I.f {
        public final transient Map d;

        public class a extends I.c {
            public a() {
            }

            public boolean contains(Object obj) {
                return m.c(c.this.d.entrySet(), obj);
            }

            public Map d() {
                return c.this;
            }

            public Iterator iterator() {
                return c.this.new b();
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                d.q(d.this, entry.getKey());
                return true;
            }
        }

        public class b implements Iterator {
            public final Iterator a;
            public Collection c;

            public b() {
                this.a = c.this.d.entrySet().iterator();
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.c = (Collection) entry.getValue();
                return c.this.f(entry);
            }

            public boolean hasNext() {
                return this.a.hasNext();
            }

            public void remove() {
                r5.m.q(this.c != null, "no calls to next() since the last call to remove()");
                this.a.remove();
                d.p(d.this, this.c.size());
                this.c.clear();
                this.c = null;
            }
        }

        public c(Map map) {
            this.d = map;
        }

        public Set a() {
            return new a();
        }

        public void clear() {
            if (this.d == d.k(d.this)) {
                d.this.clear();
            } else {
                E.c(new b());
            }
        }

        public boolean containsKey(Object obj) {
            return I.i(this.d, obj);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) I.j(this.d, obj);
            if (collection == null) {
                return null;
            }
            return d.this.y(obj, collection);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.d.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection r = d.this.r();
            r.addAll(collection);
            d.p(d.this, collection.size());
            collection.clear();
            return r;
        }

        public boolean equals(Object obj) {
            return this == obj || this.d.equals(obj);
        }

        public Map.Entry f(Map.Entry entry) {
            Object key = entry.getKey();
            return I.d(key, d.this.y(key, (Collection) entry.getValue()));
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        public Set keySet() {
            return d.this.keySet();
        }

        public int size() {
            return this.d.size();
        }

        public String toString() {
            return this.d.toString();
        }
    }

    public abstract class d implements Iterator {
        public final Iterator a;
        public Object c = null;
        public Collection d = null;
        public Iterator e = E.h();

        public d() {
            this.a = d.k(d.this).entrySet().iterator();
        }

        public abstract Object a(Object obj, Object obj2);

        public boolean hasNext() {
            return this.a.hasNext() || this.e.hasNext();
        }

        public Object next() {
            if (!this.e.hasNext()) {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.c = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.d = collection;
                this.e = collection.iterator();
            }
            return a(O.a(this.c), this.e.next());
        }

        public void remove() {
            this.e.remove();
            Collection collection = this.d;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.a.remove();
            }
            d.n(d.this);
        }
    }

    public class e extends I.d {

        public class a implements Iterator {
            public Map.Entry a;
            public final /* synthetic */ Iterator c;

            public a(Iterator it) {
                this.c = it;
            }

            public boolean hasNext() {
                return this.c.hasNext();
            }

            public Object next() {
                Map.Entry entry = (Map.Entry) this.c.next();
                this.a = entry;
                return entry.getKey();
            }

            public void remove() {
                r5.m.q(this.a != null, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.a.getValue();
                this.c.remove();
                d.p(d.this, collection.size());
                collection.clear();
                this.a = null;
            }
        }

        public e(Map map) {
            super(map);
        }

        public void clear() {
            E.c(iterator());
        }

        public boolean containsAll(Collection collection) {
            return d().keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            return this == obj || d().keySet().equals(obj);
        }

        public int hashCode() {
            return d().keySet().hashCode();
        }

        public Iterator iterator() {
            return new a(d().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) d().remove(obj);
            if (collection != null) {
                i = collection.size();
                collection.clear();
                d.p(d.this, i);
            } else {
                i = 0;
            }
            return i > 0;
        }
    }

    public class f extends i implements NavigableMap {
        public f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry ceilingEntry = i().ceilingEntry(obj);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        public Object ceilingKey(Object obj) {
            return i().ceilingKey(obj);
        }

        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap descendingMap() {
            return d.this.new f(i().descendingMap());
        }

        public Map.Entry firstEntry() {
            Map.Entry firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        public Map.Entry floorEntry(Object obj) {
            Map.Entry floorEntry = i().floorEntry(obj);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        public Object floorKey(Object obj) {
            return i().floorKey(obj);
        }

        public NavigableMap headMap(Object obj, boolean z) {
            return d.this.new f(i().headMap(obj, z));
        }

        public Map.Entry higherEntry(Object obj) {
            Map.Entry higherEntry = i().higherEntry(obj);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        public Object higherKey(Object obj) {
            return i().higherKey(obj);
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return d.this.new g(i());
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        public Map.Entry lastEntry() {
            Map.Entry lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        public Map.Entry lowerEntry(Object obj) {
            Map.Entry lowerEntry = i().lowerEntry(obj);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        public Object lowerKey(Object obj) {
            return i().lowerKey(obj);
        }

        /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet keySet() {
            return super.keySet();
        }

        public Map.Entry n(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection r = d.this.r();
            r.addAll((Collection) entry.getValue());
            it.remove();
            return I.d(entry.getKey(), d.this.x(r));
        }

        public NavigableSet navigableKeySet() {
            return keySet();
        }

        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap i() {
            return super.i();
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        public Map.Entry pollFirstEntry() {
            return n(entrySet().iterator());
        }

        public Map.Entry pollLastEntry() {
            return n(descendingMap().entrySet().iterator());
        }

        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return d.this.new f(i().subMap(obj, z, obj2, z2));
        }

        public NavigableMap tailMap(Object obj, boolean z) {
            return d.this.new f(i().tailMap(obj, z));
        }
    }

    public class g extends j implements NavigableSet {
        public g(NavigableMap navigableMap) {
            super(navigableMap);
        }

        public Object ceiling(Object obj) {
            return f().ceilingKey(obj);
        }

        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet descendingSet() {
            return d.this.new g(f().descendingMap());
        }

        public Object floor(Object obj) {
            return f().floorKey(obj);
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        public NavigableSet headSet(Object obj, boolean z) {
            return d.this.new g(f().headMap(obj, z));
        }

        public Object higher(Object obj) {
            return f().higherKey(obj);
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap f() {
            return super.f();
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        public Object lower(Object obj) {
            return f().lowerKey(obj);
        }

        public Object pollFirst() {
            return E.o(iterator());
        }

        public Object pollLast() {
            return E.o(descendingIterator());
        }

        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return d.this.new g(f().subMap(obj, z, obj2, z2));
        }

        public NavigableSet tailSet(Object obj, boolean z) {
            return d.this.new g(f().tailMap(obj, z));
        }
    }

    public class h extends l implements RandomAccess {
        public h(d dVar, Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }
    }

    public class i extends c implements SortedMap {
        public SortedSet f;

        public i(SortedMap sortedMap) {
            super(sortedMap);
        }

        public Comparator comparator() {
            return i().comparator();
        }

        public Object firstKey() {
            return i().firstKey();
        }

        public SortedSet g() {
            return d.this.new j(i());
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            SortedSet sortedSet = this.f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet g = g();
            this.f = g;
            return g;
        }

        public SortedMap headMap(Object obj) {
            return d.this.new i(i().headMap(obj));
        }

        public SortedMap i() {
            return this.d;
        }

        public Object lastKey() {
            return i().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return d.this.new i(i().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return d.this.new i(i().tailMap(obj));
        }
    }

    public class j extends e implements SortedSet {
        public j(SortedMap sortedMap) {
            super(sortedMap);
        }

        public Comparator comparator() {
            return f().comparator();
        }

        public SortedMap f() {
            return super.d();
        }

        public Object first() {
            return f().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return d.this.new j(f().headMap(obj));
        }

        public Object last() {
            return f().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return d.this.new j(f().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return d.this.new j(f().tailMap(obj));
        }
    }

    public class k extends AbstractCollection {
        public final Object a;
        public Collection c;
        public final k d;
        public final Collection e;

        public class a implements Iterator {
            public final Iterator a;
            public final Collection c;

            public a() {
                Collection collection = k.this.c;
                this.c = collection;
                this.a = d.l(collection);
            }

            public Iterator b() {
                c();
                return this.a;
            }

            public void c() {
                k.this.j();
                if (k.this.c != this.c) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                c();
                return this.a.hasNext();
            }

            public Object next() {
                c();
                return this.a.next();
            }

            public void remove() {
                this.a.remove();
                d.n(d.this);
                k.this.l();
            }

            public a(Iterator it) {
                this.c = k.this.c;
                this.a = it;
            }
        }

        public k(Object obj, Collection collection, k kVar) {
            this.a = obj;
            this.c = collection;
            this.d = kVar;
            this.e = kVar == null ? null : kVar.g();
        }

        public boolean add(Object obj) {
            j();
            boolean isEmpty = this.c.isEmpty();
            boolean add = this.c.add(obj);
            if (add) {
                d.m(d.this);
                if (isEmpty) {
                    d();
                }
            }
            return add;
        }

        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.c.addAll(collection);
            if (addAll) {
                d.o(d.this, this.c.size() - size);
                if (size == 0) {
                    d();
                }
            }
            return addAll;
        }

        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.c.clear();
            d.p(d.this, size);
            l();
        }

        public boolean contains(Object obj) {
            j();
            return this.c.contains(obj);
        }

        public boolean containsAll(Collection collection) {
            j();
            return this.c.containsAll(collection);
        }

        public void d() {
            k kVar = this.d;
            if (kVar != null) {
                kVar.d();
            } else {
                d.k(d.this).put(this.a, this.c);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            j();
            return this.c.equals(obj);
        }

        public k f() {
            return this.d;
        }

        public Collection g() {
            return this.c;
        }

        public int hashCode() {
            j();
            return this.c.hashCode();
        }

        public Object i() {
            return this.a;
        }

        public Iterator iterator() {
            j();
            return new a();
        }

        public void j() {
            Collection collection;
            k kVar = this.d;
            if (kVar != null) {
                kVar.j();
                if (this.d.g() != this.e) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.c.isEmpty() || (collection = (Collection) d.k(d.this).get(this.a)) == null) {
                    return;
                }
                this.c = collection;
            }
        }

        public void l() {
            k kVar = this.d;
            if (kVar != null) {
                kVar.l();
            } else if (this.c.isEmpty()) {
                d.k(d.this).remove(this.a);
            }
        }

        public boolean remove(Object obj) {
            j();
            boolean remove = this.c.remove(obj);
            if (remove) {
                d.n(d.this);
                l();
            }
            return remove;
        }

        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.c.removeAll(collection);
            if (removeAll) {
                d.o(d.this, this.c.size() - size);
                l();
            }
            return removeAll;
        }

        public boolean retainAll(Collection collection) {
            r5.m.k(collection);
            int size = size();
            boolean retainAll = this.c.retainAll(collection);
            if (retainAll) {
                d.o(d.this, this.c.size() - size);
                l();
            }
            return retainAll;
        }

        public int size() {
            j();
            return this.c.size();
        }

        public String toString() {
            j();
            return this.c.toString();
        }
    }

    public class l extends k implements List {

        public class a extends k.a implements ListIterator {
            public a() {
                super();
            }

            public void add(Object obj) {
                boolean isEmpty = l.this.isEmpty();
                d().add(obj);
                d.m(d.this);
                if (isEmpty) {
                    l.this.d();
                }
            }

            public final ListIterator d() {
                return b();
            }

            public boolean hasPrevious() {
                return d().hasPrevious();
            }

            public int nextIndex() {
                return d().nextIndex();
            }

            public Object previous() {
                return d().previous();
            }

            public int previousIndex() {
                return d().previousIndex();
            }

            public void set(Object obj) {
                d().set(obj);
            }

            public a(int i) {
                super(l.this.n().listIterator(i));
            }
        }

        public l(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }

        public void add(int i, Object obj) {
            j();
            boolean isEmpty = g().isEmpty();
            n().add(i, obj);
            d.m(d.this);
            if (isEmpty) {
                d();
            }
        }

        public boolean addAll(int i, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = n().addAll(i, collection);
            if (addAll) {
                d.o(d.this, g().size() - size);
                if (size == 0) {
                    d();
                }
            }
            return addAll;
        }

        public Object get(int i) {
            j();
            return n().get(i);
        }

        public int indexOf(Object obj) {
            j();
            return n().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            j();
            return n().lastIndexOf(obj);
        }

        public ListIterator listIterator() {
            j();
            return new a();
        }

        public List n() {
            return g();
        }

        public Object remove(int i) {
            j();
            Object remove = n().remove(i);
            d.n(d.this);
            l();
            return remove;
        }

        public Object set(int i, Object obj) {
            j();
            return n().set(i, obj);
        }

        public List subList(int i, int i2) {
            j();
            return d.this.z(i(), n().subList(i, i2), f() == null ? this : f());
        }

        public ListIterator listIterator(int i) {
            j();
            return new a(i);
        }
    }

    public d(Map map) {
        r5.m.d(map.isEmpty());
        this.f = map;
    }

    public static /* synthetic */ Map k(d dVar) {
        return dVar.f;
    }

    public static /* synthetic */ Iterator l(Collection collection) {
        return v(collection);
    }

    public static /* synthetic */ int m(d dVar) {
        int i2 = dVar.g;
        dVar.g = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int n(d dVar) {
        int i2 = dVar.g;
        dVar.g = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int o(d dVar, int i2) {
        int i3 = dVar.g + i2;
        dVar.g = i3;
        return i3;
    }

    public static /* synthetic */ int p(d dVar, int i2) {
        int i3 = dVar.g - i2;
        dVar.g = i3;
        return i3;
    }

    public static /* synthetic */ void q(d dVar, Object obj) {
        dVar.w(obj);
    }

    public static Iterator v(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public Collection a() {
        return super.a();
    }

    public void clear() {
        Iterator it = this.f.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f.clear();
        this.g = 0;
    }

    public Map e() {
        return new c(this.f);
    }

    public Collection f() {
        return new f.a(this);
    }

    public Set g() {
        return new e(this.f);
    }

    public Collection get(Object obj) {
        Collection collection = (Collection) this.f.get(obj);
        if (collection == null) {
            collection = s(obj);
        }
        return y(obj, collection);
    }

    public Collection h() {
        return new f.b(this);
    }

    public Iterator i() {
        return new b(this);
    }

    public Iterator j() {
        return new a(this);
    }

    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.f.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.g++;
            return true;
        }
        Collection s = s(obj);
        if (!s.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.g++;
        this.f.put(obj, s);
        return true;
    }

    public abstract Collection r();

    public Collection s(Object obj) {
        return r();
    }

    public int size() {
        return this.g;
    }

    public final Map t() {
        Map map = this.f;
        return map instanceof NavigableMap ? new f(this.f) : map instanceof SortedMap ? new i(this.f) : new c(this.f);
    }

    public final Set u() {
        Map map = this.f;
        return map instanceof NavigableMap ? new g(this.f) : map instanceof SortedMap ? new j(this.f) : new e(this.f);
    }

    public Collection values() {
        return super.values();
    }

    public final void w(Object obj) {
        Collection collection = (Collection) I.k(this.f, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.g -= size;
        }
    }

    public abstract Collection x(Collection collection);

    public abstract Collection y(Object obj, Collection collection);

    public final List z(Object obj, List list, k kVar) {
        return list instanceof RandomAccess ? new h(this, obj, list, kVar) : new l(obj, list, kVar);
    }

    public class a extends d {
        public a(d dVar) {
            super();
        }

        public Object a(Object obj, Object obj2) {
            return obj2;
        }
    }
}
