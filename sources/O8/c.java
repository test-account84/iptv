package o8;

import java.io.Serializable;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import o8.g;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class c implements g, Serializable {
    public final g a;
    public final g.b c;

    public static final class a extends m implements p {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String acc, g.b element) {
            l.e(acc, "acc");
            l.e(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(g left, g.b element) {
        l.e(left, "left");
        l.e(element, "element");
        this.a = left;
        this.c = element;
    }

    private final int t() {
        int i = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.a;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i;
            }
            i++;
        }
    }

    public g V(g gVar) {
        return g.a.a(this, gVar);
    }

    public g.b a(g.c key) {
        l.e(key, "key");
        c cVar = this;
        while (true) {
            g.b a2 = cVar.c.a(key);
            if (a2 != null) {
                return a2;
            }
            g gVar = cVar.a;
            if (!(gVar instanceof c)) {
                return gVar.a(key);
            }
            cVar = (c) gVar;
        }
    }

    public final boolean b(g.b bVar) {
        return l.a(a(bVar.getKey()), bVar);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.t() != t() || !cVar.f(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean f(c cVar) {
        while (b(cVar.c)) {
            g gVar = cVar.a;
            if (!(gVar instanceof c)) {
                l.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.c.hashCode();
    }

    public Object l(Object obj, p operation) {
        l.e(operation, "operation");
        return operation.invoke(this.a.l(obj, operation), this.c);
    }

    public String toString() {
        return '[' + ((String) l("", a.a)) + ']';
    }

    public g w(g.c key) {
        l.e(key, "key");
        if (this.c.a(key) != null) {
            return this.a;
        }
        g w = this.a.w(key);
        return w == this.a ? this : w == h.a ? this.c : new c(w, this.c);
    }
}
