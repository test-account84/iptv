package M4;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f4 implements Runnable {
    public final /* synthetic */ h4 a;

    public f4(h4 h4Var) {
        this.a = h4Var;
    }

    public final void run() {
        i4 i4Var = this.a.d;
        Context c = i4Var.a.c();
        this.a.d.a.b();
        i4.M(i4Var, new ComponentName(c, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
