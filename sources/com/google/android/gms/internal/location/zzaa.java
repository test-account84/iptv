package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaa extends a implements h {
    private final Status zzb;
    public static final zzaa zza = new zzaa(Status.k);
    public static final Parcelable.Creator CREATOR = new zzab();

    public zzaa(Status status) {
        this.zzb = status;
    }

    public final Status getStatus() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.r(parcel, 1, this.zzb, i, false);
        c.b(parcel, a);
    }
}
