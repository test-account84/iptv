package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzab implements Continuation {
    final /* synthetic */ Collection zza;

    public zzab(Collection collection) {
        this.zza = collection;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zza);
        return Tasks.forResult(arrayList);
    }
}
