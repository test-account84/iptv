package l8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class c extends l8.a implements List, x8.a {

    @NotNull
    public static final a Companion = new a(null);

    public static final class a {
        public a() {
        }

        public final void a(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void c(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }

        public final boolean d(Collection c, Collection other) {
            kotlin.jvm.internal.l.e(c, "c");
            kotlin.jvm.internal.l.e(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            Iterator it = other.iterator();
            Iterator it2 = c.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.l.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection c) {
            kotlin.jvm.internal.l.e(c, "c");
            Iterator it = c.iterator();
            int i = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i = (i * 31) + (next != null ? next.hashCode() : 0);
            }
            return i;
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public class b implements Iterator, x8.a {
        public int a;

        public b() {
        }

        public final int b() {
            return this.a;
        }

        public final void c(int i) {
            this.a = i;
        }

        public boolean hasNext() {
            return this.a < c.this.size();
        }

        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c cVar = c.this;
            int i = this.a;
            this.a = i + 1;
            return cVar.get(i);
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends b implements ListIterator, x8.a {
        public c(int i) {
            super();
            c.Companion.b(i, c.this.size());
            c(i);
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            return b() > 0;
        }

        public int nextIndex() {
            return b();
        }

        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            c cVar = c.this;
            c(b() - 1);
            return cVar.get(b());
        }

        public int previousIndex() {
            return b() - 1;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d extends c implements RandomAccess {
        public final c a;
        public final int c;
        public int d;

        public d(c list, int i, int i2) {
            kotlin.jvm.internal.l.e(list, "list");
            this.a = list;
            this.c = i;
            c.Companion.c(i, i2, list.size());
            this.d = i2 - i;
        }

        public Object get(int i) {
            c.Companion.a(i, this.d);
            return this.a.get(this.c + i);
        }

        public int getSize() {
            return this.d;
        }
    }

    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.d(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i);

    public int hashCode() {
        return Companion.e(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.l.a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @NotNull
    public Iterator iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.l.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator listIterator() {
        return new c(0);
    }

    public Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public List subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @NotNull
    public ListIterator listIterator(int i) {
        return new c(i);
    }
}
