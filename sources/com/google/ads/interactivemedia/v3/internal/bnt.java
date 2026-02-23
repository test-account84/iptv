package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnt extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        return new AtomicBoolean(bohVar.q());
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        bojVar.m(((AtomicBoolean) obj).get());
    }
}
