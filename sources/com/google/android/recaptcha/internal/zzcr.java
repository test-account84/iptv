package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import l8.h;
import l8.k;
import l8.s;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcr {

    @NotNull
    public static final zzcr zza = new zzcr();

    @NotNull
    private static List zzb = k.f();

    private zzcr() {
    }

    public static final void acx(@NotNull int[] iArr) {
        zzb(iArr);
    }

    public static final int zza(@NotNull int[] iArr) {
        Iterator it = s.D(zzb, h.R(iArr)).iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = Integer.valueOf(((Number) next).intValue() ^ ((Number) it.next()).intValue());
        }
        return ((Number) next).intValue();
    }

    public static final void zzb(@NotNull int[] iArr) {
        zzb = h.R(iArr);
    }
}
