package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bns extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        try {
            return new AtomicInteger(bohVar.b());
        } catch (NumberFormatException e) {
            throw new bkf((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        bojVar.i(((AtomicInteger) obj).get());
    }
}
