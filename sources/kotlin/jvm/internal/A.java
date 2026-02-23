package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class a implements Iterator, x8.a {
    public final Object[] a;
    public int c;

    public a(Object[] array) {
        l.e(array, "array");
        this.a = array;
    }

    public boolean hasNext() {
        return this.c < this.a.length;
    }

    public Object next() {
        try {
            Object[] objArr = this.a;
            int i = this.c;
            this.c = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.c--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
