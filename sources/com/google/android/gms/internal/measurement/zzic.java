package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzic implements zzhk {
    private static final Map zza = new s.a();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    public static zzic zza(Context context, String str, Runnable runnable) {
        zzic zzicVar;
        if (zzhb.zzb()) {
            throw null;
        }
        synchronized (zzic.class) {
            try {
                zzicVar = (zzic) zza.get((Object) null);
                if (zzicVar == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzicVar;
    }

    public static synchronized void zzc() {
        synchronized (zzic.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (it.hasNext()) {
                SharedPreferences sharedPreferences = ((zzic) it.next()).zzb;
                throw null;
            }
            map.clear();
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
