package M4;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b3 implements Runnable {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ t3 c;

    public b3(t3 t3Var, Bundle bundle) {
        this.c = t3Var;
        this.a = bundle;
    }

    public final void run() {
        t3 t3Var = this.c;
        Bundle bundle = this.a;
        t3Var.h();
        t3Var.i();
        com.google.android.gms.common.internal.r.m(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        com.google.android.gms.common.internal.r.g(string);
        com.google.android.gms.common.internal.r.g(string2);
        com.google.android.gms.common.internal.r.m(bundle.get("value"));
        if (!t3Var.a.o()) {
            t3Var.a.d().v().a("Conditional property not set since app measurement is disabled");
            return;
        }
        V4 v4 = new V4(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            v y0 = t3Var.a.N().y0(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            t3Var.a.L().s(new d(bundle.getString("app_id"), string2, v4, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), t3Var.a.N().y0(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), y0, bundle.getLong("time_to_live"), t3Var.a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
