package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.BasePendingResult;
import o4.e;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbp extends BasePendingResult {
    private final zzbq zza;

    public zzbp(zzbq zzbqVar) {
        super(null);
        this.zza = zzbqVar;
    }

    public final h createFailedResult(Status status) {
        b bVar = e.o;
        return status;
    }
}
