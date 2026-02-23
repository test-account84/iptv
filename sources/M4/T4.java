package M4;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzqo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class t4 implements Runnable {
    public final /* synthetic */ u4 a;

    public /* synthetic */ t4(u4 u4Var) {
        this.a = u4Var;
    }

    public final void run() {
        u4 u4Var = this.a;
        v4 v4Var = u4Var.d;
        long j = u4Var.a;
        long j2 = u4Var.c;
        v4Var.b.h();
        v4Var.b.a.d().q().a("Application going to the background");
        v4Var.b.a.F().r.a(true);
        v4Var.b.s(true);
        if (!v4Var.b.a.z().D()) {
            v4Var.b.f.b(j2);
            v4Var.b.f.d(false, false, j2);
        }
        zzqo.zzc();
        if (v4Var.b.a.z().B(null, m1.D0)) {
            v4Var.b.a.d().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(j));
        } else {
            v4Var.b.a.I().v("auto", "_ab", j, new Bundle());
        }
    }
}
