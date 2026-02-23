package D8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k8.j;
import k8.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e extends f implements Iterator, o8.d, x8.a {
    public int a;
    public Object c;
    public Iterator d;
    public o8.d e;

    public Object a(Object obj, o8.d dVar) {
        this.c = obj;
        this.a = 3;
        this.e = dVar;
        Object d = p8.c.d();
        if (d == p8.c.d()) {
            q8.h.c(dVar);
        }
        return d == p8.c.d() ? d : q.a;
    }

    public final Throwable c() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    public final Object d() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void e(o8.d dVar) {
        this.e = dVar;
    }

    public o8.g getContext() {
        return o8.h.a;
    }

    public boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator it = this.d;
                kotlin.jvm.internal.l.b(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.d = null;
            }
            this.a = 5;
            o8.d dVar = this.e;
            kotlin.jvm.internal.l.b(dVar);
            this.e = null;
            j.a aVar = k8.j.c;
            dVar.resumeWith(k8.j.b(q.a));
        }
    }

    public Object next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return d();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.d;
            kotlin.jvm.internal.l.b(it);
            return it.next();
        }
        if (i != 3) {
            throw c();
        }
        this.a = 0;
        Object obj = this.c;
        this.c = null;
        return obj;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object obj) {
        k8.k.b(obj);
        this.a = 4;
    }
}
