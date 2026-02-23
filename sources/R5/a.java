package r5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a implements Iterator {
    public b a = b.NOT_READY;
    public Object c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object b();

    public final Object c() {
        this.a = b.DONE;
        return null;
    }

    public final boolean d() {
        this.a = b.FAILED;
        this.c = b();
        if (this.a == b.DONE) {
            return false;
        }
        this.a = b.READY;
        return true;
    }

    public final boolean hasNext() {
        m.p(this.a != b.FAILED);
        int i = a.a[this.a.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return d();
        }
        return true;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = b.NOT_READY;
        Object a2 = i.a(this.c);
        this.c = null;
        return a2;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
