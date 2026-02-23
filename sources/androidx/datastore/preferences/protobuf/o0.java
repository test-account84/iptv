package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o0 extends AbstractList implements D, RandomAccess {
    public final D a;

    public class a implements ListIterator {
        public ListIterator a;
        public final /* synthetic */ int c;

        public a(int i) {
            this.c = i;
            this.a = o0.a(o0.this).listIterator(i);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.a.next();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.a.previous();
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        public int nextIndex() {
            return this.a.nextIndex();
        }

        public int previousIndex() {
            return this.a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator {
        public Iterator a;

        public b() {
            this.a = o0.a(o0.this).iterator();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.a.next();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public o0(D d) {
        this.a = d;
    }

    public static /* synthetic */ D a(o0 o0Var) {
        return o0Var.a;
    }

    public D C() {
        return this;
    }

    public Object G(int i) {
        return this.a.G(i);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(int i) {
        return (String) this.a.get(i);
    }

    public Iterator iterator() {
        return new b();
    }

    public ListIterator listIterator(int i) {
        return new a(i);
    }

    public List m() {
        return this.a.m();
    }

    public int size() {
        return this.a.size();
    }

    public void x(g gVar) {
        throw new UnsupportedOperationException();
    }
}
