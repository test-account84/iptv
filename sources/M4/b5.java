package M4;

import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b5 implements Runnable {
    public final /* synthetic */ zzcf a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ AppMeasurementDynamiteService e;

    public b5(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, String str, String str2) {
        this.e = appMeasurementDynamiteService;
        this.a = zzcfVar;
        this.c = str;
        this.d = str2;
    }

    public final void run() {
        this.e.a.L().T(this.a, this.c, this.d);
    }
}
