package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaf {

    @NotNull
    private final zzkw zza;

    @NotNull
    private final String zzb;

    @NotNull
    private final String zzc;

    @NotNull
    private final String zzd;

    @Nullable
    private final String zze = null;

    public zzaf(@NotNull zzkw zzkwVar, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        this.zza = zzkwVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf zzafVar = (zzaf) obj;
        return zzafVar.zza == this.zza && l.a(zzafVar.zzb, this.zzb) && l.a(zzafVar.zzc, this.zzc) && l.a(zzafVar.zzd, this.zzd) && l.a((Object) null, (Object) null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    @NotNull
    public final zzkw zza() {
        return this.zza;
    }

    @NotNull
    public final String zzb() {
        return this.zzb;
    }

    @NotNull
    public final String zzc() {
        return this.zzc;
    }

    @NotNull
    public final String zzd() {
        return this.zzd;
    }
}
