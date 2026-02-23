package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aqq {
    private final String a;
    private final Object b;
    private final int c = 1;

    public aqq(String str, Object obj, int i) {
        this.a = str;
        this.b = obj;
    }

    public static aqq a(String str, boolean z) {
        return new aqq(str, Boolean.valueOf(z), 1);
    }

    public final Object b() {
        aqt a = aqv.a();
        if (a != null) {
            return a.a(this.a, ((Boolean) this.b).booleanValue());
        }
        if (aqv.b() != null) {
            aqv.b().a();
        }
        return this.b;
    }
}
