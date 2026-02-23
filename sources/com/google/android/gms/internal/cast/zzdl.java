package com.google.android.gms.internal.cast;

import android.view.Display;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdl implements h {
    private final Status zza;
    private final Display zzb;

    public zzdl(Display display) {
        this.zza = Status.k;
        this.zzb = display;
    }

    public final Display getPresentationDisplay() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public zzdl(Status status) {
        this.zza = status;
        this.zzb = null;
    }
}
