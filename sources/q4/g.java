package q4;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends zza implements i {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
    }

    public final Bitmap l(Uri uri) {
        Parcel zza = zza();
        zzc.zzc(zza, uri);
        Parcel zzb = zzb(1, zza);
        Bitmap zza2 = zzc.zza(zzb, Bitmap.CREATOR);
        zzb.recycle();
        return zza2;
    }
}
