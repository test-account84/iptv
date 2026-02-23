package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static com.google.android.gms.common.api.b a(Status status) {
        return status.K() ? new com.google.android.gms.common.api.g(status) : new com.google.android.gms.common.api.b(status);
    }
}
