package L;

import android.os.CancellationSignal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e {
    public boolean a;
    public b b;
    public Object c;
    public boolean d;

    public static class a {
        public static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface b {
        void a();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.a) {
                    return;
                }
                this.a = true;
                this.d = true;
                b bVar = this.b;
                Object obj = this.c;
                if (bVar != null) {
                    try {
                        bVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    a.a(obj);
                }
                synchronized (this) {
                    this.d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public Object b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.c == null) {
                    CancellationSignal b2 = a.b();
                    this.c = b2;
                    if (this.a) {
                        a.a(b2);
                    }
                }
                obj = this.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void d(b bVar) {
        synchronized (this) {
            try {
                e();
                if (this.b == bVar) {
                    return;
                }
                this.b = bVar;
                if (this.a && bVar != null) {
                    bVar.a();
                }
            } finally {
            }
        }
    }

    public final void e() {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
