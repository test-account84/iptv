package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdu extends zzdp {
    final /* synthetic */ Iterable zza;
    final /* synthetic */ int zzb;

    public zzdu(Iterable iterable, int i) {
        this.zza = iterable;
        this.zzb = i;
    }

    public final Iterator iterator() {
        List list = this.zza;
        if (list instanceof List) {
            List list2 = list;
            return list2.subList(Math.min(list2.size(), this.zzb), list2.size()).iterator();
        }
        Iterator it = list.iterator();
        int i = this.zzb;
        it.getClass();
        zzdi.zzb(i >= 0, "numberToAdvance must be nonnegative");
        for (int i2 = 0; i2 < i && it.hasNext(); i2++) {
            it.next();
        }
        return new zzdt(this, it);
    }
}
