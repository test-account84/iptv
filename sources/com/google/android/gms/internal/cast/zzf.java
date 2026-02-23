package com.google.android.gms.internal.cast;

import A2.a;
import C2.u;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Locale;
import java.util.UUID;
import n4.C;
import o4.e;
import o4.x;
import org.checkerframework.dataflow.qual.Pure;
import t4.A;
import t4.H;
import z2.b;
import z2.c;
import z2.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzf {

    @VisibleForTesting
    f zza;
    private final Context zzb;
    private final H zzc;
    private final x zzd;
    private final zzbm zze;
    private final zzae zzf;
    private int zzh = 1;
    private final String zzg = UUID.randomUUID().toString();

    private zzf(Context context, H h, x xVar, zzbm zzbmVar, zzae zzaeVar) {
        this.zzb = context;
        this.zzc = h;
        this.zzd = xVar;
        this.zze = zzbmVar;
        this.zzf = zzaeVar;
    }

    public static zzf zza(Context context, H h, x xVar, zzbm zzbmVar, zzae zzaeVar) {
        return new zzf(context, h, xVar, zzbmVar, zzaeVar);
    }

    public final /* synthetic */ void zzb(String str, SharedPreferences sharedPreferences, Bundle bundle) {
        r.m(this.zzd);
        x xVar = this.zzd;
        zzbm zzbmVar = this.zze;
        zzk zzkVar = new zzk(sharedPreferences, this, bundle, str);
        this.zzf.zze(zzkVar.zzc());
        xVar.a(new zzi(zzkVar), e.class);
        if (zzbmVar != null) {
            zzbmVar.zzm(new zzj(zzkVar));
        }
    }

    public final void zzc(Bundle bundle) {
        boolean z = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED");
        boolean z2 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED");
        if (z || z2) {
            String packageName = this.zzb.getPackageName();
            String format = String.format(Locale.ROOT, "%s.%s", new Object[]{packageName, "client_cast_analytics_data"});
            this.zzh = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0 ? 1 : 2;
            u.f(this.zzb);
            this.zza = u.c().g(a.g).a("CAST_SENDER_SDK", zzmq.class, b.b("proto"), zze.zza);
            SharedPreferences sharedPreferences = this.zzb.getApplicationContext().getSharedPreferences(format, 0);
            if (z) {
                H h = this.zzc;
                h.doRead(t.a().b(new A(h, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"})).d(C.g).c(false).e(8426).a()).addOnSuccessListener(new zzd(this, packageName, sharedPreferences));
            }
            if (z2) {
                r.m(sharedPreferences);
                zzr.zza(sharedPreferences, this, packageName).zze();
                zzr.zzd(zzln.zzf);
            }
            zzp.zzg(this, packageName);
        }
    }

    @Pure
    public final void zzd(zzmq zzmqVar, int i) {
        zzmp zzd = zzmq.zzd(zzmqVar);
        zzd.zzk(this.zzg);
        zzd.zzf(this.zzg);
        zzmq zzmqVar2 = (zzmq) zzd.zzp();
        int i2 = this.zzh;
        int i3 = i2 - 1;
        c cVar = null;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            cVar = c.f(i - 1, zzmqVar2);
        } else if (i3 == 1) {
            cVar = c.d(i - 1, zzmqVar2);
        }
        r.m(cVar);
        f fVar = this.zza;
        if (fVar != null) {
            fVar.a(cVar);
        }
    }
}
