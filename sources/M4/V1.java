package M4;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v1 extends com.google.android.gms.common.internal.c {
    public v1(Context context, Looper looper, c.a aVar, c.b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof p1 ? (p1) queryLocalInterface : new n1(iBinder);
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
