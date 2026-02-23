package I8;

import G8.P;
import I8.h;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.y;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class c implements s {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
    public final w8.l b;
    public final kotlinx.coroutines.internal.k c = new kotlinx.coroutines.internal.k();

    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;

    public c(w8.l lVar) {
        this.b = lVar;
    }

    public final Object a(Object obj) {
        h.b bVar;
        i iVar;
        Object m = m(obj);
        if (m == b.b) {
            return h.b.c(k8.q.a);
        }
        if (m == b.c) {
            iVar = g();
            if (iVar == null) {
                return h.b.b();
            }
            bVar = h.b;
        } else {
            if (!(m instanceof i)) {
                throw new IllegalStateException(("trySend returned " + m).toString());
            }
            bVar = h.b;
            iVar = (i) m;
        }
        return bVar.a(k(iVar));
    }

    public boolean c(Throwable th) {
        boolean z;
        i iVar = new i(th);
        kotlinx.coroutines.internal.m mVar = this.c;
        while (true) {
            kotlinx.coroutines.internal.m q = mVar.q();
            z = true;
            if (!(!(q instanceof i))) {
                z = false;
                break;
            }
            if (q.j(iVar, mVar)) {
                break;
            }
        }
        if (!z) {
            iVar = (i) this.c.q();
        }
        j(iVar);
        if (z) {
            l(th);
        }
        return z;
    }

    public final int e() {
        kotlinx.coroutines.internal.k kVar = this.c;
        int i = 0;
        for (kotlinx.coroutines.internal.m mVar = (kotlinx.coroutines.internal.m) kVar.o(); !kotlin.jvm.internal.l.a(mVar, kVar); mVar = mVar.p()) {
            if (mVar instanceof kotlinx.coroutines.internal.m) {
                i++;
            }
        }
        return i;
    }

    public String f() {
        return "";
    }

    public final i g() {
        kotlinx.coroutines.internal.m q = this.c.q();
        i iVar = q instanceof i ? (i) q : null;
        if (iVar == null) {
            return null;
        }
        j(iVar);
        return iVar;
    }

    public final kotlinx.coroutines.internal.k h() {
        return this.c;
    }

    public final String i() {
        String str;
        kotlinx.coroutines.internal.m p = this.c.p();
        if (p == this.c) {
            return "EmptyQueue";
        }
        if (p instanceof i) {
            str = p.toString();
        } else if (p instanceof n) {
            str = "ReceiveQueued";
        } else if (p instanceof r) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + p;
        }
        kotlinx.coroutines.internal.m q = this.c.q();
        if (q == p) {
            return str;
        }
        String str2 = str + ",queueSize=" + e();
        if (!(q instanceof i)) {
            return str2;
        }
        return str2 + ",closedForSend=" + q;
    }

    public final void j(i iVar) {
        Object b = kotlinx.coroutines.internal.h.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.m q = iVar.q();
            n nVar = q instanceof n ? (n) q : null;
            if (nVar == null) {
                break;
            } else if (nVar.u()) {
                b = kotlinx.coroutines.internal.h.c(b, nVar);
            } else {
                nVar.r();
            }
        }
        if (b != null) {
            if (b instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) b;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((n) arrayList.get(size)).B(iVar);
                }
            } else {
                ((n) b).B(iVar);
            }
        }
        n(iVar);
    }

    public final Throwable k(i iVar) {
        j(iVar);
        return iVar.G();
    }

    public final void l(Throwable th) {
        y yVar;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (yVar = b.f) || !t.b.a(d, this, obj, yVar)) {
            return;
        }
        ((w8.l) F.b(obj, 1)).invoke(th);
    }

    public Object m(Object obj) {
        p p;
        do {
            p = p();
            if (p == null) {
                return b.c;
            }
        } while (p.f(obj, null) == null);
        p.d(obj);
        return p.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p o(Object obj) {
        kotlinx.coroutines.internal.m q;
        kotlinx.coroutines.internal.k kVar = this.c;
        a aVar = new a(obj);
        do {
            q = kVar.q();
            if (q instanceof p) {
                return (p) q;
            }
        } while (!q.j(aVar, kVar));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.m] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public p p() {
        ?? r1;
        kotlinx.coroutines.internal.m w;
        kotlinx.coroutines.internal.k kVar = this.c;
        while (true) {
            r1 = (kotlinx.coroutines.internal.m) kVar.o();
            if (r1 != kVar && (r1 instanceof p)) {
                if (((((p) r1) instanceof i) && !r1.t()) || (w = r1.w()) == null) {
                    break;
                }
                w.s();
            }
        }
        r1 = 0;
        return (p) r1;
    }

    public final r q() {
        kotlinx.coroutines.internal.m mVar;
        kotlinx.coroutines.internal.m w;
        kotlinx.coroutines.internal.k kVar = this.c;
        while (true) {
            mVar = (kotlinx.coroutines.internal.m) kVar.o();
            if (mVar != kVar && (mVar instanceof r)) {
                if (((((r) mVar) instanceof i) && !mVar.t()) || (w = mVar.w()) == null) {
                    break;
                }
                w.s();
            }
        }
        mVar = null;
        return (r) mVar;
    }

    public String toString() {
        return P.a(this) + '@' + P.b(this) + '{' + i() + '}' + f();
    }

    public void n(kotlinx.coroutines.internal.m mVar) {
    }

    public static final class a extends r {
        public final Object e;

        public a(Object obj) {
            this.e = obj;
        }

        public Object A() {
            return this.e;
        }

        public y B(m.b bVar) {
            return G8.p.a;
        }

        public String toString() {
            return "SendBuffered@" + P.b(this) + '(' + this.e + ')';
        }

        public void z() {
        }
    }
}
