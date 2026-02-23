package P4;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends zaa implements IInterface {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void A(int i) {
        Parcel zaa = zaa();
        zaa.writeInt(i);
        zac(7, zaa);
    }

    public final void E(com.google.android.gms.common.internal.k kVar, int i, boolean z) {
        Parcel zaa = zaa();
        zac.zad(zaa, kVar);
        zaa.writeInt(i);
        zaa.writeInt(z ? 1 : 0);
        zac(9, zaa);
    }

    public final void Z(j jVar, f fVar) {
        Parcel zaa = zaa();
        zac.zac(zaa, jVar);
        zac.zad(zaa, fVar);
        zac(12, zaa);
    }
}
