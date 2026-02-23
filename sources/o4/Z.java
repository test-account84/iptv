package o4;

import android.content.Context;
import android.os.IBinder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class z {
    private final Context zza;
    private final String zzb;
    private final c0 zzc = new c0(this, null);

    public z(Context context, String str) {
        this.zza = ((Context) com.google.android.gms.common.internal.r.m(context)).getApplicationContext();
        this.zzb = com.google.android.gms.common.internal.r.g(str);
    }

    public abstract w createSession(String str);

    public final String getCategory() {
        return this.zzb;
    }

    public final Context getContext() {
        return this.zza;
    }

    public abstract boolean isSessionRecoverable();

    public final IBinder zza() {
        return this.zzc;
    }
}
