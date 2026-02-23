package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzab {
    private final zzj zza;
    private final boolean zzb;
    private final zzah zzc;
    private final int zzd;

    private zzab(zzah zzahVar) {
        this(zzahVar, false, zzn.zza, Integer.MAX_VALUE);
    }

    public static /* bridge */ /* synthetic */ int zza(zzab zzabVar) {
        return zzabVar.zzd;
    }

    public static /* bridge */ /* synthetic */ zzj zzb(zzab zzabVar) {
        return zzabVar.zza;
    }

    private zzab(zzah zzahVar, boolean z, zzj zzjVar, int i) {
        this.zzc = zzahVar;
        this.zzb = false;
        this.zza = zzjVar;
        this.zzd = Integer.MAX_VALUE;
    }

    public static zzab zza(char c) {
        zzl zzlVar = new zzl(c);
        zzy.zza(zzlVar);
        return new zzab(new zzaa(zzlVar));
    }

    public static zzab zza(String str) {
        zzs zza = zzx.zza(str);
        if (!zza.zza("").zzc()) {
            return new zzab(new zzac(zza));
        }
        throw new IllegalArgumentException(zzag.zza("The pattern may not match the empty string: %s", zza));
    }

    public final List zza(CharSequence charSequence) {
        zzy.zza(charSequence);
        Iterator zza = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add((String) zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
