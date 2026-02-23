package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzadz extends zzacd {
    private final String zza;
    private final /* synthetic */ zzadu zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzadz(zzadu zzaduVar, zzacd zzacdVar, String str) {
        super(zzacdVar);
        this.zzb = zzaduVar;
        this.zza = str;
    }

    public final void zza(Status status) {
        zzadu.zza().c("SMS verification code request failed: " + c.a(status.I()) + " " + status.J(), new Object[0]);
        zzaeb zzaebVar = (zzaeb) zzadu.zza(this.zzb).get(this.zza);
        if (zzaebVar == null) {
            return;
        }
        Iterator it = zzaebVar.zzb.iterator();
        while (it.hasNext()) {
            ((zzacd) it.next()).zza(status);
        }
        this.zzb.zzc(this.zza);
    }

    public final void zzb(String str) {
        zzadu.zza().a("onCodeSent", new Object[0]);
        zzaeb zzaebVar = (zzaeb) zzadu.zza(this.zzb).get(this.zza);
        if (zzaebVar == null) {
            return;
        }
        Iterator it = zzaebVar.zzb.iterator();
        while (it.hasNext()) {
            ((zzacd) it.next()).zzb(str);
        }
        zzaebVar.zzg = true;
        zzaebVar.zzd = str;
        if (zzaebVar.zza <= 0) {
            zzadu.zzc(this.zzb, this.zza);
        } else if (!zzaebVar.zzc) {
            zzadu.zzb(this.zzb, this.zza);
        } else {
            if (zzag.zzc(zzaebVar.zze)) {
                return;
            }
            zzadu.zza(this.zzb, this.zza);
        }
    }
}
