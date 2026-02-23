package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l8.h;
import l8.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbz implements zzby {

    @NotNull
    public static final zzbz zza = new zzbz();

    private zzbz() {
    }

    @Nullable
    public static final List zzc(@NotNull Object obj) {
        if (obj instanceof byte[]) {
            return h.O((byte[]) obj);
        }
        if (obj instanceof short[]) {
            return h.U((short[]) obj);
        }
        if (obj instanceof int[]) {
            return h.R((int[]) obj);
        }
        if (obj instanceof long[]) {
            return h.S((long[]) obj);
        }
        if (obj instanceof float[]) {
            return h.Q((float[]) obj);
        }
        if (obj instanceof double[]) {
            return h.P((double[]) obj);
        }
        return null;
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 2) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Object)) {
            obj = null;
        }
        if (obj == null) {
            throw new zzt(4, 5, null);
        }
        Object obj2 = objArr[1];
        if (true != (obj2 instanceof Object)) {
            obj2 = null;
        }
        if (obj2 == null) {
            throw new zzt(4, 5, null);
        }
        zzblVar.zzc().zzf(i, zzb(obj, obj2));
    }

    @NotNull
    public final Object zzb(@NotNull Object obj, @NotNull Object obj2) throws zzt {
        List zzc = zzc(obj);
        List zzc2 = zzc(obj2);
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return Double.valueOf(Math.pow(((Number) obj).doubleValue(), ((Number) obj2).doubleValue()));
            }
            if (zzc2 != null) {
                ArrayList arrayList = new ArrayList(l.o(zzc2, 10));
                Iterator it = zzc2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Double.valueOf(Math.pow(((Number) it.next()).doubleValue(), ((Number) obj).doubleValue())));
                }
                return arrayList.toArray(new Double[0]);
            }
        }
        if (zzc != null && (obj2 instanceof Number)) {
            ArrayList arrayList2 = new ArrayList(l.o(zzc, 10));
            Iterator it2 = zzc.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Double.valueOf(Math.pow(((Number) it2.next()).doubleValue(), ((Number) obj2).doubleValue())));
            }
            return arrayList2.toArray(new Double[0]);
        }
        if (zzc == null || zzc2 == null) {
            throw new zzt(4, 5, null);
        }
        zzbx.zzb(this, zzc.size(), zzc2.size());
        int size = zzc.size();
        Double[] dArr = new Double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = Double.valueOf(Math.pow(((Number) zzc.get(i)).doubleValue(), ((Number) zzc2.get(i)).doubleValue()));
        }
        return dArr;
    }
}
