package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aqm implements aqt {
    final /* synthetic */ aqn a;

    public aqm(aqn aqnVar) {
        this.a = aqnVar;
    }

    public final Boolean a(String str, boolean z) {
        try {
            return Boolean.valueOf(aqn.a(this.a).getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(aqn.a(this.a).getString(str, String.valueOf(z)));
        }
    }
}
