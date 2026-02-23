package s5;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a extends d0 {
    public final int a;
    public int c;

    public a(int i, int i2) {
        r5.m.m(i2, i);
        this.a = i;
        this.c = i2;
    }

    public abstract Object a(int i);

    public final boolean hasNext() {
        return this.c < this.a;
    }

    public final boolean hasPrevious() {
        return this.c > 0;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.c;
        this.c = i + 1;
        return a(i);
    }

    public final int nextIndex() {
        return this.c;
    }

    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.c - 1;
        this.c = i;
        return a(i);
    }

    public final int previousIndex() {
        return this.c - 1;
    }
}
