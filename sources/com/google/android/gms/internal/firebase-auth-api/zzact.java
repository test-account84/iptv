package com.google.android.gms.internal.firebase-auth-api;

import A5.f;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import d.D;
import h6.i;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzact {
    private Context zza;
    private zzadp zzb;
    private String zzc;
    private final f zzd;
    private boolean zze;
    private String zzf;

    public zzact(f fVar, String str) {
        this(fVar.l(), fVar, str);
    }

    private static String zza(f fVar) {
        D.a(FirebaseAuth.getInstance(fVar).B().get());
        return null;
    }

    private static String zzb(f fVar) {
        i iVar = (i) FirebaseAuth.getInstance(fVar).C().get();
        if (iVar != null) {
            try {
                return (String) Tasks.await(iVar.a());
            } catch (InterruptedException | ExecutionException e) {
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: " + e.getMessage());
            }
        }
        return null;
    }

    public zzact(Context context, f fVar, String str) {
        this.zze = false;
        this.zza = (Context) r.m(context);
        this.zzd = (f) r.m(fVar);
        this.zzc = String.format("Android/%s/%s", new Object[]{"Fallback", str});
    }

    public final void zza(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }

    public final void zzb(String str) {
        this.zzf = str;
    }

    public final void zza(URLConnection uRLConnection) {
        StringBuilder sb;
        String str;
        if (this.zze) {
            String str2 = this.zzc;
            sb = new StringBuilder();
            sb.append(str2);
            str = "/FirebaseUI-Android";
        } else {
            String str3 = this.zzc;
            sb = new StringBuilder();
            sb.append(str3);
            str = "/FirebaseCore-Android";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (this.zzb == null) {
            this.zzb = new zzadp(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzacw.zza());
        uRLConnection.setRequestProperty("X-Client-Version", sb2);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.p().c());
        uRLConnection.setRequestProperty("X-Firebase-Client", zzb(this.zzd));
        String zza = zza(this.zzd);
        if (!TextUtils.isEmpty(zza)) {
            uRLConnection.setRequestProperty("X-Firebase-AppCheck", zza);
        }
        this.zzf = null;
    }
}
