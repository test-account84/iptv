package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnf extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        bohVar.j();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (bohVar.r() != 4) {
            String g = bohVar.g();
            int b = bohVar.b();
            if ("year".equals(g)) {
                i = b;
            } else if ("month".equals(g)) {
                i2 = b;
            } else if ("dayOfMonth".equals(g)) {
                i3 = b;
            } else if ("hourOfDay".equals(g)) {
                i4 = b;
            } else if ("minute".equals(g)) {
                i5 = b;
            } else if ("second".equals(g)) {
                i6 = b;
            }
        }
        bohVar.l();
        return new GregorianCalendar(i, i2, i3, i4, i5, i6);
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        if (((Calendar) obj) == null) {
            bojVar.g();
            return;
        }
        bojVar.c();
        bojVar.f("year");
        bojVar.i(r4.get(1));
        bojVar.f("month");
        bojVar.i(r4.get(2));
        bojVar.f("dayOfMonth");
        bojVar.i(r4.get(5));
        bojVar.f("hourOfDay");
        bojVar.i(r4.get(11));
        bojVar.f("minute");
        bojVar.i(r4.get(12));
        bojVar.f("second");
        bojVar.i(r4.get(13));
        bojVar.e();
    }
}
