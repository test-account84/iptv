package com.google.android.gms.common.api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends UnsupportedOperationException {
    public final w4.d a;

    public l(w4.d dVar) {
        this.a = dVar;
    }

    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.a));
    }
}
