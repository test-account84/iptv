package M4;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzqu;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y4 {
    public final /* synthetic */ z4 a;

    public y4(z4 z4Var) {
        this.a = z4Var;
    }

    public final void a() {
        this.a.h();
        if (this.a.a.F().v(this.a.a.a().a())) {
            this.a.a.F().l.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.a.a.d().v().a("Detected application was in foreground");
                c(this.a.a.a().a(), false);
            }
        }
    }

    public final void b(long j, boolean z) {
        this.a.h();
        z4.p(this.a);
        if (this.a.a.F().v(j)) {
            this.a.a.F().l.a(true);
            zzqu.zzc();
            if (this.a.a.z().B(null, m1.p0)) {
                this.a.a.B().v();
            }
        }
        this.a.a.F().o.b(j);
        if (this.a.a.F().l.b()) {
            c(j, z);
        }
    }

    public final void c(long j, boolean z) {
        this.a.h();
        if (this.a.a.o()) {
            this.a.a.F().o.b(j);
            this.a.a.d().v().b("Session started, time", Long.valueOf(this.a.a.a().b()));
            long j2 = j / 1000;
            this.a.a.I().M("auto", "_sid", Long.valueOf(j2), j);
            this.a.a.F().p.b(j2);
            this.a.a.F().l.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            if (this.a.a.z().B(null, m1.d0) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.a.a.I().v("auto", "_s", j, bundle);
            zzos.zzc();
            if (this.a.a.z().B(null, m1.g0)) {
                String a = this.a.a.F().u.a();
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a);
                this.a.a.I().v("auto", "_ssr", j, bundle2);
            }
        }
    }
}
