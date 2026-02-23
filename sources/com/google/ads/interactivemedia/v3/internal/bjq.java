package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bjq extends bkl {
    final /* synthetic */ bkl a;

    public bjq(bkl bklVar) {
        this.a = bklVar;
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        return new AtomicLong(((Number) this.a.read(bohVar)).longValue());
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        this.a.write(bojVar, Long.valueOf(((AtomicLong) obj).get()));
    }
}
