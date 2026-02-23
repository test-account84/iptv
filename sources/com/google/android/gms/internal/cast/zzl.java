package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzl {
    public String zzb;
    public String zzc;
    public long zzd = zza;
    public int zze = 1;
    public String zzf;
    public int zzg;
    public String zzh;
    public boolean zzi;
    public boolean zzj;
    public int zzk;
    private static final b zzl = new b("ApplicationAnalyticsSession");
    public static long zza = System.currentTimeMillis();

    private zzl(boolean z) {
        this.zzi = z;
    }

    public static zzl zza(boolean z) {
        zzl zzlVar = new zzl(z);
        zza++;
        return zzlVar;
    }

    public static zzl zzb(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return null;
        }
        zzl zzlVar = new zzl(sharedPreferences.getBoolean("is_app_backgrounded", false));
        zzlVar.zzj = sharedPreferences.getBoolean("is_output_switcher_enabled", false);
        if (!sharedPreferences.contains("application_id")) {
            return null;
        }
        zzlVar.zzb = sharedPreferences.getString("application_id", "");
        if (!sharedPreferences.contains("receiver_metrics_id")) {
            return null;
        }
        zzlVar.zzc = sharedPreferences.getString("receiver_metrics_id", "");
        if (!sharedPreferences.contains("analytics_session_id")) {
            return null;
        }
        zzlVar.zzd = sharedPreferences.getLong("analytics_session_id", 0L);
        if (!sharedPreferences.contains("event_sequence_number")) {
            return null;
        }
        zzlVar.zze = sharedPreferences.getInt("event_sequence_number", 0);
        if (!sharedPreferences.contains("receiver_session_id")) {
            return null;
        }
        zzlVar.zzf = sharedPreferences.getString("receiver_session_id", "");
        zzlVar.zzg = sharedPreferences.getInt("device_capabilities", 0);
        zzlVar.zzh = sharedPreferences.getString("device_model_name", "");
        zzlVar.zzk = sharedPreferences.getInt("analytics_session_start_type", 0);
        return zzlVar;
    }

    public final void zzc(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        zzl.a("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("application_id", this.zzb);
        edit.putString("receiver_metrics_id", this.zzc);
        edit.putLong("analytics_session_id", this.zzd);
        edit.putInt("event_sequence_number", this.zze);
        edit.putString("receiver_session_id", this.zzf);
        edit.putInt("device_capabilities", this.zzg);
        edit.putString("device_model_name", this.zzh);
        edit.putInt("analytics_session_start_type", this.zzk);
        edit.putBoolean("is_app_backgrounded", this.zzi);
        edit.putBoolean("is_output_switcher_enabled", this.zzj);
        edit.apply();
    }
}
