package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class blx extends bkl {
    public static final bkm a = new blw(0);
    private final List b;

    public blx() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (bkz.a()) {
            arrayList.add(bjh.e(2, 2));
        }
    }

    private final Date a(boh bohVar) throws IOException {
        String h = bohVar.h();
        synchronized (this.b) {
            try {
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(h);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return bnx.a(h, new ParsePosition(0));
                } catch (ParseException e) {
                    throw new bkf("Failed parsing '" + h + "' as Date; at path " + bohVar.f(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() != 9) {
            return a(bohVar);
        }
        bohVar.m();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            bojVar.g();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        synchronized (this.b) {
            format = dateFormat.format(date);
        }
        bojVar.l(format);
    }
}
