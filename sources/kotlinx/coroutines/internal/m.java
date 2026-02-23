package kotlinx.coroutines.internal;

import G8.P;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_removedRef");

    @NotNull
    volatile /* synthetic */ Object _next = this;

    @NotNull
    volatile /* synthetic */ Object _prev = this;

    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends kotlinx.coroutines.internal.c {
        public final m b;
        public m c;

        public a(m mVar) {
            this.b = mVar;
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(m mVar, Object obj) {
            boolean z = obj == null;
            m mVar2 = z ? this.b : this.c;
            if (mVar2 != null && t.b.a(m.a, mVar, this, mVar2) && z) {
                m mVar3 = this.b;
                m mVar4 = this.c;
                kotlin.jvm.internal.l.b(mVar4);
                m.h(mVar3, mVar4);
            }
        }
    }

    public static final class b extends u {
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.u {
        public c(Object obj) {
            super(obj, P.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return P.a(this.receiver);
        }
    }

    public static final /* synthetic */ void h(m mVar, m mVar2) {
        mVar.n(mVar2);
    }

    public final void i(m mVar) {
        while (!q().j(mVar, this)) {
        }
    }

    public final boolean j(m mVar, m mVar2) {
        c.lazySet(mVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(mVar, mVar2);
        if (!t.b.a(atomicReferenceFieldUpdater, this, mVar2, mVar)) {
            return false;
        }
        mVar.n(mVar2);
        return true;
    }

    public final boolean k(m mVar) {
        c.lazySet(mVar, this);
        a.lazySet(mVar, this);
        while (o() == this) {
            if (t.b.a(a, this, this, mVar)) {
                mVar.n(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (t.b.a(kotlinx.coroutines.internal.m.a, r3, r2, ((kotlinx.coroutines.internal.v) r4).a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.m l(kotlinx.coroutines.internal.u r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.m r0 = (kotlinx.coroutines.internal.m) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.m.c
            boolean r0 = t.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.t()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.u
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.u r0 = (kotlinx.coroutines.internal.u) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.u r4 = (kotlinx.coroutines.internal.u) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.v
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.m.a
            kotlinx.coroutines.internal.v r4 = (kotlinx.coroutines.internal.v) r4
            kotlinx.coroutines.internal.m r4 = r4.a
            boolean r2 = t.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.m r2 = (kotlinx.coroutines.internal.m) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.m r3 = (kotlinx.coroutines.internal.m) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.m.l(kotlinx.coroutines.internal.u):kotlinx.coroutines.internal.m");
    }

    public final m m(m mVar) {
        while (mVar.t()) {
            mVar = (m) mVar._prev;
        }
        return mVar;
    }

    public final void n(m mVar) {
        m mVar2;
        do {
            mVar2 = (m) mVar._prev;
            if (o() != mVar) {
                return;
            }
        } while (!t.b.a(c, mVar, mVar2, this));
        if (t()) {
            mVar.l(null);
        }
    }

    public final Object o() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof u)) {
                return obj;
            }
            ((u) obj).c(this);
        }
    }

    public final m p() {
        return l.b(o());
    }

    public final m q() {
        m l = l(null);
        return l == null ? m((m) this._prev) : l;
    }

    public final void r() {
        ((v) o()).a.s();
    }

    public final void s() {
        m mVar = this;
        while (true) {
            Object o = mVar.o();
            if (!(o instanceof v)) {
                mVar.l(null);
                return;
            }
            mVar = ((v) o).a;
        }
    }

    public boolean t() {
        return o() instanceof v;
    }

    public String toString() {
        return new c(this) + '@' + P.b(this);
    }

    public boolean u() {
        return w() == null;
    }

    public final m v() {
        while (true) {
            m mVar = (m) o();
            if (mVar == this) {
                return null;
            }
            if (mVar.u()) {
                return mVar;
            }
            mVar.r();
        }
    }

    public final m w() {
        Object o;
        m mVar;
        do {
            o = o();
            if (o instanceof v) {
                return ((v) o).a;
            }
            if (o == this) {
                return (m) o;
            }
            mVar = (m) o;
        } while (!t.b.a(a, this, o, mVar.x()));
        mVar.l(null);
        return null;
    }

    public final v x() {
        v vVar = (v) this._removedRef;
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this);
        d.lazySet(this, vVar2);
        return vVar2;
    }

    public final int y(m mVar, m mVar2, a aVar) {
        c.lazySet(mVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(mVar, mVar2);
        aVar.c = mVar2;
        if (t.b.a(atomicReferenceFieldUpdater, this, mVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
