package com.google.android.recaptcha.internal;

import E8.o;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.l;
import l8.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbj {

    @NotNull
    public static final zzbj zza = new zzbj();

    @Nullable
    private static Set zzb;

    @Nullable
    private static Set zzc;

    @Nullable
    private static Long zzd;
    private static int zze;

    private zzbj() {
    }

    public static final void zza(@NotNull zzlr zzlrVar) {
        zzb = s.O(zzlrVar.zzf().zzi());
        zzc = s.O(zzlrVar.zzg().zzi());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x016b  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object zzb(@org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull android.content.Context r23, @org.jetbrains.annotations.NotNull com.google.android.recaptcha.internal.zzr r24, @org.jetbrains.annotations.NotNull o8.d r25) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbj.zzb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context, com.google.android.recaptcha.internal.zzr, o8.d):java.lang.Object");
    }

    public static final boolean zzc(@NotNull String str) {
        Set set = zzb;
        if (set == null || zzc == null) {
            if (zzd == null) {
                zzd = Long.valueOf(System.currentTimeMillis());
            }
            zze++;
            return true;
        }
        l.c(set, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (set.isEmpty()) {
            return true;
        }
        Set set2 = zzc;
        l.c(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (zzd(str, set2)) {
            return false;
        }
        return zzd(str, set);
    }

    private static final boolean zzd(String str, Set set) {
        Iterator it = o.r0(str, new char[]{'.'}, false, 0, 6, (Object) null).iterator();
        String str2 = "";
        while (it.hasNext()) {
            String concat = str2.concat(String.valueOf((String) it.next()));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(".");
        }
        return false;
    }
}
