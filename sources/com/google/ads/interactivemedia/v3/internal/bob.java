package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bob extends bkl {
    static final bkm a = new bnz(2);
    private final bkl b;

    public /* synthetic */ bob(bkl bklVar) {
        this.b = bklVar;
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        Date date = (Date) this.b.read(bohVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        this.b.write(bojVar, (Timestamp) obj);
    }
}
