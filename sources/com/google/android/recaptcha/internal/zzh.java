package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import java.util.Map;
import k8.i;
import k8.m;
import l8.B;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzh extends Exception {

    @NotNull
    public static final zzg zza = new zzg(null);

    @NotNull
    private static final Map zzb;

    @NotNull
    private final zzf zzc;

    @NotNull
    private final zzd zzd;

    @NotNull
    private final Map zze = B.e(new i[]{m.a(zzf.zze, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, null, 2, null)), m.a(zzf.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, null, 2, null)), m.a(zzf.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, null, 2, null)), m.a(zzf.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, null, 2, null)), m.a(zzf.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, null, 2, null)), m.a(zzf.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, null, 2, null))});

    static {
        i a = m.a(zzmf.zzc, new zzh(zzf.zze, zzd.zzm));
        zzmf zzmfVar = zzmf.zzd;
        zzf zzfVar = zzf.zzc;
        zzb = B.e(new i[]{a, m.a(zzmfVar, new zzh(zzfVar, zzd.zzk)), m.a(zzmf.zze, new zzh(zzf.zzf, zzd.zzn)), m.a(zzmf.zzf, new zzh(zzf.zzg, zzd.zzo)), m.a(zzmf.zzi, new zzh(zzf.zzh, zzd.zzp)), m.a(zzmf.zzh, new zzh(zzf.zzi, zzd.zzq)), m.a(zzmf.zzj, new zzh(zzfVar, zzd.zzv))});
    }

    public zzh(@NotNull zzf zzfVar, @NotNull zzd zzdVar) {
        this.zzc = zzfVar;
        this.zzd = zzdVar;
    }

    public static final /* synthetic */ Map zzd() {
        return zzb;
    }

    @NotNull
    public final zzd zza() {
        return this.zzd;
    }

    @NotNull
    public final zzf zzb() {
        return this.zzc;
    }

    @NotNull
    public final RecaptchaException zzc() {
        RecaptchaException recaptchaException = (RecaptchaException) this.zze.get(this.zzc);
        return recaptchaException == null ? new RecaptchaException(RecaptchaErrorCode.UNKNOWN_ERROR, null, 2, null) : recaptchaException;
    }
}
