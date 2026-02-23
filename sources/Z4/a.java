package z4;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends zaa implements IInterface {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void A(v vVar) {
        Parcel zaa = zaa();
        zac.zac(zaa, vVar);
        zad(1, zaa);
    }
}
