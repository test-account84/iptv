package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class boa extends bkl {
    static final bkm a = new bnz(0);
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    private boa() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Time read(boh bohVar) throws IOException {
        Time time;
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        try {
            synchronized (this) {
                time = new Time(this.b.parse(h).getTime());
            }
            return time;
        } catch (ParseException e) {
            throw new bkf("Failed parsing '" + h + "' as SQL Time; at path " + bohVar.f(), e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        String format;
        Time time = (Time) obj;
        if (time == null) {
            bojVar.g();
            return;
        }
        synchronized (this) {
            format = this.b.format(time);
        }
        bojVar.l(format);
    }

    public /* synthetic */ boa(byte[] bArr) {
    }
}
