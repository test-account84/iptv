package com.google.ads.interactivemedia.v3.internal;

import java.sql.Date;
import java.sql.Timestamp;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class boe {
    public static final boolean a;
    public static final blz b;
    public static final blz c;
    public static final bkm d;
    public static final bkm e;
    public static final bkm f;

    static {
        boolean z;
        bkm bkmVar;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (z) {
            b = new boc(Date.class);
            c = new bod(Timestamp.class);
            d = bny.a;
            e = boa.a;
            bkmVar = bob.a;
        } else {
            bkmVar = null;
            b = null;
            c = null;
            d = null;
            e = null;
        }
        f = bkmVar;
    }
}
