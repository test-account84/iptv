package com.google.android.recaptcha.internal;

import java.util.Collection;
import l8.h;
import l8.s;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbt implements zzby {

    @NotNull
    public static final zzbt zza = new zzbt();

    private zzbt() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        String A;
        String str;
        if (objArr.length != 1) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Object)) {
            obj = null;
        }
        if (obj == null) {
            throw new zzt(4, 5, null);
        }
        if (obj instanceof int[]) {
            A = h.H((int[]) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
        } else {
            if (obj instanceof byte[]) {
                str = new String((byte[]) obj, E8.c.b);
            } else if (obj instanceof long[]) {
                A = h.I((long[]) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
            } else if (obj instanceof short[]) {
                A = h.K((short[]) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
            } else if (obj instanceof float[]) {
                A = h.G((float[]) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
            } else if (obj instanceof double[]) {
                A = h.F((double[]) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
            } else if (obj instanceof char[]) {
                str = new String((char[]) obj);
            } else if (obj instanceof Object[]) {
                A = h.J((Object[]) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
            } else {
                if (!(obj instanceof Collection)) {
                    throw new zzt(4, 5, null);
                }
                A = s.A((Iterable) obj, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
            }
            A = str;
        }
        zzblVar.zzc().zzf(i, A);
    }
}
