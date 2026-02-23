package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzn extends e {
    private static final a.g zza;
    private static final a.a zzb;
    private static final a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzr zzrVar = new zzr();
        zzb = zzrVar;
        zzc = new a("SmsCodeAutofill.API", zzrVar, gVar);
    }

    public zzn(Activity activity) {
        super(activity, zzc, (a.d) null, e.a.c);
    }

    public final Task checkPermissionState() {
        return doRead(t.a().d(zzaa.zza).b(new zzp(this)).a());
    }

    public final Task hasOngoingSmsRequest(String str) {
        r.m(str);
        r.b(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(t.a().d(zzaa.zza).b(new zzo(this, str)).a());
    }

    public final Task startSmsCodeRetriever() {
        return doWrite(t.a().d(zzaa.zza).b(new zzm(this)).a());
    }

    public zzn(Context context) {
        super(context, zzc, (a.d) null, e.a.c);
    }
}
