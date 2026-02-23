package M4;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c3 implements Runnable {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ t3 c;

    public c3(t3 t3Var, Bundle bundle) {
        this.c = t3Var;
        this.a = bundle;
    }

    public final void run() {
        t3 t3Var = this.c;
        Bundle bundle = this.a;
        t3Var.h();
        t3Var.i();
        com.google.android.gms.common.internal.r.m(bundle);
        String g = com.google.android.gms.common.internal.r.g(bundle.getString("name"));
        if (!t3Var.a.o()) {
            t3Var.a.d().v().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            t3Var.a.L().s(new d(bundle.getString("app_id"), "", new V4(g, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), t3Var.a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
