package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzain implements zzana {
    private final zzaik zza;

    private zzain(zzaik zzaikVar) {
        zzaik zzaikVar2 = (zzaik) zzajf.zza(zzaikVar, "output");
        this.zza = zzaikVar2;
        zzaikVar2.zze = this;
    }

    public final int zza() {
        return zzand.zza;
    }

    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzk(i, 3);
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzi(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zze(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzl(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzh(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzd(((Long) list.get(i4)).longValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzj(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzi(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzg(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zze(((Long) list.get(i4)).longValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzh(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzk(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzh(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzf(((Long) list.get(i4)).longValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzj(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzn(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzg(((Long) list.get(i4)).longValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzj(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static zzain zza(zzaik zzaikVar) {
        zzain zzainVar = zzaikVar.zze;
        return zzainVar != null ? zzainVar : new zzain(zzaikVar);
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzf(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zza(((Float) list.get(i4)).floatValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzb(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzk(i, 4);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzi(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzc(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzl(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzd(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzd(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zze(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zzc(((Long) list.get(i4)).longValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzh(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    public final void zzb(int i, Object obj, zzalf zzalfVar) throws IOException {
        this.zza.zzc(i, (zzakn) obj, zzalfVar);
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    public final void zzb(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajt)) {
            while (i2 < list.size()) {
                this.zza.zzb(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzajt zzajtVar = (zzajt) list;
        while (i2 < list.size()) {
            Object zzb = zzajtVar.zzb(i2);
            if (zzb instanceof String) {
                this.zza.zzb(i, (String) zzb);
            } else {
                this.zza.zzc(i, (zzahp) zzb);
            }
            i2++;
        }
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    public final void zzb(int i, List list, zzalf zzalfVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzalfVar);
        }
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzb(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zza(((Double) list.get(i4)).doubleValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzb(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void zza(int i, zzahp zzahpVar) throws IOException {
        this.zza.zzc(i, zzahpVar);
    }

    public final void zza(int i, zzake zzakeVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            this.zza.zzk(i, 2);
            this.zza.zzn(zzakf.zza(zzakeVar, entry.getKey(), entry.getValue()));
            zzakf.zza(this.zza, zzakeVar, entry.getKey(), entry.getValue());
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzahp) {
            this.zza.zzd(i, (zzahp) obj);
        } else {
            this.zza.zzb(i, (zzakn) obj);
        }
    }

    public final void zza(int i, Object obj, zzalf zzalfVar) throws IOException {
        zzaik zzaikVar = this.zza;
        zzaikVar.zzk(i, 3);
        zzalfVar.zza(obj, (zzana) zzaikVar.zze);
        zzaikVar.zzk(i, 4);
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    public final void zza(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, (zzahp) list.get(i2));
        }
    }

    public final void zza(int i, List list, zzalf zzalfVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzalfVar);
        }
    }

    public final void zza(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzk(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzaik.zza(((Boolean) list.get(i4)).booleanValue());
        }
        this.zza.zzn(i3);
        while (i2 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }
}
