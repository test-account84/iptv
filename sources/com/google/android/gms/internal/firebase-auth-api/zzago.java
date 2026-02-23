package com.google.android.gms.internal.firebase-auth-api;

import C4.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzago {
    private final int zza;
    private List zzb;

    public zzago() {
        this(null);
    }

    public static zzago zza() {
        return new zzago(null);
    }

    public final List zzb() {
        return this.zzb;
    }

    public zzago(int i, List list) {
        List emptyList;
        this.zza = 1;
        if (list == null || list.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, o.a((String) list.get(i2)));
            }
            emptyList = Collections.unmodifiableList(list);
        }
        this.zzb = emptyList;
    }

    private zzago(List list) {
        this.zza = 1;
        this.zzb = new ArrayList();
    }
}
