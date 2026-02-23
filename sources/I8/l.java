package I8;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.G;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l extends a {
    public final ReentrantLock e;
    public Object f;

    public l(w8.l lVar) {
        super(lVar);
        this.e = new ReentrantLock();
        this.f = b.a;
    }

    public final G C(Object obj) {
        w8.l lVar;
        Object obj2 = this.f;
        G g = null;
        if (obj2 != b.a && (lVar = this.b) != null) {
            g = t.d(lVar, obj2, null, 2, null);
        }
        this.f = obj;
        return g;
    }

    public String f() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return "(value=" + this.f + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    public Object m(Object obj) {
        p p;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            i g = g();
            if (g != null) {
                return g;
            }
            if (this.f == b.a) {
                do {
                    p = p();
                    if (p != null) {
                        if (p instanceof i) {
                            return p;
                        }
                        kotlin.jvm.internal.l.b(p);
                    }
                } while (p.f(obj, null) == null);
                k8.q qVar = k8.q.a;
                reentrantLock.unlock();
                p.d(obj);
                return p.a();
            }
            G C = C(obj);
            if (C == null) {
                return b.b;
            }
            throw C;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean u(n nVar) {
        ReentrantLock reentrantLock = this.e;
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
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return this.f == b.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Object z() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            Object obj = this.f;
            y yVar = b.a;
            if (obj != yVar) {
                this.f = yVar;
                k8.q qVar = k8.q.a;
                return obj;
            }
            Object g = g();
            if (g == null) {
                g = b.d;
            }
            return g;
        } finally {
            reentrantLock.unlock();
        }
    }
}
