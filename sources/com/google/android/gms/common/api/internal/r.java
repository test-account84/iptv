package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class r extends h.a {
    public final e a;

    public r(e eVar) {
        this.a = eVar;
    }

    public void onResult(Status status) {
        this.a.setResult(status);
    }
}
