package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l;
import l8.h;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcd implements zzby {

    @NotNull
    public static final zzcd zza = new zzcd();

    private zzcd() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length < 2) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Object)) {
            obj = null;
        }
        if (obj == null) {
            throw new zzt(4, 5, null);
        }
        Class cls = obj instanceof Class ? (Class) obj : obj.getClass();
        Object obj2 = objArr[1];
        if (true != (obj2 instanceof String)) {
            obj2 = null;
        }
        String str = (String) obj2;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        String zza2 = zzbx.zza(this, str, zzblVar.zza());
        if (l.a(zza2, "forName")) {
            throw new zzt(6, 48, null);
        }
        List n = h.n(objArr, 2);
        ArrayList arrayList = new ArrayList(l8.l.o(n, 10));
        Iterator it = n.iterator();
        while (it.hasNext()) {
            arrayList.add(zzbk.zza(it.next()));
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        try {
            zzblVar.zzc().zzf(i, cls.getMethod(zza2, (Class[]) Arrays.copyOf(clsArr, clsArr.length)));
        } catch (Exception e) {
            throw new zzt(6, 13, e);
        }
    }
}
