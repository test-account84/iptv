package com.google.android.gms.internal.appset;

import C4.h;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import i4.b;
import i4.c;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzl implements b {
    private static b zza;
    private final Context zzb;
    private boolean zzc;
    private final ScheduledExecutorService zzd;
    private final ExecutorService zze;

    public zzl(Context context) {
        this.zzc = false;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.zzd = newSingleThreadScheduledExecutor;
        this.zze = Executors.newSingleThreadExecutor();
        this.zzb = context;
        if (this.zzc) {
            return;
        }
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new zzj(this, null), 0L, 86400L, TimeUnit.SECONDS);
        this.zzc = true;
    }

    public static /* bridge */ /* synthetic */ Context zzb(zzl zzlVar) {
        return zzlVar.zzb;
    }

    public static synchronized b zzc(Context context) {
        b bVar;
        synchronized (zzl.class) {
            try {
                r.n(context, "Context must not be null");
                if (zza == null) {
                    zza = new zzl(context.getApplicationContext());
                }
                bVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static final void zze(Context context) {
        if (!zzf(context).edit().remove("app_set_id").commit()) {
            String valueOf = String.valueOf(context.getPackageName());
            Log.e("AppSet", valueOf.length() != 0 ? "Failed to clear app set ID generated for App ".concat(valueOf) : new String("Failed to clear app set ID generated for App "));
        }
        if (zzf(context).edit().remove("app_set_id_last_used_time").commit()) {
            return;
        }
        String valueOf2 = String.valueOf(context.getPackageName());
        Log.e("AppSet", valueOf2.length() != 0 ? "Failed to clear app set ID last used time for App ".concat(valueOf2) : new String("Failed to clear app set ID last used time for App "));
    }

    private static final SharedPreferences zzf(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    private static final void zzg(Context context) throws zzk {
        if (zzf(context).edit().putLong("app_set_id_last_used_time", h.c().a()).commit()) {
            return;
        }
        String valueOf = String.valueOf(context.getPackageName());
        Log.e("AppSet", valueOf.length() != 0 ? "Failed to store app set ID last used time for App ".concat(valueOf) : new String("Failed to store app set ID last used time for App "));
        throw new zzk("Failed to store the app set ID last used time.");
    }

    public final Task getAppSetIdInfo() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zze.execute(new zzh(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final long zza() {
        long j = zzf(this.zzb).getLong("app_set_id_last_used_time", -1L);
        if (j != -1) {
            return j + 33696000000L;
        }
        return -1L;
    }

    public final /* synthetic */ void zzd(TaskCompletionSource taskCompletionSource) {
        String string = zzf(this.zzb).getString("app_set_id", (String) null);
        long zza2 = zza();
        if (string == null || h.c().a() > zza2) {
            string = UUID.randomUUID().toString();
            try {
                Context context = this.zzb;
                if (!zzf(context).edit().putString("app_set_id", string).commit()) {
                    String valueOf = String.valueOf(context.getPackageName());
                    Log.e("AppSet", valueOf.length() != 0 ? "Failed to store app set ID generated for App ".concat(valueOf) : new String("Failed to store app set ID generated for App "));
                    throw new zzk("Failed to store the app set ID.");
                }
                zzg(context);
                Context context2 = this.zzb;
                if (!zzf(context2).edit().putLong("app_set_id_creation_time", h.c().a()).commit()) {
                    String valueOf2 = String.valueOf(context2.getPackageName());
                    Log.e("AppSet", valueOf2.length() != 0 ? "Failed to store app set ID creation time for App ".concat(valueOf2) : new String("Failed to store app set ID creation time for App "));
                    throw new zzk("Failed to store the app set ID creation time.");
                }
            } catch (zzk e) {
                taskCompletionSource.setException(e);
                return;
            }
        } else {
            try {
                zzg(this.zzb);
            } catch (zzk e2) {
                taskCompletionSource.setException(e2);
                return;
            }
        }
        taskCompletionSource.setResult(new c(string, 1));
    }
}
