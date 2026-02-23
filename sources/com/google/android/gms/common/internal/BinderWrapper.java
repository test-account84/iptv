package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator CREATOR = new i0();
    public final IBinder a;

    public BinderWrapper(IBinder iBinder) {
        this.a = iBinder;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.a);
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, j0 j0Var) {
        this.a = parcel.readStrongBinder();
    }
}
