package com.google.android.recaptcha.internal;

import G8.L;
import G8.N;
import G8.i;
import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import kotlin.jvm.internal.g;
import l8.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzao implements zzaj {

    @NotNull
    public static final zzak zza = new zzak(null);

    @Nullable
    private static Timer zzb;

    @NotNull
    private final zzap zzc;

    @NotNull
    private final L zzd;

    @NotNull
    private final zzad zze;

    public /* synthetic */ zzao(Context context, zzap zzapVar, L l, int i, g gVar) {
        L zza2 = zzp.zza();
        this.zzc = zzapVar;
        this.zzd = zza2;
        zzad zzc = zzad.zzc();
        zzc = zzc == null ? new zzad(context, null) : zzc;
        zzad.zze(zzc);
        this.zze = zzc;
        zzh();
    }

    public static final /* synthetic */ zzad zza(zzao zzaoVar) {
        return zzaoVar.zze;
    }

    public static final /* synthetic */ Timer zzb() {
        return zzb;
    }

    public static final /* synthetic */ L zzc(zzao zzaoVar) {
        return zzaoVar.zzd;
    }

    public static final /* synthetic */ void zzd(zzao zzaoVar) {
        zzaoVar.zzg();
    }

    public static final /* synthetic */ void zze(Timer timer) {
        zzb = null;
    }

    private final void zzg() {
        for (List list : s.P(this.zze.zzd(), 20, 20, true)) {
            zzkz zzf = zzla.zzf();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzf.zzd(zzkx.zzG(zzeb.zzg().zzj(((zzae) it.next()).zzc())));
            }
            if (this.zzc.zza(((zzla) zzf.zzj()).zzd())) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    this.zze.zzf((zzae) it2.next());
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzal(this), 120000L, 120000L);
        }
    }

    public final void zzf(@NotNull zzkx zzkxVar) {
        i.d(this.zzd, (o8.g) null, (N) null, new zzan(zzkxVar, this, null), 3, (Object) null);
        zzh();
    }
}
