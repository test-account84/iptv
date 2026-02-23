package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhn implements zzhk {
    private static zzhn zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzhn() {
        this.zzb = null;
        this.zzc = null;
    }

    public static zzhn zza(Context context) {
        zzhn zzhnVar;
        synchronized (zzhn.class) {
            try {
                if (zza == null) {
                    zza = E.d.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhn(context) : new zzhn();
                }
                zzhnVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhnVar;
    }

    public static synchronized void zze() {
        Context context;
        synchronized (zzhn.class) {
            try {
                zzhn zzhnVar = zza;
                if (zzhnVar != null && (context = zzhnVar.zzb) != null && zzhnVar.zzc != null) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
                zza = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb(String str) {
        Context context = this.zzb;
        if (context != null && !zzhb.zza(context)) {
            try {
                return (String) zzhi.zza(new zzhl(this, str));
            } catch (NullPointerException | SecurityException | IllegalStateException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzha.zza(this.zzb.getContentResolver(), str, null);
    }

    private zzhn(Context context) {
        this.zzb = context;
        zzhm zzhmVar = new zzhm(this, null);
        this.zzc = zzhmVar;
        context.getContentResolver().registerContentObserver(zzha.zza, true, zzhmVar);
    }
}
