package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l extends k implements Iterable {
    public final s.j k;
    public int l;
    public String m;

    public class a implements Iterator {
        public int a = -1;
        public boolean c = false;

        public a() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c = true;
            s.j jVar = l.this.k;
            int i = this.a + 1;
            this.a = i;
            return (k) jVar.n(i);
        }

        public boolean hasNext() {
            return this.a + 1 < l.this.k.m();
        }

        public void remove() {
            if (!this.c) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            ((k) l.this.k.n(this.a)).u(null);
            l.this.k.l(this.a);
            this.a--;
            this.c = false;
        }
    }

    public l(s sVar) {
        super(sVar);
        this.k = new s.j();
    }

    public final k A(int i) {
        return B(i, true);
    }

    public final k B(int i, boolean z) {
        k kVar = (k) this.k.g(i);
        if (kVar != null) {
            return kVar;
        }
        if (!z || n() == null) {
            return null;
        }
        return n().A(i);
    }

    public String D() {
        if (this.m == null) {
            this.m = Integer.toString(this.l);
        }
        return this.m;
    }

    public final int E() {
        return this.l;
    }

    public final void F(int i) {
        if (i != i()) {
            this.l = i;
            this.m = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i + " cannot use the same id as the graph " + this);
    }

    public String g() {
        return i() != 0 ? super.g() : "the root navigation";
    }

    public final Iterator iterator() {
        return new a();
    }

    public k.a o(j jVar) {
        k.a o = super.o(jVar);
        Iterator it = iterator();
        while (it.hasNext()) {
            k.a o2 = ((k) it.next()).o(jVar);
            if (o2 != null && (o == null || o2.compareTo(o) > 0)) {
                o = o2;
            }
        }
        return o;
    }

    public void p(Context context, AttributeSet attributeSet) {
        super.p(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, w0.a.y);
        F(obtainAttributes.getResourceId(w0.a.z, 0));
        this.m = k.h(context, this.l);
        obtainAttributes.recycle();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        k A = A(E());
        if (A == null) {
            str = this.m;
            if (str == null) {
                sb.append("0x");
                str = Integer.toHexString(this.l);
            }
        } else {
            sb.append("{");
            sb.append(A.toString());
            str = "}";
        }
        sb.append(str);
        return sb.toString();
    }

    public final void z(k kVar) {
        int i = kVar.i();
        if (i == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        }
        if (i == i()) {
            throw new IllegalArgumentException("Destination " + kVar + " cannot have the same id as graph " + this);
        }
        k kVar2 = (k) this.k.g(i);
        if (kVar2 == kVar) {
            return;
        }
        if (kVar.n() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (kVar2 != null) {
            kVar2.u(null);
        }
        kVar.u(this);
        this.k.k(kVar.i(), kVar);
    }
}
