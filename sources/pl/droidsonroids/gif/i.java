package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i extends j {
    public i(a aVar) {
        super(aVar);
    }

    public void a() {
        a aVar = this.a;
        long q = aVar.h.q(aVar.g);
        if (q >= 0) {
            this.a.d = SystemClock.uptimeMillis() + q;
            if (this.a.isVisible() && this.a.c) {
                a aVar2 = this.a;
                if (!aVar2.m) {
                    aVar2.a.remove(this);
                    a aVar3 = this.a;
                    aVar3.q = aVar3.a.schedule(this, q, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.a.i.isEmpty() && this.a.b() == this.a.h.i() - 1) {
                a aVar4 = this.a;
                aVar4.n.sendEmptyMessageAtTime(aVar4.c(), this.a.d);
            }
        } else {
            a aVar5 = this.a;
            aVar5.d = Long.MIN_VALUE;
            aVar5.c = false;
        }
        if (!this.a.isVisible() || this.a.n.hasMessages(-1)) {
            return;
        }
        this.a.n.sendEmptyMessageAtTime(-1, 0L);
    }
}
