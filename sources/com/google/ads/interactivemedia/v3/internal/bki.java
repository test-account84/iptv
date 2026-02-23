package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public enum bki implements bkj {
    DOUBLE,
    LAZILY_PARSED_NUMBER,
    LONG_OR_DOUBLE,
    BIG_DECIMAL;

    public static final Double b(boh bohVar) throws IOException {
        return Double.valueOf(bohVar.a());
    }

    public final /* synthetic */ Number a(boh bohVar) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return b(bohVar);
        }
        if (ordinal == 1) {
            return new blb(bohVar.h());
        }
        if (ordinal != 2) {
            throw null;
        }
        throw null;
    }
}
