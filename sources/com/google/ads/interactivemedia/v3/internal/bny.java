package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bny extends bkl {
    static final bkm a = new bnz(1);
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    private bny() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Date read(boh bohVar) throws IOException {
        java.util.Date parse;
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        try {
            synchronized (this) {
                parse = this.b.parse(h);
            }
            return new Date(parse.getTime());
        } catch (ParseException e) {
            throw new bkf("Failed parsing '" + h + "' as SQL Date; at path " + bohVar.f(), e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            bojVar.g();
            return;
        }
        synchronized (this) {
            format = this.b.format(date);
        }
        bojVar.l(format);
    }

    public /* synthetic */ bny(byte[] bArr) {
    }
}
