package kotlinx.coroutines.scheduling;

import G8.P;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class k extends h {
    public final Runnable d;

    public k(Runnable runnable, long j, i iVar) {
        super(j, iVar);
        this.d = runnable;
    }

    public void run() {
        try {
            this.d.run();
        } finally {
            this.c.a();
        }
    }

    public String toString() {
        return "Task[" + P.a(this.d) + '@' + P.b(this.d) + ", " + this.a + ", " + this.c + ']';
    }
}
