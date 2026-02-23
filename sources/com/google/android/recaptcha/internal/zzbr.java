package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbr implements zzby {

    @NotNull
    public static final zzbr zza = new zzbr();

    private zzbr() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 3) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num == null) {
            throw new zzt(4, 5, null);
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            throw new zzt(4, 6, null);
        }
        Object obj2 = objArr[1];
        if (true != (obj2 instanceof Object)) {
            obj2 = null;
        }
        if (obj2 == null) {
            throw new zzt(4, 5, null);
        }
        Object obj3 = objArr[2];
        if (true != (obj3 instanceof Object)) {
            obj3 = null;
        }
        if (obj3 == null) {
            throw new zzt(4, 5, null);
        }
        if (l.a(obj2, obj3)) {
            zzblVar.zzg(zzblVar.zzb() + intValue);
        }
    }
}
