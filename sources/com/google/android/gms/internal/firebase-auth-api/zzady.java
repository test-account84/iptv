package com.google.android.gms.internal.firebase-auth-api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzady extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzadu zzb;

    public zzady(zzadu zzaduVar, String str) {
        this.zzb = zzaduVar;
        this.zza = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).I() == 0) {
                String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                zzaeb zzaebVar = (zzaeb) zzadu.zza(this.zzb).get(this.zza);
                if (zzaebVar == null) {
                    zzadu.zza().c("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String zza = zzadu.zza(str);
                    zzaebVar.zze = zza;
                    if (zza == null) {
                        zzadu.zza().c("Unable to extract verification code.", new Object[0]);
                    } else if (!zzag.zzc(zzaebVar.zzd)) {
                        zzadu.zza(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
