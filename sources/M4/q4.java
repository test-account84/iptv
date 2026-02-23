package M4;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q4 {
    public final Context a;

    public q4(Context context) {
        com.google.android.gms.common.internal.r.m(context);
        this.a = context;
    }

    public final int a(Intent intent, int i, int i2) {
        l2 H = l2.H(this.a, null, null);
        z1 d = H.d();
        if (intent == null) {
            d.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        H.b();
        d.v().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            h(new n4(this, i2, d, intent));
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().r().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new D2(S4.f0(this.a), null);
        }
        k().w().b("onBind received unknown action", action);
        return null;
    }

    public final /* synthetic */ void c(int i, z1 z1Var, Intent intent) {
        if (this.a.c(i)) {
            z1Var.v().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            k().v().a("Completed wakeful intent.");
            this.a.d(intent);
        }
    }

    public final /* synthetic */ void d(z1 z1Var, JobParameters jobParameters) {
        z1Var.v().a("AppMeasurementJobService processed last upload request.");
        this.a.e(jobParameters, false);
    }

    public final void e() {
        l2 H = l2.H(this.a, null, null);
        z1 d = H.d();
        H.b();
        d.v().a("Local AppMeasurementService is starting up");
    }

    public final void f() {
        l2 H = l2.H(this.a, null, null);
        z1 d = H.d();
        H.b();
        d.v().a("Local AppMeasurementService is shutting down");
    }

    public final void g(Intent intent) {
        if (intent == null) {
            k().r().a("onRebind called with null intent");
        } else {
            k().v().b("onRebind called. action", intent.getAction());
        }
    }

    public final void h(Runnable runnable) {
        S4 f0 = S4.f0(this.a);
        f0.f().z(new o4(this, f0, runnable));
    }

    public final boolean i(JobParameters jobParameters) {
        l2 H = l2.H(this.a, null, null);
        z1 d = H.d();
        String string = jobParameters.getExtras().getString("action");
        H.b();
        d.v().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        h(new m4(this, d, jobParameters));
        return true;
    }

    public final boolean j(Intent intent) {
        if (intent == null) {
            k().r().a("onUnbind called with null intent");
            return true;
        }
        k().v().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final z1 k() {
        return l2.H(this.a, null, null).d();
    }
}
