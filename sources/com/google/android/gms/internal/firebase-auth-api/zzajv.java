package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzajv extends zzajs {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzajv() {
        super(null);
    }

    private static List zzc(Object obj, long j) {
        return (List) zzamk.zze(obj, j);
    }

    public final List zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzamk.zze(obj, j);
        if (list instanceof zzajt) {
            unmodifiableList = ((zzajt) list).zzd();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzakz) && (list instanceof zzajj)) {
                zzajj zzajjVar = (zzajj) list;
                if (zzajjVar.zzc()) {
                    zzajjVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzamk.zza(obj, j, unmodifiableList);
    }

    public /* synthetic */ zzajv(zzaju zzajuVar) {
        this();
    }

    private static List zza(Object obj, long j, int i) {
        zzajj zza2;
        ArrayList zzajqVar;
        Collection zzc = zzc(obj, j);
        if (!zzc.isEmpty()) {
            if (zza.isAssignableFrom(zzc.getClass())) {
                zzajqVar = new ArrayList(zzc.size() + i);
                zzajqVar.addAll(zzc);
            } else if (zzc instanceof zzamf) {
                zzajqVar = new zzajq(zzc.size() + i);
                zzajqVar.addAll((zzamf) zzc);
            } else {
                if (!(zzc instanceof zzakz) || !(zzc instanceof zzajj)) {
                    return zzc;
                }
                zzajj zzajjVar = (zzajj) zzc;
                if (zzajjVar.zzc()) {
                    return zzc;
                }
                zza2 = zzajjVar.zza(zzc.size() + i);
            }
            zzamk.zza(obj, j, zzajqVar);
            return zzajqVar;
        }
        zza2 = zzc instanceof zzajt ? new zzajq(i) : ((zzc instanceof zzakz) && (zzc instanceof zzajj)) ? ((zzajj) zzc).zza(i) : new ArrayList(i);
        zzamk.zza(obj, j, zza2);
        return zza2;
    }

    public final void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzamk.zza(obj, j, zzc);
    }
}
