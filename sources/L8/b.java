package l8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b implements Iterator, x8.a {
    public G a = G.NotReady;
    public Object c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[G.values().length];
            iArr[G.Done.ordinal()] = 1;
            iArr[G.Ready.ordinal()] = 2;
            a = iArr;
        }
    }

    public abstract void b();

    public final void c() {
        this.a = G.Done;
    }

    public final void d(Object obj) {
        this.c = obj;
        this.a = G.Ready;
    }

    public final boolean e() {
        this.a = G.Failed;
        b();
        return this.a == G.Ready;
    }

    public boolean hasNext() {
        G g = this.a;
        if (g == G.Failed) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i = a.a[g.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return e();
        }
        return true;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = G.NotReady;
        return this.c;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
