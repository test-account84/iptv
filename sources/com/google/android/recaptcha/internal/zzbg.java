package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.l;
import l8.g;
import l8.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbg extends zzbd {

    @NotNull
    private final zzbf zza;

    @NotNull
    private final String zzb;

    public zzbg(@NotNull zzbf zzbfVar, @NotNull String str, @Nullable Object obj) {
        super(obj);
        this.zza = zzbfVar;
        this.zzb = str;
    }

    public final boolean zza(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
        List f;
        if (!l.a(method.getName(), this.zzb)) {
            return false;
        }
        zzbf zzbfVar = this.zza;
        if (objArr == null || (f = g.b(objArr)) == null) {
            f = k.f();
        }
        zzbfVar.zzb(f);
        return true;
    }
}
