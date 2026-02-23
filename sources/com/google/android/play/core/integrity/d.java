package com.google.android.play.core.integrity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class d extends w {
    private String a;

    public final w a(String str) {
        this.a = str;
        return this;
    }

    public final IntegrityTokenResponse b() {
        String str = this.a;
        if (str != null) {
            return new f(str, null);
        }
        throw new IllegalStateException("Missing required properties: token");
    }
}
