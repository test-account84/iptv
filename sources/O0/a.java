package o0;

import L.s;
import O.i;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a extends c {
    public final Executor i;
    public volatile a j;
    public volatile a k;
    public long l;
    public long m;
    public Handler n;

    public final class a extends d implements Runnable {
        public final CountDownLatch l = new CountDownLatch(1);
        public boolean m;

        public a() {
        }

        public void g(Object obj) {
            try {
                a.this.B(this, obj);
            } finally {
                this.l.countDown();
            }
        }

        public void h(Object obj) {
            try {
                a.this.C(this, obj);
            } finally {
                this.l.countDown();
            }
        }

        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public Object b(Void... voidArr) {
            try {
                return a.this.H();
            } catch (s e) {
                if (f()) {
                    return null;
                }
                throw e;
            }
        }

        public void run() {
            this.m = false;
            a.this.D();
        }
    }

    public a(Context context) {
        this(context, d.i);
    }

    public void B(a aVar, Object obj) {
        G(obj);
        if (this.k == aVar) {
            v();
            this.m = SystemClock.uptimeMillis();
            this.k = null;
            e();
            D();
        }
    }

    public void C(a aVar, Object obj) {
        if (this.j != aVar) {
            B(aVar, obj);
            return;
        }
        if (j()) {
            G(obj);
            return;
        }
        c();
        this.m = SystemClock.uptimeMillis();
        this.j = null;
        f(obj);
    }

    public void D() {
        if (this.k != null || this.j == null) {
            return;
        }
        if (this.j.m) {
            this.j.m = false;
            this.n.removeCallbacks(this.j);
        }
        if (this.l <= 0 || SystemClock.uptimeMillis() >= this.m + this.l) {
            this.j.c(this.i, null);
        } else {
            this.j.m = true;
            this.n.postAtTime(this.j, this.m + this.l);
        }
    }

    public boolean E() {
        return this.k != null;
    }

    public abstract Object F();

    public abstract void G(Object obj);

    public Object H() {
        return F();
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.j);
            printWriter.print(" waiting=");
            printWriter.println(this.j.m);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.m);
        }
        if (this.l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.c(this.l, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.m, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public boolean n() {
        if (this.j == null) {
            return false;
        }
        if (!this.d) {
            this.g = true;
        }
        if (this.k != null) {
            if (this.j.m) {
                this.j.m = false;
                this.n.removeCallbacks(this.j);
            }
            this.j = null;
            return false;
        }
        if (this.j.m) {
            this.j.m = false;
            this.n.removeCallbacks(this.j);
            this.j = null;
            return false;
        }
        boolean a2 = this.j.a(false);
        if (a2) {
            this.k = this.j;
            A();
        }
        this.j = null;
        return a2;
    }

    public void p() {
        super.p();
        b();
        this.j = new a();
        D();
    }

    public a(Context context, Executor executor) {
        super(context);
        this.m = -10000L;
        this.i = executor;
    }

    public void A() {
    }
}
