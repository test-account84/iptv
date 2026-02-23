package com.google.android.gms.internal.location;

import J4.u;
import J4.v;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzl extends a {
    public static final Parcelable.Creator CREATOR = new zzm();
    final int zza;
    final zzj zzb;
    final v zzc;
    final zzai zzd;

    public zzl(int i, zzj zzjVar, IBinder iBinder, IBinder iBinder2) {
        this.zza = i;
        this.zzb = zzjVar;
        zzai zzaiVar = null;
        this.zzc = iBinder == null ? null : u.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzaiVar = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzag(iBinder2);
        }
        this.zzd = zzaiVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.l(parcel, 1, this.zza);
        c.r(parcel, 2, this.zzb, i, false);
        v vVar = this.zzc;
        c.k(parcel, 3, vVar == null ? null : vVar.asBinder(), false);
        zzai zzaiVar = this.zzd;
        c.k(parcel, 4, zzaiVar != null ? zzaiVar.asBinder() : null, false);
        c.b(parcel, a);
    }
}
