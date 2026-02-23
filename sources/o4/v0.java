package o4;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class v0 extends zzb implements w0 {
    public static w0 A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastContext");
        return queryLocalInterface instanceof w0 ? (w0) queryLocalInterface : new u0(iBinder);
    }
}
