package i;

import P.S;
import P.T;
import P.U;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h {
    public Interpolator c;
    public T d;
    public boolean e;
    public long b = -1;
    public final U f = new a();
    public final ArrayList a = new ArrayList();

    public class a extends U {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == h.this.a.size()) {
                T t = h.this.d;
                if (t != null) {
                    t.b(null);
                }
                d();
            }
        }

        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            T t = h.this.d;
            if (t != null) {
                t.c(null);
            }
        }

        public void d() {
            this.b = 0;
            this.a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((S) it.next()).c();
            }
            this.e = false;
        }
    }

    public void b() {
        this.e = false;
    }

    public h c(S s) {
        if (!this.e) {
            this.a.add(s);
        }
        return this;
    }

    public h d(S s, S s2) {
        this.a.add(s);
        s2.l(s.d());
        this.a.add(s2);
        return this;
    }

    public h e(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public h g(T t) {
        if (!this.e) {
            this.d = t;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            S s = (S) it.next();
            long j = this.b;
            if (j >= 0) {
                s.h(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                s.i(interpolator);
            }
            if (this.d != null) {
                s.j(this.f);
            }
            s.n();
        }
        this.e = true;
    }
}
