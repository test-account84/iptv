package I8;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.y;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d extends I8.a {
    public final int e;
    public final e f;
    public final ReentrantLock g;
    public Object[] h;
    public int i;

    @NotNull
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            iArr[e.SUSPEND.ordinal()] = 1;
            iArr[e.DROP_LATEST.ordinal()] = 2;
            iArr[e.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public d(int i, e eVar, w8.l lVar) {
        super(lVar);
        this.e = i;
        this.f = eVar;
        if (i < 1) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.g = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        l8.g.l(objArr, b.a, 0, 0, 6, null);
        this.h = objArr;
        this.size = 0;
    }

    public final void C(int i, Object obj) {
        if (i < this.e) {
            D(i);
            Object[] objArr = this.h;
            objArr[(this.i + i) % objArr.length] = obj;
        } else {
            Object[] objArr2 = this.h;
            int i2 = this.i;
            objArr2[i2 % objArr2.length] = null;
            objArr2[(i + i2) % objArr2.length] = obj;
            this.i = (i2 + 1) % objArr2.length;
        }
    }

    public final void D(int i) {
        Object[] objArr = this.h;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.e);
            Object[] objArr2 = new Object[min];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.h;
                objArr2[i2] = objArr3[(this.i + i2) % objArr3.length];
            }
            l8.g.j(objArr2, b.a, i, min);
            this.h = objArr2;
            this.i = 0;
        }
    }

    public final y E(int i) {
        if (i < this.e) {
            this.size = i + 1;
            return null;
        }
        int i2 = a.a[this.f.ordinal()];
        if (i2 == 1) {
            return b.c;
        }
        if (i2 == 2) {
            return b.b;
        }
        if (i2 == 3) {
            return null;
        }
        throw new k8.h();
    }

    public String f() {
        return "(buffer:capacity=" + this.e + ",size=" + this.size + ')';
    }

    public Object m(Object obj) {
        p p;
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            int i = this.size;
            i g = g();
            if (g != null) {
                return g;
            }
            y E = E(i);
            if (E != null) {
                return E;
            }
            if (i == 0) {
                do {
                    p = p();
                    if (p != null) {
                        if (p instanceof i) {
                            this.size = i;
                            return p;
                        }
                        kotlin.jvm.internal.l.b(p);
                    }
                } while (p.f(obj, null) == null);
                this.size = i;
                k8.q qVar = k8.q.a;
                reentrantLock.unlock();
                p.d(obj);
                return p.a();
            }
            C(i, obj);
            return b.b;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean u(n nVar) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            return super.u(nVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean v() {
        return false;
    }

    public final boolean w() {
        return this.size == 0;
    }

    public Object z() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object g = g();
                if (g == null) {
                    g = b.d;
                }
                return g;
            }
            Object[] objArr = this.h;
            int i2 = this.i;
            Object obj = objArr[i2];
            r rVar = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj2 = b.d;
            boolean z = false;
            if (i == this.e) {
                r rVar2 = null;
                while (true) {
                    r q = q();
                    if (q == null) {
                        rVar = rVar2;
                        break;
                    }
                    kotlin.jvm.internal.l.b(q);
                    if (q.B(null) != null) {
                        obj2 = q.A();
                        rVar = q;
                        z = true;
                        break;
                    }
                    q.C();
                    rVar2 = q;
                }
            }
            if (obj2 != b.d && !(obj2 instanceof i)) {
                this.size = i;
                Object[] objArr2 = this.h;
                objArr2[(this.i + i) % objArr2.length] = obj2;
            }
            this.i = (this.i + 1) % this.h.length;
            k8.q qVar = k8.q.a;
            if (z) {
                kotlin.jvm.internal.l.b(rVar);
                rVar.z();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
