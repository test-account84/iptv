package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzalh {
    private static final Class zza = zzd();
    private static final zzame zzb = zzc();
    private static final zzame zzc = new zzamg();

    public static int zza(int i, Object obj, zzalf zzalfVar) {
        return obj instanceof zzajr ? zzaik.zzb(i, (zzajr) obj) : zzaik.zzb(i, (zzakn) obj, zzalfVar);
    }

    public static int zzb(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzi = zzaik.zzi(i) * size;
        if (list instanceof zzajt) {
            zzajt zzajtVar = (zzajt) list;
            while (i2 < size) {
                Object zzb2 = zzajtVar.zzb(i2);
                zzi += zzb2 instanceof zzahp ? zzaik.zza((zzahp) zzb2) : zzaik.zza((String) zzb2);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zzi += obj instanceof zzahp ? zzaik.zza((zzahp) obj) : zzaik.zza((String) obj);
                i2++;
            }
        }
        return zzi;
    }

    public static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaik.zzc(i, 0);
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaik.zza(i, 0L);
    }

    public static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzaik.zzi(i));
    }

    public static int zzf(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzaik.zzi(i));
    }

    public static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaik.zzi(i));
    }

    public static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaik.zzi(i));
    }

    public static int zzi(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaik.zzi(i));
    }

    public static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaik.zzi(i));
    }

    public static void zzk(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzk(i, list, z);
    }

    public static void zzl(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzl(i, list, z);
    }

    public static void zzm(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzm(i, list, z);
    }

    public static void zzn(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzn(i, list, z);
    }

    public static int zza(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzi = size * zzaik.zzi(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzi += zzaik.zza((zzahp) list.get(i2));
        }
        return zzi;
    }

    public static int zzb(int i, List list, zzalf zzalfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzi = zzaik.zzi(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zzi += obj instanceof zzajr ? zzaik.zza((zzajr) obj) : zzaik.zza((zzakn) obj, zzalfVar);
        }
        return zzi;
    }

    public static int zzc(List list) {
        return list.size() << 2;
    }

    public static int zzd(List list) {
        return list.size() << 3;
    }

    public static int zze(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zze(zzajdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zze(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajy) {
            zzajy zzajyVar = (zzajy) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zzd(zzajyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zzd(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zzh(zzajdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zzh(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzh(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajy) {
            zzajy zzajyVar = (zzajy) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zzf(zzajyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zzf(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zzj(zzajdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zzj(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajy) {
            zzajy zzajyVar = (zzajy) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zzg(zzajyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zzg(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zza(int i, List list, zzalf zzalfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzaik.zza(i, (zzakn) list.get(i3), zzalfVar);
        }
        return i2;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzaik.zzi(i));
    }

    private static zzame zzc() {
        try {
            Class zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzame) zze.getConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzf(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzf(i, list, z);
    }

    public static void zzg(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzg(i, list, z);
    }

    public static void zzh(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzh(i, list, z);
    }

    public static void zzi(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzi(i, list, z);
    }

    public static void zzj(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzj(i, list, z);
    }

    public static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaik.zza(i, true);
    }

    public static int zzb(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajdVar = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaik.zzc(zzajdVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzaik.zzc(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzc(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzc(i, list, z);
    }

    public static void zzd(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzd(i, list, z);
    }

    public static void zze(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zze(i, list, z);
    }

    public static int zza(List list) {
        return list.size();
    }

    public static zzame zzb() {
        return zzc;
    }

    public static zzame zza() {
        return zzb;
    }

    public static void zzb(int i, List list, zzana zzanaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzb(i, list);
    }

    public static Object zza(Object obj, int i, int i2, Object obj2, zzame zzameVar) {
        if (obj2 == null) {
            obj2 = zzameVar.zzc(obj);
        }
        zzameVar.zzb(obj2, i, i2);
        return obj2;
    }

    public static void zzb(int i, List list, zzana zzanaVar, zzalf zzalfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzb(i, list, zzalfVar);
    }

    public static Object zza(Object obj, int i, List list, zzajg zzajgVar, Object obj2, zzame zzameVar) {
        if (zzajgVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int intValue = num.intValue();
                if (zzajgVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = zza(obj, i, intValue, obj2, zzameVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzajgVar.zza(intValue2)) {
                    obj2 = zza(obj, i, intValue2, obj2, zzameVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static void zzb(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zzb(i, list, z);
    }

    public static void zza(int i, List list, zzana zzanaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zza(i, list);
    }

    public static void zza(int i, List list, zzana zzanaVar, zzalf zzalfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zza(i, list, zzalfVar);
    }

    public static void zza(int i, List list, zzana zzanaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanaVar.zza(i, list, z);
    }

    public static void zza(zzaiq zzaiqVar, Object obj, Object obj2) {
        zzaiv zza2 = zzaiqVar.zza(obj2);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzaiqVar.zzb(obj).zza(zza2);
    }

    public static void zza(zzakg zzakgVar, Object obj, Object obj2, long j) {
        zzamk.zza(obj, j, zzakgVar.zza(zzamk.zze(obj, j), zzamk.zze(obj2, j)));
    }

    public static void zza(zzame zzameVar, Object obj, Object obj2) {
        zzameVar.zzc(obj, zzameVar.zza(zzameVar.zzd(obj), zzameVar.zzd(obj2)));
    }

    public static void zza(Class cls) {
        Class cls2;
        if (!zzajc.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
