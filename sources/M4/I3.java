package M4;

import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i3 implements Runnable {
    public final /* synthetic */ zzcf a;
    public final /* synthetic */ AppMeasurementDynamiteService c;

    public i3(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar) {
        this.c = appMeasurementDynamiteService;
        this.a = zzcfVar;
    }

    public final void run() {
        this.c.a.L().R(this.a);
    }
}
