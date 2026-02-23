package v4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new h(parcel.readStrongBinder());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new h[i];
    }
}
