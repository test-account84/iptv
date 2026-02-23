package q4;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h extends zzb implements i {
    public static i A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
        return queryLocalInterface instanceof i ? (i) queryLocalInterface : new g(iBinder);
    }
}
