package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class GooglePlayServicesManifestException extends IllegalStateException {
    public final int a;

    public GooglePlayServicesManifestException(int i, String str) {
        super(str);
        this.a = i;
    }
}
