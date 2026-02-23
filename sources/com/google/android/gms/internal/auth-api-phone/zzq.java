package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzq extends h.a {
    private final /* synthetic */ TaskCompletionSource zza;

    public zzq(zzn zznVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onResult(Status status) {
        if (status.I() == 6) {
            this.zza.trySetException(b.a(status));
        } else {
            u.a(status, this.zza);
        }
    }
}
