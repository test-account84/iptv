package com.google.android.recaptcha.internal;

import G8.L;
import G8.M;
import G8.N;
import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k8.i;
import k8.m;
import k8.n;
import k8.q;
import l8.B;
import l8.l;
import l8.s;
import o8.g;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzba implements zzas, zzbi {

    @NotNull
    public static final zzat zza = new zzat(null);

    @NotNull
    private final zzbc zzb;

    @NotNull
    private final L zzc;

    @NotNull
    private final zzbn zzd;

    @NotNull
    private final Map zze;

    @NotNull
    private final Map zzf;

    public zzba(@NotNull zzbc zzbcVar, @NotNull L l, @NotNull Context context) {
        this.zzb = zzbcVar;
        this.zzc = l;
        zzbn zzbnVar = new zzbn();
        this.zzd = zzbnVar;
        this.zze = zzbnVar.zzb().zzc();
        this.zzf = B.e(new i[]{m.a(39, zzbt.zza), m.a(34, zzcg.zza), m.a(35, zzco.zza), m.a(25, zzbz.zza), m.a(37, zzcn.zza), m.a(21, zzbo.zza), m.a(22, zzcm.zza), m.a(23, zzch.zza), m.a(24, zzbw.zza), m.a(1, zzcj.zza), m.a(2, zzbs.zza), m.a(38, zzcl.zza), m.a(3, zzca.zza), m.a(4, zzcb.zza), m.a(17, zzbv.zza), m.a(32, zzbp.zza), m.a(5, zzcd.zza), m.a(31, zzbq.zza), m.a(36, zzbr.zza), m.a(16, zzbu.zza), m.a(26, zzck.zza), m.a(6, zzcc.zza), m.a(27, zzci.zza), m.a(8, zzce.zza), m.a(9, zzcf.zza)});
        zzcr.zzb(new int[0]);
        zzbnVar.zze(3, context);
    }

    public static final /* synthetic */ zzmh zzc(zzba zzbaVar, String str, List list) {
        return zzy(str, list);
    }

    public static final /* synthetic */ Object zzd(zzba zzbaVar, List list, zzn zznVar, zzn zznVar2, o8.d dVar) {
        return zzbaVar.zzt(list, zznVar, zznVar2, dVar);
    }

    public static final /* synthetic */ Object zze(zzba zzbaVar, Exception exc, String str, zzn zznVar, zzn zznVar2, int i, o8.d dVar) {
        return zzbaVar.zzu(exc, str, zznVar, zznVar2, i, dVar);
    }

    public static /* synthetic */ Object zzf(zzba zzbaVar, Exception exc, String str, zzn zznVar, zzn zznVar2, int i, o8.d dVar, int i2, Object obj) {
        return zzbaVar.zzu(exc, "recaptcha.m.Main.rge", zznVar, zznVar2, 0, dVar);
    }

    public static final /* synthetic */ void zzg(zzba zzbaVar, String str, String... strArr) {
        zzbaVar.zzv(str, strArr);
    }

    public static final /* synthetic */ void zzh(zzba zzbaVar, int i, List list) {
        if (list.isEmpty()) {
            throw new zzt(4, 3, null);
        }
        if (!zzx(list)) {
            throw new zzt(4, 5, null);
        }
        zzmk zzf = zzmn.zzf();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzmu zzmuVar = (zzmu) it.next();
            zzml zzf2 = zzmm.zzf();
            Object zza2 = zzbaVar.zzd.zzb().zza(zzmuVar);
            if (zza2 == null) {
                throw new zzt(4, 4, null);
            }
            if (zza2 instanceof Integer) {
                zzf2.zzt(((Number) zza2).intValue());
            } else if (zza2 instanceof Short) {
                zzf2.zzs(((Number) zza2).shortValue());
            } else if (zza2 instanceof Byte) {
                zzf2.zze(zzez.zzm(new byte[]{((Number) zza2).byteValue()}, 0, 1));
            } else if (zza2 instanceof Long) {
                zzf2.zzu(((Number) zza2).longValue());
            } else if (zza2 instanceof Double) {
                zzf2.zzq(((Number) zza2).doubleValue());
            } else if (zza2 instanceof Float) {
                zzf2.zzr(((Number) zza2).floatValue());
            } else if (zza2 instanceof Boolean) {
                zzf2.zzd(((Boolean) zza2).booleanValue());
            } else if (zza2 instanceof Character) {
                zzf2.zzp(zza2.toString());
            } else {
                zzf2.zzv(zza2 instanceof String ? (String) zza2 : zza2.toString());
            }
            zzf.zze((zzmm) zzf2.zzj());
        }
        zzbm zzb = zzbaVar.zzd.zzb();
        byte[] zzd = ((zzmn) zzf.zzj()).zzd();
        zzb.zzf(i, zzeb.zzh().zzi(zzd, 0, zzd.length));
    }

    public static final /* synthetic */ void zzi(zzba zzbaVar, List list) {
        if (list.size() != 2) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof String)) {
            zza2 = null;
        }
        String str = (String) zza2;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        Object zza3 = zzbaVar.zzd.zzb().zza((zzmu) list.get(1));
        if (zza3 == null) {
            throw new zzt(4, 4, null);
        }
        if (!(zza3 instanceof Integer) && !(zza3 instanceof Short) && !(zza3 instanceof Byte) && !(zza3 instanceof Long) && !(zza3 instanceof Double) && !(zza3 instanceof Float) && !(zza3 instanceof Boolean) && !(zza3 instanceof Character) && !(zza3 instanceof String)) {
            throw new zzt(4, 7, null);
        }
        zzbaVar.zzv(str, zza3.toString());
    }

    public static final /* synthetic */ void zzj(zzba zzbaVar, List list) {
        if (!zzx(list)) {
            throw new zzt(4, 5, null);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbaVar.zzd.zzb().zzb(((zzmu) it.next()).zzi());
        }
    }

    public static final /* synthetic */ void zzk(zzba zzbaVar, int i, List list) {
        int i2;
        if (list.size() != 4 && list.size() != 5) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof String)) {
            zza2 = null;
        }
        String str = (String) zza2;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        Object zza3 = zzbaVar.zzd.zzb().zza((zzmu) list.get(1));
        if (true != (zza3 instanceof Object)) {
            zza3 = null;
        }
        if (zza3 == null) {
            throw new zzt(4, 5, null);
        }
        Object zza4 = zzbaVar.zzd.zzb().zza((zzmu) list.get(2));
        if (true != (zza4 instanceof String)) {
            zza4 = null;
        }
        String str2 = (String) zza4;
        if (str2 == null) {
            throw new zzt(4, 5, null);
        }
        String zza5 = zzbh.zza(zzbaVar, str2, zzbaVar.zzd.zza());
        Object zza6 = zzbaVar.zzd.zzb().zza((zzmu) list.get(3));
        if (list.size() == 5) {
            Object zza7 = zzbaVar.zzd.zzb().zza((zzmu) list.get(4));
            if (true != (zza7 instanceof Integer)) {
                zza7 = null;
            }
            Integer num = (Integer) zza7;
            if (num == null) {
                throw new zzt(4, 5, null);
            }
            i2 = num.intValue();
        } else {
            i2 = -1;
        }
        try {
            byte zza8 = zzbaVar.zzd.zza();
            if (zza3 instanceof String) {
                zza3 = zzbh.zza(zzbaVar, (String) zza3, zza8);
            }
            Class zza9 = zzbk.zza(zza3);
            zzbaVar.zzd.zzb().zzf(i, Proxy.newProxyInstance(zza9.getClassLoader(), new Class[]{zza9}, new zzbe(new zzau(zzbaVar, str, i2), zza5, zza6)));
        } catch (Exception e) {
            throw new zzt(6, 20, e);
        }
    }

    public static final /* synthetic */ void zzl(zzba zzbaVar, int i, List list) {
        if (list.size() != 4 && list.size() != 5) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof Integer)) {
            zza2 = null;
        }
        Integer num = (Integer) zza2;
        if (num == null) {
            throw new zzt(4, 5, null);
        }
        int intValue = num.intValue();
        Object zza3 = zzbaVar.zzd.zzb().zza((zzmu) list.get(1));
        if (true != (zza3 instanceof Integer)) {
            zza3 = null;
        }
        Integer num2 = (Integer) zza3;
        if (num2 == null) {
            throw new zzt(4, 5, null);
        }
        int intValue2 = num2.intValue();
        Object zza4 = zzbaVar.zzd.zzb().zza((zzmu) list.get(2));
        if (true != (zza4 instanceof String)) {
            zza4 = null;
        }
        String str = (String) zza4;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        String zza5 = zzbh.zza(zzbaVar, str, zzbaVar.zzd.zza());
        Object zza6 = zzbaVar.zzd.zzb().zza((zzmu) list.get(3));
        if (true != (zza6 instanceof String)) {
            zza6 = null;
        }
        String str2 = (String) zza6;
        if (str2 == null) {
            throw new zzt(4, 5, null);
        }
        String zza7 = zzbh.zza(zzbaVar, str2, zzbaVar.zzd.zza());
        Object zza8 = list.size() == 5 ? zzbaVar.zzd.zzb().zza((zzmu) list.get(4)) : null;
        zzbf zzbfVar = new zzbf(intValue2);
        try {
            Class zza9 = zzbk.zza(zza5);
            zzbaVar.zzd.zzb().zzf(intValue, Proxy.newProxyInstance(zza9.getClassLoader(), new Class[]{zza9}, new zzbg(zzbfVar, zza7, zza8)));
            zzbaVar.zzd.zzb().zzf(i, zzbfVar);
        } catch (Exception e) {
            throw new zzt(6, 20, e);
        }
    }

    public static final /* synthetic */ void zzm(zzba zzbaVar, int i, List list) {
        if (list.size() != 2) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof Field)) {
            zza2 = null;
        }
        Field field = (Field) zza2;
        if (field == null) {
            throw new zzt(4, 5, null);
        }
        try {
            zzbaVar.zzd.zzb().zzf(i, field.get(zzbaVar.zzd.zzb().zza((zzmu) list.get(1))));
        } catch (Exception e) {
            throw new zzt(6, 16, e);
        }
    }

    public static final /* synthetic */ void zzn(zzba zzbaVar, int i, List list) {
        if (list.size() != 1) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof Field)) {
            zza2 = null;
        }
        Field field = (Field) zza2;
        if (field == null) {
            throw new zzt(4, 5, null);
        }
        try {
            zzbaVar.zzd.zzb().zzf(i, field.get((Object) null));
        } catch (Exception e) {
            throw new zzt(6, 16, e);
        }
    }

    public static final /* synthetic */ void zzo(zzba zzbaVar, int i, List list) {
        if (list.isEmpty()) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof Constructor)) {
            zza2 = null;
        }
        Constructor constructor = (Constructor) zza2;
        if (constructor == null) {
            throw new zzt(4, 5, null);
        }
        Object[] zzg = zzbaVar.zzd.zzb().zzg(list.subList(1, list.size()));
        try {
            zzbaVar.zzd.zzb().zzf(i, constructor.newInstance(Arrays.copyOf(zzg, zzg.length)));
        } catch (Exception e) {
            throw new zzt(6, 14, e);
        }
    }

    public static final /* synthetic */ void zzp(zzba zzbaVar, List list) {
        if (list.size() != 3) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof Field)) {
            zza2 = null;
        }
        Field field = (Field) zza2;
        if (field == null) {
            throw new zzt(4, 5, null);
        }
        try {
            field.set(zzbaVar.zzd.zzb().zza((zzmu) list.get(1)), zzbaVar.zzd.zzb().zza((zzmu) list.get(2)));
        } catch (Exception e) {
            throw new zzt(6, 11, e);
        }
    }

    public static final /* synthetic */ void zzq(zzba zzbaVar, List list) {
        if (list.size() != 2) {
            throw new zzt(4, 3, null);
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof Field)) {
            zza2 = null;
        }
        Field field = (Field) zza2;
        if (field == null) {
            throw new zzt(4, 5, null);
        }
        try {
            field.set((Object) null, zzbaVar.zzd.zzb().zza((zzmu) list.get(1)));
        } catch (Exception e) {
            throw new zzt(6, 11, e);
        }
    }

    public static final /* synthetic */ void zzr(zzba zzbaVar, zzn zznVar, int i, List list) {
        if (list.size() != 2 && list.size() != 0) {
            throw new zzt(4, 3, null);
        }
        if (list.size() == 0) {
            zzbaVar.zzd.zzb().zzf(i, new zzn());
            return;
        }
        Object zza2 = zzbaVar.zzd.zzb().zza((zzmu) list.get(0));
        if (true != (zza2 instanceof String)) {
            zza2 = null;
        }
        String str = (String) zza2;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        Object zza3 = zzbaVar.zzd.zzb().zza((zzmu) list.get(1));
        if (true != (zza3 instanceof zzn)) {
            zza3 = null;
        }
        zzn zznVar2 = (zzn) zza3;
        if (zznVar2 == null) {
            throw new zzt(4, 5, null);
        }
        byte[] zzd = zzar.zza(zznVar, zznVar2).zzd();
        zzbaVar.zzv(str, zzeb.zzh().zzi(zzd, 0, zzd.length));
    }

    public static final /* synthetic */ boolean zzs(zzba zzbaVar, zzmv zzmvVar, zzbl zzblVar) {
        return zzbaVar.zzw(zzmvVar, zzblVar);
    }

    private final Object zzt(List list, zzn zznVar, zzn zznVar2, o8.d dVar) {
        Object c = M.c(new zzax(this, list, zznVar, zznVar2, null), dVar);
        return c == p8.c.d() ? c : q.a;
    }

    private final Object zzu(Exception exc, String str, zzn zznVar, zzn zznVar2, int i, o8.d dVar) {
        Object c = M.c(new zzay(exc, i, zznVar, zznVar2, str, this, null), dVar);
        return c == p8.c.d() ? c : q.a;
    }

    private final void zzv(String str, String... strArr) {
        this.zzb.zzb(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    private final boolean zzw(zzmv zzmvVar, zzbl zzblVar) throws zzt {
        zzdk zzb = zzdk.zzb();
        int zzb2 = zzblVar.zzb();
        zzby zzbyVar = (zzby) this.zzf.get(Integer.valueOf(zzmvVar.zzf()));
        if (zzbyVar == null) {
            return false;
        }
        Object[] zzg = this.zzd.zzb().zzg(zzmvVar.zzj());
        zzbyVar.zza(zzmvVar.zzg(), zzblVar, Arrays.copyOf(zzg, zzg.length));
        if (zzb2 == zzblVar.zzb()) {
            zzblVar.zzg(zzblVar.zzb() + 1);
        }
        zzb.zzf();
        long zza2 = zzb.zza(TimeUnit.MICROSECONDS);
        zzj zzjVar = zzj.zza;
        zzj.zza(zzms.zza(zzmvVar.zzk()), zza2);
        zzmvVar.zzk();
        s.A(zzmvVar.zzj(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzav(this), 31, (Object) null);
        return true;
    }

    private static final boolean zzx(List list) {
        ArrayList arrayList = new ArrayList(l.o(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((zzmu) it.next()).zzM()));
        }
        return !arrayList.contains(Boolean.FALSE);
    }

    private static final zzmh zzy(String str, List list) throws zzt {
        if (str.length() == 0) {
            throw new zzt(3, 17, null);
        }
        try {
            zzcq zzcqVar = new zzcq((short) zzcr.zza(s.K(list)), (short) 255);
            StringBuilder sb = new StringBuilder(str.length());
            for (int i = 0; i < str.length(); i++) {
                sb.append((char) n.a(n.a(str.charAt(i)) ^ n.a(zzcqVar.zza())));
            }
            return zzmh.zzg(zzeb.zzh().zzj(sb.toString()));
        } catch (Exception e) {
            throw new zzt(3, 18, e);
        }
    }

    public final void zza(@NotNull String str) {
        G8.i.d(this.zzc, (g) null, (N) null, new zzaz(this, str, new zzn(), null), 3, (Object) null);
    }

    @NotNull
    public final zzbn zzb() {
        return this.zzd;
    }
}
