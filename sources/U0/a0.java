package u0;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a0 {
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Runnable b;
    public long c;
    public long d;
    public boolean e;

    public a0(Runnable runnable) {
        this.b = runnable;
    }

    public boolean a() {
        if (this.e) {
            long j = this.c;
            if (j > 0) {
                this.a.postDelayed(this.b, j);
            }
        }
        return this.e;
    }

    public void b(boolean z, long j) {
        if (z) {
            long j2 = this.d;
            if (j2 - j >= 30000) {
                return;
            }
            this.c = Math.max(this.c, (j + 30000) - j2);
            this.e = true;
        }
    }

    public void c() {
        this.c = 0L;
        this.e = false;
        this.d = SystemClock.elapsedRealtime();
        this.a.removeCallbacks(this.b);
    }
}
