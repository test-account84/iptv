package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import l8.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcb implements zzby {

    @NotNull
    public static final zzcb zza = new zzcb();

    private zzcb() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        int length = objArr.length;
        if (length == 0) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Class)) {
            obj = null;
        }
        Class cls = (Class) obj;
        if (cls == null) {
            throw new zzt(4, 5, null);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj2 = objArr[i2];
            int i4 = i3 + 1;
            if (i3 > 0) {
                arrayList.add(obj2);
            }
            i2++;
            i3 = i4;
        }
        ArrayList arrayList2 = new ArrayList(l.o(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(zzbk.zza(it.next()));
        }
        Class[] clsArr = (Class[]) arrayList2.toArray(new Class[0]);
        try {
            zzblVar.zzc().zzf(i, cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)));
        } catch (Exception e) {
            throw new zzt(6, 9, e);
        }
    }
}
