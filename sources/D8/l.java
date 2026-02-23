package D8;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class l implements d {
    public final d a;
    public final w8.l b;

    public static final class a implements Iterator, x8.a {
        public final Iterator a;

        public a() {
            this.a = l.b(l.this).iterator();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public Object next() {
            return l.c(l.this).invoke(this.a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public l(d sequence, w8.l transformer) {
        kotlin.jvm.internal.l.e(sequence, "sequence");
        kotlin.jvm.internal.l.e(transformer, "transformer");
        this.a = sequence;
        this.b = transformer;
    }

    public static final /* synthetic */ d b(l lVar) {
        return lVar.a;
    }

    public static final /* synthetic */ w8.l c(l lVar) {
        return lVar.b;
    }

    public Iterator iterator() {
        return new a();
    }
}
