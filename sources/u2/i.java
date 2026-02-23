package U2;

import java.util.ArrayDeque;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class i implements d {
    public final Thread a;
    public final Object b = new Object();
    public final ArrayDeque c = new ArrayDeque();
    public final ArrayDeque d = new ArrayDeque();
    public final g[] e;
    public final com.google.android.exoplayer2.decoder.a[] f;
    public int g;
    public int h;
    public g i;
    public f j;
    public boolean k;
    public boolean l;
    public int m;

    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        public void run() {
            i.e(i.this);
        }
    }

    public i(g[] gVarArr, com.google.android.exoplayer2.decoder.a[] aVarArr) {
        this.e = gVarArr;
        this.g = gVarArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = g();
        }
        this.f = aVarArr;
        this.h = aVarArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f[i2] = h();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.a = aVar;
        aVar.start();
    }

    public static /* synthetic */ void e(i iVar) {
        iVar.t();
    }

    public final boolean f() {
        return !this.c.isEmpty() && this.h > 0;
    }

    public final void flush() {
        synchronized (this.b) {
            try {
                this.k = true;
                this.m = 0;
                g gVar = this.i;
                if (gVar != null) {
                    q(gVar);
                    this.i = null;
                }
                while (!this.c.isEmpty()) {
                    q((g) this.c.removeFirst());
                }
                while (!this.d.isEmpty()) {
                    ((com.google.android.exoplayer2.decoder.a) this.d.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract g g();

    public abstract com.google.android.exoplayer2.decoder.a h();

    public abstract f i(Throwable th);

    public abstract f j(g gVar, com.google.android.exoplayer2.decoder.a aVar, boolean z);

    public final boolean k() {
        f i;
        synchronized (this.b) {
            while (!this.l && !f()) {
                try {
                    this.b.wait();
                } finally {
                }
            }
            if (this.l) {
                return false;
            }
            g gVar = (g) this.c.removeFirst();
            com.google.android.exoplayer2.decoder.a[] aVarArr = this.f;
            int i2 = this.h - 1;
            this.h = i2;
            com.google.android.exoplayer2.decoder.a aVar = aVarArr[i2];
            boolean z = this.k;
            this.k = false;
            if (gVar.isEndOfStream()) {
                aVar.addFlag(4);
            } else {
                if (gVar.isDecodeOnly()) {
                    aVar.addFlag(Integer.MIN_VALUE);
                }
                if (gVar.isFirstSample()) {
                    aVar.addFlag(134217728);
                }
                try {
                    i = j(gVar, aVar, z);
                } catch (OutOfMemoryError | RuntimeException e) {
                    i = i(e);
                }
                if (i != null) {
                    synchronized (this.b) {
                        this.j = i;
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                try {
                    if (this.k) {
                        aVar.release();
                    } else if (aVar.isDecodeOnly()) {
                        this.m++;
                        aVar.release();
                    } else {
                        aVar.skippedOutputBufferCount = this.m;
                        this.m = 0;
                        this.d.addLast(aVar);
                    }
                    q(gVar);
                } finally {
                }
            }
            return true;
        }
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final g d() {
        g gVar;
        synchronized (this.b) {
            o();
            d4.a.g(this.i == null);
            int i = this.g;
            if (i == 0) {
                gVar = null;
            } else {
                g[] gVarArr = this.e;
                int i2 = i - 1;
                this.g = i2;
                gVar = gVarArr[i2];
            }
            this.i = gVar;
        }
        return gVar;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final com.google.android.exoplayer2.decoder.a b() {
        synchronized (this.b) {
            try {
                o();
                if (this.d.isEmpty()) {
                    return null;
                }
                return (com.google.android.exoplayer2.decoder.a) this.d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n() {
        if (f()) {
            this.b.notify();
        }
    }

    public final void o() {
        f fVar = this.j;
        if (fVar != null) {
            throw fVar;
        }
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void c(g gVar) {
        synchronized (this.b) {
            o();
            d4.a.a(gVar == this.i);
            this.c.addLast(gVar);
            n();
            this.i = null;
        }
    }

    public final void q(g gVar) {
        gVar.clear();
        g[] gVarArr = this.e;
        int i = this.g;
        this.g = i + 1;
        gVarArr[i] = gVar;
    }

    public void r(com.google.android.exoplayer2.decoder.a aVar) {
        synchronized (this.b) {
            s(aVar);
            n();
        }
    }

    public void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void s(com.google.android.exoplayer2.decoder.a aVar) {
        aVar.clear();
        com.google.android.exoplayer2.decoder.a[] aVarArr = this.f;
        int i = this.h;
        this.h = i + 1;
        aVarArr[i] = aVar;
    }

    public final void t() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (k());
    }

    public final void u(int i) {
        d4.a.g(this.g == this.e.length);
        for (g gVar : this.e) {
            gVar.e(i);
        }
    }
}
