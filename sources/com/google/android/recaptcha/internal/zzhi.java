package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhi extends zzhm {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzhi() {
        super(null);
    }

    private static List zzf(Object obj, long j, int i) {
        ArrayList zzhfVar;
        Collection collection = (List) zzjp.zzf(obj, j);
        if (collection.isEmpty()) {
            zzgv zzhfVar2 = collection instanceof zzhg ? new zzhf(i) : ((collection instanceof zzig) && (collection instanceof zzgv)) ? ((zzgv) collection).zzd(i) : new ArrayList(i);
            zzjp.zzs(obj, j, zzhfVar2);
            return zzhfVar2;
        }
        if (zza.isAssignableFrom(collection.getClass())) {
            zzhfVar = new ArrayList(collection.size() + i);
            zzhfVar.addAll(collection);
        } else {
            if (!(collection instanceof zzjk)) {
                if (!(collection instanceof zzig) || !(collection instanceof zzgv)) {
                    return collection;
                }
                zzgv zzgvVar = (zzgv) collection;
                if (zzgvVar.zzc()) {
                    return collection;
                }
                zzgv zzd = zzgvVar.zzd(collection.size() + i);
                zzjp.zzs(obj, j, zzd);
                return zzd;
            }
            zzhfVar = new zzhf(collection.size() + i);
            zzhfVar.addAll(zzhfVar.size(), (zzjk) collection);
        }
        zzjp.zzs(obj, j, zzhfVar);
        return zzhfVar;
    }

    public final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzjp.zzf(obj, j);
        if (list instanceof zzhg) {
            unmodifiableList = ((zzhg) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzig) && (list instanceof zzgv)) {
                zzgv zzgvVar = (zzgv) list;
                if (zzgvVar.zzc()) {
                    zzgvVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzjp.zzs(obj, j, unmodifiableList);
    }

    public final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzjp.zzf(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzjp.zzs(obj, j, list);
    }

    public /* synthetic */ zzhi(zzhh zzhhVar) {
        super(null);
    }
}
