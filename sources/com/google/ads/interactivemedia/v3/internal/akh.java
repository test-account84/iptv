package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class akh implements ayr {
    final /* synthetic */ String a;
    final /* synthetic */ akl b;

    public akh(akl aklVar, String str) {
        this.b = aklVar;
        this.a = str;
    }

    public final void a(Throwable th) {
        com.google.ads.interactivemedia.v3.impl.data.m.b("Failure to make Native-layer network request", th);
    }

    public final /* bridge */ /* synthetic */ void b(Object obj) {
        akl.a(this.b).o(new ajr(ajp.nativeXhr, ajq.nativeResponse, this.a, (com.google.ads.interactivemedia.v3.impl.data.br) obj));
    }
}
