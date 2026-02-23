package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.l;
import l8.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbe extends zzbd implements zzbi {

    @NotNull
    private final p zza;

    @NotNull
    private final String zzb;

    public zzbe(@NotNull p pVar, @NotNull String str, @Nullable Object obj) {
        super(obj);
        this.zza = pVar;
        this.zzb = str;
    }

    public final boolean zza(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
        ArrayList f;
        if (!l.a(method.getName(), this.zzb)) {
            return false;
        }
        zzmk zzf = zzmn.zzf();
        if (objArr != null) {
            f = new ArrayList(objArr.length);
            for (Object obj2 : objArr) {
                zzml zzf2 = zzmm.zzf();
                zzf2.zzv(obj2.toString());
                f.add((zzmm) zzf2.zzj());
            }
        } else {
            f = k.f();
        }
        zzf.zzd(f);
        zzmn zzmnVar = (zzmn) zzf.zzj();
        p pVar = this.zza;
        byte[] zzd = zzmnVar.zzd();
        pVar.invoke(objArr, zzeb.zzh().zzi(zzd, 0, zzd.length));
        return true;
    }
}
