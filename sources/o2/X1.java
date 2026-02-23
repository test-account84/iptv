package O2;

import android.os.Looper;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x1 {
    public final b a;
    public final a b;
    public final d4.e c;
    public final Q1 d;
    public int e;
    public Object f;
    public Looper g;
    public int h;
    public long i = -9223372036854775807L;
    public boolean j = true;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    public interface a {
        void d(x1 x1Var);
    }

    public interface b {
        void n(int i, Object obj);
    }

    public x1(a aVar, b bVar, Q1 q1, int i, d4.e eVar, Looper looper) {
        this.b = aVar;
        this.a = bVar;
        this.d = q1;
        this.g = looper;
        this.c = eVar;
        this.h = i;
    }

    public synchronized boolean a(long j) {
        boolean z;
        try {
            d4.a.g(this.k);
            d4.a.g(this.g.getThread() != Thread.currentThread());
            long b2 = this.c.b() + j;
            while (true) {
                z = this.m;
                if (z || j <= 0) {
                    break;
                }
                this.c.d();
                wait(j);
                j = b2 - this.c.b();
            }
            if (!z) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.l;
    }

    public boolean b() {
        return this.j;
    }

    public Looper c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public Object e() {
        return this.f;
    }

    public long f() {
        return this.i;
    }

    public b g() {
        return this.a;
    }

    public Q1 h() {
        return this.d;
    }

    public int i() {
        return this.e;
    }

    public synchronized boolean j() {
        return this.n;
    }

    public synchronized void k(boolean z) {
        this.l = z | this.l;
        this.m = true;
        notifyAll();
    }

    public x1 l() {
        d4.a.g(!this.k);
        if (this.i == -9223372036854775807L) {
            d4.a.a(this.j);
        }
        this.k = true;
        this.b.d(this);
        return this;
    }

    public x1 m(Object obj) {
        d4.a.g(!this.k);
        this.f = obj;
        return this;
    }

    public x1 n(int i) {
        d4.a.g(!this.k);
        this.e = i;
        return this;
    }
}
