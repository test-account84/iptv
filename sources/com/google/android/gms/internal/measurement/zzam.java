package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzam implements zzap, zzal {
    final Map zza = new HashMap();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzam) {
            return this.zza.equals(((zzam) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!this.zza.isEmpty()) {
            for (String str : this.zza.keySet()) {
                sb.append(String.format("%s: %s,", new Object[]{str, this.zza.get(str)}));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }

    public final List zzb() {
        return new ArrayList(this.zza.keySet());
    }

    public zzap zzbU(String str, zzg zzgVar, List list) {
        return "toString".equals(str) ? new zzat(toString()) : zzaj.zza(this, new zzat(str), zzgVar, list);
    }

    public final zzap zzd() {
        Map map;
        String str;
        zzap zzd;
        zzam zzamVar = new zzam();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzal) {
                map = zzamVar.zza;
                str = (String) entry.getKey();
                zzd = (zzap) entry.getValue();
            } else {
                map = zzamVar.zza;
                str = (String) entry.getKey();
                zzd = ((zzap) entry.getValue()).zzd();
            }
            map.put(str, zzd);
        }
        return zzamVar;
    }

    public final zzap zzf(String str) {
        return this.zza.containsKey(str) ? (zzap) this.zza.get(str) : zzap.zzf;
    }

    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    public final Double zzh() {
        return Double.valueOf(Double.NaN);
    }

    public final String zzi() {
        return "[object Object]";
    }

    public final Iterator zzl() {
        return zzaj.zzb(this.zza);
    }

    public final void zzr(String str, zzap zzapVar) {
        if (zzapVar == null) {
            this.zza.remove(str);
        } else {
            this.zza.put(str, zzapVar);
        }
    }

    public final boolean zzt(String str) {
        return this.zza.containsKey(str);
    }
}
