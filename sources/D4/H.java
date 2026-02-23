package d4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h {
    public final e a;
    public boolean b;

    public h() {
        this(e.a);
    }

    public synchronized void a() {
        while (!this.b) {
            wait();
        }
    }

    public synchronized boolean b(long j) {
        if (j <= 0) {
            return this.b;
        }
        long b = this.a.b();
        long j2 = j + b;
        if (j2 < b) {
            a();
        } else {
            while (!this.b && b < j2) {
                wait(j2 - b);
                b = this.a.b();
            }
        }
        return this.b;
    }

    public synchronized void c() {
        boolean z = false;
        while (!this.b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z;
        z = this.b;
        this.b = false;
        return z;
    }

    public synchronized boolean e() {
        return this.b;
    }

    public synchronized boolean f() {
        if (this.b) {
            return false;
        }
        this.b = true;
        notifyAll();
        return true;
    }

    public h(e eVar) {
        this.a = eVar;
    }
}
