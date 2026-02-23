package com.google.ads.interactivemedia.v3.internal;

import android.annotation.TargetApi;
import java.util.concurrent.ExecutorService;

@TargetApi(19)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class akl {
    private final akj a;
    private final akc b;
    private final aze c;

    public akl(akc akcVar, ExecutorService executorService, akj akjVar) {
        this.c = azh.a(executorService);
        this.a = akjVar;
        this.b = akcVar;
    }

    public static /* bridge */ /* synthetic */ akc a(akl aklVar) {
        return aklVar.b;
    }

    public final /* synthetic */ com.google.ads.interactivemedia.v3.impl.data.br b(com.google.ads.interactivemedia.v3.impl.data.bq bqVar) throws Exception {
        return this.a.a(bqVar);
    }

    public final void c(ajq ajqVar, String str, com.google.ads.interactivemedia.v3.impl.data.bq bqVar) {
        ajq ajqVar2 = ajq.activate;
        if (ajqVar.ordinal() != 35) {
            com.google.ads.interactivemedia.v3.impl.data.m.c("Unexpected network request of type".concat(String.valueOf(ajqVar)));
        } else {
            azh.d(this.c.a(new akg(this, bqVar)), new akh(this, str), this.c);
        }
    }
}
