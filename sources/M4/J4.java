package M4;

import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j4 implements Runnable {
    public final /* synthetic */ zzcf a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ AppMeasurementDynamiteService f;

    public j4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, String str, String str2, boolean z) {
        this.f = appMeasurementDynamiteService;
        this.a = zzcfVar;
        this.c = str;
        this.d = str2;
        this.e = z;
    }

    public final void run() {
        this.f.a.L().V(this.a, this.c, this.d, this.e);
    }
}
