package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x implements f.a {
    public final /* synthetic */ BasePendingResult a;
    public final /* synthetic */ z b;

    public x(z zVar, BasePendingResult basePendingResult) {
        this.b = zVar;
        this.a = basePendingResult;
    }

    public final void a(Status status) {
        z.a(this.b).remove(this.a);
    }
}
