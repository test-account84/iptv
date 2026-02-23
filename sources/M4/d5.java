package M4;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d5 implements O2 {
    public final zzci a;
    public final /* synthetic */ AppMeasurementDynamiteService b;

    public d5(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzciVar) {
        this.b = appMeasurementDynamiteService;
        this.a = zzciVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        try {
            this.a.zze(str, str2, bundle, j);
        } catch (RemoteException e) {
            l2 l2Var = this.b.a;
            if (l2Var != null) {
                l2Var.d().w().b("Event interceptor threw exception", e);
            }
        }
    }
}
