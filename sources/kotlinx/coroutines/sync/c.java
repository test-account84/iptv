package kotlinx.coroutines.sync;

import G8.d0;
import G8.n;
import G8.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k8.q;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.u;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class c implements kotlinx.coroutines.sync.b {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_state");

    @NotNull
    volatile /* synthetic */ Object _state;

    public final class a extends b {
        public final n h;

        public static final class a extends m implements l {
            public final /* synthetic */ c a;
            public final /* synthetic */ a c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, a aVar) {
                super(1);
                this.a = cVar;
                this.c = aVar;
            }

            public final void a(Throwable th) {
                this.a.c(this.c.e);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return q.a;
            }
        }

        public a(Object obj, n nVar) {
            super(obj);
            this.h = nVar;
        }

        public boolean B() {
            return A() && this.h.f(q.a, null, new a(c.this, this)) != null;
        }

        public String toString() {
            return "LockCont[" + this.e + ", " + this.h + "] for " + c.this;
        }

        public void z() {
            this.h.y(p.a);
        }
    }

    public abstract class b extends kotlinx.coroutines.internal.m implements d0 {
        public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(b.class, "isTaken");
        public final Object e;

        @NotNull
        private volatile /* synthetic */ int isTaken = 0;

        public b(Object obj) {
            this.e = obj;
        }

        public final boolean A() {
            return g.compareAndSet(this, 0, 1);
        }

        public abstract boolean B();

        public final void dispose() {
            u();
        }

        public abstract void z();
    }

    public static final class c extends k {

        @NotNull
        public volatile Object owner;

        public c(Object obj) {
            this.owner = obj;
        }

        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    public static final class d extends kotlinx.coroutines.internal.c {
        public final c b;

        public d(c cVar) {
            this.b = cVar;
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(c cVar, Object obj) {
            t.b.a(c.a, cVar, this, obj == null ? kotlinx.coroutines.sync.d.d() : this.b);
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(c cVar) {
            if (this.b.z()) {
                return null;
            }
            return kotlinx.coroutines.sync.d.g();
        }
    }

    public static final class e extends m implements l {
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(1);
            this.c = obj;
        }

        public final void a(Throwable th) {
            c.this.c(this.c);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return q.a;
        }
    }

    public c(boolean z) {
        this._state = z ? kotlinx.coroutines.sync.d.c() : kotlinx.coroutines.sync.d.d();
    }

    public Object a(Object obj, o8.d dVar) {
        if (e(obj)) {
            return q.a;
        }
        Object d2 = d(obj, dVar);
        return d2 == p8.c.d() ? d2 : q.a;
    }

    public boolean b() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.a) {
                return ((kotlinx.coroutines.sync.a) obj).a != kotlinx.coroutines.sync.d.f();
            }
            if (obj instanceof c) {
                return true;
            }
            if (!(obj instanceof u)) {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
            ((u) obj).c(this);
        }
    }

    public void c(Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.a) {
                kotlinx.coroutines.sync.a aVar = (kotlinx.coroutines.sync.a) obj2;
                if (obj == null) {
                    if (aVar.a == kotlinx.coroutines.sync.d.f()) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else if (aVar.a != obj) {
                    throw new IllegalStateException(("Mutex is locked by " + aVar.a + " but expected " + obj).toString());
                }
                if (t.b.a(a, this, obj2, kotlinx.coroutines.sync.d.d())) {
                    return;
                }
            } else if (obj2 instanceof u) {
                ((u) obj2).c(this);
            } else {
                if (!(obj2 instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                if (obj != null) {
                    c cVar = (c) obj2;
                    if (cVar.owner != obj) {
                        throw new IllegalStateException(("Mutex is locked by " + cVar.owner + " but expected " + obj).toString());
                    }
                }
                c cVar2 = (c) obj2;
                kotlinx.coroutines.internal.m v = cVar2.v();
                if (v == null) {
                    d dVar = new d(cVar2);
                    if (t.b.a(a, this, obj2, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    b bVar = (b) v;
                    if (bVar.B()) {
                        Object obj3 = bVar.e;
                        if (obj3 == null) {
                            obj3 = kotlinx.coroutines.sync.d.e();
                        }
                        cVar2.owner = obj3;
                        bVar.z();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        G8.q.c(r0, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.Object r7, o8.d r8) {
        /*
            r6 = this;
            o8.d r0 = p8.b.c(r8)
            G8.o r0 = G8.q.b(r0)
            kotlinx.coroutines.sync.c$a r1 = new kotlinx.coroutines.sync.c$a
            r1.<init>(r7, r0)
        Ld:
            java.lang.Object r2 = r6._state
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.a
            if (r3 == 0) goto L4a
            r3 = r2
            kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r3
            java.lang.Object r4 = r3.a
            kotlinx.coroutines.internal.y r5 = kotlinx.coroutines.sync.d.f()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.c.a
            kotlinx.coroutines.sync.c$c r5 = new kotlinx.coroutines.sync.c$c
            java.lang.Object r3 = r3.a
            r5.<init>(r3)
            t.b.a(r4, r6, r2, r5)
            goto Ld
        L2b:
            if (r7 != 0) goto L32
            kotlinx.coroutines.sync.a r3 = kotlinx.coroutines.sync.d.c()
            goto L37
        L32:
            kotlinx.coroutines.sync.a r3 = new kotlinx.coroutines.sync.a
            r3.<init>(r7)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.c.a
            boolean r2 = t.b.a(r4, r6, r2, r3)
            if (r2 == 0) goto Ld
            k8.q r1 = k8.q.a
            kotlinx.coroutines.sync.c$e r2 = new kotlinx.coroutines.sync.c$e
            r2.<init>(r7)
            r0.u(r1, r2)
            goto L6c
        L4a:
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.c.c
            if (r3 == 0) goto L9e
            r3 = r2
            kotlinx.coroutines.sync.c$c r3 = (kotlinx.coroutines.sync.c.c) r3
            java.lang.Object r4 = r3.owner
            if (r4 == r7) goto L83
            r3.i(r1)
            java.lang.Object r3 = r6._state
            if (r3 == r2) goto L69
            boolean r2 = r1.A()
            if (r2 != 0) goto L63
            goto L69
        L63:
            kotlinx.coroutines.sync.c$a r1 = new kotlinx.coroutines.sync.c$a
            r1.<init>(r7, r0)
            goto Ld
        L69:
            G8.q.c(r0, r1)
        L6c:
            java.lang.Object r7 = r0.r()
            java.lang.Object r0 = p8.c.d()
            if (r7 != r0) goto L79
            q8.h.c(r8)
        L79:
            java.lang.Object r8 = p8.c.d()
            if (r7 != r8) goto L80
            return r7
        L80:
            k8.q r7 = k8.q.a
            return r7
        L83:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Already locked by "
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L9e:
            boolean r3 = r2 instanceof kotlinx.coroutines.internal.u
            if (r3 == 0) goto La9
            kotlinx.coroutines.internal.u r2 = (kotlinx.coroutines.internal.u) r2
            r2.c(r6)
            goto Ld
        La9:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Illegal state "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.c.d(java.lang.Object, o8.d):java.lang.Object");
    }

    public boolean e(Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.a) {
                if (((kotlinx.coroutines.sync.a) obj2).a != kotlinx.coroutines.sync.d.f()) {
                    return false;
                }
                if (t.b.a(a, this, obj2, obj == null ? kotlinx.coroutines.sync.d.c() : new kotlinx.coroutines.sync.a(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof c) {
                    if (((c) obj2).owner != obj) {
                        return false;
                    }
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
                if (!(obj2 instanceof u)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((u) obj2).c(this);
            }
        }
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.a) {
                sb = new StringBuilder();
                sb.append("Mutex[");
                obj = ((kotlinx.coroutines.sync.a) obj2).a;
                break;
            }
            if (obj2 instanceof u) {
                ((u) obj2).c(this);
            } else {
                if (!(obj2 instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                sb = new StringBuilder();
                sb.append("Mutex[");
                obj = ((c) obj2).owner;
            }
        }
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
